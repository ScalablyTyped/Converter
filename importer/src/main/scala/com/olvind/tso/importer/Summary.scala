package com.olvind.tso
package importer

import ammonite.ops.RelPath
import com.olvind.tso.ts.TsIdentLibrary
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class Summary(
    successes: Set[TsIdentLibrary],
    failures:  Set[TsIdentLibrary],
)
case class SummaryDiff(
    sha:          String,
    newSuccesses: Set[TsIdentLibrary],
    newFailures:  Set[TsIdentLibrary],
    oldFailures:  Set[TsIdentLibrary],
)

object Summary {
  implicit val EncoderTsIdentLibrary: Encoder[TsIdentLibrary] = deriveEncoder[TsIdentLibrary]
  implicit val EncoderSummary:        Encoder[Summary]        = deriveEncoder[Summary]
  implicit val EncoderSummaryDiff:    Encoder[SummaryDiff]    = deriveEncoder[SummaryDiff]

  implicit val DecoderTsIdentLibrary: Decoder[TsIdentLibrary] = deriveDecoder[TsIdentLibrary]
  implicit val DecoderSummary:        Decoder[Summary]        = deriveDecoder[Summary]
  implicit val DecoderSummaryDiff:    Decoder[SummaryDiff]    = deriveDecoder[SummaryDiff]

  val path = RelPath("summary.json")

  def diff(sha: String, existingOpt: Option[Summary], current: Summary): SummaryDiff =
    existingOpt match {
      case Some(existing) =>
        val newFailures = current.failures -- existing.failures
        SummaryDiff(
          sha,
          newSuccesses = current.successes -- existing.successes,
          newFailures  = newFailures,
          oldFailures  = current.failures -- newFailures,
        )
      case None =>
        SummaryDiff(sha, current.successes, current.failures, Set.empty)
    }

  def formatDiff(diff: SummaryDiff): String =
    s"""|Converter: ${diff.sha} - ${diff.newSuccesses.size} new successes, ${diff.newFailures.size} new failures
        |
        |New successes:
        |${diff.newSuccesses.map[String, Seq[String]](x => x.value)(collection.breakOut).sorted.mkString("\n")}
        |
        |New failures:
        |${diff.newFailures.map[String, Seq[String]](x => x.value)(collection.breakOut).sorted.mkString("\n")}
        |
        |Old failures
        |${diff.oldFailures.map[String, Seq[String]](x => x.value)(collection.breakOut).sorted.mkString("\n")}
        |""".stripMargin
}
