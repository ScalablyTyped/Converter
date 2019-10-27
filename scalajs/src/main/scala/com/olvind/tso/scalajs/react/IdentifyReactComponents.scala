package com.olvind.tso
package scalajs
package react

import com.olvind.tso.seqs._

import scala.collection.mutable

object IdentifyReactComponents {
  def length(qualifiedName: QualifiedName): Int =
    qualifiedName.parts.foldRight(0)(_.unescaped.length + _)

  /* this is effectively a heurestic which component to use */
  implicit val ComponentOrdering: Ordering[Component] = Ordering.by { c =>
    val preferModule = !c.isGlobal
    /* because for instance mui ships with icons called `List` and `Tab` */
    val preferPropsMatchesName = c.props.fold(false)(_.name.unescaped.startsWith(c.fullName.unescaped))
    /* because for instance mui declares both a default and a names export, where only the former exists */
    val preferDefault = c.scalaLocation.parts.last === Name.Default
    /* because some libraries expect you to use top-level imports. shame for the tree shakers */
    val preferShortModuleName = -length(c.scalaLocation)

    (preferModule, preferPropsMatchesName, preferDefault, preferShortModuleName)
  }

  def all(scope: TreeScope, tree: ContainerTree): List[Component] = {
    def go(p: ContainerTree, scope: TreeScope): List[Component] = {
      val fromSelf = p match {
        case ModuleTree(_, name, Seq(TypeRef(QualifiedName.TopLevel, Seq(tpe), _)), _, comments, codePath) =>
          maybeFieldComponent(FieldTree(Nil, name, tpe, MemberImpl.Native, true, false, comments, codePath), p, scope)
        case _ => None
      }
      val fromMembers = p.members.flatMap {
        case x: ContainerTree => all(scope / x, x)
        case x: ClassTree     => maybeClassComponent(x, p, scope / x).toList
        case x: FieldTree     => maybeFieldComponent(x, p, scope / x).toList
        case x: MethodTree    => maybeMethodComponent(x, p, scope / x).toList
        case _ => Nil
      }
      fromSelf.toList ++ fromMembers
    }

    go(tree, scope)
  }

  /* just one of each component (determined by name), which one is chosen by the `Ordering` implicit above */
  def oneOfEach(scope: TreeScope, tree: ContainerTree): Seq[Component] =
    all(scope, tree)
      .groupBy(_.fullName)
      .map { case (_, sameName) => sameName.max }
      .to[Seq]
      .sortBy(_.fullName)

  val Unnamed = Set(Name.Default, Name.namespaced, Name.APPLY)

