package org.scalablytyped.converter.plugin

import sbt.{File, taskKey}

trait ExternalNpmKeys {
  val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
}
