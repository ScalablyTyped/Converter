package com.olvind.tso
package importer
package build

import ammonite.ops.Path
import com.olvind.tso.maps.MapOps

import scala.collection.immutable.SortedMap
import scala.collection.mutable

case class SbtProject(name: String, organization: String, artifactId: String, version: String)(
    val baseDir:            Path,
    val written:            Map[Path, Synced],
    val deps:               Map[Source, PublishedSbtProject]
)

case class PublishedSbtProject(project: SbtProject)(
    val localIvyFiles:                  IvyLayout[Path, Synced],
    val publishedOpt:                   Option[Unit]
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
