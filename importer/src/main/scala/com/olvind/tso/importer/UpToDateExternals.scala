package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.ts.PackageJsonDeps

object UpToDateExternals {
  def apply(
      logger:                Logger[_],
      cmd:                   Cmd,
      folder:                os.Path,
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
    val packageJson     = Json.opt[PackageJsonDeps](packageJsonPath)

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

    /* graalvm bundles a botched version which fails with SOE */
    val npmCommand = sys.env.get("NVM_BIN") match {
      case None       => List("npm")
      case Some(path) => List(s"$path/node", s"$path/npm")
    }

    if (missingExternals.isEmpty) logger.warn(s"All external libraries present in $nodeModulesPath")
    else {
      logger.warn(s"Adding ${missingExternals.size} missing libraries to $nodeModulesPath")
      missingExternals.toSeq.sorted.grouped(100).foreach { es =>
        cmd.runVerbose(
          npmCommand,
          "add",
          "--ignore-scripts",
          "--no-cache",
          "--no-audit",
          "--no-bin-links",
          es,
        )(folder)
      }
    }

    if (!offline) {
      logger.warn(s"Updating libraries in $nodeModulesPath")

      /* because of course *cough* somebody distributes their whole history, and `npm` refuses to update when that happens */
      os.walk.stream(folder).foreach {
        case dir if os.isDir(dir) && dir.last === ".git" => os.remove.all(dir)
        case _                                           => ()
      }

      cmd.runVerbose(
        npmCommand,
        'upgrade,
        "--latest",
        "--no-cache",
        "--ignore-scripts",
        "--no-audit",
        "--no-bin-links",
      )(folder)
    }

    if (missingExternals.exists(_.startsWith("@material-ui")) || !offline) {
      cmd.runVerbose(
        npmCommand,
        "add",
        "@material-ui/core@3.9.3",
        "--no-cache",
        "--ignore-scripts",
        "--no-audit",
        "--no-bin-links",
      )(folder)
    }

    if (conserveSpace && os.exists(folder)) {
      /* only keep some files within npm folder*/
      val KeepExtensions = Set("json", "ts", "lock")

      logger.warn(s"Trimming $nodeModulesPath")

      os.walk.stream(folder).foreach {
        case link if os.isLink(link)                              => os.remove.all(link)
        case file if os.isFile(file) && !KeepExtensions(file.ext) => os.remove.all(file)
        case dir if os.isDir(dir) && dir.last === ".git"          => os.remove.all(dir)
        case _                                                    => ()
      }
    }

    InFolder(nodeModulesPath)
  }
}
