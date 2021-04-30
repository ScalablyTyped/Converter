package org.scalablytyped.converter.internal.ts

sealed trait MethodType
object MethodType {
  case object Normal extends MethodType
  case object Getter extends MethodType
  case object Setter extends MethodType
}
