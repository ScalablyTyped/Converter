package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Source.{FacadeSource, TsLibSource}
import org.scalablytyped.converter.internal.maps.MapOps
import org.scalablytyped.converter.internal.scalajs.{Name, PackageTree, TreeScope}

import scala.collection.immutable.SortedMap
import scala.collection.mutable

sealed trait Phase2Res

object Phase2Res {
  case object Facade extends Phase2Res

  case class LibScalaJs(source: TsLibSource)(
      val libName:              String,
      val scalaName:            Name,
      val libVersion:           LibraryVersion,
      val packageTree:          PackageTree,
      val dependencies:         Map[TsLibSource, LibScalaJs],
      val isStdLib:             Boolean,
      val facades:              Set[FacadeSource],
  ) extends Phase2Res
      with TreeScope.Lib

  object Unpack {
    def unapply(_m: SortedMap[Source, Phase2Res]): Some[(SortedMap[TsLibSource, LibScalaJs], Set[FacadeSource])] =
      Some(apply(_m))

    def apply(_m: SortedMap[Source, Phase2Res]): (SortedMap[TsLibSource, LibScalaJs], Set[FacadeSource]) = {

      val libs    = mutable.HashMap.empty[TsLibSource, LibScalaJs]
      val facades = mutable.HashSet.empty[FacadeSource]

      def go(m: Map[Source, Phase2Res]): Unit =
        m foreach {
          case (s: TsLibSource, lib: LibScalaJs) =>
            if (!libs.contains(s)) {
              libs(s) = lib
              goLibs(libs, lib.dependencies)
            }
          case (s: FacadeSource, Facade) =>
            facades.add(s)

          case other => sys.error(s"Unexpected $other")
        }

      go(_m)

      (libs.toSorted, facades.to[Set])
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
