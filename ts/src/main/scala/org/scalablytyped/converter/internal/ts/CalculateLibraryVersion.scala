package org.scalablytyped.converter.internal
package ts

trait CalculateLibraryVersion {
  def apply(
      sourceFolder:   InFolder,
      isStdLib:       Boolean,
      packageJsonOpt: Option[PackageJson],
      comments:       Comments,
  ): LibraryVersion
}

object CalculateLibraryVersion {
  object PackageJsonOnly extends CalculateLibraryVersion {
    override def apply(
        sourceFolder:   InFolder,
        isStdLib:       Boolean,
        packageJsonOpt: Option[PackageJson],
        comments:       Comments,
    ): LibraryVersion = LibraryVersion(isStdLib, packageJsonOpt.flatMap(_.version), None)
  }
}
