package com.olvind.tso
package importer

import ammonite.ops.{ls, up, RelPath}
import com.olvind.tso.ts._

object PathsFromTsLibSource {
  def apply(resolve:        LibraryResolver,
            source:         Source.TsLibSource,
            packageJsonOpt: Option[PackageJsonDeps],
            tsConfig:       Option[TsConfig]): Set[Source.TsHelperFile] = {

    val found: Seq[(InFile, Source.TsLibSource)] =
      source match {
        case Source.FromFile(file, _) =>
          Seq(file -> source)

        case f: Source.FromFolder =>
          FirstNonEmpty(
            () =>
              fromTypingsJson(f, packageJsonOpt.flatMap(_.typings))
                .map(x => (x, Source.FromFile(x, source.libName))),
            () =>
              fromFileEntry(resolve, f, packageJsonOpt.flatMap(_.typings))
                .map(x => (x, Source.FromFile(x, source.libName))),
            () =>
              fromFileEntry(resolve, f, packageJsonOpt.flatMap(_.types))
                .map(x => (x, Source.FromFile(x, source.libName))),
            () => fromFilesEntry(resolve, f, packageJsonOpt.flatMap(_.files)).map(x => (x, source)),
            () => fromFilesEntry(resolve, f, tsConfig.flatMap(_.files)).map(x       => (x, source)),
            () => whateverIsThere(f).map(x                                          => (x, source))
          ).getOrElse(Nil)
      }

    found.map {
      case (file, newSource) => Source.TsHelperFile(file, newSource, resolve.inferredModule(file.path, newSource))

    }.toSet
  }

  private def fromTypingsJson(fromFolder: Source.FromFolder, fileOpt: Option[String]): Seq[InFile] =
    fileOpt match {
      case Some(path) if path.endsWith("typings.json") =>
        import jsonCodecs._
        val typingsJsonPath = fromFolder.folder.path / RelPath(path)
        val typingsJson     = Json[TypingsJson](typingsJsonPath)
        Seq(InFile(typingsJsonPath / up / typingsJson.main))
      case _ => Nil
    }

  private def fromFileEntry(resolve:    LibraryResolver,
                            fromFolder: Source.FromFolder,
                            fileOpt:    Option[String]): Seq[InFile] =
    fileOpt.flatMap(file => resolve.file(fromFolder.folder, file)).to[Seq]

  private def fromFilesEntry(resolve:    LibraryResolver,
                             fromFolder: Source.FromFolder,
                             filesOpt:   Option[Seq[String]]): Seq[InFile] =
    filesOpt match {
      case Some(files) =>
        files
          .flatMap(file => resolve.file(fromFolder.folder, file))
          .filter(_.path.toString().endsWith(".d.ts"))
      case _ => Nil
    }

  private def whateverIsThere(fromFolder: Source.FromFolder): Seq[InFile] = {
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
