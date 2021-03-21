package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.scalajs.ExprTree._

object Mangler extends TreeTransformation {
  case object LeaveAlone extends Comment.Data
  case object WasJsNative extends Comment.Data
  val WasJsNativeComment = Comments(List(CommentData(WasJsNative)))

  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree = {
    val rewrittenMembers = container.members.map {
      case pkg: PackageTree if pkg.comments.has[LeaveAlone.type] => pkg
      case pkg: PackageTree => genPkgForwarders(pkg, Empty)
      case mod: ModuleTree if mod.comments.has[Markers.EnumObject.type] =>
        def stripLocationAnns(tree: Tree): Tree = {
          def filterAnns(anns: IArray[Annotation]): IArray[Annotation] =
            anns.filter {
              case Annotation.JsBracketAccess => true
              case Annotation.JsName(_)       => true
              case Annotation.JsNameSymbol(_) => true
              case _                          => false
            }

          tree match {
            case x: FieldTree =>
              x.copy(annotations = filterAnns(x.annotations), isReadOnly = true)
            case x: MethodTree =>
              x.copy(annotations = filterAnns(x.annotations))
            case x => x
          }
        }

        mod.copy(members = mod.members.map(stripLocationAnns))
      case mod: ModuleTree if mod.comments.has[LeaveAlone.type] || !mod.isNative => mod
      case mod: ModuleTree =>
        Action(scope / mod, mod) match {
          case Action.RemainModule =>
            genModForwarders(mod)

          case Action.ConvertToPackage =>
            genPkgForwarders(
              PackageTree(mod.annotations, mod.name, mod.members, mod.comments, mod.codePath),
              mod.parents,
            )
        }
      case other => other
    }

    val isTopLevel = scope.stack.length < 3 // typings, libName
    if (isTopLevel && !container.comments.has[LeaveAlone.type])
      genPkgForwarders(
        PackageTree(container.annotations, container.name, rewrittenMembers, container.comments, container.codePath),
        Empty,
      )
    else
      container.withMembers(rewrittenMembers)
  }

  sealed trait Action

  object Action {
    case object RemainModule extends Action
    case object ConvertToPackage extends Action

    // Checks if any parent object has a collision with a class.
    //
    // In the scala 3 world we have no encoding for a package and a class with the same path. In scala 2 we reused
    //  a rewrite and a type alias with a "companion package"
    //
    // todo: This is pretty wacko and slow, but it's because we evaluate depth first. Should rewrite and do manual traversal
    def parentClassCollision(scope: TreeScope): Option[ClassTree] = {
      def classCollision(scope: TreeScope, name: Name): Option[ClassTree] =
        for {
          owner <- scope.stack.collectFirst { case x: ContainerTree => x }
          sameName <- owner.index.get(name)
          cls <- sameName.collectFirst { case x: ClassTree => x }
        } yield cls

      scope match {
        case _:      TreeScope.Root[_] => None
        case scoped: TreeScope.Scoped =>
          scoped.current match {
            case tree: ContainerTree =>
              classCollision(scoped.`..`, tree.name).orElse(parentClassCollision(scope.`..`))
            case _ => parentClassCollision(scoped.`..`)
          }
      }
    }

    def apply(scope: TreeScope, mod: ModuleTree): Action = {
      val containsPackage = mod.members.exists {
        case _: PackageTree => true
        case _ => false
      }

      val isCompanion: Option[ClassTree] =
        parentClassCollision(scope)

      val maybePackage = (containsPackage, isCompanion) match {
        case (true, Some(_))  => scope.logger.fatal("Found package within companion")
        case (true, None)     => true
        case (false, Some(_)) => false
        case (false, None)    => true
      }

      val tooBig = {
        def countClasses(x: ContainerTree): Int =
          x.members.foldLeft(0) {
            case (n, xx: ContainerTree)   => n + 1 + countClasses(xx)
            case (n, _:  InheritanceTree) => n + 1
            case (n, _) => n
          }

        if (mod.comments.has[Markers.EnumObject.type]) false
        else countClasses(mod) > 40
      }

      if (maybePackage && tooBig) Action.ConvertToPackage
      else Action.RemainModule
    }
  }

