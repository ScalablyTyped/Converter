package org.scalablytyped.converter

sealed trait Flavour

object Flavour {
  case object Normal extends Flavour
  case object Slinky extends Flavour
  case object SlinkyNative extends Flavour
  case object Japgolly extends Flavour

  val all = Map(
    "normal" -> Flavour.Normal,
    "japgolly" -> Flavour.Japgolly,
    "slinky" -> Flavour.Slinky,
    "slinky-native" -> Flavour.SlinkyNative,
  )
}
