package org.scalablytyped.converter.internal
package ts

object OptionalType {
  val undefineds = Set[TsType](TsTypeRef.undefined, TsTypeRef.`null`)

  def unapply(tpe: TsType): Option[TsType] =
    tpe match {
      case TsTypeUnion(types) =>
        types partition undefineds match {
          case (Nil, _)       => None
          case (_, remaining) => Some(TsTypeUnion.simplified(remaining))
        }
      case _ => None
    }
}
