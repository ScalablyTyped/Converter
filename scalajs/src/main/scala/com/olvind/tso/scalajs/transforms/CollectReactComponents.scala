package com.olvind.tso
package scalajs
package transforms

import seqs._

object CollectReactComponents {
  /* Let's not torture the scala compiler too much, because there *will* be a revenge
   * in the form of difficult-to-diagnose autoslaying
   */
  val MaxNumComponents = 3500

  sealed trait ComponentType

  object ComponentType {
    case object Class extends ComponentType
    case object Function extends ComponentType
    case object Field extends ComponentType
  }

  final case class Component(
      name:            Name,
      tparams:         Seq[TypeParamTree],
      props:           TypeRef,
      scalaLocation:   QualifiedName,
      isGlobal:        Boolean,
      componentType:   ComponentType,
      isAbstractProps: Boolean,
  )

  object Component {
    def length(qualifiedName: QualifiedName): Int =
      qualifiedName.parts.foldRight(0)(_.unescaped.length + _)

    /* this is effectively a heurestic which component to use */
    implicit val ComponentOrdering: Ordering[Component] = Ordering.by { c =>
      val preferModule = !c.isGlobal
      /* because for instance mui ships with icons called `List` and `Tab` */
      val preferPropsMatchesName = c.props.name.unescaped.startsWith(c.name.unescaped)
      /* because for instance mui declares both a default and a names export, while only the former exists */
      val preferDefault = c.scalaLocation.parts.last === Name.Default
      /* because some libraries expect you to to top-level imports. shame for the tree shakers */
      val preferShortModuleName = -length(c.scalaLocation)

      (preferModule, preferPropsMatchesName, preferDefault, preferShortModuleName)
    }
  }

  def apply(_scope: TreeScope, tree: ContainerTree): ContainerTree = {
    val scope = _scope / tree

    val allComponents: Seq[Component] =
      identify(scope, tree)
        .groupBy(_.name)
        .map { case (_, sameName) => sameName.max }
        .to[Seq]
        .sortBy(_.name)

    val components = allComponents take MaxNumComponents

    if (components.isEmpty) tree
    else {
      val comments = allComponents.length - components.length match {
        case 0          => NoComments
        case numDropped => Comments(Comment(s"/* Dropped $numDropped components to please scalac */\n"))
      }

      val traitName     = Name(tree.name.unescaped + "Props")
      val traitCodePath = tree.codePath + traitName
      val `trait` = {
        val forwarders: Seq[Tree] =
          components
            .sortBy(_.name.unescaped)
            .flatMap {
              case comp if comp.isAbstractProps => Nil
              case comp =>
                val propsName = Name(comp.name.unescaped + "Props")
                genPropsRef(scope, comp, traitCodePath, propsName) ++
                  genPropsAlias(scope, comp, traitCodePath, propsName)
            }

        ClassTree(
          annotations = Nil,
          name        = traitName,
          tparams     = Nil,
          parents     = Nil,
          ctors       = Nil,
          members     = forwarders,
          classType   = ClassType.Trait,
          isSealed    = false,
          comments    = NoComments,
          codePath    = traitCodePath,
        )
      }
      val module = {
        val moduleName     = Name(tree.name.unescaped + "Components")
        val moduleCodePath = tree.codePath + moduleName
        ModuleTree(
          annotations = Nil,
          name        = moduleName,
          parents     = List(TypeRef(traitCodePath)),
          members     = components.sortBy(_.name.unescaped).map(comp => genComponentRef(comp, moduleCodePath)),
          comments    = comments,
          codePath    = moduleCodePath,
        )
      }

      tree.withMembers(tree.members :+ module :+ `trait`)
    }
  }

  def genPropsAlias(
      scope:          TreeScope,
      comp:           Component,
      moduleCodePath: QualifiedName,
      propsName:      Name,
  ): Option[TypeAliasTree] =
    scope lookup comp.props.typeName collectFirst {
      case (x: TypeAliasTree, _) => x.tparams
      case (x: ClassTree, _)     => x.tparams
    } map { tps =>
      TypeAliasTree(
        propsName,
        tps,
        comp.props.copy(targs = TypeParamTree.asTypeArgs(tps)),
        NoComments,
        moduleCodePath + propsName,
      )
    }

