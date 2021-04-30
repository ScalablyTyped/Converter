package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.ts.{PackageJsonDeps, TsIdentLibrary}

object UpToDateExternals {
  def apply(
      logger:                Logger[_],
      cmd:                   Cmd,
      folder:                os.Path,
      ensurePresentPackages: Set[TsIdentLibrary],
      ignored:               Set[TsIdentLibrary],
      conserveSpace:         Boolean,
      offline:               Boolean,
  ): InFolder = {

    val packageJsonPath = folder / "package.json"
    val nodeModulesPath = folder / "node_modules"
    val packageJson     = Json.opt[PackageJsonDeps](packageJsonPath)

    val alreadyAddedExternals: Set[TsIdentLibrary] =
      packageJson match {
        case Some(PackageJsonDeps(_, deps, _, peerDeps, _, _, _, _)) =>
          (deps.getOrElse(Map.empty) ++ peerDeps.getOrElse(Map.empty))
            .map { case (name, _) => TsIdentLibrary(name) }(collection.breakOut)
        case None =>
          files.softWrite(packageJsonPath)(_.println("{}"))
          Set.empty
      }

    val missingExternals: Set[TsIdentLibrary] =
      ensurePresentPackages -- alreadyAddedExternals -- ignored

    /* graalvm bundles a botched version which fails with SOE */
    val npmCommand = sys.env.get("NVM_BIN") match {
      case None       => List("npm")
      case Some(path) => List(s"$path/node", "--stack-size=4096", s"$path/npm")
    }

    if (missingExternals.isEmpty) logger.warn(s"All external libraries present in $nodeModulesPath")
    else {
      logger.warn(s"Adding ${missingExternals.size} missing libraries to $nodeModulesPath")
      missingExternals.toSeq.map(_.value).sorted.grouped(100).foreach { es =>
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
        case dir if os.isDir(dir) && dir.last === ".git" => files.deleteAll(dir)
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

    if (missingExternals.exists(_.value.startsWith("@material-ui")) || !offline) {
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

    if (conserveSpace && files.exists(folder)) {
      /* only keep some files within npm folder*/
      val KeepExtensions = Set("json", "ts", "lock")

      logger.warn(s"Trimming $nodeModulesPath")

      os.walk.stream(folder).foreach {
        case link if os.isLink(link)                              => files.deleteAll(link)
        case file if os.isFile(file) && !KeepExtensions(file.ext) => files.deleteAll(file)
        case dir if os.isDir(dir) && dir.last === ".git"          => files.deleteAll(dir)
        case _                                                    => ()
      }
    }

    InFolder(nodeModulesPath)
  }
}
