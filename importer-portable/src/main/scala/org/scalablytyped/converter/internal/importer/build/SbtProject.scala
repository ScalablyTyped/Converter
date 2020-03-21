package org.scalablytyped.converter.internal
package importer
package build

import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps.MapOps
import org.scalablytyped.converter.internal.scalajs.Dep

import scala.collection.immutable.SortedMap
import scala.collection.mutable

case class SbtProject(name: String, artifactId: String, reference: Dep.ScalaJs)(
    val baseDir:            os.Path,
    val deps:               Map[Source, PublishedSbtProject],
    val metadata:           Option[Npmjs.Data],
)

case class PublishedSbtProject(project: SbtProject)(
    val classfileDir:                   os.Path,
    val localIvyFiles:                  IvyLayout[os.Path, _],
    val publishedOpt:                   Option[Unit],
)

object PublishedSbtProject {
  object Unpack {
    def unapply(_m: SortedMap[Source, PublishedSbtProject]): Some[SortedMap[Source, PublishedSbtProject]] =
      Some(apply(_m))

    def apply(_m: SortedMap[Source, PublishedSbtProject]): SortedMap[Source, PublishedSbtProject] = {
      val ret = mutable.HashMap.empty[Source, PublishedSbtProject]

      def go(libs: mutable.Map[Source, PublishedSbtProject], ds: Map[Source, PublishedSbtProject]): Unit =
        ds foreach {
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
