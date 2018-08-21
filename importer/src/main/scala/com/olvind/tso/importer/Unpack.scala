package com.olvind.tso
package importer

import com.olvind.tso.ts.{LibTs, TsParsedFile, TsSource}

import scala.collection.mutable

/**
  * todo: the handling of recursive types in the entire app is terrible
  */
object Unpack {
  object Libs {
    def unapply(_m: Map[TsSource, LibTs]): Some[Map[TsSource, LibTs]] =
      Some(apply(_m))

    def apply(_m: Map[TsSource, LibTs]): Map[TsSource, LibTs] = {
      val libs = mutable.HashMap.empty[TsSource, LibTs]
      goLibs(libs, _m)
      libs.toMap
    }
  }

  type M = Map[TsSource.HelperFile, FileAndRefs]

  def unapply(_m: Map[TsSource, Either[LibraryPart, LibTs]]): Some[(M, Map[TsSource, LibTs])] = Some(apply(_m))

  def apply(_m: Map[TsSource, Either[LibraryPart, LibTs]]): (M, Map[TsSource, LibTs]) = {

    val libParts = mutable.HashMap.empty[TsSource.HelperFile, FileAndRefs]
    val libs     = mutable.HashMap.empty[TsSource, LibTs]

    def go(m: Map[TsSource, Either[LibraryPart, LibTs]]): Unit =
      m foreach {
        case (s: TsSource.HelperFile, Left(libPart)) if !libParts.contains(s) =>
          libParts(s) = FileAndRefs(libPart.file.file, goRefs(libPart.file))
          go(libPart.parts)
        case (s, Right(lib)) if !libs.contains(s) =>
          libs(s) = lib
          goLibs(libs, lib.dependencies)
        case _ =>
      }

    go(_m)
    (libParts.toMap, libs.toMap)
  }

  private def goRefs(file: FileAndRefsRec): Seq[TsParsedFile] =
    file.pathRefFiles.map(_.file) ++ file.pathRefFiles.flatMap(goRefs)

  private def goLibs(libs: mutable.Map[TsSource, LibTs], ds: Map[TsSource, LibTs]): Unit =
    ds foreach {
      case (s, lib) if !libs.contains(s) =>
        libs(s) = lib
        goLibs(libs, lib.dependencies)
      case _ =>
    }
}
