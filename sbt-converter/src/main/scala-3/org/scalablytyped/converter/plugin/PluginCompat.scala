package org.scalablytyped.converter.plugin

import org.scalablytyped.converter.internal.ImportTypings
import sbt.Plugins
import sbt.plugins.JvmPlugin

/** The bits of the sbt api which differ between sbt 1.x (Scala 2.12) and sbt 2.x (Scala 3).
  *
  * There is a mirror of this file in `src/main/scala-2.12`, keep the signatures in sync.
  */
object PluginCompat {

  /** sbt 2.x has cross-platform (`%%%`) support built in, so there is no `sbt-platform-deps` to require. */
  val basePluginRequirements: Plugins = JvmPlugin

  /** The sbt versions this build of the plugin supports */
  def isSupportedSbtVersion(major: Int, minor: Int): Boolean =
    major == 2

  val supportedSbtVersions: String = "2.x"

  /** `allDependencies` is a cached task in sbt 2.x, and `stImport` is not something we can hash,
    * so this contribution has to opt out of caching. `Def.uncached` does not exist in sbt 1.x. */
  def allDependenciesFromImport(stImport: sbt.TaskKey[ImportTypings.InOut]): Seq[sbt.Def.Setting[_]] =
    Seq(sbt.Keys.allDependencies ++= sbt.Def.uncached(stImport.value._2.moduleIds.toSeq))
}
