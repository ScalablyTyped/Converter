package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Formatter
import org.scalablytyped.converter.internal.ts._

sealed trait LibTsSource extends TsTreeScope.TsLib {
  final def path: os.Path = folder.path
  def folder:  InFolder
  def libName: TsIdentLibrary

  private val pathString: String = path.toString

  override lazy val packageJsonOpt: Option[PackageJson] =
    Json.opt[PackageJson](folder.path / "package.json").orElse /* discover stdlib package.json as well */ (
      Json.opt[PackageJson](folder.path / os.up / "package.json"),
    )

  lazy val tsConfig: Option[TsConfig] =
    Json.opt[TsConfig](folder.path / "tsconfig.json")

  lazy val shortenedFiles: IArray[InFile] = LibTsSource.findShortenedFiles(this)
}

object LibTsSource {
  def hasTypescriptSources(folder: InFolder): Boolean =
    os.walk.stream(folder.path, _.last == "node_modules").exists(_.last.endsWith(".d.ts"))

  final case class StdLibSource(folder: InFolder, files: IArray[InFile], libName: TsIdentLibrary) extends LibTsSource

  final case class FromFolder(folder: InFolder, libName: TsIdentLibrary) extends LibTsSource

  implicit def SourceOrdering[S <: LibTsSource]: Ordering[S] =
    Ordering.by[S, String](_.pathString)
  implicit val SourceFormatter: Formatter[LibTsSource] =
    _.libName.value

  /* for files referenced through here we must shorten the paths */
  def findShortenedFiles(src: LibTsSource): IArray[InFile] = {
    def fromTypingsJson(fromFolder: LibTsSource.FromFolder, files: Option[IArray[String]]): IArray[InFile] =
      files.getOrElse(IArray.Empty).collect {
        case path if path.endsWith("typings.json") =>
          val typingsJsonPath = fromFolder.folder.path / os.RelPath(path)
          val typingsJson     = Json.force[TypingsJson](typingsJsonPath)
          InFile(typingsJsonPath / os.up / typingsJson.main)
      }

    def fromFileEntry(fromFolder: LibTsSource.FromFolder, files: Option[IArray[String]]): IArray[InFile] =
      files.getOrElse(IArray.Empty).mapNotNone(file => LibraryResolver.file(fromFolder.folder, file))

    def fromModuleDeclaration(
        fromFolder: LibTsSource.FromFolder,
        files:      Option[Map[String, String]],
    ): IArray[InFile] = {
      val files1 = files match {
        case Some(files) => IArray.fromTraversable(files.values)
        case None        => IArray.Empty
      }

      files1
        .mapNotNone(file => LibraryResolver.file(fromFolder.folder, file))
        .mapNotNone {
          case existingFile if LibTsSource.hasTypescriptSources(existingFile.folder) => Some(existingFile)
          case _                                                                     => None
        }
    }

    src match {
      case _: StdLibSource => Empty
      case f: FromFolder =>
        val fromTypings =
          IArray(
            fromFileEntry(f, f.packageJsonOpt.flatMap(_.parsedTypes).orElse(f.packageJsonOpt.flatMap(_.parsedTypings))),
            fromTypingsJson(f, f.packageJsonOpt.flatMap(_.parsedTypings)),
          ).flatten

        val mainTypings =
          if (fromTypings.nonEmpty) fromTypings
          else fromModuleDeclaration(f, f.packageJsonOpt.flatMap(_.parsedModules))

        // This used to only find files from the types and typings fields but that is far too limited.
        // At the very least we need to also include any types specified in the files field.
        // FIXME: The files field includes file patterns but this assumes that they are all files/folders pointing to
        //  modules.
        val filesTypings = fromFileEntry(f, f.packageJsonOpt.flatMap(_.files))

        (mainTypings ++ filesTypings).distinct
    }
  }
}
