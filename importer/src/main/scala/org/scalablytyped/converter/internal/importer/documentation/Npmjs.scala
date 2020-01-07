package org.scalablytyped.converter.internal
package importer.documentation

import java.nio.file.Path

import com.olvind.logging.Logger
import dispatch._
import gigahorse.HttpClient
import gigahorse.support.okhttp.Gigahorse
import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer.{Json, Source}
import org.scalablytyped.converter.internal.stringUtils.encodeURIComponent
import org.scalablytyped.converter.internal.ts.TsIdentLibrarySimple

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

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
    implicit val DecoderDatedNumbers: Decoder[DatedNumbers] = io.circe.derivation.deriveDecoder[DatedNumbers]
    implicit val EncoderDatedNumbers: Encoder[DatedNumbers] = io.circe.derivation.deriveEncoder[DatedNumbers]
    implicit val DecoderLinks:        Decoder[Links]        = io.circe.derivation.deriveDecoder[Links]
    implicit val EncoderLinks:        Encoder[Links]        = io.circe.derivation.deriveEncoder[Links]
    implicit val DecoderRepository:   Decoder[Repository]   = io.circe.derivation.deriveDecoder[Repository]
    implicit val EncoderRepository:   Encoder[Repository]   = io.circe.derivation.deriveEncoder[Repository]
    implicit val DecoderMetadata:     Decoder[Metadata]     = io.circe.derivation.deriveDecoder[Metadata]
    implicit val EncoderMetadata:     Encoder[Metadata]     = io.circe.derivation.deriveEncoder[Metadata]
    implicit val DecoderNpm:          Decoder[Npm]          = io.circe.derivation.deriveDecoder[Npm]
    implicit val EncoderNpm:          Encoder[Npm]          = io.circe.derivation.deriveEncoder[Npm]
    implicit val DecoderCollected:    Decoder[Collected]    = io.circe.derivation.deriveDecoder[Collected]
    implicit val EncoderCollected:    Encoder[Collected]    = io.circe.derivation.deriveEncoder[Collected]
    implicit val DecoderScoreDetail:  Decoder[ScoreDetail]  = io.circe.derivation.deriveDecoder[ScoreDetail]
    implicit val EncoderScoreDetail:  Encoder[ScoreDetail]  = io.circe.derivation.deriveEncoder[ScoreDetail]
    implicit val DecoderScore:        Decoder[Score]        = io.circe.derivation.deriveDecoder[Score]
    implicit val EncoderScore:        Encoder[Score]        = io.circe.derivation.deriveEncoder[Score]
    implicit val DecoderData:         Decoder[Data]         = io.circe.derivation.deriveDecoder[Data]
    implicit val EncoderData:         Encoder[Data]         = io.circe.derivation.deriveEncoder[Data]
  }

  trait Fetcher {
    def apply[L](source: Source, logger: Logger[L]): Future[Option[Data]]
  }

  object No extends Fetcher {
    override def apply[L](source: Source, logger: Logger[L]): Future[Option[Data]] =
      Future.successful(None)
  }

  case class GigahorseFetcher(cacheDir: Path)(implicit ec: ExecutionContext) extends Fetcher {
    val client: HttpClient = Gigahorse.http(
      Gigahorse.config
        .withMaxConnections(10)
        .withMaxRequestRetry(3),
    )

    override def apply[L](source: Source, logger: Logger[L]): Future[Option[Data]] = {
      val libOpt = source match {
        case Source.StdLibSource(_, _, _)  => Some(TsIdentLibrarySimple("typescript"))
        case Source.FromFolder(_, libName) => Some(libName)
        case _                             => None
      }

      libOpt match {
        case None => Future.successful(None)
        case Some(lib) =>
          val cacheFile = cacheDir.resolve("/" + lib.`__value`)

          Json.opt[Data](cacheFile) match {
            case Some(x) => Future.successful(Some(x))
            case None =>
              client
                .run(
                  Gigahorse.url(s"https://api.npms.io/v2/package/${encodeURIComponent(lib.value)}").get,
                  Gigahorse.asString,
                )
                .transform {
                  case Failure(th) =>
                    logger.warn(s"Could't fetch metadata for $lib", th)
                    Success(None)
                  case Success(jsonStr) =>
                    Json.CustomJacksonParser.decode[Data](jsonStr) match {
                      case Left(err) =>
                        logger.error(s"Could't decode json for $lib, $jsonStr", err)
                        Success(None)
                      case Right(data) =>
                        files.softWrite(cacheFile)(_.println(jsonStr))
                        Success(Some(data))

                    }
                }
          }
      }
    }
  }
}
