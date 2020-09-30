package org.scalablytyped.converter.internal
package ts

object FollowAliases {
  def apply(scope: TsTreeScope)(tpe: TsType): TsType =
    tpe match {
      case typeRef: TsTypeRef =>
        scope
          .lookupTypeIncludeScope(typeRef.name)
          .collectFirst {
            case (ta: TsDeclTypeAlias, newScope) => apply(newScope)(FillInTParams(ta, typeRef.tparams).alias)
            /* see through thin interfaces which might be translated into type aliases */
            case (i @ TsDeclInterface(_, _, _, _, IArray.exactlyOne(_), Empty, _), newScope) =>
              apply(newScope)(FillInTParams(i, typeRef.tparams).inheritance.head)
          }
          .getOrElse(typeRef)
      case TsTypeIntersect(types) =>
        TsTypeIntersect.simplified(types.map(FollowAliases(scope)))
      case TsTypeUnion(types) =>
        TsTypeUnion.simplified(types.map(FollowAliases(scope)))
      case other => other
    }

  def typeRef(scope: TsTreeScope)(tr: TsTypeRef): TsTypeRef =
    scope
      .lookupTypeIncludeScope(tr.name)
      .firstDefined {
        case (ta: TsDeclTypeAlias, newScope) =>
          FillInTParams(ta, tr.tparams).alias match {
            case next: TsTypeRef => Some(typeRef(newScope)(next))
            case _ => None
          }
        /* see through thin interfaces which might be translated into type aliases */
        case (i @ TsDeclInterface(_, _, _, _, IArray.exactlyOne(_), Empty, _), newScope) =>
          Some(typeRef(newScope)(FillInTParams(i, tr.tparams).inheritance.head))

        case _ => None
      }
      .getOrElse(tr)

}
