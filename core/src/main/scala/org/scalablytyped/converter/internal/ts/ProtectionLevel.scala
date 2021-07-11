package org.scalablytyped.converter.internal.ts

sealed trait TsProtectionLevel

object TsProtectionLevel {
  case object Default extends TsProtectionLevel
  case object Private extends TsProtectionLevel
  case object Protected extends TsProtectionLevel
}
