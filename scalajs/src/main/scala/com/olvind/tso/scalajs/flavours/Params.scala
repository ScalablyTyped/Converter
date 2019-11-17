package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.maps._
import com.olvind.tso.scalajs.transforms.CleanIllegalNames
import com.olvind.tso.seqs._

import scala.collection.immutable.SortedMap

object Params {
  /* javascript limitation */
  val MaxParamsForMethod = 254
}

class Params(cleanIllegalNames: CleanIllegalNames) {

  def forClassTree(
                    cls:           ClassTree,
                    _scope:        TreeScope,
                    memberToParam: MemberToParam,
                    maxNum:        Int,
                  ): Seq[Param] =
    forClassTree(cls, _scope, maxNum).flatMap {
      case Left(param)   => Some(param)
      case Right(member) => memberToParam(_scope / cls, member)
    }.sorted

  def realNameFrom(anns: Seq[Annotation], fallback: Name): Name =
    anns
      .collectFirst {
        case Annotation.JsName(name)                       => name
        case Annotation.JsImport(_, Imported.Named(names)) => names.last
        case Annotation.JsGlobal(qname)                    => qname.parts.last
      }
      .filterNot(cleanIllegalNames.Illegal)
      .getOrElse(fallback)

  /**
    * this is only exported separately from the other `forClassTree` overload because the slinky integration does weird things
    */
  def forClassTree(cls: ClassTree, _scope: TreeScope, maxNum: Int): Seq[Either[Param, MemberTree]] = {
    val scope = _scope / cls

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

    builder
      .skipParentInlineIfMoreMembersThan(maxNum) { parent =>
        val isRequired = parent.classTree.members.exists {
          case _: MethodTree => true
          case FieldTree(_, _, Nullable(_), _, _, _, _, _) => false
          case _: FieldTree => true
          case _ => false
        }
        parentParameter(parent.refs.head, isRequired)
      }
      .allParamsUnique
      .values
      .to[Seq]
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
      val fromUnresolved = unresolved.map(typeRef => parentParameter(typeRef, isRequired = false))
      fromParents ++ fromUnresolved ++ own
    }
  }

  def parentParameter(ref: TypeRef, isRequired: Boolean): (Name, Left[Param, Nothing]) =
    ref.name -> Left(
      Param(
        ParamTree(ref.name, isImplicit = false, ref, if (isRequired) None else Some(TypeRef.`null`), NoComments),
        Right(
          obj =>
            if (!isRequired) s"if (${ref.name.value} != null) js.Dynamic.global.Object.assign($obj, ${ref.name.value})"
            else s"js.Dynamic.global.Object.assign($obj, ${ref.name.value})",
        ),
      ),
    )
}
