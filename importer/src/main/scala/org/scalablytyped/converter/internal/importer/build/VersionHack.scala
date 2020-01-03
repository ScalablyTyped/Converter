package org.scalablytyped.converter.internal
package importer
package build

/* We base the calculation of version numbers on the hash of the generated project,
 *  which means we have to digest it before we enter the version.
 */
object VersionHack {
  val TemplateValue = "$$$___VERSION___$$$"

  def templateVersion[K](out: SbtProjectLayout[K, Array[Byte]], version: String): SbtProjectLayout[K, Array[Byte]] = {
    val (key, content) = out.buildSbt
    val patched        = new String(content, constants.Utf8).replace(TemplateValue, version)
    out.copy(buildSbt = key -> patched.getBytes(constants.Utf8))
  }
}
