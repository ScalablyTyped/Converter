package org.scalablytyped.converter.internal.ts

sealed trait ExportType

object ExportType {
  val NotNamed: Set[ExportType] = Set(ExportType.Namespaced, ExportType.Defaulted)

  case object Named extends ExportType
  case object Defaulted extends ExportType
  case object Namespaced extends ExportType
}
