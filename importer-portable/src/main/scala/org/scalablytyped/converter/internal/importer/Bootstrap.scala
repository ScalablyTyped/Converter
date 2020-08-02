package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Source.{FromFolder, StdLibSource, TsLibSource}
import org.scalablytyped.converter.internal.seqs.TraversableOps
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
      folders:         IArray[InFolder],
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
        conversion.stdLibs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }

    val allSources = findSources(externalsFolder, Some(dtFolder))

    val resolver = new LibraryResolver(stdLibSource, allSources, conversion.ignoredLibs)

    val initial: Either[Unresolved, Vector[TsLibSource]] =
      wantedLibs match {
        case sets.EmptySet() => Right(allSources.toVector)
        case wantedLibs      => resolveAll(resolver, wantedLibs)
      }

    Bootstrapped(
      folders         = IArray(externalsFolder, dtFolder),
      libraryResolver = resolver,
      initialLibs     = initial,
    )
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
        conversion.stdLibs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }

    val `@types` = InFolder(fromFolder.path / "@types")

    val sources: IndexedSeq[Source.FromFolder] =
      findSources(`@types`, Some(fromFolder))

    val libraryResolver = new LibraryResolver(stdLibSource, sources, conversion.ignoredLibs)

    Bootstrapped(
      folders         = IArray(`@types`, fromFolder),
      libraryResolver = libraryResolver,
      initialLibs     = resolveAll(libraryResolver, wantedLibs),
    )
  }

  def findSources(nodeModulesFolder: InFolder, dtFolderOpt: Option[InFolder]): IndexedSeq[Source.FromFolder] =
    dtFolderOpt.foldLeft(forFolder(nodeModulesFolder).filter(_.hasSources)) {
      case (externalSources, dtFolder) =>
        val externalSourcesLibs = externalSources.map(_.libName).toSet
        val dtSources           = forFolder(dtFolder).filterNot(s => externalSourcesLibs(s.libName))

        externalSources ++ dtSources
    }

  private def forFolder(folder: InFolder): IndexedSeq[Source.FromFolder] =
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

  case class Unresolved(notAvailable: Vector[TsIdentLibrary]) {
    def msg =
      s"Missing typescript definitions for the following libraries: ${notAvailable.map(_.value).mkString(", ")}. Try to add a corresponding `@types` npm package, or use `stIgnore` to ignore"
  }

  def resolveAll(resolver: LibraryResolver, libs: SortedSet[TsIdentLibrary]): Either[Unresolved, Vector[TsLibSource]] =
    libs.toVector
      .map(resolver.library)
      .partitionCollect2({ case LibraryResolver.Found(x) => x }, { case LibraryResolver.NotAvailable(name) => name }) match {
      case (allFound, Seq(), _) => Right(allFound)
      case (_, notAvailable, _) => Left(Unresolved(notAvailable))
    }
}
