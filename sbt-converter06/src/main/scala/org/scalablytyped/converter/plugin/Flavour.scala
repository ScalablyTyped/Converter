package org.scalablytyped.converter.plugin

sealed trait Flavour
object Flavour {
  case object Plain extends Flavour
  case object Normal extends Flavour
  case object Slinky extends Flavour
  case object SlinkyNative extends Flavour
  case object Japgolly extends Flavour
}
