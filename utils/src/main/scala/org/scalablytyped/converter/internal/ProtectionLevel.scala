package org.scalablytyped.converter.internal

sealed trait ProtectionLevel

object ProtectionLevel {
  case object Default extends ProtectionLevel
  case object Private extends ProtectionLevel
  case object Protected extends ProtectionLevel
}
