package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TreeScope.LoopDetector

/**
  * We also don't really implement this. We try to recover whatever useful types are in there
  */
/** We dont really implement this stuff, we just ignore the effects of the type mapping.
  * This line below is a very rough approximation to picking the original unmapped type
  */
object SimplifyTypes extends TreeVisitorScopedChanges {
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

  override def leaveTsType(scope: TreeScope)(x: TsType): TsType =
    x match {
      case lookup: TsTypeLookup =>
        expandLookupType(scope, lookup) getOrElse x

      case x: TsTypeConditional =>
        /* It's common to nest these things, so handle that */
        def go(x: TsType): List[TsType] =
          x match {
            case xx: TsTypeConditional =>
              val types: List[TsType] =
                go(xx.ifFalse) ::: go(xx.ifTrue)

              val inferredNames: Seq[TsIdent] =
                TreeTraverse.collect(xx.pred) { case TsTypeInfer(tp) => tp.name }

              lazy val inferAny: TsType => TsType = {
                val rewrites: Map[TsType, TsType] =
                  Map(inferredNames.map(ident => TsTypeRef.of(ident) -> TsTypeRef.any): _*)

                new ts.transforms.TypeRewriter(x).visitTsType(rewrites)
              }

              types map inferAny

            case other => other :: Nil
          }

        unify(go(x))

      case other => other
    }

  def expandLookupType(scope: TreeScope, lookup: TsTypeLookup): Option[TsType] =
    lookup.key match {
      case Left(key) =>
        lookup.from match {
          case TsTypeRef(TsQIdent(Seq(tparam)), Nil) if scope.tparams.contains(tparam) => None
          case fromTypeRef: TsTypeRef =>
            val members = AllMembersFor(scope, new LoopDetector)(fromTypeRef)
            Some(unify(pickNonStatic(members, key)))

          case TsTypeObject(members) => Some(unify(pickNonStatic(members, key)))
          case _                     => None
        }
      case Right(_) =>
        //todo: need to investigate what's going on here
        None
    }

  def pickNonStatic(members: Seq[TsMember], key: TsIdent): Seq[TsType] =
    members collect {
      case TsMemberProperty(_, _, `key`, tpeOpt, false, _, isOptional) =>
        optional(tpeOpt getOrElse TsTypeRef.any, isOptional)
      case TsMemberFunction(_, _, `key`, signature, false, _, isOptional) =>
        optional(TsTypeFunction(signature), isOptional)
    }
}
