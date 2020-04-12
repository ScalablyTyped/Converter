package org.scalablytyped.converter.internal
package importer
package build

import java.net.URI
import java.nio.file.{Files, Path}
import java.util.concurrent.TimeUnit

import bintry.Client
import com.ning.http.client._
import com.ning.http.client.listenable.AbstractListenableFuture
import dispatch.{FunctionHandler, Http, StatusCode}
import gigahorse.Status
import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.scalajs.Dep
import org.scalablytyped.converter.internal.stringUtils.quote

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try
import scala.util.control.NonFatal

class BinTrayPublisher private (
    cachePathOpt: Option[Path],
    repoPublic:   URI,
    user:         String,
    password:     String,
    repoName:     ProjectName,
)(
    implicit ec: ExecutionContext,
) extends Publisher {

  override val sbtPublishTo = s"bintrayRepository := ${quote(repoName.value)}"
  override val sbtResolver  = s"Resolver.bintrayRepo(${quote(user)}, ${quote(repoName.value)})"
  override val sbtPlugin    = BinTrayPublisher.sbtPlugin

  private def builder =
    new AsyncHttpClientConfig.Builder()
      .setRequestTimeout(-1)

  private lazy val http = cachePathOpt match {
    case Some(cachePath) => new Http(Caching.Client(cachePath, builder.build()))
    case None            => new Http(new AsyncHttpClient(builder.build()))
  }

  private lazy val client = Client(user, password, http)
  private lazy val repo   = client.repo(user, repoName.value)

  object Handle {
    val createOrConflictUncached = new FunctionHandler({
      case res if res.getStatusCode === Status.CONFLICT => false
      case res if res.getStatusCode === Status.CREATED  => true
      case res if res.getStatusCode === Status.OK       => true
      case failed                                       => throw StatusCode(failed.getStatusCode)
    })

    val createOrConflict: AsyncHandler[Boolean] =
      Caching.Handler(createOrConflictUncached)

    val asFound: AsyncHandler[Boolean] =
      Caching.Handler(new FunctionHandler(_.getStatusCode != 404))
  }

  def close(): Unit = http.shutdown()

  private def ensurePackage(
      packageName: String,
      desc:        String,
      vcs:         URI,
      lics:        Seq[String],
      labels:      Seq[String],
  ): Future[repo.Package] = {
    val pkgRepo = repo.get(packageName)

    pkgRepo(Handle.asFound).flatMap {
      case true => Future.successful(pkgRepo)
      case false =>
        repo
          .createPackage(packageName)
          .desc(desc)
          .vcs(vcs.toString)
          .licenses(lics: _*)
          .labels(labels: _*)
          .apply(Handle.createOrConflictUncached)
          .map(_ => pkgRepo)
    }
  }

  def ensureVersion(pkg: repo.Package, version: String): Future[pkg.Version] =
    pkg
      .createVersion(version)(Handle.createOrConflict)
      .map(_ => pkg.version(version))

  def retry[T](n: Int)(thunk: => Future[T]): Future[T] =
    thunk.recoverWith {
      case NonFatal(_) if n > 0 => retry(n - 1)(thunk)
    }

  object isEnabled extends Publisher.Enabled {
    override def publish(p: SbtProject, layout: Layout[os.RelPath, os.Path]): Future[Unit] = {
      def uploadFiles(pkg: repo.Package): Iterable[Future[Boolean]] =
        layout.all.map {
          case (relPath, src) =>
            retry(2)(pkg.mvnUpload(relPath.toString(), src.toIO).exploded(true)(Handle.createOrConflict))
        }

      for {
        pkg <- retry(2)(ensurePackage(p.name, p.name, repoPublic, List("MIT"), Nil))
        v <- retry(2)(ensureVersion(pkg, p.reference.version))
        _ <- Future.sequence(uploadFiles(pkg))
        _ <- retry(2)(v.publish(Handle.createOrConflict))
      } yield ()
    }
  }
  val enabled = Some(isEnabled)
}

object BinTrayPublisher {
  val sbtPlugin: Dep = Dep.Java("org.foundweekends", "sbt-bintray", "0.5.4")

