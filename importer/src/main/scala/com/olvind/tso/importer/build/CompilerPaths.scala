package com.olvind
package tso
package importer
package build

import ammonite.ops.Path

case class CompilerPaths private (baseDir: Path, sourcesDir: Path, classesDir: Path)

object CompilerPaths {
  //changing this? Have a look at `CommitRun` as well - i was lazy
  def apply(v: Versions, thisBaseDir: Path): CompilerPaths =
    new CompilerPaths(
      thisBaseDir,
      sourcesDir = thisBaseDir / "src" / 'main / 'scala,
      classesDir = thisBaseDir / "target" / s"scala-${v.binVersion}" / 'classes,
    )

  def of(v: Versions, baseDir: Path, libName: String) =
    apply(v, baseDir / libName.filter(_.isLetterOrDigit).take(1) / libName)
}
