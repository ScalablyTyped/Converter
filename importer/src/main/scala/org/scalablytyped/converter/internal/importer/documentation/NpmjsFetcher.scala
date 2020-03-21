package org.scalablytyped.converter.internal
package importer
package documentation

import java.nio.file.Path

import com.olvind.logging.Logger
import gigahorse.HttpClient
import gigahorse.support.okhttp.Gigahorse
import org.scalablytyped.converter.internal.stringUtils.encodeURIComponent
import org.scalablytyped.converter.internal.ts.TsIdentLibrarySimple

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

case class NpmjsFetcher(cacheDir: Path)(implicit ec: ExecutionContext) extends Npmjs {
  val client: HttpClient = Gigahorse.http(
    Gigahorse.config
      .withMaxConnections(10)
      .withMaxRequestRetry(3),
  )

  override def apply[L](source: Source, logger: Logger[L]): Future[Option[Npmjs.Data]] = {
    val libOpt = source match {
      case Source.StdLibSource(_, _, _)  => Some(TsIdentLibrarySimple("typescript"))
      case Source.FromFolder(_, libName) => Some(libName)
      case _                             => None
    }

    libOpt match {
      case None => Future.successful(None)
      case Some(lib) =>
        val cacheFile = cacheDir.resolve("/" + lib.`__value`)

        Json.opt[Npmjs.Data](cacheFile) match {
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
                  Json.CustomJacksonParser.decode[Npmjs.Data](jsonStr) match {
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
