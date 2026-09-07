package org.scalablytyped.converter.plugin

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import org.scalablytyped.converter.internal.ImportTypings
import sbt.Plugins
import sbt.plugins.JvmPlugin

/** The bits of the sbt api which differ between sbt 1.x (Scala 2.12) and sbt 2.x (Scala 3).
  *
  * There is a mirror of this file in `src/main/scala-3`, keep the signatures in sync.
  */
object PluginCompat {

  /** sbt 1.x gets `%%%` from `sbt-platform-deps`, which `sbt-scalajs` pulls in for us. */
  val basePluginRequirements: Plugins = JvmPlugin && PlatformDepsPlugin

  /** The sbt versions this build of the plugin supports */
  def isSupportedSbtVersion(major: Int, minor: Int): Boolean =
    major == 1 && minor >= 8

  val supportedSbtVersions: String = "1.8.x or later"

  /** sbt 1.x has no task caching, so this is just the plain contribution. See the sbt 2.x mirror. */
  def allDependenciesFromImport(stImport: sbt.TaskKey[ImportTypings.InOut]): Seq[sbt.Def.Setting[_]] =
    Seq(sbt.Keys.allDependencies ++= stImport.value._2.moduleIds.toSeq)
}
