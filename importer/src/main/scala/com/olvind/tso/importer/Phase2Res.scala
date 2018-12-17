package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{ContribSource, TsLibSource}
import com.olvind.tso.maps.MapOps
import com.olvind.tso.scalajs.{ContainerTree, TreeScope}

import scala.collection.immutable.SortedMap
import scala.collection.mutable

sealed trait Phase2Res

object Phase2Res {
  case object Contrib extends Phase2Res

  case class LibScalaJs(source: Source)(
      val libName:              String,
      val libVersion:           LibraryVersion,
      val packageTree:          ContainerTree,
      val dependencies:         Map[TsLibSource, LibScalaJs],
      val isStdLib:             Boolean,
      val contribs:             Set[ContribSource]
  ) extends Phase2Res
      with TreeScope.Lib

  object Unpack {
    def unapply(_m: SortedMap[Source, Phase2Res]): Some[(SortedMap[TsLibSource, LibScalaJs], Set[ContribSource])] =
      Some(apply(_m))

    def apply(_m: SortedMap[Source, Phase2Res]): (SortedMap[TsLibSource, LibScalaJs], Set[ContribSource]) = {

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

      (libs.sorted, contribs.to[Set])
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
