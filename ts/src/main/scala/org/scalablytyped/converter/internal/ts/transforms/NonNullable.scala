package org.scalablytyped.converter.internal
package ts
package transforms

/**
  * `NonNullable<A | null | undefined>` is `A`. Since TypeScript 4.8 `NonNullable<T>` is defined as `T & {}`, which
  * blocks lookups through it, like `NonNullable<BadgeTypeMap['props']['slotProps']>['root']` in @mui/material.
  *
  * Runs together with `ResolveTypeLookups`, so that the inner lookup is resolved (to `SlotProps | undefined`) before
  * we get here, and the outer lookup sees the union without `undefined`.
  *
  * Adapted from Øyvind Raddum Berg's `mui5-support` branch.
  */
object NonNullable extends TreeTransformationScopedChanges {
  val nullables: Set[TsType] = Set(TsTypeRef.`null`, TsTypeRef.undefined)

  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeRef(_, TsQIdent.Std.NonNullable, IArray.exactlyOne(tparam)) =>
        FollowAliases(scope)(tparam) match {
          case TsTypeUnion(types) =>
            val filtered = types.filterNot(nullables)
            if (filtered.length =/= types.length) TsTypeUnion.simplified(filtered) else x
          case _ => x
        }
      case _ => x
    }
}
