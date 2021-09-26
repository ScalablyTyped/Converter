package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Formatter
import org.scalablytyped.converter.internal.ts._

sealed trait LibTsSource extends TsTreeScope.TsLib {
  final def path: os.Path = folder.path
  def folder:  InFolder
  def libName: TsIdentLibrary

  private lazy val key: String = path.toString

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

  implicit val SourceKey:                        Key[LibTsSource]       = Key.of[LibTsSource, String](_.key)
  implicit def SourceOrdering[S <: LibTsSource]: Ordering[S]            = Ordering.by[S, String](_.key)
  implicit val SourceFormatter:                  Formatter[LibTsSource] = _.libName.value

  /* for files referenced through here we must shorten the paths */
  def findShortenedFiles(src: LibTsSource): IArray[InFile] = {
    def fromTypingsJson(fromFolder: LibTsSource.FromFolder, fileOpt: Option[String]): IArray[InFile] =
      fileOpt match {
        case Some(path) if path.endsWith("typings.json") =>
          val typingsJsonPath = fromFolder.folder.path / os.RelPath(path)
          val typingsJson     = Json.force[TypingsJson](typingsJsonPath)
          IArray(InFile(typingsJsonPath / os.up / typingsJson.main))
        case _ => Empty
      }

    def fromFileEntry(fromFolder: LibTsSource.FromFolder, fileOpt: Option[String]): IArray[InFile] =
      IArray.fromOption(fileOpt.flatMap(file => LibraryResolver.file(fromFolder.folder, file)))

    def fromModuleDeclaration(fromFolder: LibTsSource.FromFolder, fileOpt: Option[String]): IArray[InFile] =
      fileOpt.flatMap(file => LibraryResolver.file(fromFolder.folder, file)) match {
        case Some(existingFile) if LibTsSource.hasTypescriptSources(existingFile.folder) => IArray(existingFile)
        case _                                                                           => Empty
      }

    src match {
      case _: StdLibSource => Empty
      case f: FromFolder =>
        val fromTypings =
          IArray(
            fromFileEntry(f, f.packageJsonOpt.flatMap(_.types).orElse(f.packageJsonOpt.flatMap(_.typings))),
            fromTypingsJson(f, f.packageJsonOpt.flatMap(_.typings)),
          ).flatten

        if (fromTypings.nonEmpty) fromTypings
        else fromModuleDeclaration(f, f.packageJsonOpt.flatMap(_.module))
    }
  }
}
