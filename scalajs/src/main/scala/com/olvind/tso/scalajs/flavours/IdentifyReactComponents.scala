package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.seqs._

import scala.collection.mutable

class IdentifyReactComponents(reactNames: ReactNames) {
  def length(qualifiedName: QualifiedName): Int =
    qualifiedName.parts.foldRight(0)(_.unescaped.length + _)

  /* this is effectively a heuristic which component to use */
  implicit val ComponentOrdering: Ordering[Component] = Ordering.by { c =>
    /* sometimes there are typings both for transpiled and original code. Default to transpiled */
    val preferNotSrc =
      !c.scalaRef.typeName.parts.exists(part => part.unescaped.startsWith("src") && part.unescaped.endsWith("Mod"))

    val preferModule = !c.isGlobal
    /* because for instance mui ships with icons called `List` and `Tab` */
    val preferPropsMatchesName = c.props.fold(false)(_.name.unescaped.startsWith(c.fullName.unescaped))
    /* because for instance mui declares both a default and a names export, where only the former exists */
    val preferDefault = c.scalaRef.name === Name.Default
    /* because some libraries expect you to use top-level imports. shame for the tree shakers */
    val preferShortModuleName = -length(c.scalaRef.typeName)

    (preferNotSrc, preferModule, preferPropsMatchesName, preferDefault, preferShortModuleName)
  }

  def all(scope: TreeScope, tree: ContainerTree): List[Component] = {
    def go(p: ContainerTree, scope: TreeScope): List[Component] = {
      val fromSelf = p match {
        case ModuleTree(
            _,
            name,
            Seq(TypeRef(QualifiedName.TopLevel, Seq(tpe), _)),
            _,
            comments,
            codePath,
            isOverride,
            ) =>
          maybeFieldComponent(
            FieldTree(Nil, name, tpe, MemberImpl.Native, true, isOverride, comments, codePath),
            p,
            scope,
          )
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

    go(tree, scope).filterNot(c => reactNames.isComponent(c.scalaRef.typeName)).map(_.rewritten(scope, Wildcards.Remove))
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
      if (reactNames.isElement(current.typeName)) Some(current)
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
                  location         = locationFrom(scope),
                  scalaRef         = TypeRef(owner.codePath),
                  fullName         = componentName(scope, owner.annotations, owner.codePath, method.comments),
                  tparams          = method.tparams,
                  props            = propsTypeOpt,
                  isGlobal         = isGlobal(owner.annotations),
                  componentType    = ComponentType.Field,
                  isAbstractProps  = isAbstractProps,
                  componentMembers = Nil,
                )

              case _ =>
                Component(
                  location         = locationFrom(scope),
                  scalaRef         = TypeRef(method.codePath, TypeParamTree.asTypeArgs(method.tparams), NoComments),
                  fullName         = componentName(scope, owner.annotations, QualifiedName(method.name :: Nil), method.comments),
                  tparams          = method.tparams,
                  props            = propsTypeOpt,
                  isGlobal         = isGlobal(method.annotations),
                  componentType    = ComponentType.Function,
                  isAbstractProps  = isAbstractProps,
                  componentMembers = Nil,
                )

            }
      case _ => None
    }
  }

  def maybeFieldComponent(field: FieldTree, owner: ContainerTree, scope: TreeScope): Option[Component] = {
    def pointsAtComponentType(scope: TreeScope, current: TypeRef): Option[TypeRef] =
      if (reactNames.isComponent(current.typeName)) {
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
      tr <- pointsAtComponentType(scope, field.tpe)
      props = tr.targs.head
    } yield
      Component(
        location         = locationFrom(scope),
        scalaRef         = TypeRef(field.codePath),
        fullName         = componentName(scope, owner.annotations, QualifiedName(field.name :: Nil), field.comments),
        tparams          = Nil,
        props            = Some(props).filterNot(_ === TypeRef.Object),
        isGlobal         = isGlobal(field.annotations),
        componentType    = ComponentType.Field,
        isAbstractProps  = scope.isAbstract(props),
        componentMembers = Nil,
      )

    def isAliasToFC: Option[Component] =
      FollowAliases(scope)(field.tpe) match {
        case TypeRef.Function(params, ret) =>
          maybeMethodComponent(
            MethodTree(
              annotations = field.annotations,
              level       = ProtectionLevel.Default,
              name        = field.name,
              tparams     = Nil,
              params      = List(params.map(p => ParamTree(Name.dummy, false, p, None, NoComments))),
              impl        = field.impl,
              resultType  = ret,
              isOverride  = false,
              comments    = field.comments,
              codePath    = field.codePath,
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
        case (TypeRef(qname, props +: _, _), _) if reactNames isComponent qname =>
          Component(
            location         = locationFrom(scope),
            scalaRef         = TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            fullName         = componentName(scope, owner.annotations, cls.codePath, cls.comments),
            tparams          = cls.tparams,
            props            = Some(props).filterNot(_ === TypeRef.Object),
            isGlobal         = isGlobal(cls.annotations),
            componentType    = ComponentType.Class,
            isAbstractProps  = scope.isAbstract(props),
            componentMembers = cls.members.collect { case x: MemberTree => x },
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
        case ""                             => Name("component")
        case other if other.endsWith("Cls") => Name(other.dropRight(3))
        case other                          => Name(other)
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

  def locationFrom(scope: TreeScope): LocationAnnotation = {
    object Location {
      def unapply(anns: Seq[ClassAnnotation]): Option[LocationAnnotation] =
        anns.collectFirst {
          case a: Annotation.JsImport => a
          case a: Annotation.JsGlobal => a
          case Annotation.JsGlobalScope => Annotation.JsGlobalScope
        }
    }
    var baseLocationOpt: Option[LocationAnnotation] = None
    var after = List.empty[Tree]
    var idx   = 0

    while (idx < scope.stack.length && baseLocationOpt.isEmpty) {
      val current = scope.stack(idx)
      val base: Option[LocationAnnotation] =
        current match {
          case ClassTree(Location(loc), _, _, _, _, _, _, _, _, _) => Some(loc)
          case ModuleTree(Location(loc), _, _, _, _, _, _)         => Some(loc)
          case PackageTree(Location(loc), _, _, _, _)              => Some(loc)
          case _                                                   => None
        }

      if (base.isEmpty) {
        after = current :: after
      } else {
        baseLocationOpt = base
      }

      idx += 1
    }

    val ret = baseLocationOpt match {
      case Some(baseLocation) =>
        after.foldLeft(baseLocation) {
          case (ann, tree) if tree.name === Name.APPLY => ann
          case (Annotation.JsImport(mod, imported), tree) =>
            val newImported: Imported =
              imported match {
                case Imported.Namespace =>
                  tree.name match {
                    case Name.Default => Imported.Default
                    case other        => Imported.Named(List(other))
                  }
                case Imported.Default     => Imported.Named(List(Name.Default, tree.name))
                case Imported.Named(name) => Imported.Named(name :+ tree.name)
              }
            Annotation.JsImport(mod, newImported)
          case (Annotation.JsGlobal(name), tree) => Annotation.JsGlobal(name + tree.name)
          case (Annotation.JsGlobalScope, tree)  => Annotation.JsGlobal(QualifiedName(List(tree.name)))

        }
      case None => sys.error("Couldnt find base location for component")
    }
    ret
  }
}
