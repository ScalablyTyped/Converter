package org.scalablytyped.converter.internal
package importer
package build

import bleep.model
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.scalajs.Dep

import scala.collection.immutable.SortedMap

case class ScalaProject(name: String, reference: Dep.Concrete)(
    val baseDir:              os.Path,
    val deps:                 Map[LibTsSource, ScalaProject],
    val metadata:             Option[Npmjs.Data],
    val bleepFile:            model.BuildFile,
)

object ScalaProject {
  object Unpack {
    def unapply(m: SortedMap[LibTsSource, ScalaProject]): Some[SortedMap[LibTsSource, ScalaProject]] =
      Some(apply(m))

    def apply(m: SortedMap[LibTsSource, ScalaProject]): SortedMap[LibTsSource, ScalaProject] = {
      val b = SortedMap.newBuilder[LibTsSource, ScalaProject]

      def go(tuple: (LibTsSource, ScalaProject)): Unit = {
        b += tuple
        tuple._2.deps.foreach(go)
      }

      m.foreach(go)

      b.result()
    }
  }
}