  def genPropsRef(
      scope:          TreeScope,
      comp:           Component,
      moduleCodePath: QualifiedName,
      propsName:      Name,
  ): Option[MethodTree] =
    scope.lookup(comp.props.typeName).collectFirst {
      case (generatedPropsCompanion: ModuleTree, _) if !generatedPropsCompanion.isNative =>
        MethodTree(
          Inline :: Nil,
          Default,
          propsName,
          Nil,
          Nil,
          MemberImpl.Custom(Printer.formatQN(Nil, generatedPropsCompanion.codePath)),
          TypeRef.Singleton(comp.props.copy(targs = Nil)),
          isOverride = false,
          NoComments,
          moduleCodePath + propsName,
        )
    }

  def genComponentRef(comp: Component, moduleCodePath: QualifiedName): MethodTree = {
    val loc = Printer.formatTypeRef(Nil, 0)(
      TypeRef(comp.scalaLocation, TypeParamTree.asTypeArgs(comp.tparams), NoComments),
    )

    val ref = comp.componentType match {
      case ComponentType.Class => s"js.constructorOf[$loc]"
      case ComponentType.Field => loc
      case ComponentType.Function =>
        comp.scalaLocation.parts match {
          case ownerQName :+ name =>
            val owner = Printer.formatQN(Nil, QualifiedName(ownerQName))
            s"""$owner.asInstanceOf[js.Dynamic].selectDynamic("${name.unescaped}")"""
        }
    }

    MethodTree(
      Inline :: Nil,
      Default,
      comp.name,
      comp.tparams,
      Nil,
      MemberImpl.Custom(
        s"$ref.asInstanceOf[${Printer.formatTypeRef(Nil, 0)(TypeRef(Names.ComponentType, comp.props :: Nil, NoComments))}]",
      ),
      TypeRef(Names.ComponentType, comp.props :: Nil, NoComments),
      isOverride = false,
      NoComments,
      moduleCodePath + comp.name,
    )
  }

  def identify(scope: TreeScope, p: ContainerTree): Seq[Component] = {
    def go(p: ContainerTree, scope: TreeScope): Seq[Component] =
      p.members.flatMap {
        case x: ContainerTree => identify(scope / x, x)
        case x: ClassTree     => maybeClassComponent(x, scope / x).toList
        case x: FieldTree     => maybeFieldComponent(x, p, scope / x).toList
        case x: MethodTree    => maybeMethodComponent(x, scope / x).toList
        case _ => Nil
      }

    go(p, scope)
  }

  def maybeMethodComponent(method: MethodTree, scope: TreeScope): Option[Component] = {
    def returnsElement(scope: TreeScope, current: TypeRef): Option[TypeRef] =
      if (current.typeName === Names.Element) Some(current)
      else {
        scope
          .lookup(current.typeName)
          .firstDefined {
            case (x: TypeAliasTree, newScope) =>
              val rewritten = FillInTParams(x, newScope, current.targs, Nil)
              returnsElement(scope, rewritten.alias)
            case _ => None
          }
      }

    val flattenedParams = method.params.flatten

    flattenedParams.length match {
      case 1 | 2 =>
        /* props and maybe context */
        val isTopLevel = scope.stack.forall {
          case _: ClassTree => false
          case _ => true
        }
        val propsParam      = flattenedParams.head
        val isAbstractProps = scope.isAbstract(propsParam.tpe)

        /* this is clearly insufficient, but WFM right now */
        val mentionsProps =
          propsParam.name.unescaped.toLowerCase.contains("props") ||
            propsParam.tpe.name.unescaped.toLowerCase.contains("props")

        if (!isTopLevel || isAbstractProps || !mentionsProps) None
        else
          for {
            _ <- returnsElement(scope, method.resultType)
            compName <- componentName(method.annotations, QualifiedName(method.name :: Nil))
          } yield
            Component(
              compName,
              tparams         = method.tparams,
              props           = propsParam.tpe,
              scalaLocation   = method.codePath,
              isGlobal        = isGlobal(method.annotations),
              componentType   = ComponentType.Function,
              isAbstractProps = isAbstractProps,
            )
      case _ => None
    }
  }