  val bintrayCredentialsFile = os.home / ".bintray" / ".credentials"

  object Dummy extends Publisher {
    val repoName              = "ScalablyTyped"
    override val sbtPublishTo = s"bintrayRepository := ${quote(repoName)}"
    override val sbtResolver  = s"Resolver.bintrayRepo(${quote("oyvindberg")}, ${quote(repoName)})"
    override val sbtPlugin    = BinTrayPublisher.sbtPlugin
    override val enabled      = None
  }

  def apply(
      cachePathOpt:   Option[Path],
      bintryRepoName: ProjectName,
      repoPublicOpt:  Option[URI],
      ec:             ExecutionContext,
  ): Either[String, BinTrayPublisher] = {
    def values(content: String): Map[String, String] =
      content
        .split("\n")
        .map(_.split("=").map(_.trim).filter(_.nonEmpty).toList)
        .collect { case List(k, v) => (k, v) }
        .toMap

    for {
      repoPublic <- repoPublicOpt.toRight(
        "Must supply a public git repository url since published artifacts must be open source",
      )
      file <- Option(bintrayCredentialsFile).filter(files.exists).toRight(s"$bintrayCredentialsFile doesnt exist")
      content <- Try(files.content(InFile(file))).toEither.left.map(th => s"Couldn't read $file: ${th.getMessage}")
      map = values(content)
      user <- map.get("user").toRight(s"""didnt find a line with `user=...` in $file""")
      password <- map.get("password").toRight(s"""didnt find a line with `password=...` in $file""")
    } yield new BinTrayPublisher(cachePathOpt, repoPublic, user, password, bintryRepoName)(ec)
  }
}

/**
  * Yeah, I know. There are better ways. there must be.
  * This, however, was very easy
  */
private object Caching {
  def pathFor(cachePath: Path, request: Request): Path =
    cachePath.resolve(s"/${request.getUrl}/${request.getMethod}.json")

  final case class Handler[T](underlying: AsyncHandler[T])(implicit val encoder: Encoder[T], val decoder: Decoder[T])
      extends WrappedHandler[T](underlying)

  final case class Client(cachePath: Path, config: AsyncHttpClientConfig) extends AsyncHttpClient(config) {
    override def executeRequest[T](request: Request, handler: AsyncHandler[T]): ListenableFuture[T] =
      handler match {
        case x: Handler[T] =>
          val file = pathFor(cachePath, request)
          Json.opt[T](file)(x.decoder) match {
            case None =>
              object StoringHandler extends WrappedHandler[T](handler) {
                override def onCompleted(): T = {
                  val ret = super.onCompleted()
                  Files.createDirectories(file.getParent)
                  Json.persist(file)(ret)(x.encoder)
                  ret
                }
              }

              super.executeRequest(request, StoringHandler)
            case Some(value) =>
              Completed(value)
          }

        case other => super.executeRequest(request, other)
      }
  }

  abstract class WrappedHandler[T](underlying: AsyncHandler[T]) extends AsyncHandler[T] {
    override def onThrowable(t: Throwable): Unit =
      underlying.onThrowable(t)
    override def onBodyPartReceived(bodyPart: HttpResponseBodyPart): AsyncHandler.STATE =
      underlying.onBodyPartReceived(bodyPart)
    override def onStatusReceived(responseStatus: HttpResponseStatus): AsyncHandler.STATE =
      underlying.onStatusReceived(responseStatus)
    override def onHeadersReceived(headers: HttpResponseHeaders): AsyncHandler.STATE =
      underlying.onHeadersReceived(headers)
    override def onCompleted(): T = underlying.onCompleted()
  }

  final case class Completed[T](value: T) extends AbstractListenableFuture[T] {
    override def done(): Unit = ()
    override def abort(t: Throwable): Unit = ()
    override def touch(): Unit = ()
    override def cancel(b: Boolean): Boolean = false
    override def isCancelled: Boolean = false
    override def isDone:      Boolean = true
    override def get():       T       = value
    override def get(l: Long, timeUnit: TimeUnit): T = value
    runListeners()
  }
}
