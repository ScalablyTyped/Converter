package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.maps._

class IdentifyReactComponents(
    reactNames:             ReactNamesProxy,
    parentsResolver:        ParentsResolver,
    enableReactTreeShaking: Selection[Name],
) {
  def length(qualifiedName: QualifiedName): Int =
    qualifiedName.parts.foldLeft(0)(_ + _.unescaped.length)

  /* this is effectively a heuristic which component to use */
  implicit val ComponentOrdering: Ordering[Component] = Ordering.by { c =>
    /* sometimes there are typings both for transpiled and original code. Default to transpiled */
    val preferNotSrc =
      !c.scalaRef.typeName.parts.exists(part => part.unescaped.startsWith("src") && part.unescaped.endsWith("Mod"))

    val preferModule = !c.isGlobal

    /* because some libraries expect you to use top-level imports. shame for the tree shakers */
    val preferShortModuleName = c.location match {
      case Right(Annotation.JsGlobalScope)          => 0
      case Right(Annotation.JsImport(module, _, _)) => -module.length
      case Right(Annotation.JsGlobal(name))         => -length(name)
      case Left(_)                                  => 0
    }

    val preferNested = c.nested.length

    /* because for instance mui ships with icons called `List` and `Tab` */
    val preferPropsMatchesName = c.propsRef.ref.name.unescaped.toLowerCase.startsWith(c.fullName.unescaped.toLowerCase)

    /* because for instance mui declares both a default and a names export, where only the former exists */
    val preferDefault = c.scalaRef.name === Name.Default

    /* if components are otherwise the same, choosing the class one means we get a ref type */
    val preferClass = c.componentType === ComponentType.Class

    (
      preferNotSrc,
      preferModule,
      preferShortModuleName,
      preferNested,
      preferPropsMatchesName,
      preferDefault,
      preferClass,
    )
  }

  def intrinsics(scope: TreeScope): IArray[Component] =
    if (scope.libName.unescaped === "react") {
      scope
        .lookup(reactNames.JsxIntrinsicElements)
        .collectFirst {
          case (t: ClassTree, _) =>
            t.members.collect {
              // a: React.DetailedHTMLProps<React.AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>;
              case FieldTree(_, _, name, props @ TypeRef(_, tparams, _), _, _, _, _, _) =>
                Component(
                  location      = Left(ExprTree.StringLit(name.unescaped)),
                  scalaRef      = tparams.last,
                  fullName      = name,
                  tparams       = Empty,
                  propsRef      = reactNames.unpackedProps(props),
                  componentType = ComponentType.Intrinsic,
                  nested        = Empty,
                )
            }
        }
        .getOrElse(Empty)
    } else Empty

  def all(scope: TreeScope, tree: ContainerTree): IArray[Component] =
    recurse(scope, tree)
      .filterNot(c => reactNames.ComponentQNames(c.scalaRef.typeName))

  /* just one of each component (determined by name), which one is chosen by the `Ordering` implicit above */
  def oneOfEach(scope: TreeScope, tree: ContainerTree): IArray[Component] =
    all(scope, tree)
      .groupBy(_.fullName.unescaped.toLowerCase)
      .mapToIArray {
        case (_, sameName) =>
          /* in this sorting the normally preferred component is *last* */
          val sorted = sameName.sorted(ComponentOrdering)

          /* if we want to encourage tree shaking we should choose the *longest* module name instead.
           *  Take special care to choose a component with *same props* as the originally chosen component */
          if (enableReactTreeShaking(scope.libName)) {
            val IArray.initLast(init, originalChosen) = sorted

            val newFound = init
              .find(other =>
                other.propsRef === originalChosen.propsRef &&
                  other.isGlobal === originalChosen.isGlobal &&
                  other.componentType === originalChosen.componentType &&
                  other.nested.length === originalChosen.nested.length,
              )
              .getOrElse(originalChosen)

            newFound
          } else sorted.last
      }

  private def recurse(scope: TreeScope, outer: ContainerTree): IArray[Component] =
    outer.index.flatMapToIArray {
      case (_, sameName) =>
        /** semantically all these except methods are [[Option]] */
        val (containers, fields, classes, methods, _) = sameName.partitionCollect4(
          { case x: ContainerTree => x },
          { case x: FieldTree     => x },
          { case x: ClassTree     => x },
          { case x: MethodTree    => x },
        )

        /* handle together to fix nesting. when a class component is detected, its static member components will be found in the companion object */
        val _1: IArray[Component] = {
          def handleContainers(mods: IArray[ContainerTree]) =
            mods.flatMap { x =>
              maybeContainerComponent(x, scope / x) match {
                case Left(pkg) => all(scope / pkg, pkg)
                case Right(c)  => IArray(c)
              }
            }

          (containers, classes) match {
            case (Empty, Empty) =>
              Empty
            case (Empty, classes) =>
              classes.mapNotNone(x => maybeClassComponent(x, scope / x))
            case (containers, Empty) =>
              handleContainers(containers)
            case (IArray.first(c), IArray.first(cls)) =>
              val newScope = scope / cls
              maybeClassComponent(cls, newScope) match {
                case None => handleContainers(containers)
                case Some(clsComp) =>
                  val nested = recurse(newScope, separateContainer(c, newScope).restAsPackage)
                    .sortBy(_.fullName)
                    .distinctBy(_.fullName)
                  IArray(clsComp.withNested(nested))
              }
          }
        }

        val _2: IArray[Component] =
          fields.flatMap { x =>
            /* translate to module first (it will be translated back later) to find nested components */
            val anns = IArray(locationFrom(scope / x))
            val asModule = ModuleTree(
              anns,
              ProtectionLevel.Public,
              x.name,
              IArray(x.tpe),
              Empty,
              x.comments,
              x.codePath,
              isOverride = false,
            )
            maybeContainerComponent(asModule, scope / asModule) match {
              case Left(_)  => Empty
              case Right(c) => IArray(c)
            }
          }

        val _3: IArray[Component] =
          methods.flatMap(x => IArray.fromOption(maybeMethodComponent(x, outer, scope / x)))

        IArray(_1, _2, _3).flatten
    }

  val Unnamed = Set(Name.Default, Name.namespaced, Name.APPLY)

  def maybeMethodComponent(method: MethodTree, owner: ContainerTree, scope: TreeScope): Option[Component] = {
    def returnsElement(scope: TreeScope, current: TypeRef): Option[TypeRef] =
      if (reactNames.isElement(current.typeName)) Some(current)
      else if (current === TypeRef.Any)
        Some(current) // unfortunately this conforms on the TS side, let's see how it works out
      else if (scope.isAbstract(current)) None
      else
        current match {
          case Optionality(opt, base) if opt =/= Optionality.No => returnsElement(scope, base)
          case _ =>
            scope
              .lookup(current.typeName)
              .firstDefined {
                case (x: TypeAliasTree, newScope) =>
                  val rewritten = FillInTParams(x, newScope, current.targs, Empty)
                  returnsElement(scope, rewritten.alias)
                case _ => None
              }
        }

    val flattenedParams = method.params.flatten

    flattenedParams.length match {
      /* optional props and context */
      case 0 | 1 | 2 =>
        def isTopLevel = scope.stack.forall {
          case _: ClassTree => false
          case _ => true
        }
        val propsRef = reactNames.unpackedProps(flattenedParams.headOption.map(_.tpe).getOrElse(TypeRef.JsObject))
        def validName =
          isUpper(method.name) || (Unnamed(method.name) && (isUpper(owner.name) || Unnamed(owner.name) || owner.name === Name.mod))

        if (!validName || !isTopLevel || !method.isNative) None
        else
          returnsElement(scope, method.resultType).map { _ =>
            method.name match {
              case Name.APPLY =>
                Component(
                  location      = Right(locationFrom(scope)),
                  scalaRef      = TypeRef(method.codePath),
                  fullName      = componentName(method.annotations, method.codePath),
                  tparams       = method.tparams,
                  propsRef      = propsRef,
                  componentType = ComponentType.Field,
                  nested        = Empty,
                )

              case _ =>
                Component(
                  location      = Right(locationFrom(scope)),
                  scalaRef      = TypeRef(method.codePath, TypeParamTree.asTypeArgs(method.tparams), NoComments),
                  fullName      = componentName(method.annotations, QualifiedName(IArray(method.name))),
                  tparams       = method.tparams,
                  propsRef      = propsRef,
                  componentType = ComponentType.Function,
                  nested        = Empty,
                )
            }
          }
      case _ => None
    }
  }

  case class SeparatedContainer(
      parentRefs:    IArray[TypeRef],
      applyMembers:  IArray[MethodTree],
      restAsPackage: PackageTree,
  )

  def separateContainer(c: ContainerTree, scope: TreeScope): SeparatedContainer = {
    val parentRefs: IArray[TypeRef] = {
      val fromNamespaced: IArray[TypeRef] = {
        c.index
          .getOrElse(Name.namespaced, Empty)
          .collectFirst {
            case m: ModuleTree =>
              m.parents.flatMap {
                case TypeRef.Intersection(types, _) => types
                case tpe                            => IArray(tpe)
              }
            case f: FieldTree =>
              f.tpe match {
                case TypeRef.Intersection(types, _) => types
                case other                          => IArray(other)
              }
          }
          .getOrElse(Empty)
      }

      val normal = c match {
        case _: PackageTree => Empty
        case x: ModuleTree =>
          x.parents.flatMap {
            case TypeRef.Intersection(types, _) => types
            case other                          => IArray(other)
          }
      }

      fromNamespaced ++ normal
    }

    val (applyMembers: IArray[MethodTree], restMembers: IArray[Tree]) = {
      val parents    = parentsResolver(scope, parentRefs).transitiveParents.values
      val allMembers = c.members ++ IArray.fromTraversable(parents).flatMap(_.members).map(setCodePath(c.codePath, _))
      allMembers.partitionCollect { case m: MethodTree if m.name === Name.APPLY => m }
    }

    val restAsPackage = PackageTree(c.annotations, c.name, restMembers, c.comments, c.codePath)
    SeparatedContainer(parentRefs, applyMembers, restAsPackage)
  }

  def maybeContainerComponent(c: ContainerTree, scope: TreeScope): Either[PackageTree, Component] = {
    val separated = separateContainer(c, scope)

    val componentOpt: Option[Component] = {
      def fromParents = separated.parentRefs.firstDefined { tpe =>
        val asField = FieldTree(
          annotations = c.annotations,
          level       = ProtectionLevel.Public,
          name        = c.name,
          tpe         = tpe,
          impl        = ExprTree.native,
          isReadOnly  = true,
          isOverride  = false,
          comments    = c.comments,
          codePath    = c.codePath,
        )
        maybeFieldComponent(asField, c, scope)
      }
      def fromApplies = separated.applyMembers.firstDefined(a => maybeMethodComponent(a, c, scope / a))

      fromParents.orElse(fromApplies)
    }

    componentOpt match {
      case Some(component) =>
        val nested = recurse(scope, separated.restAsPackage).sortBy(_.fullName).distinctBy(_.fullName)
        Right(component.withNested(nested))
      case None =>
        Left(separated.restAsPackage)
    }
  }

  def maybeFieldComponent(field: FieldTree, owner: ContainerTree, scope: TreeScope): Option[Component] = {
    def pointsAtComponentType(scope: TreeScope, current: TypeRef): Option[PropsRef] =
      reactNames.isComponent(current).orElse {
        scope
          .lookup(current.typeName)
          .firstDefined {
            case (x: ClassTree, newScope) =>
              val rewritten = FillInTParams(x, newScope, current.targs, Empty)
              parentsResolver(newScope, rewritten).transitiveParents.firstDefined {
                case (tr, _) => pointsAtComponentType(newScope, tr)
              }
            case (x: TypeAliasTree, newScope) =>
              val rewritten = FillInTParams(x, newScope, current.targs, Empty)
              pointsAtComponentType(scope, rewritten.alias)
            case _ => None
          }
      }

    val fieldResult = pointsAtComponentType(scope, field.tpe).map(propsRef =>
      Component(
        location      = Right(locationFrom(scope)),
        scalaRef      = TypeRef(field.codePath),
        fullName      = componentName(field.annotations, QualifiedName(IArray(field.name))),
        tparams       = Empty,
        propsRef      = propsRef,
        componentType = ComponentType.Field,
        nested        = Empty,
      ),
    )
    def isAliasToFC: Option[Component] =
      FollowAliases(scope)(field.tpe) match {
        case TypeRef.JsFunction(paramTypes, ret) =>
          val params =
            paramTypes.map(tpe =>
              ParamTree(Name.dummy, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments),
            )

          maybeMethodComponent(
            MethodTree(
              annotations = field.annotations,
              level       = ProtectionLevel.Public,
              name        = field.name,
              tparams     = Empty,
              params      = IArray(params),
              impl        = field.impl,
              resultType  = ret,
              isOverride  = false,
              comments    = field.comments,
              codePath    = field.codePath,
              isImplicit  = false,
            ),
            owner,
            scope,
          )
        case _ => None
      }

    fieldResult.orElse(isAliasToFC)
  }

  def maybeClassComponent(cls: ClassTree, scope: TreeScope): Option[Component] =
    if (cls.classType =/= ClassType.Class) None
    else
      parentsResolver(scope, cls).transitiveParents.firstDefined { (tr, _) =>
        reactNames.isComponent(tr).map { propsRef =>
          Component(
            location      = Right(locationFrom(scope)),
            scalaRef      = TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            fullName      = componentName(cls.annotations, cls.codePath),
            tparams       = cls.tparams,
            propsRef      = propsRef,
            componentType = ComponentType.Class,
            nested        = Empty,
          )
        }
      }

  object componentName {
    def apply(anns: IArray[Annotation], codePath: QualifiedName): Name = {

      val fromCodePath = codePath.parts
        .filterNot(Unnamed)
        .reverse
        .takeWhile(n => !n.unescaped.endsWith("Mod") && n != Name.mod)
        .headOption

      val name = fromCodePath.orElse(fromAnnotations(anns))

      val ret = IArray
        .fromOption(name)
        .map(x => nameVariants(x.unescaped).head)
        .distinct
        .map(_.capitalize)
        .mkString("") match {
        case ""                             => Name("Component")
        case other if other.endsWith("Cls") => Name(other.dropRight(3))
        case other                          => Name(other)
      }
      ret
    }

    def fromAnnotations(anns: IArray[Annotation]): Option[Name] =
      anns.collectFirst {
        case Annotation.JsName(name)                                                  => name
        case Annotation.JsImport(_, Imported.Named(names), _) if !Unnamed(names.last) => names.last
        case Annotation.JsImport(mod, _, _) =>
          Name.necessaryRewrite(Name(mod.split("/").filterNot(x => Unnamed(Name(x))).last))
        case Annotation.JsGlobal(qname) => qname.parts.last
      }
  }

  def isUpper(n: Name): Boolean = n.value.head.isUpper

  def locationFrom(scope: TreeScope): LocationAnnotation = {
    var baseLocationOpt: Option[LocationAnnotation] = None
    var after = List.empty[Tree]
    var idx   = 0

    def fromAnns(anns: IArray[Annotation]): Option[LocationAnnotation] =
      anns.collectFirst {
        case a: Annotation.JsImport => a
        case a: Annotation.JsGlobal => a
        case Annotation.JsGlobalScope => Annotation.JsGlobalScope
      }

    while (idx < scope.stack.length && baseLocationOpt.isEmpty) {
      val current = scope.stack(idx)
      val base: Option[LocationAnnotation] =
        current match {
          case cls: ClassTree   => fromAnns(cls.annotations)
          case mod: ModuleTree  => fromAnns(mod.annotations)
          case pkg: PackageTree => fromAnns(pkg.annotations)
          case _ => None
        }

      if (base.isEmpty) {
        after = current :: after
      } else {
        baseLocationOpt = base
      }

      idx += 1
    }

    def addTreeToImport(`import`: LocationAnnotation, tree: Tree): LocationAnnotation =
      (`import`, tree) match {
        case (ann, tree) if tree.name === Name.APPLY => ann
        case (Annotation.JsImport(mod, imported, globalOpt), tree) =>
          val newImported: Imported =
            imported match {
              case Imported.Namespace =>
                tree.name match {
                  case Name.Default => Imported.Default
                  case other        => Imported.Named(IArray(other))
                }
              case Imported.Default     => Imported.Named(IArray(Name.Default, tree.name))
              case Imported.Named(name) => Imported.Named(name :+ tree.name)
            }

          val newGlobal = globalOpt.map {
            case Annotation.JsGlobal(old) => Annotation.JsGlobal(old + tree.name)
          }

          Annotation.JsImport(mod, newImported, newGlobal)
        case (Annotation.JsGlobal(name), tree) => Annotation.JsGlobal(name + tree.name)
        case (Annotation.JsGlobalScope, tree)  => Annotation.JsGlobal(QualifiedName(IArray(tree.name)))

      }

    baseLocationOpt match {
      case Some(baseLocation) => after.foldLeft(baseLocation)(addTreeToImport)
      case None               => sys.error("Couldnt find base location for component")
    }
  }
}
