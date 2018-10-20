package com.olvind.tso
package importer
package build

import ammonite.ops.RelPath

/* We base the calculation of version numbers on the hash of the generated project,
 *  which means we have to digest it before we enter the version.
 */
object VersionHack {
  val TemplateValue = "$$$___VERSION___$$$"

  def templateVersion(out:     SbtProjectLayout[RelPath, Array[Byte]],
                      version: String): SbtProjectLayout[RelPath, Array[Byte]] = {
    val (path, content) = out.buildSbt
    val patched         = new String(content, constants.Utf8).replace(TemplateValue, version)
    out.copy(buildSbt = path -> patched.getBytes(constants.Utf8))
  }
}