  def genPkgForwarders(pkg: PackageTree, inheritance: IArray[TypeRef]): PackageTree = {
    val hatCp = pkg.codePath + Name.namespaced

    val isGlobal = pkg.annotations.contains(Annotation.JsGlobalScope)

    val dynamicRef: ExprTree =
      if (isGlobal) Ref(QualifiedName.DynamicGlobal)
      else Cast(Ref(hatCp), TypeRef.Dynamic)

    var needsHatObject = false

    val forwarders = pkg.members.flatMap {
      case m: MethodTree if m.location.isDefined =>
        needsHatObject = true

        val impl = {
          def call(params: IArray[Arg]) = m.name match {
            case Name.APPLY =>
              Call(Select(dynamicRef, Name("apply")), IArray(params))
            case _ =>
              Call(
                Select(dynamicRef, Name("applyDynamic")),
                IArray(IArray(StringLit(m.originalName.unescaped)), params),
              )
          }

          Cast(call(m.params.flatten.map(p => Cast(Ref(p.name), TypeRef.Any))), m.resultType)
        }

        if (pkg.index(m.name).exists(_.isInstanceOf[ClassTree])) {
          val asApply =
            m.copy(
              annotations = IArray(Annotation.Inline),
              name        = Name.APPLY,
              impl        = impl,
              comments    = m.comments ++ WasJsNativeComment,
              codePath    = m.codePath + Name.APPLY,
            )

          IArray(ModuleTree(Empty, m.name, Empty, IArray(asApply), NoComments, m.codePath, m.isOverride))

        } else
          IArray(
            m.copy(annotations = IArray(Annotation.Inline), impl = impl, comments = m.comments ++ WasJsNativeComment),
          )

      case f: FieldTree if f.tpe.typeName === QualifiedName.THIS => Empty
      case f: FieldTree if f.location.isDefined =>
        needsHatObject = true

        val getter = {
          val impl = Cast(
            Call(Select(dynamicRef, Name("selectDynamic")), IArray(IArray(StringLit(f.originalName.unescaped)))),
            f.tpe,
          )
          MethodTree(
            annotations = IArray(Annotation.Inline),
            level       = ProtectionLevel.Default,
            name        = f.name,
            tparams     = Empty,
            params      = Empty,
            impl        = impl,
            resultType  = f.tpe,
            isOverride  = false,
            comments    = f.comments ++ WasJsNativeComment,
            codePath    = f.codePath,
            isImplicit  = false,
          )
        }

        val setterOpt =
          if (f.isReadOnly || f.name.isEscaped) None
          else {
            val xParam = ParamTree(Name("x"), isImplicit = false, isVal = false, f.tpe, NotImplemented, NoComments)

            val impl = Call(
              Select(dynamicRef, Name("updateDynamic")),
              IArray(IArray(StringLit(f.originalName.unescaped)), IArray(Cast(Ref(xParam.name), TypeRef.Any))),
            )

            val m = MethodTree(
              annotations = IArray(Annotation.Inline),
              level       = ProtectionLevel.Default,
              name        = Name(f.name.unescaped + "_="),
              tparams     = Empty,
              params      = IArray(IArray(xParam)),
              impl        = impl,
              resultType  = TypeRef.Unit,
              isOverride  = false,
              comments    = WasJsNativeComment,
              codePath    = f.codePath,
              isImplicit  = false,
            )

            Some(m)
          }
        IArray.fromOptions(Some(getter), setterOpt)

      case other => IArray(other)
    }

    val hatModuleOpt =
      if ((!needsHatObject && inheritance.isEmpty) || isGlobal) None
      else {
        val parents = inheritance match {
          case Empty    => Empty
          case nonEmpty => IArray(TypeRef.TopLevel(TypeRef.Intersection(nonEmpty, NoComments)))
        }
        Some(
          ModuleTree(
            annotations = pkg.annotations,
            name        = Name.namespaced,
            parents     = parents,
            members     = Empty,
            comments    = NoComments,
            codePath    = hatCp,
            isOverride  = false,
          ),
        )
      }

    val comments = {
      val addedRelated: IArray[TypeRef] = IArray.fromOption(
        hatModuleOpt.map(hat => TypeRef(hat.codePath)),
      )

      pkg.comments.extract { case Minimization.Related(related) => related } match {
        case Some((existingRelated, restComments)) =>
          restComments + CommentData(Minimization.Related(existingRelated ++ addedRelated))
        case None => pkg.comments + CommentData(Minimization.Related(addedRelated))
      }
    }

    ModulesCombine.combineModules(
      pkg.copy(comments = comments, members = IArray.fromOption(hatModuleOpt) ++ forwarders),
    )
  }

