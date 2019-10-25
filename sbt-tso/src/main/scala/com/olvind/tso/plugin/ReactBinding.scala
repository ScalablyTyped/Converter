package com.olvind.tso.plugin

sealed trait ReactBinding
object ReactBinding {
  object Native extends ReactBinding
  object Slinky extends ReactBinding
  object Japgolly extends ReactBinding
}
