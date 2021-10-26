package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Formatter
import org.scalablytyped.converter.internal.ts._

sealed trait LibTsSource extends TsTreeScope.TsLib {
  def path: os.Path = folder.path
  def folder:  InFolder
  def libName: TsIdentLibrary

  val pathString: String = path.toString

  lazy val tsConfig: Option[TsConfig] =
    Json.opt[TsConfig](folder.path / "tsconfig.json")

  lazy val shortenedFiles: IArray[InFile] =
    LibTsSource.findShortenedFiles(this)

  object webpack {
    private def lookup(f: PackageJson => Option[String]): Option[InFile] =
      packageJsonOpt.flatMap(f).flatMap(LibraryResolver.file(folder, _))

//    val browser: Option[InFile] = lookup(_.browser)
    val main:    Option[InFile] = lookup(_.main)
    val module:  Option[InFile] = lookup(_.module)

    // found these in angular. no idea. at all
    val es2015:   Option[InFile] = lookup(_.es2015)
    val esm2015:  Option[InFile] = lookup(_.esm2015)
    val fesm2015: Option[InFile] = lookup(_.fesm2015)

    val all:         IArray[InFile] = IArray.fromOptions(/* browser, */ module, main, es2015, esm2015, fesm2015)
    val maybeChosen: Option[InFile] = all.headOption

    // ignore files within these folders
    val blacklist: IArray[InFile] =
      maybeChosen match {
        case Some(chosen) =>
          all.filterNot(file => file.path.startsWith(chosen.folder.path) || chosen.folder.path.startsWith(file.path))
        case None => Empty
      }
  }
}

object LibTsSource {
  def hasTypescriptSources(folder: InFolder): Boolean =
    os.walk.stream(folder.path, _.last == "node_modules").exists(_.last.endsWith(".d.ts"))

  final case class StdLibSource(folder: InFolder, files: IArray[InFile], libName: TsIdentLibrary) extends LibTsSource {
    override val packageJsonOpt: Option[PackageJson] =
      Json.opt[PackageJson](folder.path / os.up / "package.json")
  }

  final case class FromFolder(folder: InFolder, libName: TsIdentLibrary) extends LibTsSource {
    override val packageJsonOpt: Option[PackageJson] =
      Json.opt[PackageJson](folder.path / "package.json")
  }

  implicit val ordering: Ordering[LibTsSource]  = Ordering.by(_.pathString)
  implicit val formats:  Formatter[LibTsSource] = _.libName.value

  /* for files referenced through here we must shorten the paths */
  def findShortenedFiles(libSrc: LibTsSource): IArray[InFile] = {
    def fromTypingsJson(fromFolder: LibTsSource.FromFolder, fileOpt: Option[String]): Option[InFile] =
      fileOpt match {
        case Some(path) if path.endsWith("typings.json") =>
          val typingsJsonPath = fromFolder.folder.path / os.RelPath(path)
          val typingsJson     = Json.force[TypingsJson](typingsJsonPath)
          Option(InFile(typingsJsonPath / os.up / typingsJson.main))
        case _ => None
      }

    def fromFileEntry(fromFolder: LibTsSource.FromFolder, fileOpt: Option[String]): Option[InFile] =
      fileOpt.flatMap(file => LibraryResolver.file(fromFolder.folder, file))

    def fromModuleDeclaration(fromFolder: LibTsSource.FromFolder, fileOpt: Option[String]): Option[InFile] =
      fileOpt
        .flatMap(file => LibraryResolver.file(fromFolder.folder, file))
        .filter(existingFile => LibTsSource.hasTypescriptSources(existingFile.folder))

    libSrc match {
      case _:      StdLibSource => Empty
      case libSrc: FromFolder =>
        val fromTypings: IArray[InFile] =
          IArray.fromOptions(
            fromFileEntry(
              libSrc,
              libSrc.packageJsonOpt.flatMap(_.types).orElse(libSrc.packageJsonOpt.flatMap(_.typings)),
            ),
            fromTypingsJson(libSrc, libSrc.packageJsonOpt.flatMap(_.typings)),
          )

        if (fromTypings.nonEmpty) fromTypings
        else IArray.fromOption(fromModuleDeclaration(libSrc, libSrc.packageJsonOpt.flatMap(_.module)))
    }
  }
}
