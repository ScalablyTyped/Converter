package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.{Name, PackageTree, TreeScope}

import scala.collection.immutable.SortedMap

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
    def unapply(m: SortedMap[LibTsSource, LibScalaJs]): Some[SortedMap[LibTsSource, LibScalaJs]] =
      Some(apply(m))

    def apply(m: SortedMap[LibTsSource, LibScalaJs]): SortedMap[LibTsSource, LibScalaJs] = {
      val b = SortedMap.newBuilder[LibTsSource, LibScalaJs]

      def go(tuple: (LibTsSource, LibScalaJs)): Unit = {
        b += tuple
        tuple._2.dependencies.foreach(go)
      }

      m.foreach(go)

      b.result()
    }
  }
}
