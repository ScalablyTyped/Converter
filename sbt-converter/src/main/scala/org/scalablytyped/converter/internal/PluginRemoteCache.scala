package org.scalablytyped.converter.internal

import java.net.URI
import java.util.concurrent.CompletionException

import com.olvind.logging.Logger
import gigahorse.support.okhttp.Gigahorse
import okhttp3.{OkHttpClient, Request, Response}
import org.scalablytyped.converter.internal.ImportTypings.InOut
import org.scalablytyped.converter.internal.importer.Cmd
import org.scalablytyped.converter.internal.seqs._
import org.scalablytyped.converter.plugin.RemoteCache
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.{stDir, stRemoteCache}
import sbt.{Def, Global, Task, TaskKey}
import software.amazon.awssdk.services.s3.model.{
  HeadObjectRequest,
  NoSuchKeyException,
  PutObjectRequest,
  PutObjectResponse,
}
import software.amazon.awssdk.services.s3.{S3AsyncClient, S3AsyncClientBuilder}

import scala.compat.java8.FutureConverters._
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.control.NonFatal

object PluginRemoteCache {
  implicit class UriOps(uri: URI) {
    def /(relPath: os.RelPath): URI =
      new URI(uri.toString + "/" + relPath.toString())
  }

  private object Lock

  // lazy and implement this with rsync since it's exactly what we want
  def publishCacheTask(inTask: TaskKey[(os.Path, ImportTypings.Output)]): Def.Initialize[Task[Unit]] =
    Def.task(
      (Global / stRemoteCache).value match {
        case RemoteCache.Disabled =>
          ()
        case RemoteCache.Rsync(pushLocation, _) =>
          val (runCachePath, output) = inTask.value
          val logger                 = WrapSbtLogger.task.value.withContext("run", runCachePath.last)
          val cmd                    = new Cmd(logger, Some(500))
          Lock.synchronized {
            locally {
              implicit val wd = Utils.IvyLocal.value
              cmd.run("rsync", "-aR", output.allRelPaths.map(_.toString), pushLocation)
            }
            // this is somewhat convoluted. we know `wc` is a prefix of `runCachePath`, but compute `relPath`
            // in order for `rsync` to create the folder if necessary
            locally {
              implicit val wd = os.Path((Global / stDir).value)
              val relPath: os.RelPath = runCachePath.relativeTo(wd)
              cmd.run("rsync", "-aR", relPath, pushLocation)
            }
          }
          logger.warn(s"pushed to $pushLocation")

        case RemoteCache.S3(bucket, _, prefix, region, endpoint, credentialsProvider) =>
          val (runCachePath, output) = inTask.value
          val logger                 = WrapSbtLogger.task.value.withContext("run", runCachePath.last)

          val s3 = {
            implicit class RichBuilder(s3ClientBuilder: S3AsyncClientBuilder) {
              def add[T](value: Option[T], builder: S3AsyncClientBuilder => T => S3AsyncClientBuilder) =
                value.fold(s3ClientBuilder)(builder(s3ClientBuilder))
            }

            S3AsyncClient
              .builder()
              .add(region, _.region)
              .add(endpoint, _.endpointOverride)
              .add(credentialsProvider, _.credentialsProvider)
              .build()
          }

          def toKey(relPath: os.RelPath) = s"${prefix.fold("")(_ + "/")}${relPath.toString()}"

          // The heavy lifting like the actual http requests is done inside an own thread pool inside the S3 client.
          // This is just for simple mapping operations so using the global context should be fine
          import scala.concurrent.ExecutionContext.Implicits.global

          def exists(relPath: os.RelPath): Future[Boolean] =
            s3.headObject(
              HeadObjectRequest
                .builder()
                .bucket(bucket)
                .key(toKey(relPath))
                .build(),
            ).toScala
              .map(_ => true)
              .recover {
                case e: CompletionException if e.getCause.isInstanceOf[NoSuchKeyException] =>
                  false
              }

          def upload(relPath: os.RelPath, relativeTo: os.Path): Future[PutObjectResponse] =
            s3.putObject(
              PutObjectRequest
                .builder()
                .bucket(bucket)
                .key(toKey(relPath))
                .acl("public-read")
                .build(),
              (relativeTo / relPath).toNIO,
            ).toScala

          Lock.synchronized {
            val allRelPaths = output.allRelPaths
            val eventualUploadedArtifacts: Future[Int] =
              for {
                cacheStatus <- Future.sequence(allRelPaths.map(relPath => exists(relPath).map(relPath -> _)))
                relPathsToUpload = cacheStatus.collect { case (relPath, false) => relPath }
                uploadResults <- Future.sequence(relPathsToUpload.map(upload(_, Utils.IvyLocal.value)))
              } yield uploadResults.length

            val numUploadedArtifacts = Await.result(eventualUploadedArtifacts, Duration.Inf)

            val relRunCachePath = runCachePath.relativeTo(os.Path((Global / stDir).value))
            Await.result(upload(relRunCachePath, os.Path((Global / stDir).value)), Duration.Inf)

            logger.warn(s"Pushed $numUploadedArtifacts files to S3 bucket $bucket")
            numUploadedArtifacts
          }
      },
    )

