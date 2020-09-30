package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Source.TsLibSource
import org.scalablytyped.converter.internal.maps.MapOps
import org.scalablytyped.converter.internal.scalajs.{Name, PackageTree, TreeScope}

import scala.collection.immutable.SortedMap
import scala.collection.mutable

case class LibScalaJs(source: TsLibSource)(
    val libName:              String,
    val scalaName:            Name,
    val libVersion:           LibraryVersion,
    val packageTree:          PackageTree,
    val dependencies:         Map[TsLibSource, LibScalaJs],
    val isStdLib:             Boolean,
    val names:                AdaptiveNamingImport,
) extends TreeScope.Lib

object LibScalaJs {

  object Unpack {
    def unapply(_m: SortedMap[Source, LibScalaJs]): Some[SortedMap[TsLibSource, LibScalaJs]] =
      Some(apply(_m))

    def apply(_m: SortedMap[Source, LibScalaJs]): SortedMap[TsLibSource, LibScalaJs] = {

      val libs = mutable.HashMap.empty[TsLibSource, LibScalaJs]

      def go(m: Map[Source, LibScalaJs]): Unit =
        m.foreach {
          case (s: TsLibSource, lib: LibScalaJs) =>
            if (!libs.contains(s)) {
              libs(s) = lib
              goLibs(libs, lib.dependencies)
            }

          case other => sys.error(s"Unexpected $other")
        }

      go(_m)

      libs.toSorted
    }

    def goLibs(libs: mutable.Map[TsLibSource, LibScalaJs], ds: Map[TsLibSource, LibScalaJs]): Unit =
      ds.foreach {
        case (s, lib) =>
          if (!libs.contains(s)) {
            libs(s) = lib
            goLibs(libs, lib.dependencies)
          }
      }
  }
}
