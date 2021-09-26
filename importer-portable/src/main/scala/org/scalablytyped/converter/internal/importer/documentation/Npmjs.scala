package org.scalablytyped.converter.internal
package importer.documentation

import com.olvind.logging.Logger
import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer.LibTsSource

import scala.concurrent.Future

trait Npmjs {
  def apply[L](source: LibTsSource, logger: Logger[L]): Future[Option[Npmjs.Data]]
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
    implicit val DecoderDatedNumbers: Decoder[DatedNumbers] = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderDatedNumbers: Encoder[DatedNumbers] = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderLinks:        Decoder[Links]        = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderLinks:        Encoder[Links]        = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderRepository:   Decoder[Repository]   = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderRepository:   Encoder[Repository]   = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderMetadata:     Decoder[Metadata]     = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderMetadata:     Encoder[Metadata]     = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderNpm:          Decoder[Npm]          = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderNpm:          Encoder[Npm]          = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderCollected:    Decoder[Collected]    = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderCollected:    Encoder[Collected]    = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderScoreDetail:  Decoder[ScoreDetail]  = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderScoreDetail:  Encoder[ScoreDetail]  = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderScore:        Decoder[Score]        = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderScore:        Encoder[Score]        = io.circe013.generic.semiauto.deriveEncoder
    implicit val DecoderData:         Decoder[Data]         = io.circe013.generic.semiauto.deriveDecoder
    implicit val EncoderData:         Encoder[Data]         = io.circe013.generic.semiauto.deriveEncoder
  }

  object No extends Npmjs {
    override def apply[L](source: LibTsSource, logger: Logger[L]): Future[Option[Data]] =
      Future.successful(None)
  }
}
