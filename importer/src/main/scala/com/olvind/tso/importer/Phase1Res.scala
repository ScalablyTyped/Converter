package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{ContribSource, TsHelperFile, TsLibSource}
import com.olvind.tso.ts.{TsConfig, TsIdentLibrary, TsParsedFile}
import maps.MapOps
import scala.collection.immutable.SortedMap
import scala.collection.mutable

sealed trait Phase1Res

/**
  * todo: the handling of recursive types in the entire app is terrible
  */
object Phase1Res {

  case object Contrib extends Phase1Res

  final case class LibTs(source: Source)(
      val version:               LibraryVersion,
      val tsConfig:              Option[TsConfig],
      val parsed:                TsParsedFile,
      val dependencies:          SortedMap[TsLibSource, LibTs],
      val contribs:              Set[ContribSource]
  ) extends Phase1Res {
    def name: TsIdentLibrary = source.libName
  }

  case class LibraryPart(file: FileAndInlinesRec, deps: SortedMap[Source, Phase1Res]) extends Phase1Res

  case class FileAndInlinesRec(file: TsParsedFile, toInline: SortedMap[Source, LibraryPart])

  case class FileAndInlinesFlat(file: TsParsedFile, toInline: SortedMap[Source, TsParsedFile])

  object UnpackLibs {
    def unapply(_m: Map[TsLibSource, LibTs]): Some[Map[TsLibSource, LibTs]] =
      Some(apply(_m))

    def apply(_m: Map[TsLibSource, LibTs]): Map[TsLibSource, LibTs] = {
      val libs = mutable.HashMap.empty[TsLibSource, LibTs]
      Unpack.goLibs(libs, _m)
      libs.toMap
    }
  }

  object Unpack {
    def unapply(
        _m: SortedMap[Source, Phase1Res]
    ): Some[(SortedMap[TsHelperFile, FileAndInlinesFlat], SortedMap[TsLibSource, LibTs], Set[ContribSource])] =
      Some(apply(_m))

    def apply(
        _m: SortedMap[Source, Phase1Res]
    ): (SortedMap[TsHelperFile, FileAndInlinesFlat], SortedMap[TsLibSource, LibTs], Set[ContribSource]) = {

      val libParts = mutable.HashMap.empty[TsHelperFile, FileAndInlinesFlat]
      val libs     = mutable.HashMap.empty[TsLibSource, LibTs]
      val contribs = mutable.HashSet.empty[ContribSource]

      def go(m: Map[Source, Phase1Res]): Unit =
        m foreach {
          case (s: TsHelperFile, libPart: LibraryPart) =>
            if (!libParts.contains(s)) {
              def flatten(os: Option[Source], _f: FileAndInlinesRec): SortedMap[Source, TsParsedFile] = {
                val first: SortedMap[Source, TsParsedFile] =
                  os match {
                    case None     => SortedMap.empty
                    case Some(s2) => SortedMap(s2 -> _f.file)
                  }
                val rest: SortedMap[Source, TsParsedFile] =
                  _f.toInline.flatMap {
                    case (s2, x: LibraryPart) =>
                      go(x.deps)
                      flatten(Some(s2), x.file)
                  }
                first ++ rest
              }

              libParts(s) = FileAndInlinesFlat(libPart.file.file, flatten(None, libPart.file))
              go(libPart.deps)
            }
          case (s: TsLibSource, lib: LibTs) =>
            if (!libs.contains(s)) {
              libs(s) = lib
              goLibs(libs, lib.dependencies)
            }
          case (s: ContribSource, Contrib) =>
            contribs.add(s)
        }

      go(_m)

      (libParts.toSorted, libs.toSorted, contribs.to[Set])
    }

    def goLibs(libs: mutable.Map[TsLibSource, LibTs], ds: Map[TsLibSource, LibTs]): Unit =
      ds foreach {
        case (s, lib) =>
          if (!libs.contains(s)) {
            libs(s) = lib
            goLibs(libs, lib.dependencies)
          }
      }
  }
}
