package com.olvind.tso
package importer

import ammonite.ops.{%, Path, mkdir}
import com.olvind.logging.Logger
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.ts.PackageJsonDeps

object UpToDateExternals {
  def apply(logger:                Logger[Unit],
            cacheFolder:           Path,
            ensurePresentPackages: Set[String],
            ignored:               Set[String]): InFolder = {
    mkdir(cacheFolder)

    val ensurePresentPackagesFixes = ensurePresentPackages.map {
      // yarn can apparently not resolve scoped packages with this syntax
      case s if s.contains("__") => s.split("__").mkString("@", "/", "")
      case other                 => other
    }
    val alreadyAddedExternals: Set[String] =
      Json.opt[PackageJsonDeps](cacheFolder / "package.json") match {
        case Some(PackageJsonDeps(_, deps, peerDeps, _, _, _)) =>
          (deps.getOrElse(Map.empty) ++ peerDeps.getOrElse(Map.empty)).map { case (name, _) => name }(
            collection.breakOut
          )
        case _ => Set.empty
      }

    val missingExternals: Set[String] =
      ensurePresentPackagesFixes -- alreadyAddedExternals -- ignored

    if (missingExternals.nonEmpty) {
      logger.warn(s"Adding missing externals $missingExternals")
      %("yarn", "add", "--ignore-scripts", missingExternals.toSeq)(
        cacheFolder
      )
    } else
      logger.warn(s"Externals is already up to date")

    InFolder(cacheFolder / 'node_modules)
  }
}
