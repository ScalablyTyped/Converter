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
    os.walk.stream(folder.path, _.last == "node_modules").exists(_.last.endsWith(".d.ts"))
}

object Source {
  case class FromNodeModules(
      sources:         Set[Source],
      folders:         IArray[InFolder],
      libraryResolver: LibraryResolver,
      stdLibSource:    StdLibSource,
  )

  def fromNodeModules(
      fromFolder: InFolder,
      conversion: ConversionOptions,
      wantedLibs: Set[ts.TsIdentLibrary],
  ): FromNodeModules = {
    val stdLibSource = {
      val folder = fromFolder.path / "typescript" / "lib"

      require(files.exists(folder), s"You must add typescript as a dependency. $folder must exist.")
      require(!conversion.ignoredLibs.contains(TsIdent.std), "You cannot ignore std")

      StdLibSource(
        InFolder(folder),
        conversion.stdLibs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }

    val inputFolders: IArray[InFolder] = IArray(InFolder(fromFolder.path / "@types"), fromFolder)
    val sources:      Set[Source]      = findSources(inputFolders, IArray.fromTraversable(wantedLibs)) + stdLibSource

    FromNodeModules(
      sources         = sources,
      folders         = inputFolders,
      libraryResolver = new LibraryResolver(stdLibSource, inputFolders),
      stdLibSource    = stdLibSource,
    )
  }

  private def findSources(fromFolders: IArray[InFolder], wanted: IArray[TsIdentLibrary]): Set[Source] =
    wanted
      .flatMap(name =>
        fromFolders.mapNotNone { fromFolder =>
          val potential = fromFolder.path / os.RelPath(name.value)
          if (files.exists(potential)) Some[Source](Source.FromFolder(InFolder(potential), name))
          else None
        },
      )
      .groupBy(_.libName)
      .flatMap { case (_, sameName) => sameName.find(_.hasSources) }
      .toSet

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
      Json.opt[PackageJsonDeps](folder.path / "package.json") orElse
        /* discover stdlib package.json as well */
        Json.opt[PackageJsonDeps](folder.path / os.up / "package.json")

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

  /* for files referenced through here we must shorten the paths (done right below) */
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
            fromFileEntry(f, f.packageJsonOpt.flatMap(_.types) orElse f.packageJsonOpt.flatMap(_.typings)),
            fromTypingsJson(f, f.packageJsonOpt.flatMap(_.typings)),
          ).flatten

        if (fromTypings.nonEmpty) fromTypings
        else fromModuleDeclaration(f, f.packageJsonOpt.flatMap(_.module))
    }
  }
}
