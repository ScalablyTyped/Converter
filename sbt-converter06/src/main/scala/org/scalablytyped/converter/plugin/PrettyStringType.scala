package org.scalablytyped.converter.plugin

sealed trait PrettyStringType
object PrettyStringType {
  case object Simplifying extends PrettyStringType
  case object Regular extends PrettyStringType
}
