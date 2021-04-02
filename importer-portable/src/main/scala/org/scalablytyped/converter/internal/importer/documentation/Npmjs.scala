package org.scalablytyped.converter.internal
package importer.documentation

import com.olvind.logging.Logger
import io.circe013.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer.Source

import scala.concurrent.Future

trait Npmjs {
  def apply[L](source: Source, logger: Logger[L]): Future[Option[Npmjs.Data]]
}

object Npmjs {
  type DateString = String
  type URI        = String

  case class Repository(`type`: Option[String], url: Option[String])

  case class Links(npm: Option[URI], homepage: Option[URI], repository: Option[URI], bugs: Option[URI])

  case class DatedNumbers(from: DateString, to: DateString, count: Long)

  case class Metadata(
      name:        String,
      scope:       String,
      version:     String,
      description: Option[String],
      keywords:    Option[List[String]],
      date:        Option[DateString],
      repository:  Option[Repository],
      links:       Links,
      releases:    List[DatedNumbers],
  )
  case class Npm(downloads: List[DatedNumbers], dependentsCount: Int, starsCount: Int)

  case class ScoreDetail(quality: Double, popularity: Double, maintenance: Double)

  case class Score(`final`: Double, detail: ScoreDetail)

  case class Collected(metadata: Metadata, npm: Npm)

  case class Data(analyzedAt: DateString, collected: Collected, score: Score)

  object Data {
    implicit val DecoderDatedNumbers: Decoder[DatedNumbers] = deriveDecoder[DatedNumbers]
    implicit val EncoderDatedNumbers: Encoder[DatedNumbers] = deriveEncoder[DatedNumbers]
    implicit val DecoderLinks:        Decoder[Links]        = deriveDecoder[Links]
    implicit val EncoderLinks:        Encoder[Links]        = deriveEncoder[Links]
    implicit val DecoderRepository:   Decoder[Repository]   = deriveDecoder[Repository]
    implicit val EncoderRepository:   Encoder[Repository]   = deriveEncoder[Repository]
    implicit val DecoderMetadata:     Decoder[Metadata]     = deriveDecoder[Metadata]
    implicit val EncoderMetadata:     Encoder[Metadata]     = deriveEncoder[Metadata]
    implicit val DecoderNpm:          Decoder[Npm]          = deriveDecoder[Npm]
    implicit val EncoderNpm:          Encoder[Npm]          = deriveEncoder[Npm]
    implicit val DecoderCollected:    Decoder[Collected]    = deriveDecoder[Collected]
    implicit val EncoderCollected:    Encoder[Collected]    = deriveEncoder[Collected]
    implicit val DecoderScoreDetail:  Decoder[ScoreDetail]  = deriveDecoder[ScoreDetail]
    implicit val EncoderScoreDetail:  Encoder[ScoreDetail]  = deriveEncoder[ScoreDetail]
    implicit val DecoderScore:        Decoder[Score]        = deriveDecoder[Score]
    implicit val EncoderScore:        Encoder[Score]        = deriveEncoder[Score]
    implicit val DecoderData:         Decoder[Data]         = deriveDecoder[Data]
    implicit val EncoderData:         Encoder[Data]         = deriveEncoder[Data]
  }

  object No extends Npmjs {
    override def apply[L](source: Source, logger: Logger[L]): Future[Option[Data]] =
      Future.successful(None)
  }
}
