package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.maps._
import com.olvind.tso.scalajs.flavours.Params.Res
import com.olvind.tso.scalajs.transforms.{CleanIllegalNames, UnionToInheritance}
import com.olvind.tso.seqs._

import scala.collection.immutable.SortedMap

object Params {
  /* javascript limitation */
  val MaxParamsForMethod = 254

  sealed trait Res[T] {
    def headOption: Option[T] = this match {
      case Res.One(_, value) => Some(value)
      case Res.Many(values)  => Some(values.head._2)
      case Res.Error(_)      => None
    }

    def asMap: Map[Name, T] = this match {
      case Res.One(name, value) => Map(name -> value)
      case Res.Many(values)     => values
      case Res.Error(_)         => Map.empty
    }

    def map[U](f: T => U): Res[U] = this match {
      case Res.Error(msg)       => Res.Error(msg)
      case Res.One(name, value) => Res.One(name, f(value))
      case Res.Many(values)     => Res.Many(values.mapValues(f))
    }
  }

  object Res {
    sealed trait Success[T] extends Res[T]
    object Success {
      def unapply[T](arg: Res[T]): Option[Success[T]] = arg match {
        case success: Success[T] => Some(success)
        case Error(_) => None
      }
    }
    case class Error[T](msg:   String) extends Res[T]
    case class One[T](name:    Name, value: T) extends Success[T]
    case class Many[T](values: Map[Name, T]) extends Success[T]

    def combine[T](ress: Seq[Res[T]]): Res[T] =
      ress.partitionCollect3(
        { case Error(msg)       => msg },
        { case One(name, value) => name -> value },
        { case Many(values)     => values },
      ) match {
        case (Nil, Seq((name, one)), Nil, _) => One(name, one)
        case (Nil, ones, manies, _)          => Many(ones.toMap ++ manies.flatten)
        case (errors, _, _, _)               => Error(errors.mkString(", "))
      }
  }

  def parentParameter(name: Name, ref: TypeRef, isRequired: Boolean): (Name, Left[Param, Nothing]) =
    name -> Left(
      Param(
        ParamTree(name, isImplicit = false, ref, if (isRequired) None else Some(TypeRef.`null`), NoComments),
        Right(
          obj =>
            if (!isRequired) s"if (${name.value} != null) js.Dynamic.global.Object.assign($obj, ${name.value})"
            else s"js.Dynamic.global.Object.assign($obj, ${name.value})",
        ),
      ),
    )
}

class Params(cleanIllegalNames: CleanIllegalNames) {

  def forClassTree(
      cls:           ClassTree,
      scope:         TreeScope,
      memberToParam: MemberToParam,
      maxNum:        Int,
  ): Res[Seq[Param]] =
    forClassTree(cls, scope, maxNum).map { eithers =>
      eithers.flatMap {
        case Left(param)   => Some(param)
        case Right(member) => memberToParam(scope, member)
      }.sorted
    }

  /**
    * this is only exported separately from the other `forClassTree` overload because the slinky integration does weird things
    */
  def forClassTree(cls: ClassTree, scope: TreeScope, maxNum: Int): Res[Seq[Either[Param, MemberTree]]] =
    cls.comments.extract { case UnionToInheritance.WasUnion(subclassRefs) => subclassRefs } match {
      case Some((subclassRefs, _)) =>
        Res.combine(subclassRefs.map { subClsRef =>
          scope
            .lookup(subClsRef.typeName)
            .collectFirst {
              case (subCls: ClassTree, _) =>
                forClassTree(FillInTParams(subCls, scope, subClsRef.targs, cls.tparams), scope, maxNum)
            }
            .getOrElse(Res.Error(s"Could not find ${subClsRef.typeName}"))
        })

      case None =>
        if (cls.classType =/= ClassType.Trait || !cls.isScalaJsDefined) Res.Error("Not @ScalaJSDefined trait")
        else {
          val parents = ParentsResolver(scope, cls)

          /* treat dictionaries specially, as they have no declared members */
          val (treatAsUnresolved, keptDirectParents) =
            parents.directParents.partitionCollect {
              case ParentsResolver.Parent(ref +: _)
                  if ref.typeName === QualifiedName.StringDictionary || ref.typeName === QualifiedName.NumberDictionary =>
                ref
            }

          val RemoveThis = TypeRewriter(
            Map(
              TypeRef.ThisType(NoComments) -> TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            ),
          )

          /* extract one per name, while undoing some renaming damage that we have done */
          def membersFrom(cls: ClassTree): Map[Name, Either[Param, MemberTree]] =
            RemoveThis
              .visitClassTree(scope)(cls)
              .members
              .collect {
                case (x: FieldTree) =>
                  val realName = realNameFrom(x.annotations, x.name)
                  realName -> Right(x.copy(name = realName))
                case (x: MethodTree) =>
                  val realName = realNameFrom(x.annotations, x.name)
                  realName -> Right(x.copy(name = realName))
              }
              .toMap

          def go(p: ParentsResolver.Parent): Map[Name, Either[Param, MemberTree]] =
            p.parents.flatMap(go).toMap ++ membersFrom(p.classTree)

          val builder =
            Builder(
              keptDirectParents.map(p => p -> go(p)).toMap,
              parents.unresolved ++ treatAsUnresolved,
              membersFrom(cls).toSorted,
            )

          Res.One(
            cls.name,
            builder
              .skipParentInlineIfMoreMembersThan(maxNum) { parent =>
                val isRequired = parent.classTree.members.exists {
                  case _: MethodTree => true
                  case FieldTree(_, _, Nullable(_), _, _, _, _, _) => false
                  case _: FieldTree => true
                  case _ => false
                }
                Params.parentParameter(parent.refs.head.name, parent.refs.head, isRequired)
              }
              .allParamsUnique
              .values
              .to[Seq],
          )
        }
    }

  private case class Builder(
      directParents: Map[ParentsResolver.Parent, Map[Name, Either[Param, MemberTree]]],
      unresolved:    Seq[TypeRef],
      own:           SortedMap[Name, Either[Param, MemberTree]],
  ) {

    def skipParentInlineIfMoreMembersThan(
        maxNum: Int,
    )(f:        ParentsResolver.Parent => (Name, Either[Param, MemberTree])): Builder = {
      val numParentMembers = directParents.foldLeft(0)((acc, p) => acc + p._2.size)
      if (own.size + numParentMembers + unresolved.length > maxNum) {

        val shortened  = own.take(maxNum - directParents.size - unresolved.length)
        val compressed = directParents.map { case (k, _) => f(k) }
        Builder(Map.empty, unresolved, shortened ++ compressed)
      } else this
    }

    /** It's not *the* most precise way of going about this (will lose useful overloads),
      *  but has the nice property that it keeps the closest/most specific definition of a member
      * */
    def allParamsUnique: Map[Name, Either[Param, MemberTree]] = {
      val fromParents    = directParents.foldLeft(Map.empty[Name, Either[Param, MemberTree]])(_ ++ _._2)
      val fromUnresolved = unresolved.map(typeRef => Params.parentParameter(typeRef.name, typeRef, isRequired = false))
      fromParents ++ fromUnresolved ++ own
    }
  }

  def realNameFrom(anns: Seq[Annotation], fallback: Name): Name =
    anns
      .collectFirst {
        case Annotation.JsName(name)                       => name
        case Annotation.JsImport(_, Imported.Named(names)) => names.last
        case Annotation.JsGlobal(qname)                    => qname.parts.last
      }
      .filterNot(cleanIllegalNames.Illegal)
      .getOrElse(fallback)
}
