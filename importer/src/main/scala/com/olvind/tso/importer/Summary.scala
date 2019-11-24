package com.olvind.tso
package importer

import com.olvind.tso.importer.build.PublishedSbtProject
import com.olvind.tso.phases.PhaseRes
import com.olvind.tso.ts.TsIdentLibrary
import io.circe.Decoder.Result
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder, HCursor}

import scala.collection.mutable

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
  def apply(x: Map[Source, PhaseRes[Source, PublishedSbtProject]]): Summary = {
    val successes = mutable.Set.empty[TsIdentLibrary]
    val failures  = mutable.Set.empty[TsIdentLibrary]
    x foreach {
      case (current, res) =>
        res match {
          case PhaseRes.Ok(_) =>
            successes += current.libName
          case PhaseRes.Ignore() =>
            ()
          case PhaseRes.Failure(errors) =>
            failures += current.libName
            errors.keys.foreach(s => failures += s.libName)
        }
    }
    Summary(successes.to[Set], failures.to[Set])
  }

  object legacyLibDecoder extends Decoder[TsIdentLibrary] {
    override def apply(c: HCursor): Result[TsIdentLibrary] = {
      val obj = c.downField("TsIdentLibraryScoped")
      obj.get[String]("scope").map {
        scope =>
          val nameOpt = obj.get[String]("nameOpt").toOption
          nameOpt match {
            case None => ts.TsIdentLibrarySimple(s"@$scope")
            case Some(name) => ts.TsIdentLibraryScoped(scope, name)
          }
      }
    }
  }

  implicit val EncoderTsIdentLibrary: Encoder[TsIdentLibrary] = deriveEncoder[TsIdentLibrary]
  implicit val DecoderTsIdentLibrary: Decoder[TsIdentLibrary] = deriveDecoder[TsIdentLibrary].or(legacyLibDecoder)
  implicit val EncoderSummary:        Encoder[Summary]        = deriveEncoder[Summary]
  implicit val EncoderSummaryDiff:    Encoder[SummaryDiff]    = deriveEncoder[SummaryDiff]
  implicit val DecoderSummary:        Decoder[Summary]        = deriveDecoder[Summary]
  implicit val DecoderSummaryDiff:    Decoder[SummaryDiff]    = deriveDecoder[SummaryDiff]

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
        |${diff.newSuccesses.map[String, Seq[String]](x => x.value)(collection.breakOut).sorted.mkString("\n")}
        |
        |New failures:
        |${diff.newFailures.map[String, Seq[String]](x => x.value)(collection.breakOut).sorted.mkString("\n")}
        |
        |Old failures
        |${diff.oldFailures.map[String, Seq[String]](x => x.value)(collection.breakOut).sorted.mkString("\n")}
        |""".stripMargin
}
