package org.scalablytyped.converter.internal
package ts

object OptionalType extends (TsType => TsType) {
  val undefineds = Set[TsType](TsTypeRef.undefined, TsTypeRef.`null`)

  def unapply(tpe: TsType): Option[TsType] =
    tpe match {
      case TsTypeUnion(types) =>
        types.partition(undefineds) match {
          case (Empty, _) => None
          case (_, remaining) =>
            val rest = TsTypeUnion.simplified(remaining) // in case of nesting
            unapply(rest).orElse(Some(rest))
        }
      case _ => None
    }

  override def apply(tpe: TsType): TsType =
    TsTypeUnion.simplified(IArray(tpe, TsTypeRef.undefined))

  def maybe(tpe: TsType, isOptional: Boolean): TsType =
    if (isOptional) apply(tpe)
    else tpe

}
