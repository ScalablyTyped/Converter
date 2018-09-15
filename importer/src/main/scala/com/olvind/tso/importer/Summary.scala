package com.olvind.tso
package importer

import ammonite.ops.{Path, RelPath}
import com.olvind.tso.ts.TsIdentLibrary
import com.olvind.tso.ts.TsSource.TsLibSource
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class Summary(successes:        Set[TsIdentLibrary], failures:    Set[TsIdentLibrary])
case class SummaryDiff(newSuccesses: Set[TsIdentLibrary], newFailures: Set[TsIdentLibrary], oldFailures: Set[TsIdentLibrary])

object Summary {

  implicit val EncoderPath:           Encoder[Path]           = Encoder[String].contramap[Path](_.toString)
  implicit val EncoderInFile:         Encoder[InFile]         = EncoderPath.contramap[InFile](_.path)
  implicit val EncoderInFolder:       Encoder[InFolder]       = EncoderPath.contramap[InFolder](_.path)
  implicit val EncoderTsIdentLibrary: Encoder[TsIdentLibrary] = deriveEncoder[TsIdentLibrary]
  implicit val EncoderTsSource:       Encoder[TsLibSource]    = deriveEncoder[TsLibSource]
  implicit val EncoderSummary:        Encoder[Summary]        = deriveEncoder[Summary]
  implicit val EncoderSummaryDiff:    Encoder[SummaryDiff]    = deriveEncoder[SummaryDiff]

  implicit val DecoderPath:           Decoder[Path]           = Decoder[String].map(Path(_))
  implicit val DecoderInFile:         Decoder[InFile]         = DecoderPath.map[InFile](InFile(_))
  implicit val DecoderInFolder:       Decoder[InFolder]       = DecoderPath.map[InFolder](InFolder)
  implicit val DecoderTsSource:       Decoder[TsLibSource]    = deriveDecoder[TsLibSource]
  implicit val DecoderTsIdentLibrary: Decoder[TsIdentLibrary] = deriveDecoder[TsIdentLibrary]
  implicit val DecoderSummary:        Decoder[Summary]        = deriveDecoder[Summary]
  implicit val DecoderSummaryDiff:    Decoder[SummaryDiff]    = deriveDecoder[SummaryDiff]

  val path = RelPath("summary.json")

  def diff(existingOpt: Option[Summary], current: Summary): SummaryDiff =
    existingOpt match {
      case Some(existing) =>
        val newFailures = current.failures -- existing.failures
        SummaryDiff(
          newSuccesses = current.successes -- existing.successes,
          newFailures = newFailures,
          oldFailures = current.failures -- newFailures
        )
      case None =>
        SummaryDiff(current.successes, current.failures, Set.empty)
    }

  def formatDiff(diff: SummaryDiff): String =
    s"""|${diff.newSuccesses.size} new successes, ${diff.newFailures.size} new failures
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
