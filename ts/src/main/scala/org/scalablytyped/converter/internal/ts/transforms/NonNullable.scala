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
  * Aliases are only followed for the target of a lookup. Elsewhere they are kept, since an alias like `React.ReactNode`
  * means more to us than the union it expands to. `NonNullable<React.ReactNode>` for a required `children` would
  * otherwise become a union which the react flavours no longer recognize as a node.
  *
  * Adapted from Øyvind Raddum Berg's `mui5-support` branch.
  */
object NonNullable extends TreeTransformationScopedChanges {
  val nullables: Set[TsType] = Set(TsTypeRef.`null`, TsTypeRef.undefined)

  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeLookup(from, key) =>
        withoutNullables(from)(tpe => FollowAliases(scope)(tpe)).fold[TsType](x)(TsTypeLookup(_, key))
      case other =>
        withoutNullables(other)(identity).getOrElse(other)
    }

  private def withoutNullables(tpe: TsType)(expand: TsType => TsType): Option[TsType] =
    tpe match {
      case TsTypeRef(_, TsQIdent.Std.NonNullable, IArray.exactlyOne(tparam)) =>
        expand(tparam) match {
          case TsTypeUnion(types) =>
            val filtered = types.filterNot(nullables)
            if (filtered.length =/= types.length) Some(TsTypeUnion.simplified(filtered)) else None
          case _ => None
        }
      case _ => None
    }
}
