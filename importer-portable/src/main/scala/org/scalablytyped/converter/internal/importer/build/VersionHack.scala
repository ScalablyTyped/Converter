package org.scalablytyped.converter.internal
package importer
package build

/* We base the calculation of version numbers on the hash of the generated project,
 *  which means we have to digest it before we enter the version.
 */
object VersionHack {
  val TemplateValue = "$$$___VERSION___$$$"

  def templateVersion[K](out: SbtProjectLayout[K, String], version: String): SbtProjectLayout[K, String] = {
    val (key, content) = out.buildSbt
    val patched        = content.replace(TemplateValue, version)
    out.copy(buildSbt = key -> patched)
  }
}
