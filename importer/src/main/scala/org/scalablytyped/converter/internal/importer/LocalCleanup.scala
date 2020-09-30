package org.scalablytyped.converter.internal
package importer

object LocalCleanup {
  implicit val Newest = Ordering.by[os.Path, Long](-_.toIO.lastModified)

  def apply(ivyLocal: os.Path, organization: String, keepNum: Int): Unit =
    os.list(files.existing(ivyLocal / organization)).foreach { project =>
      os.list(project).sorted.drop(keepNum).foreach(files.deleteAll)
    }
}
