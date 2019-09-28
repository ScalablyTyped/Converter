package com.olvind.tso
package scalajs

import com.olvind.tso.maps._
import com.olvind.tso.seqs._

import scala.collection.immutable.SortedMap

object ConstructObjectOfType {
  /* javascript limitation */
  val MaxParamsForMethod = 254

  final case class Param(parameter: ParamTree, isOptional: Boolean, asString: Either[String, String => String])

  implicit val ParamOrdering: Ordering[Param] =
    Ordering.by((p: Param) => (p.isOptional, p.parameter.name))

  def apply(cls:     ClassTree, _scope: TreeScope, maxNum: Int = MaxParamsForMethod)(
      _handleMember: (TreeScope, MemberTree) => Option[Param],
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

    def go(p: ParentsResolver.Parent): Map[Name, Param] =
      p.parents.flatMap(go).toMap ++ p.classTree.index
        .mapNotNone(
          ms =>
            ms.firstDefined {
              case m: MemberTree => handleMember(m)
              case _ => None
            },
        )

    val builder = Builder(
      keptDirectParents.map(p => p -> go(p)).toMap,
      parents.unresolved ++ treatAsUnresolved,
      cls.index
        .mapNotNone(
          ms =>
            ms.firstDefined {
              case m: MemberTree => handleMember(m)
              case _ => None
            },
        )
        .toSorted,
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

        /**
          * hack: react exposes just too many props for intrinsics (`div`, `a`, etc) to cross the 254
          * parameter limit for *many* components. I've personally never needed the `*Capture` props,
          * and they are easy to filter out en masse.
          */
        val ownWithoutReactCaptures =
          if (own.contains(Name("onCompositionEnd")) && own.contains(Name("onCompositionEndCapture")))
            own.filterKeys(!_.unescaped.endsWith("Capture"))
          else own

        val shortened  = ownWithoutReactCaptures.take(maxNum - directParents.size - unresolved.length)
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
      fromParents ++ own ++ fromUnresolved
    }
  }

  def parentParameter(ref: TypeRef, isRequired: Boolean): (Name, Param) =
    ref.name -> Param(
      ParamTree(ref.name, ref, ExprTree.`null`, NoComments),
      !isRequired,
      Right(
        obj =>
          if (isRequired) s"if ($obj != null) js.Dynamic.global.Object.assign($obj, ${ref.name.value})"
          else s"js.Dynamic.global.Object.assign($obj, ${ref.name.value})",
      ),
    )
}
