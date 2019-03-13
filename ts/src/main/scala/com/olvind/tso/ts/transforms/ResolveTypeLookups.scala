package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import seqs.TraversableOps

object ResolveTypeLookups extends TreeTransformationScopedChanges {
  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case lookup: TsTypeLookup =>
        expandLookupType(scope, lookup) getOrElse x

      case other => other
    }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  def optional(tpe: TsType, isOptional: Boolean): TsType =
    if (isOptional) TsTypeUnion.simplified(tpe :: TsTypeRef.undefined :: Nil)
    else tpe

  def memberName(x: TsMember): Option[TsIdent] = x match {
    case x: TsMemberProperty => Some(x.name)
    case x: TsMemberFunction => Some(x.name)
    case _ => None
  }

  def nonEmpty[C[t] <: TraversableOnce[t], T](ct: C[T]): Option[C[T]] =
    if (ct.isEmpty) None else Some(ct)

  def keysOf(scope: TsTreeScope)(target: TsType): Seq[TsIdent] =
    target match {
      case ref: TsTypeRef =>
        AllMembersFor(scope, LoopDetector.initial)(ref).flatMap(memberName)
      case TsTypeObject(members) =>
        members flatMap memberName
      case TsTypeUnion(types) =>
        types flatMap keysOf(scope)
      case TsTypeIntersect(types) =>
        types flatMap keysOf(scope)
      case _ =>
        Nil
    }

  def stringsFrom(scope: TsTreeScope, tpe: TsType): Option[Set[TsIdent]] =
    nonEmpty {
      tpe match {
        case TsTypeLiteral(TsLiteralString(s)) =>
          Set(TsIdent(s))
        case TsTypeUnion(types) =>
          (types flatMap (tpe => stringsFrom(scope, tpe) getOrElse Nil)).toSet
        case keyof: TsTypeKeyOf =>
          keysOf(scope)(keyof.key).toSet
        case _ => Set.empty
      }
    }

  def expandLookupType(scope: TsTreeScope, lookup: TsTypeLookup): Option[TsType] =
    stringsFrom(scope, lookup.key) flatMap { strings =>
      lookup.from match {
        case TsTypeRef(_, name, _) if scope isAbstract name => None
        case fromTypeRef: TsTypeRef =>
          val members = AllMembersFor(scope, LoopDetector.initial)(fromTypeRef)
          Some(pick(members, strings))

        case TsTypeObject(members) => Some(pick(members, strings))
        case _                     => None
      }
    }

  val NonStatic = false

  def pick(members: Seq[TsMember], strings: Set[TsIdent]): TsType =
    TsTypeUnion.simplified(strings.toList.map(x => pick(members, x)) filterNot toIgnore)

  def pick(members: Seq[TsMember], Wanted: TsIdent): TsType = {
    val (functions, fields, _) = members.partitionCollect2(
      { case TsMemberFunction(_, _, Wanted, sig, NonStatic, _, false) => sig }, {
        case TsMemberProperty(_, _, Wanted, tpeOpt, _, NonStatic, _, isOptional) =>
          optional(tpeOpt getOrElse TsTypeRef.any, isOptional)
        case TsMemberFunction(_, _, Wanted, sig, NonStatic, _, _) => TsTypeFunction(sig)
      }
    )
    val combinedFunctions: Option[TsType] = functions.distinct match {
      case Nil      => None
      case Seq(one) => Some(TsTypeFunction(one))
      case more     => Some(TsTypeObject(more.map(sig => TsMemberCall(NoComments, Default, sig))))
    }

    /**
      * TsTypeIntersect.simplified simplifies a set of types into a union types, a normal type, or `never`.
      *    The latter is the least useful, so let's rewrite it to any
      */
    TsTypeIntersect.simplified(combinedFunctions.foldLeft(fields)(_ :+ _) filterNot toIgnore) match {
      case TsTypeRef.never => TsTypeRef.any
      case other           => other
    }
  }
}
