package com.olvind.tso.ts

object FollowAliases {
  def apply(scope: TsTreeScope)(tpe: TsType): TsType =
    tpe match {
      case typeRef: TsTypeRef =>
        scope
          .lookupTypeIncludeScope(typeRef.name)
          .collectFirst {
            case (ta: TsDeclTypeAlias, newScope) =>
              apply(newScope)(FillInTParams(ta, typeRef.tparams).alias)
          }
          .getOrElse(typeRef)
      case other => other
    }
}
