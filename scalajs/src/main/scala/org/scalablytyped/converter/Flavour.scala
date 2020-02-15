package org.scalablytyped.converter

sealed trait Flavour

object Flavour {
  case object Normal extends Flavour
  case object Slinky extends Flavour
  case object SlinkyNative extends Flavour
  case object Japgolly extends Flavour
}
