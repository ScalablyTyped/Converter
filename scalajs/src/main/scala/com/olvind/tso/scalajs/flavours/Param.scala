package com.olvind.tso
package scalajs
package flavours

import scala.collection.immutable.SortedMap
import com.olvind.tso.seqs._
import com.olvind.tso.maps._

final case class Param(parameter: ParamTree, isOptional: Boolean, asString: Either[String, String => String])

object Param {
  /* javascript limitation */
  val MaxParamsForMethod = 254

  implicit val ParamOrdering: Ordering[Param] =
    Ordering.by((p: Param) => (p.isOptional, p.parameter.name))

  def forClassTree(cls: ClassTree, _scope: TreeScope, maxNum: Int = MaxParamsForMethod)(
      _handleMember:    (TreeScope, MemberTree) => Option[Param],
  ): Seq[Param] = {
    val scope = _scope / cls

    val parents = ParentsResolver(scope, cls)

    /* treat dictionaries specially, as they have no declared members */
    val (treatAsUnresolved, keptDirectParents) =
      parents.directParents.partitionCollect {
        case ParentsResolver.Parent(ref +: _)
            if ref.typeName === QualifiedName.StringDictionary || ref.typeName === QualifiedName.NumberDictionary =>
          ref
      }

    val clsRef = TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments)

    def handleMember(member: MemberTree): Option[Param] =
      _handleMember(scope, TypeRewriter(Map(TypeRef.ThisType(NoComments) -> clsRef)).visitMemberTree(scope)(member))

    /* extract one per name, undoing some renaming damage that we have done */
    def membersFrom(cls: ClassTree) =
      cls.members
        .collect {
          case (x: FieldTree) =>
            val realName = Annotation.realName(x.annotations, x.name)
            val xx       = x.copy(name = realName)
            handleMember(xx).map(p => realName -> p)
          case (x: MethodTree) =>
            val realName = Annotation.realName(x.annotations, x.name)
            val xx       = x.copy(name = realName)
            handleMember(xx).map(p => realName -> p)
          case _ => None
        }
        .flatten
        .toMap

    def go(p: ParentsResolver.Parent): Map[Name, Param] =
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
      .sorted
  }

  private case class Builder(
      directParents: Map[ParentsResolver.Parent, Map[Name, Param]],
      unresolved:    Seq[TypeRef],
      own:           SortedMap[Name, Param],
  ) {

    def skipParentInlineIfMoreMembersThan(maxNum: Int)(f: ParentsResolver.Parent => (Name, Param)): Builder = {
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
    def allParamsUnique: Map[Name, Param] = {
      val fromParents    = directParents.foldLeft(Map.empty[Name, Param])(_ ++ _._2)
      val fromUnresolved = unresolved.map(typeRef => parentParameter(typeRef, isRequired = false))
      fromParents ++ fromUnresolved ++ own
    }
  }

  def parentParameter(ref: TypeRef, isRequired: Boolean): (Name, Param) =
    ref.name -> Param(
      ParamTree(ref.name, false, ref, Some(TypeRef.`null`), NoComments),
      !isRequired,
      Right(
        obj =>
          if (isRequired) s"if (${ref.name.value} != null) js.Dynamic.global.Object.assign($obj, ${ref.name.value})"
          else s"js.Dynamic.global.Object.assign($obj, ${ref.name.value})",
      ),
    )
}
