package org.scalablytyped.converter.internal
package importer.documentation

import java.nio.file.Path

import com.olvind.logging.Logger
import dispatch._
import gigahorse.HttpClient
import gigahorse.support.okhttp.Gigahorse
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
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
