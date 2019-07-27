package com.olvind.tso.importer

object LocalCleanup {
  implicit val Newest = Ordering.by[os.Path, Long](-_.toIO.lastModified)

  def apply(ivyLocal: os.Path, organization: String, keepNum: Int): Unit =
    os.list(ivyLocal / organization).foreach { project =>
      os.list(project).sorted drop keepNum foreach os.remove.all
    }
}
