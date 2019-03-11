package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.maps._
import com.olvind.tso.scalajs.ParentsResolver.Parent

import scala.collection.immutable.SortedMap
import seqs._

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
object Companions extends TreeTransformation {

//  /* javascript limitation */
  val MaxParamsForMethod = 254

  final case class Param(parameter: ParamTree, isOptional: Boolean, asString: Either[String, String => String])

  object Param {
    implicit val ParamOrdering: Ordering[Param] =
      Ordering.by((p: Param) => (p.isOptional, p.parameter.name))
  }

  override def enterContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    // Native JS objects cannot contain inner Scala traits, classes or objects (i.e., not extending js.Any)
    if (scope.stack.dropRight(1).exists { case _: ModuleTree => true; case _ => false })
      container
    else {
      def nameConflict(name: Name): Boolean =
        container.index.getOrElse(name, Nil) exists {
          case _: ContainerTree => true
          case _ => false
        }

      container.withMembers(container.members.flatMap {
        case cls: ClassTree
            if cls.classType === ClassType.Trait && cls.annotations
              .contains(ScalaJSDefined) && !nameConflict(cls.name) =>
          generateModule(scope, cls)
        case other =>
          List(other)
      })
    }

  def generateModule(scope: TreeScope, cls: ClassTree): List[InheritanceTree] = {
    val thisRef = TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments)

    val params: Seq[Param] =
      ByParent(cls, scope)
        .mapNotNone(memberParameter(thisRef))
        .skipParentInlineIfMoreMembersThan(MaxParamsForMethod) { parent =>
          val isRequired = parent.classTree.members.exists {
            case _: MethodTree => true
            case FieldTree(_, _, OptionalType(_), _, _, _, _, _) => false
            case _: FieldTree => true
          }
          parentParameter(parent.refs.head, isRequired)
        }
        .handleUnresolvedParents(typeRef => parentParameter(typeRef, isRequired = false))
        .values
        .to[Seq]
        .sorted

    val module =
      if (params.isEmpty) Nil
      else {
        val (optionals, inLiterals, Nil) = params.partitionCollect2(
          { case Param(_, _, Right(f))  => f },
          { case Param(_, _, Left(str)) => str }
        )
        val applyRet = TypeRef(
          QualifiedName(cls.name :: Nil),
          cls.tparams.map(tp => TypeRef(QualifiedName(tp.name :: Nil), Nil, NoComments)),
          NoComments
        )

        List(
          ModuleTree(
            Nil,
            cls.name,
            ModuleTypeScala,
            Nil,
            Seq(
              MethodTree(
                Inline :: Nil,
                Default,
                Name.APPLY,
                cls.tparams,
                params.map(_.parameter) :: Nil,
                MemberImplCustom(s"""{
                  |  val __obj = js.Dynamic.literal(${inLiterals.mkString(", ")})
                  |${optionals.map(f => "  " + f("__obj")).mkString("\n")}
                  |  __obj.asInstanceOf[${Printer.formatTypeRef(Nil, 0)(applyRet)}]
                  |}""".stripMargin),
                applyRet,
                isOverride = false,
                NoComments,
                cls.codePath + Name.APPLY
              )
            ),
            NoComments,
            cls.codePath
          )
        )
      }

