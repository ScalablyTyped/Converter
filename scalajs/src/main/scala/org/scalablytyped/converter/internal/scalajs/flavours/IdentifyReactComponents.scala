package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.maps._

class IdentifyReactComponents(
    reactNames:             ReactNames,
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

    /* because for instance mui ships with icons called `List` and `Tab` */
    val preferPropsMatchesName = c.propsRef.ref.name.unescaped.startsWith(c.fullName.unescaped)

    /* because for instance mui declares both a default and a names export, where only the former exists */
    val preferDefault = c.scalaRef.name === Name.Default

    (preferNotSrc, preferModule, preferShortModuleName, preferPropsMatchesName, preferDefault)
  }

  def intrinsics(scope: TreeScope): IArray[Component] =
    if (scope.libName.unescaped === "react") {
      scope
        .lookup(reactNames.JsxIntrinsicElements)
        .collectFirst {
          case (t: ClassTree, _) =>
            t.members.collect {
              // a: React.DetailedHTMLProps<React.AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>;
              case FieldTree(_, name, props @ TypeRef(_, tparams, _), _, _, _, _, _) =>
                Component(
                  location        = Left(ExprTree.StringLit(name.unescaped)),
                  scalaRef        = tparams.last,
                  fullName        = name,
                  tparams         = Empty,
                  propsRef        = PropsRef(props),
                  componentType   = ComponentType.Intrinsic,
                  isAbstractProps = false,
                  nested          = Empty,
                  otherLocations  = Empty,
                )
            }
        }
        .getOrElse(Empty)
    } else Empty

  def all(scope: TreeScope, tree: ContainerTree): IArray[Component] =
    recurse(scope, tree)
      .filterNot(c => reactNames.ComponentQNames(c.scalaRef.typeName))
      .map(_.rewritten(scope, Wildcards.Remove))

  /* just one of each component (determined by name), which one is chosen by the `Ordering` implicit above */
  def oneOfEach(scope: TreeScope, tree: ContainerTree): IArray[Component] =
    all(scope, tree)
      .groupBy(_.fullName)
      .mapToIArray {
        case (_, sameName) =>
          /* in this sorting the normally preferred component is *last* */
          val sorted = sameName.sorted(ComponentOrdering)

          /* if we want to encourage tree shaking we should choose the *longest* module name instead.
           *  Take special care to choose a component with *same props* as the originally chosen component */
          val (chosen, notChosen) = if (enableReactTreeShaking(scope.libName)) {
            val IArray.initLast(init, originalChosen) = sorted

            val newFound = init
              .find(other => other.propsRef === originalChosen.propsRef && other.isGlobal === originalChosen.isGlobal)
              .getOrElse(originalChosen)

            (newFound, sorted.filterNot(_.scalaRef === newFound.scalaRef))
          } else {
            val IArray.initLast(rest, main) = sorted
            (main, rest)
          }

          val notChosenLocations = notChosen.map(_.location).collect { case Right(x) => x }

          chosen.copy(otherLocations = notChosenLocations)
      }
      .sortBy(_.fullName)

  private def recurse(scope: TreeScope, outer: ContainerTree): IArray[Component] =
    outer.index.flatMapToIArray {
      case (_, sameName) =>
        /** semantically all these except methods are [[Option]] */
        val (pkgs, mods, fields, classes, methods, _) = sameName.partitionCollect5(
          { case x: PackageTree => x },
          { case x: ModuleTree  => x },
          { case x: FieldTree   => x },
          { case x: ClassTree   => x },
          { case x: MethodTree  => x },
        )

        val _1: IArray[Component] = pkgs.flatMap(x => recurse(scope / x, x))

        /* handle together to fix nesting. when a class component is detected, its static member components will be found in the companion object */
        val _2: IArray[Component] = {
          def handleMods(mods: IArray[ModuleTree]) =
            mods.flatMap { x =>
              /* nested native objects cannot have a JSImport or JSGlobal annotation, and that's used for naming */
              val guaranteedLocation = x.annotations match {
                case LocationFrom(_) => x
                case anns            => x.copy(annotations = anns ++ IArray(locationFrom(scope / x)))
              }

              maybeModuleComponent(guaranteedLocation, scope / guaranteedLocation) match {
                case Left(pkg) => all(scope / pkg, pkg)
                case Right(c)  => IArray(c)
              }
            }

          (mods, classes) match {
            case (Empty, Empty) =>
              Empty
            case (Empty, classes) =>
              classes.mapNotNone(x => maybeClassComponent(x, outer, scope / x))
            case (mods, Empty) =>
              handleMods(mods)
            case (IArray.first(mod), IArray.first(cls)) =>
              val newScope = scope / cls
              maybeClassComponent(cls, outer, newScope) match {
                case None => handleMods(mods)
                case Some(clsComp) =>
                  val nested = recurse(newScope, separateMod(mod, newScope).restAsPackage).sortBy(_.fullName)
                  IArray(clsComp.withNested(nested))
              }
          }
        }

        val _3: IArray[Component] =
          fields.flatMap { x =>
            /* translate to module first (it will be translated back later) to find nested components */
            val anns     = IArray(locationFrom(scope / x))
            val asModule = ModuleTree(anns, x.name, IArray(x.tpe), Empty, x.comments, x.codePath, isOverride = false)
            maybeModuleComponent(asModule, scope / asModule) match {
              case Left(_)  => Empty
              case Right(c) => IArray(c)
            }
          }
        val _4: IArray[Component] =
          methods.flatMap(x => IArray.fromOption(maybeMethodComponent(x, outer, scope / x)))

        IArray(_1, _2, _3, _4).flatten
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
        val propsRef        = PropsRef(flattenedParams.headOption.map(_.tpe).getOrElse(TypeRef.Object))
        def isAbstractProps = scope.isAbstract(propsRef.ref)
        def validName       = isUpper(method.name) || (Unnamed(method.name) && (isUpper(owner.name) || Unnamed(owner.name)))

        if (!validName || !isTopLevel || isAbstractProps) None
        else
          for {
            _ <- returnsElement(scope, method.resultType)
          } yield method.name match {
            case Name.APPLY =>
              Component(
                location        = Right(locationFrom(scope)),
                scalaRef        = TypeRef(owner.codePath),
                fullName        = componentName(scope, owner.annotations, owner.codePath),
                tparams         = method.tparams,
                propsRef        = propsRef,
                componentType   = ComponentType.Field,
                isAbstractProps = isAbstractProps,
                nested          = Empty,
                otherLocations  = Empty,
              )

            case _ =>
              Component(
                location        = Right(locationFrom(scope)),
                scalaRef        = TypeRef(method.codePath, TypeParamTree.asTypeArgs(method.tparams), NoComments),
                fullName        = componentName(scope, owner.annotations, QualifiedName(IArray(method.name))),
                tparams         = method.tparams,
                propsRef        = propsRef,
                componentType   = ComponentType.Function,
                isAbstractProps = isAbstractProps,
                nested          = Empty,
                otherLocations  = Empty,
              )

          }
      case _ => None
    }
  }

  case class SeparatedMod(
      cleanedParentRefs: IArray[TypeRef],
      applyMembers:      IArray[MethodTree],
      restAsPackage:     PackageTree,
  )

  def separateMod(mod: ModuleTree, scope: TreeScope): SeparatedMod = {
    val cleanedParentRefs: IArray[TypeRef] =
      mod.parents.map {
        case TypeRef(QualifiedName.TopLevel, IArray.exactlyOne(tpe), _) => tpe
        case other                                                      => other
      }

    val (applyMembers: IArray[MethodTree], restMembers: IArray[Tree]) = {
      val parents    = parentsResolver(scope, mod.copy(parents = cleanedParentRefs)).transitiveParents.values
      val allMembers = mod.members ++ IArray.fromTraversable(parents).flatMap(_.members)
      allMembers.partitionCollect { case m: MethodTree if m.name === Name.APPLY => m }
    }

    val restAsPackage = PackageTree(mod.annotations, mod.name, restMembers, mod.comments, mod.codePath)
    SeparatedMod(cleanedParentRefs, applyMembers, restAsPackage)
  }

  def maybeModuleComponent(mod: ModuleTree, scope: TreeScope): Either[PackageTree, Component] = {
    val separated = separateMod(mod, scope)

    val componentOpt: Option[Component] = {
      def fromParents = separated.cleanedParentRefs match {
        case Empty => None
        case some =>
          val asField = FieldTree(
            annotations = Empty,
            name        = mod.name,
            tpe         = TypeRef.Intersection(some, NoComments),
            impl        = ExprTree.native,
            isReadOnly  = true,
            isOverride  = mod.isOverride,
            comments    = mod.comments,
            codePath    = mod.codePath,
          )
          maybeFieldComponent(asField, mod, scope)
      }
      def fromApplies = separated.applyMembers.firstDefined(a => maybeMethodComponent(a, mod, scope / a))

      fromParents.orElse(fromApplies)
    }

    componentOpt match {
      case Some(component) =>
        val nested = recurse(scope, separated.restAsPackage)
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
              parentsResolver(newScope, rewritten).transitiveParents.collectFirst {
                case (tr, _) => pointsAtComponentType(newScope, tr)
              }.flatten
            case (x: TypeAliasTree, newScope) =>
              val rewritten = FillInTParams(x, newScope, current.targs, Empty)
              pointsAtComponentType(scope, rewritten.alias)
            case _ => None
          }
      }

    val fieldResult = pointsAtComponentType(scope, field.tpe).map(propsRef =>
      Component(
        location        = Right(locationFrom(scope)),
        scalaRef        = TypeRef(field.codePath),
        fullName        = componentName(scope, owner.annotations, QualifiedName(IArray(field.name))),
        tparams         = Empty,
        propsRef        = propsRef,
        componentType   = ComponentType.Field,
        isAbstractProps = scope.isAbstract(propsRef.ref),
        nested          = Empty,
        otherLocations  = Empty,
      ),
    )
    def isAliasToFC: Option[Component] =
      FollowAliases(scope)(field.tpe) match {
        case TypeRef.Function(paramTypes, ret) =>
          val params =
            paramTypes.map(tpe =>
              ParamTree(Name.dummy, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments),
            )

          maybeMethodComponent(
            MethodTree(
              annotations = field.annotations,
              level       = ProtectionLevel.Default,
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

  def maybeClassComponent(cls: ClassTree, owner: ContainerTree, scope: TreeScope): Option[Component] =
    if (cls.classType =/= ClassType.Class) None
    else
      parentsResolver(scope, cls).transitiveParents.firstDefined { (tr, _) =>
        reactNames.isComponent(tr).map { propsRef =>
          Component(
            location        = Right(locationFrom(scope)),
            scalaRef        = TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            fullName        = componentName(scope, owner.annotations, cls.codePath),
            tparams         = cls.tparams,
            propsRef        = propsRef,
            componentType   = ComponentType.Class,
            isAbstractProps = scope.isAbstract(propsRef.ref),
            nested          = Empty,
            otherLocations  = Empty,
          )
        }
      }

  object componentName {
    def apply(scope: TreeScope, anns: IArray[Annotation], codePath: QualifiedName): Name = {

      val fromCodePath = codePath.parts
        .filterNot(Unnamed)
        .reverse
        .takeWhile(n => !n.unescaped.endsWith("Mod") && n.unescaped != "mod")
        .headOption

      val name = fromCodePath.orElse(fromAnnotations(anns))

      IArray
        .fromOption(name)
        .map(x => nameVariants(x.unescaped).head)
        .distinct
        .map(_.capitalize)
        .mkString("") match {
        case ""                             => Name("Component")
        case other if other.endsWith("Cls") => Name(other.dropRight(3))
        case other                          => Name(other)
      }
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

  object LocationFrom {
    def unapply(anns: IArray[ClassAnnotation]): Option[LocationAnnotation] =
      anns.collectFirst {
        case a: Annotation.JsImport => a
        case a: Annotation.JsGlobal => a
        case Annotation.JsGlobalScope => Annotation.JsGlobalScope
      }
  }

  def locationFrom(scope: TreeScope): LocationAnnotation = {
    var baseLocationOpt: Option[LocationAnnotation] = None
    var after = List.empty[Tree]
    var idx   = 0

    while (idx < scope.stack.length && baseLocationOpt.isEmpty) {
      val current = scope.stack(idx)
      val base: Option[LocationAnnotation] =
        current match {
          case ClassTree(_, LocationFrom(loc), _, _, _, _, _, _, _, _, _) => Some(loc)
          case ModuleTree(LocationFrom(loc), _, _, _, _, _, _)            => Some(loc)
          case PackageTree(LocationFrom(loc), _, _, _, _)                 => Some(loc)
          case _                                                          => None
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
