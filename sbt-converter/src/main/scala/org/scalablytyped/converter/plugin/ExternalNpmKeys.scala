package org.scalablytyped.converter.plugin

import sbt.{taskKey, File}

trait ExternalNpmKeys {
  val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
}
