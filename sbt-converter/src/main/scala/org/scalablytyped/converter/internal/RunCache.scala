package org.scalablytyped.converter.internal

import _root_.io.circe013.syntax.*
import com.olvind.logging.{Formatter, Logger}
import gigahorse.support.apachehttp.Gigahorse
import gigahorse.{HttpClient, Request}
import org.scalablytyped.converter.internal.ImportTypings.InOut
import org.scalablytyped.converter.internal.compat.CompletableFutureOps
import org.scalablytyped.converter.internal.importer.Cmd
import org.scalablytyped.converter.internal.seqs.*
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

import java.net.URI
import java.util.concurrent.CompletionException
import scala.concurrent.duration.*
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

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
          ensureDownloaded(pullUri / localRunFile.relativeTo(cacheDir), localRunFile).flatMap {
            case yes: PresentFile.Yes =>
              val (input, output) = Json.force[InOut](new String(yes.bytes, constants.Utf8))

              require(input === key.input)

              val files: Seq[Future[PresentFile]] =
                output.allRelPaths
                  .map(relPath => ensureDownloaded(uri = pullUri / relPath, dest = ivyLocal / relPath))

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

  private lazy val http: HttpClient =
    Gigahorse
      .http(gigahorse.Config().withReadTimeout(60.minutes).withFollowRedirects(true))

  def ensureDownloaded(uri: URI, dest: os.Path)(implicit ec: ExecutionContext): Future[PresentFile] =
    if (files.exists(dest)) Future.successful(PresentFile.Cached(dest))
    else
      getUrl(uri).map {
        case ok @ PresentFile.Downloaded(bytes) =>
          files.writeBytes(dest.toNIO, bytes)
          ok
        case otherwise => otherwise
      }

  private def getUrl(uri: URI)(implicit ec: ExecutionContext): Future[PresentFile] =
    http.run(Request(uri.toString)).transform {
      case Success(response) => Success(PresentFile.Downloaded(response.bodyAsByteBuffer.array()))
      case Failure(x: gigahorse.StatusError) if x.status == 404 => Success(PresentFile.NotFound)
      case Failure(x: gigahorse.StatusError) if x.status == 403 => Success(PresentFile.Forbidden)
      case Failure(th) => Success(PresentFile.Err(th))
    }
}
