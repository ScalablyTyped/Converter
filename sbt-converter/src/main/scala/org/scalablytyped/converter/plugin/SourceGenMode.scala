package org.scalablytyped.converter.plugin

import sbt.File

sealed trait SourceGenMode

object SourceGenMode {
  case object ResourceGenerator extends SourceGenMode

  case class Manual(toDir: File, overrideToDir: Map[String, File] = Map.empty) extends SourceGenMode
}
