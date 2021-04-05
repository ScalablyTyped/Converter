package org.scalablytyped.converter.internal
package importer

import io.circe013.Decoder.Result
import io.circe013.{Decoder, Encoder, HCursor}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

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
  object legacyLibDecoder extends Decoder[TsIdentLibrary] {
    override def apply(c: HCursor): Result[TsIdentLibrary] = {
      val obj = c.downField("TsIdentLibraryScoped")
      obj.get[String]("scope").map { scope =>
        val nameOpt = obj.get[String]("nameOpt").toOption
        nameOpt match {
          case None       => ts.TsIdentLibrarySimple(s"@$scope")
          case Some(name) => ts.TsIdentLibraryScoped(scope, name)
        }
      }
    }
  }

  implicit val EncoderTsIdentLibrary: Encoder[TsIdentLibrary] = io.circe013.generic.semiauto.deriveEncoder
  implicit val DecoderTsIdentLibrary: Decoder[TsIdentLibrary] =
    io.circe013.generic.semiauto.deriveDecoder[TsIdentLibrary].or(legacyLibDecoder)
  implicit val EncoderSummary:     Encoder[Summary]     = io.circe013.generic.semiauto.deriveEncoder
  implicit val DecoderSummary:     Decoder[Summary]     = io.circe013.generic.semiauto.deriveDecoder
  implicit val EncoderSummaryDiff: Encoder[SummaryDiff] = io.circe013.generic.semiauto.deriveEncoder
  implicit val DecoderSummaryDiff: Decoder[SummaryDiff] = io.circe013.generic.semiauto.deriveDecoder

  val path = os.RelPath("summary.json")

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
        |${diff.newSuccesses.map(x => x.value).toArray.sorted.mkString("\n")}
        |
        |New failures:
        |${diff.newFailures.map(x => x.value).toArray.sorted.mkString("\n")}
        |
        |Old failures
        |${diff.oldFailures.map(x => x.value).toArray.sorted.mkString("\n")}
        |""".stripMargin
}
