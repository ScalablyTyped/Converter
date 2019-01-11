package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector

object ResolveTypeLookups extends TreeTransformationScopedChanges {
  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case lookup: TsTypeLookup =>
        expandLookupType(scope, lookup) getOrElse x

      case other => other
    }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  /**
    * TsTypeUnion.simplified simplifies a set of types into a union types, a normal type, or `never`.
    *    The latter is the least useful, so let's rewrite it to any
    */
  def unify(types: Seq[TsType]): TsType =
    TsTypeUnion.simplified(types filterNot toIgnore) match {
      case TsTypeRef.never => TsTypeRef.any
      case other           => other
    }

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
        case TsTypeRef(_, name, Nil) if scope.isAbstract(name) => None
        case fromTypeRef: TsTypeRef =>
          val members = AllMembersFor(scope, LoopDetector.initial)(fromTypeRef)
          Some(unify(pickNonStatic(members, strings)))

        case TsTypeObject(members) => Some(unify(pickNonStatic(members, strings)))
        case _                     => None
      }
    }

  def pickNonStatic(members: Seq[TsMember], pick: Set[TsIdent]): Seq[TsType] =
    members collect {
      case TsMemberProperty(_, _, name, tpeOpt, _, false, _, isOptional) if pick(name) =>
        optional(tpeOpt getOrElse TsTypeRef.any, isOptional)
      case TsMemberFunction(_, _, name, signature, false, _, isOptional) if pick(name) =>
        optional(TsTypeFunction(signature), isOptional)
    }
}