  def maybeFieldComponent(tree: FieldTree, owner: ContainerTree, scope: TreeScope): Option[Component] = {
    def pointsAtComponentType(scope: TreeScope, current: TypeRef): Option[TypeRef] =
      if (Names.isComponent(current.typeName)) Some(current)
      else {
        scope
          .lookup(current.typeName)
          .firstDefined {
            case (x: ClassTree, newScope) =>
              val rewritten = FillInTParams(x, newScope, current.targs, Nil)
              ParentsResolver(newScope, rewritten).transitiveParents.collectFirst {
                case (tr, _) => pointsAtComponentType(newScope, tr)
              }.flatten
            case (x: TypeAliasTree, newScope) =>
              val rewritten = FillInTParams(x, newScope, current.targs, Nil)
              pointsAtComponentType(scope, rewritten.alias)
            case _ => None
          }
      }

    for {
      tr <- pointsAtComponentType(scope, tree.tpe)
      props = tr.targs.head
      name <- componentName(owner.annotations, QualifiedName(tree.name :: Nil))
    } yield
      Component(
        name            = name,
        tparams         = Nil,
        props           = props,
        scalaLocation   = tree.codePath,
        isGlobal        = isGlobal(tree.annotations),
        componentType   = ComponentType.Field,
        isAbstractProps = scope.isAbstract(props),
      )
  }

  def maybeClassComponent(cls: ClassTree, scope: TreeScope): Option[Component] =
    if (cls.classType =/= ClassType.Class) None
    else
      ParentsResolver(scope, cls).transitiveParents.collectFirst {
        case (TypeRef(qname, props +: _, _), _) if Names.isComponent(qname) =>
          componentName(cls.annotations, cls.codePath).map(
            compName =>
              Component(
                compName,
                tparams         = cls.tparams,
                props           = props,
                scalaLocation   = cls.codePath,
                isGlobal        = isGlobal(cls.annotations),
                componentType   = ComponentType.Class,
                isAbstractProps = scope.isAbstract(props),
              ),
          )
      }.flatten

  def componentName(annotations: Seq[Annotation], codePath: QualifiedName): Option[Name] = {
    val fromCodePath = codePath.parts.last match {
      case Name.Default | Name.namespaced =>
        None
      case other =>
        Some(Annotation.realName(annotations, other))
    }

    val fromAnnotation: Option[Name] =
      annotations.collectFirst {
        case JsImport(_, Imported.Named(name)) if name =/= Name.Default && name =/= Name.namespaced => name
        case JsImport(mod, _) =>
          val fragment =
            mod.split("/").filterNot(x => x === Name.Default.unescaped || x === Name.namespaced.unescaped).last
          Name(prettyString(fragment.capitalize, "", forceCamelCase = false))
      }

    fromCodePath orElse fromAnnotation
  }

  def isGlobal(as: Seq[Annotation]): Boolean =
    as exists {
      case JsGlobal(_)   => true
      case JsGlobalScope => true
      case _             => false
    }

  private object Names {
    val React         = List(Name("reactLib"), Name("reactMod"))
    val Component     = QualifiedName(React :+ Name("Component"))
    val ComponentType = QualifiedName(React :+ Name("ComponentType"))

    val Element = QualifiedName(React :+ Name("ReactElement"))

    val ComponentNames: Set[String] =
      Set(
        "ClassicComponent",
        "ClassicComponentClass",
        "Component",
        "ComponentClass",
        "ComponentType",
        "ExoticComponent",
        "FC",
        "FunctionComponent",
        "LazyExoticComponent",
        "MemoExoticComponent",
        "NamedExoticComponent",
        "ProviderExoticComponent",
        "PureComponent",
        "RefForwardingComponent",
        "SFC",
        "StatelessComponent",
      )

    val isComponent: Set[QualifiedName] = ComponentNames.map(n => QualifiedName(React :+ Name(n)))
  }
}
