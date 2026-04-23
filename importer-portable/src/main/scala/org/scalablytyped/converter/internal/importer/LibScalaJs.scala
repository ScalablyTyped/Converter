package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.{Name, PackageTree, TreeScope}

import scala.collection.mutable
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
  def allDependencies(deps: Iterable[LibScalaJs]): Map[Name, PackageTree] = {
    val seen = mutable.Set.empty[Name]
    val acc  = Map.newBuilder[Name, PackageTree]

    def go(lib: LibScalaJs): Unit =
      if (seen.add(lib.scalaName)) {
        acc += lib.scalaName -> lib.packageTree
        lib.dependencies.values.foreach(go)
      }

    deps.foreach(go)
    acc.result()
  }

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
