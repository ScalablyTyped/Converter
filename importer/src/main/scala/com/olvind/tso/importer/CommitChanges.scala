package com.olvind.tso.importer

import ammonite.ops.{%%, Path}
import com.olvind.tso.scalajs.Name
import com.olvind.tso.ts.TsIdentLibrary

import scala.util.Try

/* calculate difference from last run (if any) and commit new changes */
object CommitChanges {
  def apply(summary: Summary, otherDirs: Seq[Path])(implicit wd: Path): String = {

    val summaryFile = wd / Summary.path
    val existingOpt = Try(Json[Summary](summaryFile)).toOption
    val diff        = Summary.diff(existingOpt, summary)

    Json.persist(summaryFile)(summary)

    %% git ('add, summaryFile.toString)
    otherDirs.foreach(otherDir => %% git ('add, otherDir))

    def duplicatedLogic(s: TsIdentLibrary): String = {
      val base = Phase3CompileBloop.fromName(Name(s.`__value`))
      s"${base.filter(_.isLetterOrDigit).take(1)}/$base"
    }

    summary.successes.grouped(500).foreach(xs => %% git ('add, xs.map(duplicatedLogic).to[List]))

    val formattedDiff = Summary.formatDiff(diff)
    %% git ('commit, "-m", formattedDiff)
    formattedDiff
  }
}
