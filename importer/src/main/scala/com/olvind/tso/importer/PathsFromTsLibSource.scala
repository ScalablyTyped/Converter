package com.olvind.tso
package importer

import com.olvind.tso.ts._

object PathsFromTsLibSource {
  def apply(
      resolve: LibraryResolver,
      source:  Source.TsLibSource,
  ): Set[Source.TsHelperFile] = {

    val foundAndShorten: Map[InFile, Boolean] =
      source match {
        case Source.StdLibSource(file, _) =>
          Map(file -> false)

        case f: Source.FromFolder =>
          val base = Seq(
            fromFilesEntry(resolve, f, source.tsConfig.flatMap(_.files)).map(x        => (x, false)),
            fromFilesEntry(resolve, f, source.packageJsonOpt.flatMap(_.files)).map(x  => (x, false)),
            fromFileEntry(resolve, f, source.packageJsonOpt.flatMap(_.types)).map(x   => (x, true)),
            fromFileEntry(resolve, f, source.packageJsonOpt.flatMap(_.typings)).map(x => (x, true)),
            fromTypingsJson(f, source.packageJsonOpt.flatMap(_.typings)).map(x        => (x, true)),
          ).flatten

          base match {
            case Nil   => whateverIsThere(f).map(x => (x, false)).toMap
            case found => found.toMap
          }

      }

    foundAndShorten.map {
      case (file, true) =>
        source.libName match {
          case TsIdentLibraryScoped(scope, name) =>
            Source.TsHelperFile(file, source, TsIdentModule(Some(scope), name.to[List]))
          case TsIdentLibrarySimple(value) =>
            Source.TsHelperFile(file, source, TsIdentModule(None, value :: Nil))
        }
      case (file, false) => Source.TsHelperFile(file, source, resolve.inferredModule(file.path, source))

    }.toSet
  }

  private def fromTypingsJson(fromFolder: Source.FromFolder, fileOpt: Option[String]): Seq[InFile] =
    fileOpt match {
      case Some(path) if path.endsWith("typings.json") =>
        import jsonCodecs._
        val typingsJsonPath = fromFolder.folder.path / os.RelPath(path)
        val typingsJson     = Json[TypingsJson](typingsJsonPath)
        Seq(InFile(typingsJsonPath / os.up / typingsJson.main))
      case _ => Nil
    }

  private def fromFileEntry(
      resolve:    LibraryResolver,
      fromFolder: Source.FromFolder,
      fileOpt:    Option[String],
  ): Seq[InFile] =
    fileOpt.flatMap(file => resolve.file(fromFolder.folder, file)).to[Seq]

  private def fromFilesEntry(
      resolve:    LibraryResolver,
      fromFolder: Source.FromFolder,
      filesOpt:   Option[Seq[String]],
  ): Seq[InFile] =
    filesOpt match {
      case Some(files) =>
        files
          .flatMap(file => resolve.file(fromFolder.folder, file))
          .filter(_.path.toString().endsWith(".d.ts"))
      case _ => Nil
    }

  private def whateverIsThere(fromFolder: Source.FromFolder): Seq[InFile] = {
    val base = os
      .list(fromFolder.folder.path)
      .filter(_.last.endsWith("d.ts"))
      .to[Seq]
      .map(InFile.apply)

    if (base.nonEmpty || fromFolder.libName === TsIdentLibrarySimple("typescript")) base
    else {
      os.walk(fromFolder.folder.path, _.last === "node_modules")
        .filter(_.last.endsWith("d.ts"))
        .to[Seq]
        .map(InFile.apply)
    }
  }
}