  def fetch(
      remoteCache: RemoteCache,
      runCacheKey: RunCacheKey,
      cacheDir:    os.Path,
      ivyLocal:    os.Path,
      logger:      Logger[Unit],
      ec:          ExecutionContext,
  ): Int = {
    def pull(pullUri: URI) = {
      val localRunFile = runCacheKey.path(cacheDir)
      if (files.exists(localRunFile)) 0
      else
        Lock.synchronized {
          implicit val ec_ = ec

          val remoteRunFile: URI = pullUri / localRunFile.relativeTo(cacheDir)
          val loggerRemoteFile = logger.withContext(remoteRunFile)

          val downloads: Future[Int] =
            mehttp.download(remoteRunFile, localRunFile).flatMap {
              case Ok(bytes) =>
                val (_, output) = Json.force[InOut](new String(bytes, constants.Utf8))

                val downloads: Seq[Future[Res[Array[Byte]]]] =
                  output.allRelPaths.flatMap { relPath =>
                    val localPath = ivyLocal / relPath
                    if (files.exists(localPath)) None
                    else Option(mehttp.download(pullUri / relPath, localPath))
                  }

                Future.sequence(downloads).map { results =>
                  val (errors, notFounds, oks, Nil) = results.partitionCollect3(
                    { case x: Err => x },
                    { case NotFound => NotFound; case Forbidden => Forbidden },
                    { case Ok(b) =>
                      b
                    },
                  )

                  val numCached = output.allRelPaths.size - results.size

                  val msgs = IArray.fromOptions(
                    if (numCached == 0) None else Some(s"$numCached cached files"),
                    if (oks.nonEmpty) Some(s"${oks.size} files downloaded") else None,
                    if (notFounds.nonEmpty) Some(s"${notFounds.size} files not found") else None,
                    if (errors.nonEmpty) Some(s"${errors.size} files failed to download") else None,
                  )

                  logger.withContext(runCacheKey).warn(msgs.mkString(", "))

                  oks.size
                }

              case NotFound =>
                loggerRemoteFile.warn("No cached run")
                Future.successful(0)
              case Forbidden =>
                loggerRemoteFile.warn("Probably no cached run (403)")
                Future.successful(0)
              case Err(th) =>
                loggerRemoteFile.warn("Couldn't fetch cache", th)
                Future.successful(0)
            }

          Await.result(downloads, Duration.Inf)
        }
    }

    remoteCache match {
      case RemoteCache.Disabled                   => 0
      case RemoteCache.S3(_, pullUri, _, _, _, _) => pull(pullUri)
      case RemoteCache.Rsync(_, pullUri)          => pull(pullUri)
    }
  }

  sealed trait Res[+T]
  case class Err(th: Throwable) extends Res[Nothing]
  case object NotFound extends Res[Nothing]
  case object Forbidden extends Res[Nothing]
  case class Ok[T](value: T) extends Res[T]

  // Meh, I have no idea
  //
  // The combination of futures, execution contexts, gigahorse, okhttp is broken and starts failing requests east and west
  // on any parallelism, like this:
  // java.util.concurrent.RejectedExecutionException: Task okhttp3.RealCall$AsyncCall@6495a32c rejected from java.util.concurrent.ThreadPoolExecutor@6acf64c2[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 1]
  //
  // This here duplicates just enough working code from sbt and adapts it so things at least work.
  // Also I've tried to not take any more dependencies on third party code into the sbt giga classloader,
  //  as conflicts are more or less guaranteed.
  object mehttp {

    private lazy val http: OkHttpClient =
      Gigahorse
        .http(gigahorse.Config().withReadTimeout(60.minutes))
        .underlying[OkHttpClient]
        .newBuilder()
        .authenticator(new sbt.internal.librarymanagement.JavaNetAuthenticator)
        .followRedirects(true)
        .followSslRedirects(true)
        .build

    def download(uri: URI, dest: os.Path)(implicit ec: ExecutionContext): Future[Res[Array[Byte]]] =
      Future {
        getUrl(uri) match {
          case Ok(bytes) =>
            files.writeBytes(dest.toNIO, bytes)
            Ok(bytes)
          case otherwise => otherwise
        }
      }

    def get(url: URI)(implicit ec: ExecutionContext): Future[Res[Array[Byte]]] =
      Future(getUrl(url))

    private def getUrl(uri: URI): Res[Array[Byte]] = {
      var response: Response = null
      try {
        response = http.newCall(new Request.Builder().url(uri.toString).get().build()).execute()
        response.code() match {
          case success if success > 199 && success < 300 => Ok(response.body().bytes())
          case 404                                       => NotFound
          case 403                                       => Forbidden
          case other                                     => Err(new RuntimeException(s"Got status code $other"))
        }
      } catch {
        case NonFatal(th) => Err(th)
      } finally if (response != null) response.close()
    }
  }
}
