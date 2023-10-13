package org.scalablytyped.converter.internal
package ts

object FollowAliases {
  def apply(scope: TsTreeScope, skipValidation: Boolean = false)(tpe: TsType): TsType =
    try tpe match {
      case typeRef: TsTypeRef =>
        scope
          .lookupType(typeRef.name, skipValidation)
          .collectFirst {
            case ta: TsDeclTypeAlias =>
              val next = FillInTParams(ta, typeRef.tparams).alias
              apply(scope, skipValidation)(next)
            /* see through thin interfaces which might be translated into type aliases */
            case i @ TsDeclInterface(_, _, _, _, IArray.exactlyOne(_), Empty, _) =>
              apply(scope, skipValidation)(FillInTParams(i, typeRef.tparams).inheritance.head)
          }
          .getOrElse(typeRef)
      case TsTypeIntersect(types) =>
        TsTypeIntersect.simplified(types.map(FollowAliases(scope, skipValidation)))
      case TsTypeUnion(types) =>
        TsTypeUnion.simplified(types.map(FollowAliases(scope, skipValidation)))
      case other => other
    } catch {
      case _: StackOverflowError =>
        val formatted = TsTypeFormatter(tpe)
        scope.logger.error(s"Recovered from SOE while following type alias $formatted")
        TsTypeRef.any.copy(comments = Comments(Comment.warning(s"circular $formatted")))
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
