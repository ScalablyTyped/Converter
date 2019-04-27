package com.olvind.tso
package importer
package build

import java.util.concurrent.TimeUnit

import ammonite.ops.{mkdir, up, Path, RelPath}
import bintry.Client
import com.ning.http.client._
import com.ning.http.client.listenable.AbstractListenableFuture
import com.olvind.tso.ts.BuildInfo
import dispatch.{FunctionHandler, Http, StatusCode}
import gigahorse.Status
import io.circe.{Decoder, Encoder}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal

case class BinTrayPublisher(cacheDir: Path, repoPublic: String, user: String, password: String, repoName: String)(
    implicit ec:                      ExecutionContext
) {

  private def builder =
    new AsyncHttpClientConfig.Builder()
      .setUserAgent(s"Tso/${BuildInfo.version}")
      .setRequestTimeout(-1)

  private lazy val http   = new Http(Caching.Client(cacheDir, builder.build()))
  private lazy val client = Client(user, password, http)
  private lazy val repo   = client.repo(user, repoName)

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

  private def ensurePackage(packageName: String,
                            desc:        String,
                            vcs:         String,
                            lics:        Seq[String],
                            labels:      Seq[String]): Future[repo.Package] = {
    val pkgRepo = repo.get(packageName)

    pkgRepo(Handle.asFound).flatMap {
      case true => Future.successful(pkgRepo)
      case false =>
        repo
          .createPackage(packageName)
          .desc(desc)
          .vcs(vcs)
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

  def publish(p: SbtProject, layout: Layout[RelPath, Path]): Future[Unit] = {
    def uploadFiles(pkg: repo.Package): Iterable[Future[Boolean]] =
      layout.all.map {
        case (relPath, src) =>
          retry(2)(pkg.mvnUpload(relPath.toString(), src.toIO).exploded(true)(Handle.createOrConflict))
      }

    for {
      pkg <- retry(2)(ensurePackage(p.name, p.name, repoPublic, Seq("MIT"), Nil))
      v <- retry(2)(ensureVersion(pkg, p.version))
      _ <- Future.sequence(uploadFiles(pkg))
      _ <- retry(2)(v.publish(Handle.createOrConflict))
    } yield ()
  }
}

/**
  * Yeah, I know. There are better ways. there must be.
  * This, however, was very easy
  */
private object Caching {
  def fileFor(cacheDir: Path, request: Request): Path =
    cacheDir / RelPath(request.getUrl) / (request.getMethod + ".json")

  final case class Handler[T](underlying: AsyncHandler[T])(implicit val encoder: Encoder[T], val decoder: Decoder[T])
      extends WrappedHandler[T](underlying)

  final case class Client(cacheDir: Path, config: AsyncHttpClientConfig) extends AsyncHttpClient(config) {
    override def executeRequest[T](request: Request, handler: AsyncHandler[T]): ListenableFuture[T] =
      handler match {
        case x: Handler[T] =>
          val file = fileFor(cacheDir, request)
          Json.opt[T](file, _ => ())(x.decoder) match {
            case None =>
              object StoringHandler extends WrappedHandler[T](handler) {
                override def onCompleted(): T = {
                  val ret = super.onCompleted()
                  mkdir(file / up)
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
