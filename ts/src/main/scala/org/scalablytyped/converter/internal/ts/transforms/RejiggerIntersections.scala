package org.scalablytyped.converter.internal
package ts
package transforms

/**
  * Handling diverse constellations of union and intersection types in scala seems impossible.
  *
  * Apply some duplication so we get larger types, but easier in the sense that they are plain union types
  *
  * as an example, translate this:
  * {{{
  * A & (B | C) & D
  * }}}
  *
  * into this:
  * {{{
  * (A & B & D) | (A & C & D)
  * }}}
  *
  * Pass on doing this for multiple union types for now to guard against code explosion.
  */
object RejiggerIntersections extends TreeTransformationScopedChanges {
  override def enterTsType(t: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeIntersect(types) =>
        types.partitionCollect { case x: TsTypeUnion => x } match {
          case (IArray.exactlyOne(union), rest) =>
            TsTypeUnion(union.types.map(tpe => TsTypeIntersect(tpe +: rest)))
          case _ => x
        }
      case _ => x
    }
}
