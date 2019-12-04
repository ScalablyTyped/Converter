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
          /* for files referenced through here we must shorten the paths (done right below) */
          val shortened: Seq[InFile] =
            Seq(
              fromFileEntry(resolve, f, source.packageJsonOpt.flatMap(_.types)),
              fromFileEntry(resolve, f, source.packageJsonOpt.flatMap(_.typings)),
              fromTypingsJson(f, source.packageJsonOpt.flatMap(_.typings)),
            ).flatten

          val rest =
            if (f.libName === TsIdentLibrarySimple("typescript")) allTopLevel(f.folder)
            else {
              /* There are often whole trees parallel to what is specified in `typings` (or similar). This ignores them */
              val bound = shortened.headOption.map(_.folder).getOrElse(f.folder)
              filesFrom(bound, f.libName)
            }

          rest.map(x => (x, false)).toMap ++ shortened.map(x => (x, true))
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

  def allTopLevel(folder: InFolder): Seq[InFile] =
    os.list(folder.path)
      .filter(_.last.endsWith("d.ts"))
      .to[Seq]
      .map(InFile.apply)

  def filesFrom(bound: InFolder, libName: TsIdentLibrary): Seq[InFile] = {
    def skip(dir: os.Path) =
      dir.last match {
        case "node_modules" => true
        /* The presence of these folders mostly means unnecessary duplication.
           If we desperately want these perhaps the user can configure that,
            though it won't be as easy as just discarding them
         */
        case "amd" => true
        case "umd" => true
        case "es"  => true
        case "es6" => true
        /* DefinitelyTyped uses this pattern for newer versions of typescript. We just use the default */
        case TS() => true
        /* DefinitelyTyped uses this pattern for old versions of the library */
        case V() => true
        case _   => false
      }

    os.walk(bound.path, skip)
      .filter(_.last.endsWith(".d.ts"))
      .filterNot(_.last.contains(".src.")) // filter out files like highlight.src.d.ts,
      .to[Seq]
      .map(InFile.apply)
  }
}
