package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Formatter
import org.scalablytyped.converter.internal.ts._

sealed trait Source {
  final def path: os.Path =
    this match {
      case Source.StdLibSource(InFolder(path), _, _) => path
      case Source.FromFolder(InFolder(path), _)      => path
      case Source.TsHelperFile(InFile(path), _, _)   => path
    }

  def folder:  InFolder
  def libName: TsIdentLibrary

  private lazy val key: String = path.toString

  def hasSources: Boolean =
    Source.hasTypescriptSources(folder)
}

object Source {
  def hasTypescriptSources(folder: InFolder): Boolean =
    os.walk.stream(folder.path, _.last == "node_modules").exists(_.last.endsWith(".d.ts"))

  sealed trait TsSource extends Source {
    final def inLibrary: Source.TsLibSource =
      this match {
        case x: TsLibSource => x
        case Source.TsHelperFile(_, x, _) => x
      }
  }

  sealed trait TsLibSource extends TsSource with TsTreeScope.TsLib {
    import jsonCodecs._

    override lazy val packageJsonOpt: Option[PackageJsonDeps] =
      Json
        .opt[PackageJsonDeps](folder.path / "package.json")
        .orElse /* discover stdlib package.json as well */ (
          Json.opt[PackageJsonDeps](folder.path / os.up / "package.json"),
        )

    lazy val tsConfig: Option[TsConfig] =
      Json.opt[TsConfig](folder.path / "tsconfig.json")

    lazy val shortenedFiles: IArray[InFile] = findShortenedFiles(this)
  }

  final case class StdLibSource(folder: InFolder, files: IArray[InFile], libName: TsIdentLibrary) extends TsLibSource

  final case class FromFolder(folder: InFolder, libName: TsIdentLibrary) extends TsLibSource

  final case class TsHelperFile(file: InFile, inLib: TsLibSource, moduleNames: IArray[TsIdentModule]) extends TsSource {
    override def libName: TsIdentLibrary = inLib.libName
    override def folder:  InFolder       = file.folder
  }

  def helperFile(inLib: TsLibSource)(file: InFile): TsHelperFile =
    Source.TsHelperFile(file, inLib, LibraryResolver.moduleNameFor(inLib, file))

  implicit val SourceKey:                   Key[Source]       = Key.of[Source, String](_.key)
  implicit def SourceOrdering[S <: Source]: Ordering[S]       = Ordering.by[S, String](_.key)
  implicit val SourceFormatter:             Formatter[Source] = _.libName.value

  /* for files referenced through here we must shorten the paths */
  def findShortenedFiles(src: Source.TsLibSource): IArray[InFile] = {
    def fromTypingsJson(fromFolder: Source.FromFolder, fileOpt: Option[String]): IArray[InFile] =
      fileOpt match {
        case Some(path) if path.endsWith("typings.json") =>
          import jsonCodecs._

          val typingsJsonPath = fromFolder.folder.path / os.RelPath(path)
          val typingsJson     = Json.force[TypingsJson](typingsJsonPath)
          IArray(InFile(typingsJsonPath / os.up / typingsJson.main))
        case _ => Empty
      }

    def fromFileEntry(fromFolder: Source.FromFolder, fileOpt: Option[String]): IArray[InFile] =
      IArray.fromOption(fileOpt.flatMap(file => LibraryResolver.file(fromFolder.folder, file)))

    def fromModuleDeclaration(fromFolder: Source.FromFolder, fileOpt: Option[String]): IArray[InFile] =
      fileOpt.flatMap(file => LibraryResolver.file(fromFolder.folder, file)) match {
        case Some(existingFile) if Source.hasTypescriptSources(existingFile.folder) => IArray(existingFile)
        case _                                                                      => Empty
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
