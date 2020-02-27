package org.scalablytyped.converter.internal
package importer
package build

import org.scalablytyped.converter.internal.scalajs.Versions

case class CompilerPaths private (
    baseDir:      os.Path,
    sourcesDir:   os.Path,
    resourcesDir: os.Path,
    targetDir:    os.Path,
    classesDir:   os.Path,
)

object CompilerPaths {
  //changing this? Have a look at `CommitRun` as well - i was lazy
  def apply(v: Versions, thisBaseDir: os.Path): CompilerPaths = {
    val targetDir = thisBaseDir / "target"
    new CompilerPaths(
      thisBaseDir,
      sourcesDir   = thisBaseDir / "src" / 'main / 'scala,
      resourcesDir = thisBaseDir / "src" / 'main / 'resources,
      targetDir    = targetDir,
      classesDir   = targetDir / s"scala-${v.scala.binVersion}" / 'classes,
    )
  }

  def of(v: Versions, baseDir: os.Path, libName: String) =
    apply(v, baseDir / libName.filter(_.isLetterOrDigit).take(1) / libName)
}
