package org.scalablytyped.converter.internal
package importer
package build

import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps.MapOps
import org.scalablytyped.converter.internal.scalajs.Dep

import scala.collection.immutable.SortedMap
import scala.collection.mutable

case class SbtProject(name: String, reference: Dep.Concrete)(
    val baseDir:            os.Path,
    val deps:               Map[LibTsSource, PublishedSbtProject],
    val metadata:           Option[Npmjs.Data],
)

case class PublishedSbtProject(project: SbtProject)(
    val classfileDir:                   os.Path,
    val localIvyFiles:                  IvyLayout[os.RelPath, os.Path],
    val publishedOpt:                   Option[Unit],
)

object PublishedSbtProject {
  object Unpack {
    def unapply(_m: SortedMap[LibTsSource, PublishedSbtProject]): Some[SortedMap[LibTsSource, PublishedSbtProject]] =
      Some(apply(_m))

    def apply(_m: SortedMap[LibTsSource, PublishedSbtProject]): SortedMap[LibTsSource, PublishedSbtProject] = {
      val ret = mutable.HashMap.empty[LibTsSource, PublishedSbtProject]

      def go(libs: mutable.Map[LibTsSource, PublishedSbtProject], ds: Map[LibTsSource, PublishedSbtProject]): Unit =
        ds.foreach {
          case (s, lib) =>
            if (!libs.contains(s)) {
              libs(s) = lib
              go(libs, lib.project.deps)
            }
        }

      go(ret, _m)
      ret.toSorted
    }
  }
}
