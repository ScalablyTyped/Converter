package com.olvind.tso
package scalajs

/* We base the calculation of version numbers on the hash of the generated project,
 *  which means we have to digest it before we enter the version.
 */
object VersionHack {
  val TemplateValue    = "$$$___VERSION___$$$"
  private val BuildSbt = OutRelFile("build.sbt")

  def templateVersion(out: OutRelFiles, version: String): OutRelFiles = {
    val contents: String = new String(out.files(BuildSbt), constants.Utf8)
    val patched = contents.replace(TemplateValue, version)
    out.copy(files = out.files.updated(BuildSbt, patched.getBytes(constants.Utf8)))
  }
}
