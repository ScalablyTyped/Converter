package com.olvind.tso.importer

import ammonite.ops.{%%, Path}
import com.olvind.tso.scalajs.Name
import com.olvind.tso.ts.TsSource

/* calculate difference from last run (if any) and commit new changes */
object CommitRun {
  def apply(summary: Summary)(implicit wd: Path): Unit = {

    val summaryFile = wd / Summary.path
    val existingOpt = Json.opt[Summary](summaryFile)
    val diff        = Summary.diff(existingOpt, summary)
    Json.persist(summaryFile)(summary)

    %% git ('add, summaryFile.toString)

    def duplicatedLogic(s: TsSource.TsLibSource): String = {
      val base = PhaseCompileBloop.fromName(Name(s.libName.`__value`))
      s"${base.filter(_.isLetterOrDigit).take(1)}/$base"
    }

    summary.successes.grouped(500).foreach { xs =>
      %% git ('add, xs.map(duplicatedLogic).to[List])
    }

    val formattedDiff = Summary.formatDiff(diff)
    println(formattedDiff)
    %% git ('commit, "-m", formattedDiff)
    ()
  }
}
