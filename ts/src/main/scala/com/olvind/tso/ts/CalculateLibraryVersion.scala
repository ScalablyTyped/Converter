package com.olvind.tso
package ts

trait CalculateLibraryVersion {
  def apply(
      sourceFolder:   InFolder,
      isStdLib:       Boolean,
      packageJsonOpt: Option[PackageJsonDeps],
      comments:       Comments,
  ): LibraryVersion
}

object CalculateLibraryVersion {
  object PackageJsonOnly extends CalculateLibraryVersion {
    override def apply(
        sourceFolder:   InFolder,
        isStdLib:       Boolean,
        packageJsonOpt: Option[PackageJsonDeps],
        comments:       Comments,
    ): LibraryVersion = LibraryVersion(packageJsonOpt.flatMap(_.version), None)
  }
}
