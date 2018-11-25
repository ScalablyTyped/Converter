package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{ContribSource, TsHelperFile, TsLibSource}
import com.olvind.tso.ts.{TsConfig, TsIdentLibrary, TsParsedFile}

import scala.collection.mutable

sealed trait Phase1Res

/**
  * todo: the handling of recursive types in the entire app is terrible
  */
object Phase1Res {

  case object Contrib extends Phase1Res

  final case class LibTs(name:         TsIdentLibrary,
                         source:       Source,
                         version:      LibraryVersion,
                         tsConfig:     Option[TsConfig],
                         parsed:       TsParsedFile,
                         dependencies: Map[TsLibSource, LibTs],
                         contribs:     Set[ContribSource])
      extends Phase1Res {

    override def equals(that: Any): Boolean =
      that match {
        case x: LibTs => hashCode === x.hashCode && source === x.source
        case _ => false
      }

    override lazy val hashCode: Int = source.hashCode

    override def toString: String =
      s"TsLibBase($name, $source, $version, $tsConfig, ${parsed.members.map(_.asString)}, ${dependencies
        .map(_._2.name.value)})"

    def isStdLib: Boolean =
      parsed.isStdLib
  }

  case class LibraryPart(
      file:  FileAndRefsRec,
      parts: Map[Source, Phase1Res]
  ) extends Phase1Res

  case class FileAndRefsRec(
      file:         TsParsedFile,
      pathRefFiles: Seq[FileAndRefsRec]
  )

  case class FileAndRefs(
      file:         TsParsedFile,
      pathRefFiles: Seq[TsParsedFile]
  ) {
    def toSeq: Seq[TsParsedFile] = file +: pathRefFiles
  }

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
        _m: Map[Source, Phase1Res]
    ): Some[(Map[TsHelperFile, FileAndRefs], Map[TsLibSource, LibTs], Set[ContribSource])] =
      Some(apply(_m))

    def apply(
        _m: Map[Source, Phase1Res]
    ): (Map[TsHelperFile, FileAndRefs], Map[TsLibSource, LibTs], Set[ContribSource]) = {

      val libParts = mutable.HashMap.empty[TsHelperFile, FileAndRefs]
      val libs     = mutable.HashMap.empty[TsLibSource, LibTs]
      val contribs = mutable.HashSet.empty[ContribSource]

      def go(m: Map[Source, Phase1Res]): Unit =
        m foreach {
          case (s: TsHelperFile, libPart: LibraryPart) =>
            if (!libParts.contains(s)) {
              libParts(s) = FileAndRefs(libPart.file.file, goRefs(libPart.file))
              go(libPart.parts)
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

      (libParts.toMap, libs.toMap, contribs.to[Set])
    }

    private def goRefs(file: FileAndRefsRec): Seq[TsParsedFile] =
      file.pathRefFiles.map(_.file) ++ file.pathRefFiles.flatMap(goRefs)

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
