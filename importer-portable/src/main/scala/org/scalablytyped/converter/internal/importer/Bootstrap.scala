package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Source.{FromFolder, StdLibSource, TsLibSource}
import org.scalablytyped.converter.internal.ts.{TsIdent, TsIdentLibrary}

import scala.collection.immutable.SortedSet

object Bootstrap {

  /**
    * At this point we have scanned node_modules (and DT, if in CI) and know the location ([[Source]])
    *  of all libraries it's possible to import.
    *
    * @param initialLibs determines if all the libraries explicitly wanted by the user were available
    */
  case class Bootstrapped(
      inputFolders:    IArray[InFolder],
      libraryResolver: LibraryResolver,
      initialLibs:     Either[Unresolved, Vector[TsLibSource]],
  )

  def forCi(
      externalsFolder: InFolder,
      dtFolder:        InFolder,
      conversion:      ConversionOptions,
      wantedLibs:      SortedSet[TsIdentLibrary],
  ): Bootstrapped = {
    val stdLibSource: StdLibSource = {
      val folder = externalsFolder.path / "typescript" / "lib"

      require(files.exists(folder), s"You must add typescript as a dependency. $folder must exist.")
      require(!conversion.ignoredLibs.contains(TsIdent.std), "You cannot ignore std")

      StdLibSource(
        InFolder(folder),
        IArray.fromTraversable(conversion.stdLibs.map(s => InFile(folder / s"lib.$s.d.ts"))),
        TsIdent.std,
      )
    }

    val inputFolders = IArray(externalsFolder, dtFolder)
    val allSources   = findSources(inputFolders)

    val libraryResolver = new LibraryResolver(stdLibSource, allSources, conversion.ignoredLibs)

    val initial: Either[Unresolved, Vector[TsLibSource]] =
      wantedLibs match {
        case sets.EmptySet() => Right(allSources.toVector)
        case wantedLibs      => libraryResolver.resolveAll(wantedLibs)
      }

    Bootstrapped(inputFolders, libraryResolver, initial)
  }

  def fromNodeModules(
      fromFolder: InFolder,
      conversion: ConversionOptions,
      wantedLibs: SortedSet[TsIdentLibrary],
  ): Bootstrapped = {
    val stdLibSource = {
      val folder = fromFolder.path / "typescript" / "lib"

      require(files.exists(folder), s"You must add typescript as a dependency. $folder must exist.")
      require(!conversion.ignoredLibs.contains(TsIdent.std), "You cannot ignore std")

      StdLibSource(
        InFolder(folder),
        IArray.fromTraversable(conversion.stdLibs.map(s => InFile(folder / s"lib.$s.d.ts"))),
        TsIdent.std,
      )
    }

    val `@types`: Option[InFolder] =
      fromFolder.path / "@types" match {
        case dir if os.isDir(dir) => Some(InFolder(dir))
        case _                    => None
      }

    val inputFolders: IArray[InFolder] =
      IArray.fromOptions(`@types`, Some(fromFolder))

    val allSources: IArray[Source.FromFolder] =
      findSources(inputFolders)

    val libraryResolver = new LibraryResolver(stdLibSource, allSources, conversion.ignoredLibs)

    val initialLibs: Either[Unresolved, Vector[TsLibSource]] =
      libraryResolver.resolveAll(wantedLibs)

    Bootstrapped(inputFolders, libraryResolver, initialLibs)
  }

  def findSources(folders: IArray[InFolder]): IArray[Source.FromFolder] =
    folders.foldLeft[IArray[Source.FromFolder]](IArray.Empty) {
      case (foundSources, next) =>
        val foundNames = foundSources.map(_.libName).toSet
        val newSources = forFolder(next).filterNot(s => foundNames(s.libName))

        foundSources ++ newSources
    }

  private def forFolder(folder: InFolder): IArray[Source.FromFolder] =
    IArray.fromTraversable(
      os.list(folder.path)
        .collect { case dir if os.isDir(dir) => dir }
        .flatMap {
          case path if path.last.startsWith("@") =>
            if (path.last.startsWith("@types")) Nil
            else
              os.list(path)
                .map(nestedPath => FromFolder(InFolder(nestedPath), TsIdentLibrary(s"${path.last}/${nestedPath.last}")))
          case path => List(FromFolder(InFolder(path), TsIdentLibrary(path.last)))
        }
        .filter(_.hasSources),
    )

  case class Unresolved(notAvailable: Vector[TsIdentLibrary]) {
    def msg =
      s"Missing typescript definitions for the following libraries: ${notAvailable.map(_.value).mkString(", ")}. Try to add a corresponding `@types` npm package, or use `stIgnore` to ignore"
  }
}
