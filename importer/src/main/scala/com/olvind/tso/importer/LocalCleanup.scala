package com.olvind.tso.importer

import ammonite.ops.{ls, rm, Path}

object LocalCleanup {
  implicit val Newest = Ordering.by[Path, Long](-_.toIO.lastModified)

  def apply(ivyLocal: Path, organization: String, keepNum: Int): Unit =
    ls(ivyLocal / organization).foreach { project =>
      ls(project).sorted drop keepNum foreach rm
    }
}
