package org.scalablytyped.converter.plugin

import org.scalablytyped.converter.Selection
import sbt.{File, settingKey, taskKey}

trait GenSourceKeys {

  val stSourceGenMode = settingKey[SourceGenMode]("Whether to run automatically as source generator or manually")

  /**
   * A list of library names you don't care too much about.
   * The idea is that we can limit compile time (by a lot!)
   */
  val stMinimize = settingKey[Selection[String]]("Specify which libraries you want minimized")

  /**
   * If you care about a small set of specific things from a library you can explicitly say you want that.
   * Examples:
   * - `angularCommon.mod.AsyncPipe`
   * - `std.console`
   */
  val stMinimizeKeep = settingKey[List[String]]("a list of things you want to keep from minimized libraries")

  val stImport = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
}
