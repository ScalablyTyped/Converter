package org.scalablytyped.converter.internal.ts

sealed trait OptionalModifier {
  def apply(tpe: TsType): TsType =
    this match {
      case OptionalModifier.Noop        => tpe
      case OptionalModifier.Optionalize => OptionalType(tpe)
      case OptionalModifier.Deoptionalize =>
        tpe match {
          case OptionalType(rest) => rest
          case other              => other
        }
    }
}

object OptionalModifier {
  case object Noop extends OptionalModifier
  case object Optionalize extends OptionalModifier
  case object Deoptionalize extends OptionalModifier
}
