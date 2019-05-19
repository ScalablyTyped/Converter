package com.olvind.tso
package importer

import ammonite.ops._
import com.olvind.logging.Logger
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.ts.PackageJsonDeps

object UpToDateExternals {
  def apply(
      logger:                Logger[_],
      cmd:                   Cmd,
      folder:                Path,
      ensurePresentPackages: Set[String],
      ignored:               Set[String],
      conserveSpace:         Boolean,
      offline:               Boolean,
  ): InFolder = {

    val ensurePresentPackagesFixes = ensurePresentPackages.map {
      // you can apparently not resolve scoped packages with this syntax
      case s if s.contains("__") => s.split("__").mkString("@", "/", "")
      case other                 => other
    }

    val packageJsonPath = folder / "package.json"
    val nodeModulesPath = folder / "node_modules"
    val packageJson     = Json.opt[PackageJsonDeps](packageJsonPath, error => logger.warn(error))

    val alreadyAddedExternals: Set[String] =
      packageJson match {
        case Some(PackageJsonDeps(_, deps, _, peerDeps, _, _, _)) =>
          (deps.getOrElse(Map.empty) ++ peerDeps.getOrElse(Map.empty))
            .map { case (name, _) => name }(collection.breakOut)
        case None =>
          files.softWrite(packageJsonPath)(_.println("{}"))
          Set.empty
      }

    val missingExternals: Set[String] =
      ensurePresentPackagesFixes -- alreadyAddedExternals -- ignored

    if (missingExternals.isEmpty) logger.warn(s"All external libraries present in $nodeModulesPath")
    else {
      logger.warn(s"Adding ${missingExternals.size} missing libraries to $nodeModulesPath")
      missingExternals.toSeq.sorted.grouped(30).foreach { es =>
        cmd.runVerbose("npm", "add", "--ignore-scripts", "--no-cache", "--no-audit", "--no-bin-links", es)(folder)
      }
    }

    if (!offline) {
      logger.warn(s"Updating libraries in $nodeModulesPath")
      cmd.runVerbose('npm, 'upgrade, "--latest", "--no-cache", "--ignore-scripts", "--no-audit", "--no-bin-links")(
        folder,
      )
    }

    if (conserveSpace) {
      /* only keep some files within npm folder*/
      val KeepExtensions = Set("json", "ts", "lock")

      logger.warn(s"Trimming $nodeModulesPath")

      ls.rec(folder).foreach {
        case link if link.isSymLink                           => rm(link)
        case file if file.isFile && !KeepExtensions(file.ext) => rm(file)
        case _                                                => ()
      }
    }

    InFolder(nodeModulesPath)
  }
}
