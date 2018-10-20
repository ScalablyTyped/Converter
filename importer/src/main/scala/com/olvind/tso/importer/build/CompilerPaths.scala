package com.olvind
package tso
package importer
package build

import ammonite.ops.Path

case class CompilerPaths private (baseDir: Path, sourcesDir: Path, classesDir: Path)

object CompilerPaths {
  //changing this? Have a look at `CommitRun` as well - i was lazy
  def of(baseDir: OutFolder, libName: String) = {
    val thisBaseDir = baseDir.folder / libName.filter(_.isLetterOrDigit).take(1) / libName
    new CompilerPaths(
      thisBaseDir,
      sourcesDir = thisBaseDir / ContentSbtProject.sourcesDir,
      classesDir = thisBaseDir / ContentSbtProject.classesDir
    )
  }
}
