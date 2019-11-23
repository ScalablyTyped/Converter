package com.olvind.tso.plugin

sealed trait ReactBinding
object ReactBinding {
  case object Native extends ReactBinding
  case object Slinky extends ReactBinding
  case object Japgolly extends ReactBinding
}