    cls :: module
  }

  /**
    * The type parameter is mostly smoke and mirrors, it's one of two types.
    * This type exists to have a nice way to write `compressInto`
    */
  case class ByParent[T](directParents: Map[Parent, Map[Name, T]],
                         unresolved:    Seq[TypeRef],
                         own:           SortedMap[Name, T],
                         ownScope:      TreeScope) {
    def mapNotNone[U](f: (TreeScope, T) => Option[U]): ByParent[U] =
      ByParent(
        directParents.map { case (p, values) => p -> values.mapNotNone(x => f(ownScope / p.classTree, x)) },
        unresolved,
        own.mapNotNone(x => f(ownScope, x)),
        ownScope
      )

    def skipParentInlineIfMoreMembersThan(maxNum: Int)(f: Parent => (Name, T)): ByParent[T] = {
      val numParentMembers = directParents.foldLeft(0)((acc, p) => acc + p._2.size)
      if (own.size + numParentMembers + unresolved.length > maxNum) {
        val shortened  = own.take(maxNum - directParents.size - unresolved.length)
        val compressed = directParents.map { case (k, _) => f(k) }
        ByParent[T](Map.empty, unresolved, shortened ++ compressed, ownScope)
      } else this
    }

    /** It's not *the* most precise way of going about this (will lose useful overloads),
      *  but has the nice property that it keeps the closest/most specific definition of a member
      * */
    def handleUnresolvedParents(handleUnresolved: TypeRef => (Name, T)): Map[Name, T] =
      directParents.foldLeft(Map.empty[Name, T])(_ ++ _._2) ++ own ++ unresolved.map(handleUnresolved)
  }

  object ByParent {
    def apply(cls: ClassTree, scope: TreeScope): ByParent[MemberTree] = {
      val parents = ParentsResolver(scope, cls)

      new ByParent(
        parents.directParents.map(p => p -> go(p)).toMap,
        parents.unresolved,
        firstValue(cls.index).toSorted,
        scope / cls
      )
    }

    def firstValue[K, V](x: Map[K, Seq[V]]): Map[K, V] =
      x.mapNotNone(_.headOption)

    def go(p: Parent): Map[Name, MemberTree] =
      p.parents.flatMap(go).toMap ++ firstValue(p.classTree.index)
  }

  def parentParameter(ref: TypeRef, isRequired: Boolean): (Name, Param) = {
    val name = ref.typeName.parts.last
    name -> Param(
      ParamTree(name, ref, Some(TypeRef.`null`), NoComments),
      !isRequired,
      Right(
        obj =>
          if (isRequired) s"if ($obj != null) js.Dynamic.global.Object.assign($obj, ${name.value})"
          else s"js.Dynamic.global.Object.assign($obj, ${name.value})"
      )
    )
  }

  def memberParameter(parentRef: TypeRef)(scope: TreeScope, x: MemberTree): Option[Param] = {
    /* this is our own fault... */
    val patched = TypeRewriter(Map(TypeRef.ThisType(NoComments) -> parentRef)).visitMemberTree(scope)(x)

    /* not really sure if this actually matters, but let's keep it safe :/ */
    def findOriginalName(current: Name, annotations: Seq[Annotation]): Name =
      annotations.collectFirst {
        case JsName(name) => name
      } getOrElse current

    /* yeah, i know. We'll refactor if we'll do many more rewrites */
    patched match {
      /* fix irritating type inference issue with `js.UndefOr[Double]` where you provide an `Int` */
      case FieldTree(anns, name, OptionalType(TypeRef.Double), _, _, _, _, _) =>
        val tpe          = TypeRef.Union(List(TypeRef.Int, TypeRef.Double), sort = false)
        val originalName = findOriginalName(name, anns)

        Some(
          Param(
            ParamTree(name, tpe, Some(TypeRef.`null`), NoComments),
            isOptional = true,
            Right(
              obj =>
                s"""if (${name.value} != null) $obj.updateDynamic("${originalName.unescaped}")(${name.value}${OptionalCast.Cast})"""
            )
          )
        )
      case FieldTree(anns, name, OptionalType(tpe), _, _, _, _, _) if !CanBeNull(tpe, scope / x) =>
        val originalName = findOriginalName(name, anns)

        Some(
          Param(
            ParamTree(name, TypeRef.UndefOr(tpe), Some(TypeRef.undefined), NoComments),
            isOptional = true,
            Right(
              obj =>
                s"""if (!js.isUndefined(${name.value})) $obj.updateDynamic("${originalName.unescaped}")(${name.value}${OptionalCast(
                  scope,
                  tpe
                )})"""
            )
          )
        )

      case FieldTree(anns, name, OptionalType(TypeRef.Function(paramTypes, retType)), _, _, _, _, _) =>
        val originalName    = findOriginalName(name, anns)
        val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"

        Some(
          Param(
            ParamTree(name, TypeRef.ScalaFunction(paramTypes, retType, NoComments), Some(TypeRef.`null`), NoComments),
            isOptional = true,
            Right(
              obj => s"""if (${name.value} != null) $obj.updateDynamic("${originalName.unescaped}")($convertedTarget)"""
            )
          )
        )

      case FieldTree(anns, name, OptionalType(_tpe), _, _, _, _, _) =>
        val originalName = findOriginalName(name, anns)
        val tpe          = if (_tpe === TypeRef.Wildcard) TypeRef.Any else _tpe

        Some(
          Param(
            ParamTree(name, tpe, Some(TypeRef.`null`), NoComments),
            isOptional = true,
            Right(
              obj =>
                s"""if (${name.value} != null) $obj.updateDynamic("${originalName.unescaped}")(${name.value}${OptionalCast(
                  scope,
                  tpe
                )})"""
            )
          )
        )

      case FieldTree(anns, name, TypeRef.Function(paramTypes, retType), _, _, _, _, _) =>
        val originalName    = findOriginalName(name, anns)
        val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"

        Some(
          Param(
            ParamTree(name, TypeRef.ScalaFunction(paramTypes, retType, NoComments), None, NoComments),
            isOptional = false,
            if (!ScalaNameEscape.needsEscaping(name.unescaped) && originalName === name)
              Left(s"""${name.value} = $convertedTarget""")
            else
              Right(
                obj => s"""$obj.updateDynamic("${originalName.unescaped}")($convertedTarget)"""
              )
          )
        )

      case FieldTree(anns, name, tpe, _, _, _, _, _) =>
        val originalName = findOriginalName(name, anns)
        Some(
          Param(
            ParamTree(name, tpe, None, NoComments),
            isOptional = false,
            if (!ScalaNameEscape.needsEscaping(name.unescaped) && originalName === name)
              Left(s"""${name.value} = ${name.value}${OptionalCast(scope, tpe)}""")
            else
              Right(
                obj => s"""$obj.updateDynamic("${originalName.unescaped}")(${name.value}${OptionalCast(scope, tpe)})"""
              )
          )
        )

      case _m: MethodTree =>
        val m               = FillInTParams(_m, scope, _m.tparams.map(_ => TypeRef.Any))
        val originalName    = findOriginalName(m.name, m.annotations)
        val convertedTarget = s"js.Any.fromFunction${m.params.flatten.length}(${m.name.value})"

        Some(
          Param(
            ParamTree(m.name,
                      TypeRef.ScalaFunction(m.params.flatten.map(p => p.tpe), m.resultType, NoComments),
                      None,
                      NoComments),
            isOptional = false,
            if (!ScalaNameEscape.needsEscaping(m.name.unescaped) && originalName === m.name)
              Left(s"""${m.name.value} = $convertedTarget""")
            else
              Right(obj => s"""$obj.updateDynamic("${originalName.unescaped}")($convertedTarget)""")
          )
        )
      case _ => None
    }
  }

  /* `js.|` doesn't extend js.Any */
  object OptionalCast {
    val Cast = ".asInstanceOf[js.Any]"

    def apply(scope: TreeScope, tpe: TypeRef): String =
      if (resolvesToUnionOrAbstract(tpe, scope)) { Cast } else ""

    def resolvesToUnionOrAbstract(tpe: TypeRef, scope: TreeScope): Boolean =
      tpe match {
        case x if scope.tparams.contains(x.typeName.parts.last) => true
        case TypeRef.Union(_)                                   => true
        case TypeRef.UndefOr(_)                                 => true
        case TypeRef.Intersection(types)                        => resolvesToUnionOrAbstract(types.head, scope)
        case other =>
          scope.lookup(other.typeName) collectFirst {
            case (TypeAliasTree(_, _, alias, _, _), newScope) => resolvesToUnionOrAbstract(alias, newScope)
          } getOrElse false
      }
  }

  /* primitives can not be `null` in Scala */
  object CanBeNull {
    val NotNullable: Set[TypeRef] =
      Set(TypeRef.Boolean, TypeRef.Int, TypeRef.Long, TypeRef.Unit, TypeRef.Double, TypeRef.Nothing)

    def apply(tpe: TypeRef, scope: TreeScope): Boolean =
      if (scope.tparams.contains(tpe.typeName.parts.last)) true
      else if (NotNullable(tpe)) false
      else {
        scope.lookup(tpe.typeName) collectFirst {
          case (TypeAliasTree(_, _, alias, _, _), newScope) => CanBeNull(alias, newScope)
        } getOrElse true
      }
  }

  object OptionalType {
    val undefineds = Set[TypeRef](TypeRef.Null)

    def unapply(tpe: TypeRef): Option[TypeRef] =
      tpe match {
        case TypeRef.UndefOr(tpe) =>
          tpe match {
            case OptionalType(tpe2) => Some(tpe2)
            case _                  => Some(tpe)
          }

        case TypeRef.Union(types) =>
          types partition undefineds match {
            case (Nil, _)       => None
            case (_, remaining) => Some(TypeRef.Union(remaining, sort = false))
          }
        case _ => None
      }
  }
}
