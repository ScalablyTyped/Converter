package com.olvind.tso
package importer
package build

import java.io.IOException

import ammonite.ops.{Path, RelPath}
import bintry.Client
import com.ning.http.client.filter.{FilterContext, ResponseFilter}
import dispatch.{FunctionHandler, Http}

import scala.concurrent.{ExecutionContext, Future}

class BinTrayPublisher(user: String, password: String, repoName: String)(implicit ec: ExecutionContext) {
  private lazy val http =
    new Http()
      .configure(
        _.addResponseFilter(new ResponseFilter {
          override def filter[T](ctx: FilterContext[T]): FilterContext[T] = {
            System.err.println(ctx.getRequest.getUri)
            Option(ctx.getResponseStatus).foreach(s => System.err.println(s.getStatusCode))
            ctx
          }
        })
      )

  private lazy val client = Client(user, password, http)
  private lazy val repo   = client.repo(user, repoName)

  object Handle {
    val asStatusAndBody = new FunctionHandler(r => (r.getStatusCode, r.getResponseBody))
    val asCreated       = new FunctionHandler(_.getStatusCode == 201)
    val asFound         = new FunctionHandler(_.getStatusCode != 404)
  }

  def close(): Unit = http.shutdown()

  private def ensurePackage(packageName: String,
                            desc:        String,
                            vcs:         String,
                            lics:        Seq[String],
                            labels:      Seq[String]): Future[repo.Package] = {

    val foundOrCreated: Future[Boolean] =
      repo.get(packageName)(Handle.asFound).flatMap {
        case true => Future.successful(true)
        case false =>
          repo
            .createPackage(packageName)
            .desc(desc)
            .vcs(vcs)
            .licenses(lics: _*)
            .labels(labels: _*)(Handle.asCreated)
      }

    foundOrCreated.map {
      case true => repo.get(packageName)
      case false =>
        sys.error(s"was not able to find or create a package for $user in $repoName named $packageName")
    }
  }
  object Existed

  def checkVersion(pkg: repo.Package, version: String): Future[Either[Existed.type, pkg.Version]] =
    pkg
      .version(version)(Handle.asFound)
      .flatMap {
        case true => Future.successful(Left(Existed))
        case false =>
          pkg.createVersion(version)(Handle.asCreated).map {
            case true => Right(pkg.version(version))
            case false =>
              sys.error(
                s"was not able to find or create version $version for $user in $repoName for package ${pkg.name}"
              )
          }
      }

  def retry[T](n: Int)(thunk: => Future[T]): Future[T] =
    thunk.recoverWith {
      case _: IOException if n > 0 => retry(n - 1)(thunk)
    }

  def publish(p: SbtProject, layout: Layout[RelPath, Path]): Future[Iterable[(Int, String)]] = {
    def uploadFiles(pkg: repo.Package): Iterable[Future[(Int, String)]] =
      layout.all.map {
        case (relPath, src) =>
          retry(2)(pkg.mvnUpload(relPath.toString(), src.toIO).publish(true)(Handle.asStatusAndBody))
      }

    def uploadIfNotExisting(pkg: repo.Package,
                            ev:  Either[Existed.type, repo.Package#Version]): Future[List[(Int, String)]] =
      ev match {
        case Left(Existed) => Future.successful(Nil)
        case Right(v) =>
          for {
            uploaded <- Future.sequence(uploadFiles(pkg))
            published <- retry(2)(v.publish(Handle.asStatusAndBody))
          } yield uploaded.toList :+ published
      }

    for {
      pkg <- ensurePackage(p.name, p.name, constants.ScalablyTypedRepoPublic, Seq("MIT"), Nil)
      ev <- checkVersion(pkg, p.version)
      published <- uploadIfNotExisting(pkg, ev)
    } yield published
  }
}
