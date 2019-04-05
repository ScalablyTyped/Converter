package com.olvind.tso
package importer

import ammonite.ops._
import com.olvind.logging.Logger
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.ts.PackageJsonDeps

object UpToDateExternals {
  def apply(logger:                Logger[Unit],
            cacheFolder:           Path,
            ensurePresentPackages: Set[String],
            ignored:               Set[String],
            conserveSpace:         Boolean,
            offline:               Boolean): InFolder = {
    mkdir(cacheFolder)

    val ensurePresentPackagesFixes = ensurePresentPackages.map {
      // yarn can apparently not resolve scoped packages with this syntax
      case s if s.contains("__") => s.split("__").mkString("@", "/", "")
      case other                 => other
    }

    val alreadyAddedExternals: Set[String] =
      Json.opt[PackageJsonDeps](cacheFolder / "package.json", error => logger.warn(error)) match {
        case Some(PackageJsonDeps(_, deps, peerDeps, _, _, _)) =>
          (deps.getOrElse(Map.empty) ++ peerDeps.getOrElse(Map.empty)).map { case (name, _) => name }(
            collection.breakOut
          )
        case _ => Set.empty
      }

    val missingExternals: Set[String] =
      ensurePresentPackagesFixes -- alreadyAddedExternals -- ignored

    if (missingExternals.nonEmpty) {
      if (offline) {
        logger.fatal(s"Is in offline mode but is missing externals $missingExternals")
      }

      logger.warn(s"Adding missing externals $missingExternals")
      %("yarn", "add", "--ignore-scripts", missingExternals.toSeq)(cacheFolder)

    } else
      logger.warn("All external libraries present in node_modules")

    if (!offline) {
      logger.warn("Updating external libraries in node_modules")
      %('yarn, 'upgrade, "--latest", "--ignore-scripts")(cacheFolder)
    }

    if (conserveSpace) {
      /* only keep some files within npm folder*/
      val KeepExtensions = Set("json", "ts", "lock")

      logger.warn("Trimming node_modules")
      ls.rec(p => KeepExtensions(p.ext))(cacheFolder).filter(_.isFile).foreach(rm)

      logger.warn("Deleting yarn cache")
      rm(home / 'cache / 'yarn)

    }
    InFolder(cacheFolder / 'node_modules)
  }
}
