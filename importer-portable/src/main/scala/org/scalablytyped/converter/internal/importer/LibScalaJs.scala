package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.maps.MapOps
import org.scalablytyped.converter.internal.scalajs.{Name, PackageTree, TreeScope}

import scala.collection.immutable.SortedMap
import scala.collection.mutable

case class LibScalaJs(source: LibTsSource)(
    val libName:              String,
    val scalaName:            Name,
    val libVersion:           LibraryVersion,
    val packageTree:          PackageTree,
    val dependencies:         Map[LibTsSource, LibScalaJs],
    val isStdLib:             Boolean,
    val names:                AdaptiveNamingImport,
) extends TreeScope.Lib

object LibScalaJs {

  object Unpack {
    def unapply(_m: SortedMap[LibTsSource, LibScalaJs]): Some[SortedMap[LibTsSource, LibScalaJs]] =
      Some(apply(_m))

    def apply(_m: SortedMap[LibTsSource, LibScalaJs]): SortedMap[LibTsSource, LibScalaJs] = {

      val libs = mutable.HashMap.empty[LibTsSource, LibScalaJs]

      def go(m: Map[LibTsSource, LibScalaJs]): Unit =
        m.foreach {
          case (s: LibTsSource, lib: LibScalaJs) =>
            if (!libs.contains(s)) {
              libs(s) = lib
              goLibs(libs, lib.dependencies)
            }

          case other => sys.error(s"Unexpected $other")
        }

      go(_m)

      libs.toSorted
    }

    def goLibs(libs: mutable.Map[LibTsSource, LibScalaJs], ds: Map[LibTsSource, LibScalaJs]): Unit =
      ds.foreach {
        case (s, lib) =>
          if (!libs.contains(s)) {
            libs(s) = lib
            goLibs(libs, lib.dependencies)
          }
      }
  }
}
