package org.scalablytyped.converter.internal

import org.scalablytyped.converter.internal.scalajs.Dep
import sbt.Def
import sbt.Keys.ivyPaths
import sbt.librarymanagement.ModuleID

object Utils {
  val IvyLocal = Def.setting(ivyPaths.value.ivyHome.fold(constants.defaultLocalPublishFolder)(os.Path(_) / "local"))

  def asModuleID(dep: Dep.Concrete): ModuleID =
    ModuleID(dep.org, dep.mangledArtifact, dep.version)
}
