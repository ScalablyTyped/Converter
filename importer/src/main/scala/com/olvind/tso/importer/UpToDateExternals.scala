package com.olvind.tso
package importer

import ammonite.ops.{%, mkdir, Path}
import com.olvind.logging.Logger
import com.olvind.tso.ts.PackageJsonDeps
import com.olvind.tso.importer.jsonCodecs._

object UpToDateExternals {
  def apply(logger:                Logger[Unit],
            cacheFolder:           Path,
            ensurePresentPackages: Set[String],
            ignored:               Set[String]): InFolder = {
    mkdir(cacheFolder)

    val alreadyAddedExternals: Set[String] =
      Json.opt[PackageJsonDeps](cacheFolder / "package.json") match {
        case Some(PackageJsonDeps(_, deps, peerDeps, _, _, _)) =>
          (deps.getOrElse(Map.empty) ++ peerDeps.getOrElse(Map.empty)).map { case (name, _) => name }(
            collection.breakOut
          )
        case _ => Set.empty
      }

    val missingExternals: Set[String] =
      ensurePresentPackages -- alreadyAddedExternals -- ignored

    if (missingExternals.nonEmpty) {
      logger.warn(s"Adding missing externals $missingExternals")
      %("/home/olvind/.nvm/versions/node/v10.12.0/bin/yarn", "add", "--ignore-scripts", missingExternals.toSeq)(
        cacheFolder
      )
    } else
      logger.warn(s"Externals is already up to date")

    InFolder(cacheFolder / 'node_modules)
  }
}
