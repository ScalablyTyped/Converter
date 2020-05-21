package org.scalablytyped.converter.internal

import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}
import sbt.librarymanagement.ModuleID

object Deps {
  def asModuleID(versions: Versions)(dep: Dep): ModuleID =
    ModuleID(dep.org, dep.mangledArtifact(versions), dep.version)
}
