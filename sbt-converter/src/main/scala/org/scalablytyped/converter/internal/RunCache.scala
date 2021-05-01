package org.scalablytyped.converter.internal

import java.net.URI
import java.util.concurrent.CompletionException

import _root_.io.circe013.syntax._
import com.olvind.logging.{Formatter, Logger}
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

object RunCache {
  case class Key(input: ImportTypings.Input) {
    lazy val digest: Digest = Digest.of(List(input.asJson.noSpaces))
    def path(cacheDir: os.Path): os.Path = cacheDir / "runs" / s"${digest.hexString}.json"
  }

  object Key {
    implicit val formatter: Formatter[Key] =
      _.digest.hexString
  }

  sealed trait Present
  object Present {
    case class Yes(output: ImportTypings.Output) extends Present
    case object No extends Present
  }

  private implicit class UriOps(uri: URI) {
    def /(relPath: os.RelPath): URI =
      new URI(uri.toString + "/" + relPath.toString())
  }

  private object Lock

  // lazy and implement this with rsync since it's exactly what we want
  def publishCacheTask(inTask: TaskKey[ImportTypings.InOut]): Def.Initialize[Task[Unit]] =
    Def.task(
      (Global / stRemoteCache).value match {
        case RemoteCache.Disabled =>
          ()
        case RemoteCache.Rsync(pushLocation, _) =>
          val (input, output) = inTask.value
          val key             = Key(input)
          val runCachePath    = key.path(os.Path((Global / stDir).value))
          val logger          = WrapSbtLogger.task.value.withContext("run", key)
          val cmd             = new Cmd(logger, Some(500))
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
          logger.info(s"pushed to $pushLocation")

        case RemoteCache.S3(bucket, _, prefix, region, endpoint, credentialsProvider) =>
          val (input, output) = inTask.value
          val key             = Key(input)
          val runCachePath    = key.path(os.Path((Global / stDir).value))
          val logger          = WrapSbtLogger.task.value.withContext("run", key)

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
              )
              .toScala
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
              )
              .toScala

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

            logger.info(s"Pushed $numUploadedArtifacts files to S3 bucket $bucket")
          }
      },
    )

  def fetch(
      remoteCache: RemoteCache,
      key:         Key,
      cacheDir:    os.Path,
      ivyLocal:    os.Path,
      logger:      Logger[Unit],
  )(implicit ec:   ExecutionContext): Present = {
    val localRunFile     = key.path(cacheDir)
    val loggerRemoteFile = logger.withContext(localRunFile.toString)

    def pull(pullUri: URI) =
      Lock.synchronized {
        val downloads: Future[Present] =
          mehttp.ensureDownloaded(pullUri / localRunFile.relativeTo(cacheDir), localRunFile).flatMap {
            case yes: PresentFile.Yes =>
              val (input, output) = Json.force[InOut](new String(yes.bytes, constants.Utf8))

              require(input === key.input)

              val files: Seq[Future[PresentFile]] =
                output.allRelPaths
                  .map(relPath => mehttp.ensureDownloaded(uri = pullUri / relPath, dest = ivyLocal / relPath))

              Future.sequence(files).map { presentFiles: Seq[PresentFile] =>
                // format: off
                val (errors, notFounds, cacheds, downloadeds, Nil) =
                  presentFiles.partitionCollect4(
                    { case x: PresentFile.Err => x },
                    {
                      case PresentFile.NotFound  => PresentFile.NotFound
                      case PresentFile.Forbidden => PresentFile.Forbidden
                    },
                    { case cached @ PresentFile.Cached(_) => cached },
                    { case ok @ PresentFile.Downloaded(_) => ok },
                  )
                // format: on

                val msgs = IArray.fromOptions(
                  if (cacheds.nonEmpty) Some(s"${cacheds.size} cached files") else None,
                  if (downloadeds.nonEmpty) Some(s"${downloadeds.size} files downloaded") else None,
                  if (notFounds.nonEmpty) Some(s"${notFounds.size} files not found") else None,
                  if (errors.nonEmpty) Some(s"${errors.size} files failed to download") else None,
                )

                if (yes.wasCached && presentFiles.size == cacheds.size)
                  loggerRemoteFile.debug("Using cached result :")
                else
                  loggerRemoteFile.info(msgs.mkString(", "))

                if (notFounds.size + errors.size == 0) Present.Yes(output) else Present.No
              }

            case PresentFile.NotFound =>
              loggerRemoteFile.info("No cached run")
              Future.successful(Present.No)
            case PresentFile.Forbidden =>
              loggerRemoteFile.info("Probably no cached run (403)")
              Future.successful(Present.No)
            case PresentFile.Err(th) =>
              loggerRemoteFile.warn("Couldn't fetch cache", th)
              Future.successful(Present.No)
          }

        Await.result(downloads, Duration.Inf)
      }

    remoteCache match {
      case RemoteCache.Disabled =>
        if (files.exists(localRunFile)) {
          val (input, output) = Json.force[InOut](new String(os.read.bytes(localRunFile), constants.Utf8))
          require(input === key.input)
          if (output.allRelPaths.forall(relPath => files.exists(ivyLocal / relPath))) {
            loggerRemoteFile.debug("Using cached result :")
            Present.Yes(output)
          } else Present.No
        } else Present.No
      case RemoteCache.S3(_, pullUri, _, _, _, _) => pull(pullUri)
      case RemoteCache.Rsync(_, pullUri)          => pull(pullUri)
    }
  }

  sealed trait PresentFile
  object PresentFile {
    case class Err(th: Throwable) extends PresentFile
    case object NotFound extends PresentFile
    case object Forbidden extends PresentFile

    sealed trait Yes extends PresentFile {
      def bytes:     Array[Byte]
      def wasCached: Boolean
    }

    case class Downloaded(bytes: Array[Byte]) extends Yes {
      override def wasCached: Boolean = false
    }
    case class Cached[T](file: os.Path) extends Yes {
      def bytes:              Array[Byte] = os.read.bytes(file)
      override def wasCached: Boolean     = true
    }
  }

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

    def ensureDownloaded(uri: URI, dest: os.Path)(implicit ec: ExecutionContext): Future[PresentFile] =
      if (files.exists(dest)) Future.successful(PresentFile.Cached(dest))
      else
        Future {
          getUrl(uri) match {
            case ok @ PresentFile.Downloaded(bytes) =>
              files.writeBytes(dest.toNIO, bytes)
              ok
            case otherwise => otherwise
          }
        }

    private def getUrl(uri: URI): PresentFile = {
      var response: Response = null
      try {
        response = http.newCall(new Request.Builder().url(uri.toString).get().build()).execute()
        response.code() match {
          case success if success > 199 && success < 300 => PresentFile.Downloaded(response.body().bytes())
          case 404                                       => PresentFile.NotFound
          case 403                                       => PresentFile.Forbidden
          case other                                     => PresentFile.Err(new RuntimeException(s"Got status code $other"))
        }
      } catch {
        case NonFatal(th) => PresentFile.Err(th)
      } finally {
        if (response != null) response.close()
      }
    }
  }
}
