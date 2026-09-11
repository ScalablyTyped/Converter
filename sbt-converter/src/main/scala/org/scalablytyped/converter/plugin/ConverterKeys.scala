package org.scalablytyped.converter.plugin

import org.scalablytyped.converter.internal.ImportTypings
import sbt.taskKey

trait ConverterKeys {
  @transient val stImport       = taskKey[ImportTypings.InOut]("Imports all the bundled npm and generates bindings")
  @transient val stPublishCache = taskKey[Unit]("Publish all necessary files to cache")
}
