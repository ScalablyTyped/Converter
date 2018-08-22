package com.olvind.tso
package importer

import ammonite.ops.{ls, up, RelPath}
import com.olvind.tso.ts._

object PathsFromTsLibSource {
  def apply(source:         TsSource.TsLibSource,
            packageJsonOpt: Option[PackageJsonDeps],
            tsConfig:       Option[TsConfig]): Set[TsSource.HelperFile] = {

    val found: Seq[(InFile, Boolean)] =
      source match {
        case TsSource.FromFile(file, _) =>
          Seq(file -> false)

        case f: TsSource.FromFolder =>
          FirstNonEmpty(
            () => fromTypingsJson(f, packageJsonOpt.flatMap(_.typings)).map(x => (x, true)),
            () => fromFileEntry(f, packageJsonOpt.flatMap(_.typings)).map(x => (x, true)),
            () => fromFileEntry(f, packageJsonOpt.flatMap(_.types)).map(x => (x, true)),
            () => fromFilesEntry(f, packageJsonOpt.flatMap(_.files)).map(x => (x, false)),
            () => fromFilesEntry(f, tsConfig.flatMap(_.files)).map(x => (x, false)),
            () => whateverIsThere(f).map(x => (x, false))
          ).getOrElse(Nil)
      }

    found.map {
      case (file, true) =>
        source.libName match {
          case TsIdentLibraryScoped(scope, name) =>
            TsSource.HelperFile(file, source, TsIdentModule(Some(scope), name.to[List]))
          case TsIdentLibrarySimple(value) =>
            TsSource.HelperFile(file, source, TsIdentModule(None, value :: Nil))
        }
      case (file, false) => TsSource.HelperFile(file, source, ModuleNameParser.inferred(file.path, source))

    }.toSet
  }

  private def fromTypingsJson(fromFolder: TsSource.FromFolder, fileOpt: Option[String]): Seq[InFile] =
    fileOpt match {
      case Some(path) if path.endsWith("typings.json") =>
        import jsonCodecs._
        val typingsJsonPath = fromFolder.folder.path / RelPath(path)
        val typingsJson     = Json[TypingsJson](typingsJsonPath)
        Seq(InFile(typingsJsonPath / up / typingsJson.main))
      case _ => Nil
    }

  private def fromFileEntry(fromFolder: TsSource.FromFolder, fileOpt: Option[String]): Seq[InFile] =
    fileOpt.flatMap(file => libraryResolver.resolveFile(fromFolder.folder, file)).to[Seq]

  private def fromFilesEntry(fromFolder: TsSource.FromFolder, filesOpt: Option[Seq[String]]): Seq[InFile] =
    filesOpt match {
      case Some(files) =>
        files
          .flatMap(file => libraryResolver.resolveFile(fromFolder.folder, file))
          .filter(_.path.toString().endsWith(".d.ts"))
      case _ => Nil
    }

  private def whateverIsThere(fromFolder: TsSource.FromFolder): Seq[InFile] = {
    val base = ls(fromFolder.folder.path)
      .filter(_.last.endsWith("d.ts"))
      .to[Seq]
      .map(InFile.apply)

    if (base.nonEmpty) base
    else {
      ls.rec(_.name === "node_modules")(fromFolder.folder.path)
        .filter(_.last.endsWith("d.ts"))
        .to[Seq]
        .map(InFile.apply)
    }
  }
}
