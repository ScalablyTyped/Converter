package org.scalablytyped.converter.internal
package importer
package build

import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.scalajs.Dep

import scala.collection.immutable.SortedMap

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
    def unapply(m: SortedMap[LibTsSource, PublishedSbtProject]): Some[SortedMap[LibTsSource, PublishedSbtProject]] =
      Some(apply(m))

    def apply(m: SortedMap[LibTsSource, PublishedSbtProject]): SortedMap[LibTsSource, PublishedSbtProject] = {
      val b = SortedMap.newBuilder[LibTsSource, PublishedSbtProject]

      def go(tuple: (LibTsSource, PublishedSbtProject)): Unit = {
        b += tuple
        tuple._2.project.deps.foreach(go)
      }

      m.foreach(go)

      b.result()
    }
  }
}