  def genModForwarders(mod: ModuleTree): ModuleTree = {
    val isGlobal = mod.annotations.contains(Annotation.JsGlobalScope)
    val hatCp    = mod.codePath + Name.namespaced

    val dynamicRef: ExprTree =
      if (isGlobal) Ref(QualifiedName.DynamicGlobal)
      else Cast(Ref(Name.namespaced), TypeRef.Dynamic)

    var needsHatObject = false

    val rewrittenMembers: IArray[Tree] =
      mod.members.flatMap {
        case m: MethodTree if m.location.isDefined =>
          needsHatObject = true

          val impl = {
            def call(params: IArray[Arg]) = m.name match {
              case Name.APPLY =>
                Call(Select(dynamicRef, Name("apply")), IArray(params))
              case _ =>
                Call(
                  Select(dynamicRef, Name("applyDynamic")),
                  IArray(IArray(StringLit(m.originalName.unescaped)), params),
                )
            }

            Cast(call(m.params.flatten.map(p => Cast(Ref(p.name), TypeRef.Any))), m.resultType)
          }

          if (mod.index(m.name).exists(_.isInstanceOf[ClassTree])) {
            val asApply =
              m.copy(
                comments    = m.comments ++ WasJsNativeComment,
                annotations = IArray(Annotation.Inline),
                name        = Name.APPLY,
                impl        = impl,
                codePath    = m.codePath + Name.APPLY,
              )

            IArray(ModuleTree(Empty, m.name, Empty, IArray(asApply), NoComments, m.codePath, m.isOverride))

          } else
            IArray(
              m.copy(annotations = IArray(Annotation.Inline), impl = impl, comments = m.comments ++ WasJsNativeComment),
            )

        case f: FieldTree if f.isReadOnly || f.location.isEmpty =>
          IArray(f)

        case f: FieldTree if f.name.isEscaped => // don't think it's possible to generate setters in backticks
          IArray(f.copy(isReadOnly = true))

        case f: FieldTree =>
          needsHatObject = true

          val setter = {
            val xParam = ParamTree(Name("x"), isImplicit = false, isVal = false, f.tpe, NotImplemented, NoComments)

            val impl = Call(
              Select(dynamicRef, Name("updateDynamic")),
              IArray(IArray(StringLit(f.originalName.unescaped)), IArray(Cast(Ref(xParam.name), TypeRef.Any))),
            )

            MethodTree(
              annotations = IArray(Annotation.Inline),
              level       = ProtectionLevel.Default,
              name        = Name(f.name.unescaped + "_="),
              tparams     = Empty,
              params      = IArray(IArray(xParam)),
              impl        = impl,
              resultType  = TypeRef.Unit,
              isOverride  = false,
              comments    = WasJsNativeComment,
              codePath    = f.codePath,
              isImplicit  = false,
            )
          }

          val getter =
            MethodTree(
              annotations = f.annotations.filterNot(_.isInstanceOf[Annotation.JsName]),
              level       = ProtectionLevel.Default,
              name        = f.name,
              tparams     = Empty,
              params      = Empty,
              impl        = f.impl,
              resultType  = f.tpe,
              isOverride  = f.isOverride,
              comments    = f.comments ++ WasJsNativeComment,
              codePath    = f.codePath,
              isImplicit  = false,
            )

          IArray(getter, setter)

        case other =>
          IArray(other)
      }

    val hatOpt: Option[FieldTree] = {
      val tpe = TypeRef.Intersection(mod.parents, NoComments) match {
        case TypeRef.Nothing => TypeRef.Any
        case other           => other
      }

      if ((tpe === TypeRef.Any && !needsHatObject) || isGlobal) None
      else
        Some(
          FieldTree(
            annotations = mod.annotations,
            name        = Name.namespaced,
            tpe         = tpe,
            impl        = ExprTree.native,
            isReadOnly  = true,
            isOverride  = false,
            comments    = NoComments,
            codePath    = hatCp,
          ),
        )
    }

    val shortcut: Option[FieldTree] =
      hatOpt
        .orElse(mod.index.get(Name.Default) match {
          case Some(defaults) => defaults.collectFirst { case x: FieldTree => x }
          case None           => None
        })
        .filter(_.tpe =/= TypeRef.Any)

    shortcut.foldLeft(
      mod.copy(
        annotations = Empty,
        parents     = Empty,
        members     = rewrittenMembers ++ IArray.fromOption(hatOpt),
        comments    = mod.comments,
      ),
    ) {
      case (mod, field) =>
        // implement the `Shortcut` trait for some nicer syntax
        val parent = TypeRef(QualifiedName.Shortcut)
        val to = {
          val name = Name("_to")
          MethodTree(
            Empty,
            ProtectionLevel.Default,
            name,
            Empty,
            Empty,
            Ref(field.name),
            field.tpe,
            isOverride = true,
            Comments(
              Comment(
                s"/* This means you don't have to write `${field.name.value}`, but can instead just say `${mod.name.value}.foo` */\n",
              ),
            ),
            mod.codePath + name,
            isImplicit = false,
          )
        }

        val To = {
          val name = Name("_To")
          TypeAliasTree(name, Empty, field.tpe, NoComments, mod.codePath + name)
        }

        val comments = {
          val addedRelated: IArray[TypeRef] = IArray.fromOptions(
            Some(TypeRef(to.codePath)),
            Some(TypeRef(To.codePath)),
            hatOpt.map(hat => TypeRef(hat.codePath)),
          )

          mod.comments.extract { case Minimization.Related(related) => related } match {
            case Some((existingRelated, restComments)) =>
              restComments + CommentData(Minimization.Related(existingRelated ++ addedRelated))
            case None => mod.comments + CommentData(Minimization.Related(addedRelated))
          }
        }

        mod.copy(comments = comments, parents = mod.parents :+ parent, members = IArray(to, To) ++ mod.members)
    }
  }
}
