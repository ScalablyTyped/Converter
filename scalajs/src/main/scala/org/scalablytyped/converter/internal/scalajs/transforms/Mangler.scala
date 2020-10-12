package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.scalajs.ExprTree._

object Mangler extends TreeTransformation {
  case object LeaveAlone extends Comment.Data

  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree = {
    val rewrittenMembers = container.members.map {
      case pkg: PackageTree if pkg.comments.has[LeaveAlone.type] => pkg
      case pkg: PackageTree => genPkgForwarders(pkg, Empty)
      case mod: ModuleTree if mod.comments.has[LeaveAlone.type] || !mod.isNative => mod
      case mod: ModuleTree =>
        Action(scope, mod) match {
          case Action.RemainModule => genModForwarders(mod)

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

    def existsClassWithSameName(scope: TreeScope, name: Name): Option[QualifiedName] =
      for {
        owner <- scope.stack.collectFirst { case x: ContainerTree => x }
        sameName <- owner.index.get(name)
        cls <- sameName.collectFirst { case x: ClassTree => x.codePath }
      } yield cls

    def apply(scope: TreeScope, mod: ModuleTree): Action = {
      val containsPackage = mod.members.exists {
        case _: PackageTree => true
        case _ => false
      }

      val isCompanion: Option[QualifiedName] =
        existsClassWithSameName(scope, mod.name)

      val maybePackage = (containsPackage, isCompanion) match {
        case (true, Some(_))  => scope.logger.fatal("Found package within companion")
        case (true, None)     => true
        case (false, Some(_)) => false
        case (false, None)    => true
      }

      def tooBig = {
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
    var needsCombining = false

    val forwarders = pkg.members.flatMap {
      case m: MethodTree if m.location.isDefined =>
        needsHatObject = true

        val impl = {
          def call(params: IArray[Arg]) = m.originalName match {
            case Name.APPLY =>
              Call(Select(dynamicRef, Name("apply")), IArray(params))
            case name =>
              Call(Select(dynamicRef, Name("applyDynamic")), IArray(IArray(StringLit(name.unescaped)), params))
          }

          Cast(call(m.params.flatten.map(p => Cast(Ref(p.name), TypeRef.Any))), m.resultType)
        }

        if (pkg.index(m.name).exists(_.isInstanceOf[ClassTree])) {
          val asApply =
            m.copy(
              annotations = IArray(Annotation.Inline),
              name        = Name.APPLY,
              impl        = impl,
              codePath    = m.codePath + Name.APPLY,
            )

          needsCombining = true

          IArray(ModuleTree(Empty, m.name, Empty, IArray(asApply), NoComments, m.codePath, m.isOverride))

        } else IArray(m.copy(annotations = IArray(Annotation.Inline), impl = impl))

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
            comments    = f.comments,
            codePath    = f.codePath,
            isImplicit  = false,
          )
        }

        val setterOpt =
          if (f.isReadOnly) None
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
              comments    = NoComments,
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
      else
        Some(
          ModuleTree(
            annotations = pkg.annotations,
            name        = Name.namespaced,
            parents     = inheritance,
            members     = Empty,
            comments    = NoComments,
            codePath    = hatCp,
            isOverride  = false,
          ),
        )

    val base = pkg.copy(members = IArray.fromOption(hatModuleOpt) ++ forwarders)
    if (needsCombining) {
      val combined = ModulesCombine.combineModules(base)
      val sorted   = Sorter.sorted(combined.members)
      combined.copy(members = sorted)
    } else base
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
        case m: MethodTree =>
          IArray(m)

        case f: FieldTree if f.isReadOnly =>
          IArray(f)

        case f: FieldTree if !f.isReadOnly && f.location.isDefined =>
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
              comments    = NoComments,
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
              comments    = f.comments,
              codePath    = f.codePath,
              isImplicit  = false,
            )

          IArray(getter, setter)

        case other =>
          IArray(other)
      }

    val hatModuleOpt: IArray[MemberTree] = {
      val tpe = TypeRef.Intersection(mod.parents, NoComments) match {
        case TypeRef.Nothing => TypeRef.Any
        case other           => other
      }

      if ((tpe === TypeRef.Any && !needsHatObject) || isGlobal) Empty
      else {
        val field = FieldTree(
          annotations = mod.annotations,
          name        = Name.namespaced,
          tpe         = tpe,
          impl        = ExprTree.native,
          isReadOnly  = true,
          isOverride  = false,
          comments    = NoComments,
          codePath    = hatCp,
        )

        val __is = Name("__is")
        val selectOpt = tpe match {
          case TypeRef.Any => None
          case other =>
            Some(
              MethodTree(
                annotations = IArray(Annotation.Inline),
                level       = ProtectionLevel.Default,
                name        = __is,
                tparams     = Empty,
                params = IArray(
                  IArray(
                    ParamTree(
                      name       = Name("ignored"),
                      isImplicit = false,
                      isVal      = false,
                      tpe        = TypeRef.Singleton(TypeRef(mod.codePath)),
                      default    = NotImplemented,
                      comments   = NoComments,
                    ),
                  ),
                ),
                impl       = ExprTree.Ref(hatCp),
                resultType = other,
                isOverride = false,
                comments = Comments(
                  Comment(s"/* Syntax to write `${mod.name.unescaped}` instead of `${mod.name.unescaped}.^` */\n"),
                ),
                codePath   = mod.codePath + __is,
                isImplicit = true,
              ),
            )
        }

        IArray.fromOptions(Some(field), selectOpt)
      }
    }

    mod.copy(
      annotations = Empty,
      parents     = Empty,
      members     = hatModuleOpt ++ rewrittenMembers,
      comments    = mod.comments,
    )
  }
}
