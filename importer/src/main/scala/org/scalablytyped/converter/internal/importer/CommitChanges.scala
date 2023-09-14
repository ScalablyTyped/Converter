package org.scalablytyped.converter.internal.importer

/* calculate difference from last run (if any) and commit new changes */
object CommitChanges {
  def apply(cmd:   Cmd, summary: Summary, mainFolders: Seq[os.Path], others: Seq[os.Path], formattedDiff: String)(
      implicit wd: os.Path,
  ): Unit = {

    others.foreach(other => cmd.runVerbose.git('add, other))

    mainFolders.grouped(500).foreach(xs => cmd.runVerbose.git('add, xs.map(_.toString()).to(List)))

    cmd.runVerbose.git('commit, "-m", formattedDiff)
    ()
  }
}
