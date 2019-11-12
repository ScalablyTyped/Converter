package com.olvind.tso.plugin

sealed trait Flavour
object Flavour {
  case object Normal extends Flavour
  case object ReactFacade extends Flavour
  case object Slinky extends Flavour
  case object Japgolly extends Flavour
}
