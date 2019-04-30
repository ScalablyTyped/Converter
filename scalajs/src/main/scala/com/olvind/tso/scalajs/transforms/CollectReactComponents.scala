package com.olvind.tso
package scalajs
package transforms

import seqs._

object CollectReactComponents {
  final case class Component(
      name:            Name,
      tparams:         Seq[TypeParamTree],
      props:           TypeRef,
      scalaLocation:   QualifiedName,
      isGlobal:        Boolean,
      isClass:         Boolean,
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

    val components: Seq[Component] =
      identify(scope, tree)
        .groupBy(_.name)
        .map { case (_, sameName) => sameName.max }
        .to[Seq]
        .sortBy(_.name)

    if (components.isEmpty) tree
    else {
      val moduleName     = Name(tree.name.unescaped + "Components")
      val moduleCodePath = tree.codePath + moduleName

      val propsPointers: Seq[Tree] =
        components
          .filterNot(_.isAbstractProps)
          .groupBy(_.props.name)
          .collect { case (name, xs) if xs.map(_.props.typeName).distinct.length === 1 => name -> xs.head }
          .to[Seq]
          .sortBy(_._1)
          .flatMap {
            case (_, comp) =>
              val alias = scope.lookup(comp.props.typeName).collectFirst {
                case (x: TypeAliasTree, _) => x.tparams
                case (x: ClassTree, _)     => x.tparams
              } map { tps =>
                TypeAliasTree(comp.props.name,
                              tps,
                              comp.props.copy(targs = TypeParamTree.asTypeArgs(tps)),
                              NoComments,
                              moduleCodePath + comp.props.name)
              }

              val reference = scope.lookup(comp.props.typeName).collectFirst {
                case (generatedPropsCompanion: ModuleTree, _)
                    if generatedPropsCompanion.moduleType === ModuleTypeScala =>
                  MethodTree(
                    Inline :: Nil,
                    Default,
                    generatedPropsCompanion.name,
                    Nil,
                    Nil,
                    MemberImplCustom(Printer.formatQN(Nil, generatedPropsCompanion.codePath)),
                    TypeRef.Singleton(comp.props.copy(targs = Nil)),
                    isOverride = false,
                    NoComments,
                    moduleCodePath + generatedPropsCompanion.name
                  )
              }

              reference.toList ++ alias
          }

      val componentPointers: Seq[Tree] =
        components
          .collect { case comp => (comp.name, comp) }
          .toMap
          .values
          .to[Seq]
          .sortBy(_.name)
          .map { comp =>
            val loc = Printer.formatTypeRef(Nil, 0)(
              TypeRef(comp.scalaLocation, TypeParamTree.asTypeArgs(comp.tparams), NoComments)
            )
            MethodTree(
              Inline :: Nil,
              Default,
              comp.name,
              comp.tparams,
              Nil,
              MemberImplCustom(s"${if (comp.isClass) s"js.constructorOf[$loc]" else loc}.asInstanceOf[${Printer
                .formatTypeRef(Nil, 0)(TypeRef(Names.ComponentType, comp.props :: Nil, NoComments))}]"),
              TypeRef(Names.ComponentType, comp.props :: Nil, NoComments),
              isOverride = false,
              NoComments,
              moduleCodePath + comp.name
            )
          }

      val module = ModuleTree(
        Nil,
        moduleName,
        ModuleTypeScala,
        Nil,
        componentPointers ++ propsPointers,
        NoComments,
        moduleCodePath
      )

      tree.withMembers(tree.members :+ module)
    }
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

  def maybeMethodComponent(tree: MethodTree, scope: TreeScope): Option[Component] = None

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

    pointsAtComponentType(scope, tree.tpe).map { tr =>
      val props = tr.targs.head
      Component(
        componentName(owner.annotations, QualifiedName(tree.name :: Nil)),
        tparams         = Nil,
        props           = props,
        scalaLocation   = tree.codePath,
        isGlobal        = isGlobal(tree.annotations),
        isClass         = false,
        isAbstractProps = scope.isAbstract(props)
      )
    }
  }

  def maybeClassComponent(cls: ClassTree, scope: TreeScope): Option[Component] =
    if (cls.classType =/= ClassType.Class) None
    else
      ParentsResolver(scope, cls).transitiveParents.collectFirst {
        case (TypeRef(qname, props +: _, _), _) if Names.isComponent(qname)=>
          Component(
            componentName(cls.annotations, cls.codePath),
            tparams         = cls.tparams,
            props           = props,
            scalaLocation   = cls.codePath,
            isGlobal        = isGlobal(cls.annotations),
            isClass         = true,
            isAbstractProps = scope.isAbstract(props)
          )
      }

  def componentName(annotations: Seq[Annotation], codePath: QualifiedName): Name = {
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

    fromCodePath orElse fromAnnotation getOrElse sys.error(
      s"Couldn't find component name for $annotations and $codePath"
    )
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
