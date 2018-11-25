package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{ContribSource, TsLibSource}
import com.olvind.tso.scalajs.{ContainerSymbol, Name, SymbolScope}

import scala.collection.mutable

sealed trait Phase2Res

object Phase2Res {
  case object Contrib extends Phase2Res

  case class LibScalaJs(source:        Source,
                        libName:       Name,
                        libVersion:    LibraryVersion,
                        packageSymbol: ContainerSymbol,
                        dependencies:  Map[TsLibSource, LibScalaJs],
                        isStdLib:      Boolean,
                        contribs:      Set[ContribSource])
      extends Phase2Res
      with SymbolScope.Lib {

    override def equals(obj: Any): Boolean =
      obj match {
        case that: LibScalaJs => that.hashCode === hashCode && that.source === source
        case _ => false
      }

    override lazy val hashCode: Int =
      source.hashCode
  }

  object Unpack {
    def unapply(_m: Map[Source, Phase2Res]): Some[(Map[TsLibSource, LibScalaJs], Set[ContribSource])] =
      Some(apply(_m))

    def apply(_m: Map[Source, Phase2Res]): (Map[TsLibSource, LibScalaJs], Set[ContribSource]) = {

      val libs     = mutable.HashMap.empty[TsLibSource, LibScalaJs]
      val contribs = mutable.HashSet.empty[ContribSource]

      def go(m: Map[Source, Phase2Res]): Unit =
        m foreach {
          case (s: TsLibSource, lib: LibScalaJs) =>
            if (!libs.contains(s)) {
              libs(s) = lib
              goLibs(libs, lib.dependencies)
            }
          case (s: ContribSource, Contrib) =>
            contribs.add(s)
        }

      go(_m)

      (libs.toMap, contribs.to[Set])
    }

    def goLibs(libs: mutable.Map[TsLibSource, LibScalaJs], ds: Map[TsLibSource, LibScalaJs]): Unit =
      ds foreach {
        case (s, lib) =>
          if (!libs.contains(s)) {
            libs(s) = lib
            goLibs(libs, lib.dependencies)
          }
      }
  }
}
