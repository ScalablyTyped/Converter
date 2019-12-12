package com.olvind.tso.plugin

sealed trait PrettyStringType
object PrettyStringType {
  case object Simplifying extends PrettyStringType
  case object Regular extends PrettyStringType
}
