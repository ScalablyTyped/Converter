package com.olvind
package tso
package importer
package build

import ammonite.ops.Path

case class ProjectPaths private (baseDir: Path, sourcesDir: Path, classesDir: Path)

object ProjectPaths {
  //changing this? Have a look at `CommitRun` as well - i was lazy
  def of(baseDir: OutFolder, libName: String) = {
    val thisBaseDir = baseDir.folder / libName.filter(_.isLetterOrDigit).take(1) / libName
    new ProjectPaths(
      thisBaseDir,
      sourcesDir = thisBaseDir / versions.sourcesDir,
      classesDir = thisBaseDir / versions.classesDir
    )
  }
}
