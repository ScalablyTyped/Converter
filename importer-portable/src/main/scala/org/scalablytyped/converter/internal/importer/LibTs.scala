package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.ts.{TsIdentLibrary, TsParsedFile}

import scala.collection.immutable.SortedMap

case class LibTs(source: LibTsSource)(
    val version:         LibraryVersion,
    val parsed:          TsParsedFile,
    val dependencies:    SortedMap[LibTsSource, LibTs],
) {
  def name: TsIdentLibrary = source.libName

  lazy val transitiveDependencies: SortedMap[LibTsSource, LibTs] = {
    val b = SortedMap.newBuilder[LibTsSource, LibTs]
    def go(tuple: (LibTsSource, LibTs)): Unit = {
      b += tuple
      tuple._2.dependencies.foreach(go)
    }
    dependencies.foreach(go)
    b.result()
  }
}
