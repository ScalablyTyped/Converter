package com.olvind.tso.ts

object FollowAliases {
  def apply(scope: TsTreeScope)(tpe: TsType): TsType =
    tpe match {
      case typeRef: TsTypeRef =>
        scope
          .lookupTypeIncludeScope(typeRef.name)
          .collectFirst {
            case (ta: TsDeclTypeAlias, newScope) => apply(newScope)(FillInTParams(ta, typeRef.tparams).alias)
          }
          .getOrElse(typeRef)
      case TsTypeIntersect(types) =>
        TsTypeIntersect.simplified(types map FollowAliases(scope))
      case TsTypeUnion(types) =>
        TsTypeUnion.simplified(types map FollowAliases(scope))
      case other => other
    }
}