  def maybeMethodComponent(method: MethodTree, owner: ContainerTree, scope: TreeScope): Option[Component] = {
    def returnsElement(scope: TreeScope, current: TypeRef): Option[TypeRef] =
      if (current.typeName === QualifiedName.React.ReactElement) Some(current)
      else if (scope.isAbstract(current)) None
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
      /* optional props and context */
      case 0 | 1 | 2 =>
        def isTopLevel = scope.stack.forall {
          case _: ClassTree => false
          case _ => true
        }
        val propsTypeOpt    = flattenedParams.headOption.map(_.tpe)
        def isAbstractProps = propsTypeOpt.exists(scope.isAbstract)
        def validName       = isUpper(method.name) || (Unnamed(method.name) && (isUpper(owner.name) || Unnamed(owner.name)))

        if (!validName || !isTopLevel || isAbstractProps) None
        else
          for {
            _ <- returnsElement(scope, method.resultType)
          } yield
            method.name match {
              case Name.APPLY =>
                Component(
                  fullName         = componentName(scope, owner.annotations, owner.codePath, method.comments),
                  tparams          = method.tparams,
                  props            = propsTypeOpt,
                  scalaLocation    = owner.codePath,
                  isGlobal         = isGlobal(owner.annotations),
                  componentType    = ComponentType.Field,
                  isAbstractProps  = isAbstractProps,
                  componentMembers = Nil,
                  knownRef         = None,
                )

              case _ =>
                Component(
                  fullName         = componentName(scope, owner.annotations, QualifiedName(method.name :: Nil), method.comments),
                  tparams          = method.tparams,
                  props            = propsTypeOpt,
                  scalaLocation    = method.codePath,
                  isGlobal         = isGlobal(method.annotations),
                  componentType    = ComponentType.Function,
                  isAbstractProps  = isAbstractProps,
                  componentMembers = Nil,
                  knownRef         = None,
                )

            }
      case _ => None
    }
  }

  def maybeFieldComponent(tree: FieldTree, owner: ContainerTree, scope: TreeScope): Option[Component] = {
    def pointsAtComponentType(scope: TreeScope, current: TypeRef): Option[TypeRef] =
      if (QualifiedName.React.isComponent(current.typeName)) {
        Some(current)
      } else {
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

    val fieldResult = for {
      tr <- pointsAtComponentType(scope, tree.tpe)
      props = tr.targs.head
    } yield
      Component(
        fullName         = componentName(scope, owner.annotations, QualifiedName(tree.name :: Nil), tree.comments),
        tparams          = Nil,
        props            = Some(props).filterNot(_ === TypeRef.Object),
        scalaLocation    = tree.codePath,
        isGlobal         = isGlobal(tree.annotations),
        componentType    = ComponentType.Field,
        isAbstractProps  = scope.isAbstract(props),
        componentMembers = Nil,
        knownRef         = None,
      )

    def isAliasToFC: Option[Component] =
      FollowAliases(scope)(tree.tpe) match {
        case TypeRef.Function(params, ret) =>
          maybeMethodComponent(
            MethodTree(
              annotations = tree.annotations,
              level       = ProtectionLevel.Default,
              name        = tree.name,
              tparams     = Nil,
              params      = List(params.map(p => ParamTree(Name.dummy, p, None, NoComments))),
              impl        = tree.impl,
              resultType  = ret,
              isOverride  = false,
              comments    = tree.comments,
              codePath    = tree.codePath,
            ),
            owner,
            scope,
          )
        case _ => None
      }

    fieldResult orElse isAliasToFC
  }

  def maybeClassComponent(cls: ClassTree, owner: ContainerTree, scope: TreeScope): Option[Component] =
    if (cls.classType =/= ClassType.Class) None
    else
      ParentsResolver(scope, cls).transitiveParents.collectFirst {
        case (TypeRef(qname, props +: _, _), _) if QualifiedName.React isComponent qname =>
          Component(
            fullName        = componentName(scope, owner.annotations, cls.codePath, cls.comments),
            tparams         = cls.tparams,
            props           = Some(props).filterNot(_ === TypeRef.Object),
            scalaLocation   = cls.codePath,
            isGlobal        = isGlobal(cls.annotations),
            componentType   = ComponentType.Class,
            isAbstractProps = scope.isAbstract(props),
            componentMembers = cls.members.collect {
              case x: MemberTree => x
            },
            knownRef = Some(TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments)),
          )
      }

  object componentName {
    def apply(
        scope:    TreeScope,
        anns:     Seq[Annotation],
        codePath: QualifiedName,
        comments: Comments,
    ): Name = {
      val fromCodePath = codePath.parts.last match {
        case n if Unnamed(n) => None
        case other           => Some(other)
      }

      def fromNameHint = comments.extract { case Markers.NameHint(hint) => Name(hint) }.map(_._1)

      val name   = fromCodePath orElse fromAnnotations(anns) orElse fromNameHint
      val prefix = if (isGlobal(anns)) Nil else extractPrefix(scope)

      (prefix ++ name).map(_.unescaped.capitalize).distinct.mkString("") match {
        case ""    => Name("component")
        case other => Name(other)
      }
    }

    /**
      * Yeah, this turned out a bit complex.
      * If a component is not top-level in a module, we want to keep the name of its owner.
      * If that owner is something called `default` or `namespaced` we want to dig out the
      *  last part of the name of the module
      */
    def extractPrefix(scope: TreeScope): List[Name] = {

      val containers  = scope.stack.dropRight(2).collect { case x: ContainerTree => x } // drop typings and lib
      val kept        = mutable.ArrayBuffer.empty[Name]
      var idx         = 0
      var seenUnnamed = false

      while (idx < containers.length) {
        containers(idx) match {
          case c if Unnamed(c.name) =>
            seenUnnamed = true
          case mod if mod.name.unescaped.endsWith("Mod") =>
            /* we mostly don't include the module name, unless we have no other options */
            if (kept.isEmpty &&
                seenUnnamed &&
                mod.members.length < 10 /* if the container is large it's probably irrelevant */
                )
              fromAnnotations(mod.annotations) match {
                case Some(name) if !name.unescaped.contains("-") =>
                  kept += name
                case _ =>
              }
            idx = containers.length
          case c =>
            kept += c.name
        }

        idx += 1
      }

      kept.reverse.toList
    }

    def fromAnnotations(anns: Seq[Annotation]): Option[Name] =
      anns collectFirst {
        case Annotation.JsName(name)                                               => name
        case Annotation.JsImport(_, Imported.Named(names)) if !Unnamed(names.last) => names.last
        case Annotation.JsImport(mod, _) =>
          val fragment =
            mod
              .split("/")
              .filterNot(x => Unnamed(Name(x)))
              .last
          Name(prettyString(fragment, "", forceCamelCase = true))
        case Annotation.JsGlobal(qname) => qname.parts.last
      }
  }

  def isGlobal(as: Seq[Annotation]): Boolean =
    as exists {
      case Annotation.JsGlobal(_)   => true
      case Annotation.JsGlobalScope => true
      case _                        => false
    }

  def isUpper(n: Name): Boolean = n.value.head.isUpper
}
