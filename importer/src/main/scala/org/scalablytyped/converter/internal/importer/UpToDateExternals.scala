package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import gigahorse.support.okhttp.Gigahorse
import gigahorse.{HttpClient, Request}
import io.circe013.Decoder
import io.circe013.generic.semiauto.deriveDecoder
import io.circe013.syntax.EncoderOps
import org.scalablytyped.converter.internal.ts.{PackageJson, TsIdentLibrary}

import java.util.concurrent.Executors
import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object UpToDateExternals {
  class NpmClient(client: HttpClient) {
    def getVersions(lib: TsIdentLibrary)(implicit ec: ExecutionContext): Future[Either[Throwable, NpmPackageVersions]] =
      client
        .run(Request(s"https://registry.npmjs.org/${lib.value}"))
        .map(res => res.bodyAsString)
        .transformWith {
          case Failure(exception) => Future.successful(Left(exception))
          case Success(string) =>
            Json[NpmPackageVersions](string) match {
              case Left(err)    => Future.successful(Left(new RuntimeException(s"couldn't parse body: $string", err)))
              case Right(value) => Future.successful(Right(value))
            }
        }

    def download(dist: PackageJson.Dist, to: os.Path)(
        implicit ec:   ExecutionContext,
    ): Future[Either[Throwable, os.Path]] =
      client
        .download(Request(dist.tarball), to.toIO)
        .map(res => os.Path(res))
        .transformWith(tried => Future.successful(tried.toEither))
  }

  object NpmClient {
    def apply(config: gigahorse.Config): NpmClient =
      new NpmClient(Gigahorse.http(config))
  }

  case class NpmPackageVersions(
      name:        String,
      `dist-tags`: Map[String, String],
      versions:    Map[String, PackageJson],
  ) {
    def latestVersion: Option[String] =
      `dist-tags`.get("latest").orElse {
        versions.toList.sortBy { case (v, _) => v }.reverse.headOption.map { case (v, _) => v }
      }
  }

  object NpmPackageVersions {
    implicit val decodes: Decoder[NpmPackageVersions] = deriveDecoder
  }

  def apply(
      logger:                Logger[_],
      cmd:                   Cmd,
      folder:                os.Path,
      ensurePresentPackages: Set[TsIdentLibrary],
      conserveSpace:         Boolean,
      offline:               Boolean,
  ): InFolder = {

    val packageJsonPath     = folder / "package.json"
    val nodeModulesPath     = folder / "node_modules"
    val existingPackageJson = Json.opt[PackageJson](packageJsonPath)

    // if offline mode we only install what's missing. dont care that other libs may be outdated
    val targets =
      if (offline) {
        val alreadyAdded     = existingPackageJson.flatMap(_.dependencies).getOrElse(Map.empty)
        val missingExternals = ensurePresentPackages -- alreadyAdded.keySet
        if (missingExternals.isEmpty) logger.warn(s"All external libraries present in $nodeModulesPath")
        else logger.warn(s"Adding ${missingExternals.size} missing libraries to $nodeModulesPath")
        missingExternals
      } else {
        logger.warn(s"Updating libraries in $nodeModulesPath")
        ensurePresentPackages
      }

    val npmClient = NpmClient(
      Gigahorse.config.withMaxRequestRetry(3),
    )
    implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newCachedThreadPool())

    val isStarted = mutable.Set[TsIdentLibrary]()
    def shouldSkip(lib: TsIdentLibrary) =
      synchronized {
        if (isStarted.contains(lib)) true
        else {
          isStarted.add(lib)
          false
        }
      }

    targets.grouped(100).foldLeft(existingPackageJson.getOrElse(PackageJson.Empty)) {
      case (packageJson, targets) =>
        val alreadyAdded = packageJson.dependencies.getOrElse(Map.empty)
        val results = Await.result(
          downloadAll(cmd, nodeModulesPath, logger, npmClient, targets, alreadyAdded, shouldSkip),
          Duration.Inf,
        )
        val newInstalled    = results.collect { case x: Completed => x.lib -> x.version }.toMap
        val newDependencies = alreadyAdded ++ newInstalled
        val newPackageJson  = packageJson.copy(dependencies = Some(newDependencies))

        files.writeBytes(packageJsonPath.toNIO, newPackageJson.asJson.spaces2.getBytes)
        logger
          .withContext("numLibraries", newDependencies.size)
          .withContext("newLibraries", newInstalled.size)
          .warn("Flushing package.json to disk.")
        newPackageJson

    }

    if (conserveSpace && files.exists(folder)) {
      /* only keep some files within npm folder*/
      val KeepExtensions = Set("json", "ts", "lock")

      logger.warn(s"Trimming $nodeModulesPath")

      os.walk.stream(folder).foreach {
        case link if os.isLink(link)                              => files.deleteAll(link)
        case file if os.isFile(file) && !KeepExtensions(file.ext) => files.deleteAll(file)
        case dir if os.isDir(dir) && dir.last === ".git"          => files.deleteAll(dir)
        case _                                                    => ()
      }
    }

    InFolder(nodeModulesPath)
  }

  sealed trait Result
  case class Completed(lib: TsIdentLibrary, version: String) extends Result
  case class Failed(lib:    TsIdentLibrary) extends Result

  def downloadAll(
      cmd:         Cmd,
      nodeModules: os.Path,
      logger:      Logger[_],
      npmClient:   NpmClient,
      libs:        Set[TsIdentLibrary],
      installed:   Map[TsIdentLibrary, String],
      shouldSkip:  TsIdentLibrary => Boolean,
  )(implicit ec:   ExecutionContext): Future[List[Result]] = {
    def ensureDownloaded(path: List[TsIdentLibrary], lib: TsIdentLibrary): Future[List[Result]] = {
      val skip = shouldSkip(lib)

      val libLogger = logger
        .withContext("lib", lib.value)
        .withContext("via", path.map(_.value).reverse.mkString(" -> "))

      if (skip) Future.successful(Nil)
      else {
        npmClient.getVersions(lib).flatMap {
          case Left(th) =>
            libLogger.warn("Couldn't download", th)
            Future.successful(List(Failed(lib)))

          case Right(versions) =>
            libLogger.info(s"fetched metadata")
            versions.latestVersion match {
              case Some(latestVersion) if installed.get(lib).contains(latestVersion) =>
                Future.successful(List(Completed(lib, latestVersion)))

              case Some(latestVersion) =>
                versions.versions.get(latestVersion) match {
                  case Some(latestPackageJson) =>
                    val versionLogger = libLogger.withContext(latestVersion)
                    val download: Future[List[Result]] =
                      latestPackageJson.dist match {
                        case Some(dist) =>
                          versionLogger.info(s"downloading")
                          val tempDir = os.temp.dir()

                          npmClient.download(dist, (tempDir / "package.tar.gz")).map {
                            case Left(th) =>
                              versionLogger.warn("Couldn't download", th)
                              List(Failed(lib))
                            case Right(tempTarball) =>
                              Try {
                                val destination = nodeModules / os.RelPath(lib.value)
                                cmd.run("tar", "zxvf", tempTarball)(tempDir)
                                if (os.exists(destination)) os.remove.all(destination)
                                os.makeDir.all(destination / os.up)
                                // `package` subdirectory is from the downloaded tarball
                                val extractedDir = os.list(tempDir).filter(os.isDir).head
                                os.move(from = extractedDir, to = destination)
                                os.remove.all(tempDir)
                              } match {
                                case Failure(th) =>
                                  versionLogger.warn("Couldn't write/extract", th)
                                  List(Failed(lib))
                                case Success(_) =>
                                  versionLogger.warn("downloaded")
                                  List(Completed(lib, latestVersion))
                              }
                          }
                        case None =>
                          Future {
                            versionLogger.warn(s"Couldn't determine latest dist")
                            List(Failed(lib))
                          }
                      }

                    val downloadDependencies: List[Future[List[Result]]] =
                      latestPackageJson
                        .allLibs(dev = false, peer = true)
                        .map { case (depLib, _) => ensureDownloaded(lib :: path, depLib) }
                        .toList

                    Future.sequence(List(download) ++ downloadDependencies).map(_.flatten)

                  case None =>
                    Future {
                      libLogger.warn(s"Couldn't determine latest version")
                      List(Failed(lib))
                    }
                }

              case None =>
                libLogger.warn("Couldn't determine latest version")
                Future.successful(List(Failed(lib)))
            }
        }
      }
    }

    Future.sequence(libs.map(lib => ensureDownloaded(Nil, lib))).map(_.toList.flatten)
  }
}
