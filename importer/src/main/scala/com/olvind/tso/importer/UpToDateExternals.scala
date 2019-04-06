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
      // you can apparently not resolve scoped packages with this syntax
      case s if s.contains("__") => s.split("__").mkString("@", "/", "")
      case other                 => other
    }

    val packageJsonPath = cacheFolder / "package.json"
    val packageJson     = Json.opt[PackageJsonDeps](packageJsonPath, error => logger.warn(error))

    val alreadyAddedExternals: Set[String] =
      packageJson match {
        case Some(PackageJsonDeps(_, deps, peerDeps, _, _, _)) =>
          (deps.getOrElse(Map.empty) ++ peerDeps.getOrElse(Map.empty)).map { case (name, _) => name }(
            collection.breakOut
          )
        case None =>
          files.softWrite(packageJsonPath)(_.println("{}"))
          Set.empty
      }

    val missingExternals: Set[String] =
      ensurePresentPackagesFixes -- alreadyAddedExternals -- ignored

    if (missingExternals.isEmpty) logger.warn("All external libraries present in node_modules")
    else {
      if (offline) {
        logger.fatal(s"Is in offline mode but is missing externals $missingExternals")
      }

      missingExternals.toSeq.sorted.grouped(30).foreach { es =>
        logger.warn(s"Adding missing externals $es")
        %%("npm", "add", "--ignore-scripts", "--no-cache", "--no-audit", es)(cacheFolder)
      }
    }

    if (!offline) {
      logger.warn("Updating external libraries in node_modules")
      %%('npm, 'upgrade, "--latest", "--no-cache", "--ignore-scripts", "--no-audit")(cacheFolder)
    }

    if (conserveSpace) {
      /* only keep some files within npm folder*/
      val KeepExtensions = Set("json", "ts", "lock")

      logger.warn("Trimming node_modules")
      ls.rec(p => KeepExtensions(p.ext))(cacheFolder).filter(_.isFile).foreach(rm)
    }

    InFolder(cacheFolder / 'node_modules)
  }
}
