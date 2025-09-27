package org.scalablytyped.converter.internal
package importer
package documentation

import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.nio.file.Path
import java.time.{Duration => JDuration}
import java.util.concurrent.CompletableFuture

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.stringUtils.encodeURIComponent
import org.scalablytyped.converter.internal.ts.TsIdentLibrarySimple

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}

case class NpmjsFetcher(cacheDir: Path)(implicit ec: ExecutionContext) extends Npmjs {
  val client: HttpClient = HttpClient
    .newBuilder()
    .connectTimeout(JDuration.ofSeconds(10))
    .followRedirects(HttpClient.Redirect.NORMAL)
    .build()

  private def toFuture[T](cf: CompletableFuture[T]): Future[T] = {
    val promise = Promise[T]()
    cf.whenComplete { (result, error) =>
      if (error == null) promise.success(result)
      else promise.failure(error)
    }
    promise.future
  }

  override def apply[L](source: LibTsSource, logger: Logger[L]): Future[Option[Npmjs.Data]] = {
    val lib = source match {
      case LibTsSource.StdLibSource(_, _, _)  => TsIdentLibrarySimple("typescript")
      case LibTsSource.FromFolder(_, libName) => libName
    }

    val cacheFile = cacheDir.resolve("/" + lib.`__value`)

    Json.opt[Npmjs.Data](cacheFile) match {
      case Some(x) => Future.successful(Some(x))
      case None =>
        val request = HttpRequest
          .newBuilder()
          .uri(URI.create(s"https://api.npms.io/v2/package/${encodeURIComponent(lib.value)}"))
          .GET()
          .timeout(JDuration.ofSeconds(30))
          .build()

        toFuture(client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
          .transform {
            case Failure(th) =>
              logger.warn(s"Could't fetch metadata for $lib", th)
              Success(None)
            case Success(response) =>
              if (response.statusCode() != 200) {
                logger.warn(s"HTTP ${response.statusCode()} for $lib")
                Success(None)
              } else {
                Json.CustomJacksonParser.decode[Npmjs.Data](response.body()) match {
                  case Left(err) =>
                    logger.warn(s"Could't decode json for $lib, ${response.body()}", err)
                    Success(None)
                  case Right(data) =>
                    files.softWrite(cacheFile)(_.println(response.body()))
                    Success(Some(data))
                }
              }
          }
    }
  }
}
