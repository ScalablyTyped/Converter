package com.olvind.tso
package importer

import com.olvind.tso.ts._

object PathsFromTsLibSource {
  def apply(resolve: LibraryResolver, source: Source.TsLibSource): Set[Source.TsHelperFile] = {

    val foundAndShorten: Map[InFile, Boolean] =
      source match {
        case Source.StdLibSource(_, files, _) =>
          files.map(f => f -> false).toMap

        case f: Source.FromFolder =>
          /* for files referenced through here we must shorten the paths (see below) */
          val prioritized: Map[InFile, Boolean] =
            Seq(
              fromFileEntry(resolve, f, source.packageJsonOpt.flatMap(_.types)).map(x   => (x, true)),
              fromFileEntry(resolve, f, source.packageJsonOpt.flatMap(_.typings)).map(x => (x, true)),
              fromTypingsJson(f, source.packageJsonOpt.flatMap(_.typings)).map(x        => (x, true)),
            ).flatten.toMap

          allFrom(f).map(x => (x, false)).toMap ++ prioritized
      }

    foundAndShorten.map {
      case (file, true) =>
        source.libName match {
          case TsIdentLibraryScoped(scope, name) =>
            Source.TsHelperFile(file, source, TsIdentModule(Some(scope), List(name)))
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

  val V  = "v[\\d\\.]+".r
  val TS = "ts[\\d\\.]+".r

  def allFrom(fromFolder: Source.FromFolder): Seq[InFile] =
    if (fromFolder.libName === TsIdentLibrarySimple("typescript")) {
      os.list(fromFolder.folder.path)
        .filter(_.last.endsWith("d.ts"))
        .to[Seq]
        .map(InFile.apply)
    } else {
      def skip(dir: os.Path) =
        dir.last match {
          case "node_modules" => true
          case TS()           => true
          case V()            => true
          case _              => false
        }

      os.walk(fromFolder.folder.path, skip)
        .filter(_.last.endsWith("d.ts"))
        .to[Seq]
        .map(InFile.apply)
    }
}
