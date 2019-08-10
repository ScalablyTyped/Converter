package com.olvind
package tso
package scalajs

import seqs._

object IdentifyReactComponents {
  sealed trait ComponentType

  object ComponentType {
    case object Class extends ComponentType
    case object Function extends ComponentType
    case object Field extends ComponentType
  }

  final case class Component(
      name:             Name,
      tparams:          Seq[TypeParamTree],
      props:            TypeRef,
      scalaLocation:    QualifiedName,
      isGlobal:         Boolean,
      componentType:    ComponentType,
      isAbstractProps:  Boolean,
      componentMembers: Seq[MemberTree],
      knownRef:         Option[TypeRef],
  ) {
    def ref = TypeRef(scalaLocation, TypeParamTree.asTypeArgs(tparams), NoComments)
  }

  object Component {
    def formatReferenceTo(ref: TypeRef, componentType: ComponentType): String = {
      val loc = Printer.formatTypeRef(0)(ref)

      componentType match {
        case ComponentType.Class => s"js.constructorOf[$loc]"
        case ComponentType.Field => loc
        case ComponentType.Function =>
          ref.typeName.parts match {
            case ownerQName :+ name =>
              val owner = Printer.formatQN(QualifiedName(ownerQName))
              s"""$owner.asInstanceOf[js.Dynamic].selectDynamic("${name.unescaped}")"""
          }
      }
    }

    def length(qualifiedName: QualifiedName): Int =
      qualifiedName.parts.foldRight(0)(_.unescaped.length + _)

    /* this is effectively a heurestic which component to use */
    implicit val ComponentOrdering: Ordering[Component] = Ordering.by { c =>
      val preferModule = !c.isGlobal
      /* because for instance mui ships with icons called `List` and `Tab` */
      val preferPropsMatchesName = c.props.name.unescaped.startsWith(c.name.unescaped)
      /* because for instance mui declares both a default and a names export, where only the former exists */
      val preferDefault = c.scalaLocation.parts.last === Name.Default
      /* because some libraries expect you to use top-level imports. shame for the tree shakers */
      val preferShortModuleName = -length(c.scalaLocation)

      (preferModule, preferPropsMatchesName, preferDefault, preferShortModuleName)
    }
  }

  def all(scope: TreeScope, tree: ContainerTree): Seq[Component] = {
    def go(p: ContainerTree, scope: TreeScope): Seq[Component] =
      p.members.flatMap {
        case x: ContainerTree => all(scope / x, x)
        case x: ClassTree     => maybeClassComponent(x, scope / x).toList
        case x: FieldTree     => maybeFieldComponent(x, p, scope / x).toList
        case x: MethodTree    => maybeMethodComponent(x, scope / x).toList
        case _ => Nil
      }

    go(tree, scope)
  }

  /* just one of each component (determined by name), which one is chosen by the `Ordering` implicit above */
  def limited(scope: TreeScope, tree: ContainerTree): Seq[Component] =
    all(scope, tree)
      .groupBy(_.name)
      .map { case (_, sameName) => sameName.max }
      .to[Seq]
      .sortBy(_.name)

  val Unnamed = Set(Name.Default, Name.namespaced)

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
      /* props and maybe context */
      case 1 | 2 =>
        def isTopLevel = scope.stack.forall {
          case _: ClassTree => false
          case _ => true
        }
        val propsParam      = flattenedParams.head
        def isAbstractProps = scope.isAbstract(propsParam.tpe)
        def validName       = method.name.value.head.isUpper || Unnamed(method.name)

        if (!validName || !isTopLevel || isAbstractProps) None
        else
          for {
            _ <- returnsElement(scope, method.resultType)
            compName <- componentName(method.annotations, QualifiedName(method.name :: Nil), method.comments)
          } yield
            Component(
              compName,
              tparams          = method.tparams,
              props            = propsParam.tpe,
              scalaLocation    = method.codePath,
              isGlobal         = isGlobal(method.annotations),
              componentType    = ComponentType.Function,
              isAbstractProps  = isAbstractProps,
              componentMembers = Nil,
              knownRef         = None,
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
      name <- componentName(owner.annotations, QualifiedName(tree.name :: Nil), tree.comments)
    } yield
      Component(
        name             = name,
        tparams          = Nil,
        props            = props,
        scalaLocation    = tree.codePath,
        isGlobal         = isGlobal(tree.annotations),
        componentType    = ComponentType.Field,
        isAbstractProps  = scope.isAbstract(props),
        componentMembers = Nil,
        knownRef         = None,
      )
  }

  def maybeClassComponent(cls: ClassTree, scope: TreeScope): Option[Component] =
    if (cls.classType =/= ClassType.Class) None
    else
      ParentsResolver(scope, cls).transitiveParents.collectFirst {
        case (TypeRef(qname, props +: _, _), _) if Names.isComponent(qname) =>
          componentName(cls.annotations, cls.codePath, cls.comments).map(
            compName =>
              Component(
                compName,
                tparams         = cls.tparams,
                props           = props,
                scalaLocation   = cls.codePath,
                isGlobal        = isGlobal(cls.annotations),
                componentType   = ComponentType.Class,
                isAbstractProps = scope.isAbstract(props),
                componentMembers = cls.members.collect {
                  case x: MemberTree => x
                },
                knownRef = Some(TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments)),
              ),
          )
      }.flatten

  def componentName(annotations: Seq[Annotation], codePath: QualifiedName, comments: Comments): Option[Name] = {
    val fromCodePath = codePath.parts.last match {
      case Name.Default | Name.namespaced =>
        None
      case other =>
        Some(Annotation.realName(annotations, other))
    }

    val fromAnnotation: Option[Name] =
      annotations.collectFirst {
        case Annotation.JsImport(_, Imported.Named(name)) if name =/= Name.Default && name =/= Name.namespaced => name
        case Annotation.JsImport(mod, _) =>
          val fragment =
            mod.split("/").filterNot(x => x === Name.Default.unescaped || x === Name.namespaced.unescaped).last
          Name(prettyString(fragment.capitalize, "", forceCamelCase = false))
      }

    val fromNameHint: Option[Name] =
      comments.extract { case Markers.NameHint(hint) => Name(hint) }.map(_._1)

    fromCodePath orElse fromAnnotation orElse fromNameHint
  }

  def isGlobal(as: Seq[Annotation]): Boolean =
    as exists {
      case Annotation.JsGlobal(_)   => true
      case Annotation.JsGlobalScope => true
      case _                        => false
    }

  object Names {
    val React         = List(ScalaConfig.outputPkg, Name("react"), Name("reactMod"))
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
