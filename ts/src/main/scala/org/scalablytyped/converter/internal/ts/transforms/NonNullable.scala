package org.scalablytyped.converter.internal
package ts
package transforms

object NonNullable extends TreeTransformationScopedChanges {
  val nullables: Set[TsType] = Set(TsTypeRef.`null`, TsTypeRef.undefined)

  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeRef(_, TsQIdent.Std.NonNullable, IArray.exactlyOne(tparam)) =>
        FollowAliases(scope)(tparam) match {
          case TsTypeUnion(types) =>
            val filtered = types.filterNot(nullables)
            if (filtered.length != types.length) TsTypeUnion.simplified(filtered)
            else tparam
          case _ => x
        }
      case _ => x
    }
}
