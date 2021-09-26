package org.scalablytyped.converter.internal
package importer.documentation

import com.olvind.logging.Logger
import io.circe013.generic.semiauto.{deriveDecoder, deriveEncoder}
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
      scope:       Option[String],
      version:     String,
      description: Option[String],
      keywords:    Option[List[String]],
      date:        Option[DateString],
      repository:  Option[Repository],
      links:       Links,
      releases:    List[DatedNumbers],
  )
  case class Popularity(
      communityInterest:     Double,
      downloadsCount:        Double,
      downloadsAcceleration: Double,
      dependentsCount:       Double,
  )

  case class ScoreDetail(quality: Double, popularity: Double, maintenance: Double)

  case class Score(`final`:         Double, detail: ScoreDetail)
  case class Github(starsCount:     Double)
  case class Collected(metadata:    Metadata, github: Option[Github])
  case class Evaluation(popularity: Popularity)

  case class Data(analyzedAt: DateString, collected: Collected, evaluation: Evaluation, score: Score)

  object Data {
    implicit val DecoderDatedNumbers: Decoder[DatedNumbers] = deriveDecoder
    implicit val EncoderDatedNumbers: Encoder[DatedNumbers] = deriveEncoder
    implicit val DecoderLinks:        Decoder[Links]        = deriveDecoder
    implicit val EncoderLinks:        Encoder[Links]        = deriveEncoder
    implicit val DecoderRepository:   Decoder[Repository]   = deriveDecoder
    implicit val EncoderRepository:   Encoder[Repository]   = deriveEncoder
    implicit val DecoderMetadata:     Decoder[Metadata]     = deriveDecoder
    implicit val EncoderMetadata:     Encoder[Metadata]     = deriveEncoder
    implicit val DecoderPopularity:   Decoder[Popularity]   = deriveDecoder
    implicit val EncoderPopularity:   Encoder[Popularity]   = deriveEncoder
    implicit val DecoderEvaluation:   Decoder[Evaluation]   = deriveDecoder
    implicit val EncoderEvaluation:   Encoder[Evaluation]   = deriveEncoder
    implicit val DecoderGithub:       Decoder[Github]       = deriveDecoder
    implicit val EncoderGithub:       Encoder[Github]       = deriveEncoder
    implicit val DecoderCollected:    Decoder[Collected]    = deriveDecoder
    implicit val EncoderCollected:    Encoder[Collected]    = deriveEncoder
    implicit val DecoderScoreDetail:  Decoder[ScoreDetail]  = deriveDecoder
    implicit val EncoderScoreDetail:  Encoder[ScoreDetail]  = deriveEncoder
    implicit val DecoderScore:        Decoder[Score]        = deriveDecoder
    implicit val EncoderScore:        Encoder[Score]        = deriveEncoder
    implicit val DecoderData:         Decoder[Data]         = deriveDecoder
    implicit val EncoderData:         Encoder[Data]         = deriveEncoder
  }

  object No extends Npmjs {
    override def apply[L](source: LibTsSource, logger: Logger[L]): Future[Option[Data]] =
      Future.successful(None)
  }
}
