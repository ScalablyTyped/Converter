package org.scalablytyped.converter.plugin

import org.scalablytyped.converter.internal.ImportTypings
import sbt.{File, taskKey}

trait ExternalNpmKeys {
  val stImport = taskKey[ImportTypings.InOut]("Imports all the bundled npm and generates bindings")
  val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
  val stPublishCache = taskKey[Unit]("Publish all necessary files to cache")
}
