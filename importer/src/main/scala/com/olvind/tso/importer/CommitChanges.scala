package com.olvind.tso.importer

import com.olvind.tso.BuildInfo

import scala.util.Try

/* calculate difference from last run (if any) and commit new changes */
object CommitChanges {
  def apply(cmd:   Cmd, summary: Summary, mainFolders: Seq[os.Path], otherDirs: Seq[os.Path])(
      implicit wd: os.Path,
  ): String = {

    val summaryFile = wd / Summary.path
    val existingOpt = Try(Json[Summary](summaryFile)).toOption
    val diff        = Summary.diff(BuildInfo.gitSha.take(6), existingOpt, summary)

    Json.persist(summaryFile)(summary)

    cmd.runVerbose git ('add, summaryFile.toString)
    otherDirs.foreach(otherDir => cmd.runVerbose git ('add, otherDir))

    mainFolders.grouped(500).foreach(xs => cmd.runVerbose git ('add, xs.map(_.toString()).to[List]))

    val formattedDiff = Summary.formatDiff(diff)
    cmd.runVerbose git ('commit, "-m", formattedDiff)
    formattedDiff
  }
}
