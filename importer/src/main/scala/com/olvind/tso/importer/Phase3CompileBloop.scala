package com.olvind.tso
package importer

import java.nio.file.attribute.FileTime
import java.time.{Instant, ZonedDateTime}

import ammonite.ops._
import bloop.Compiler.Result
import bloop.io.AbsolutePath
import bloop.{Compiler, DependencyResolution}
import bloop.logging.{Logger => BloopLogger}
import com.olvind.logging.{Formatter, LogLevel, Logger}
import com.olvind.tso.importer.Phase2Res.{Facade, LibScalaJs}
import com.olvind.tso.importer.build._
import com.olvind.tso.importer.documentation.Npmjs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs._
import com.olvind.tso.sets.SetOps
import com.olvind.tso.ts.TsIdentLibrarySimple
import fansi.Back
import io.circe.parser.decode
import io.circe.{Decoder, Encoder}
import monix.eval.Task
import monix.execution.Scheduler
import xsbti.Severity

import scala.collection.immutable.SortedSet
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Try

class Phase3CompileBloop(resolve:         LibraryResolver,
                         versions:        Versions,
                         bloop:           BloopCompiler,
                         bloopLogger:     BloopLogger,
                         targetFolder:    Path,
                         mainPackageName: Name,
                         projectName:     String,
                         organization:    String,
                         publishUser:     String,
                         publishFolder:   Path,
                         scheduler:       Scheduler,
                         metadataFetcher: Npmjs.Fetcher,
                         failureCacheDir: Path)
    extends Phase[Source, Phase2Res, PublishedSbtProject] {

  val ScalaFiles: PartialFunction[(RelPath, Array[Byte]), Array[Byte]] = {
    case (path, value) if path.ext === "scala" || path.ext === "sbt" => value
  }

  implicit val PathFormatter: Formatter[Path] = _.toString

  override def apply(source:  Source,
                     _lib:    Phase2Res,
                     getDeps: GetDeps[Source, PublishedSbtProject],
                     v4:      IsCircular,
                     logger:  Logger[Unit]): PhaseRes[Source, PublishedSbtProject] =
    _lib match {
      case Facade =>
        val buildJson = Json[FacadeJson](source.path / "build.json")

        val dependencies: PhaseRes[Source, Set[Source]] =
          PhaseRes.sequenceSet(
            buildJson.typings.map(
              t =>
                PhaseRes.fromOption(
                  source,
                  resolve.global(TsIdentLibrarySimple(t)),
                  Right(s"Couldn't resolve $t")
              )
            )
          )

        dependencies flatMap (x => getDeps(x.sorted)) flatMap {
          case PublishedSbtProject.Unpack(deps) =>
            val sourceFilesBase: Map[RelPath, (Array[Byte], FileTime)] =
              ls.rec(source.path / 'src)
                .filter(_.isFile)
                .map { path =>
                  val relPath = path relativeTo source.path
                  val bytes   = files contentBytes InFile(path)
                  val mtime   = path.mtime
                  relPath -> ((bytes, mtime))
                }
                .toMap

            require(sourceFilesBase.nonEmpty, "no files found")

            val sourceFiles: Map[RelPath, Array[Byte]] =
              sourceFilesBase mapValues {
                case (bytes, _) => bytes
              }

            val newestChange: Instant =
              sourceFilesBase.foldLeft(Instant.MIN) {
                case (acc, (_, (_, time))) =>
                  val instant = time.toInstant
                  if (acc isBefore instant) instant else acc
              }

            val metadataOpt = None
            val sbtLayout = ContentSbtProject(
              v               = versions,
              comments        = NoComments,
              organization    = organization,
              name            = source.libName.value,
              version         = VersionHack.TemplateValue,
              publishUser     = publishUser,
              localDeps       = deps.values.to[Seq],
              facadeDeps      = buildJson.dependencies,
              scalaFiles      = sourceFiles,
              projectName     = projectName,
              metadataOpt     = metadataOpt,
              declaredVersion = None
            )

            go(
              logger             = logger,
              deps               = deps,
              source             = source,
              name               = source.libName.value,
              sbtLayout          = sbtLayout,
              compilerPaths      = CompilerPaths(versions, source.path),
              dependencies       = buildJson.dependencies,
              deleteUnknownFiles = false,
              makeVersion        = digest => s"${constants.DateTimePattern.format(newestChange)}-${digest.hexString.take(6)}",
              metadataOpt        = metadataOpt
            )
        }

      case lib: LibScalaJs =>
        getDeps(lib.dependencies.keys.map(x => x: Source).to[SortedSet]) flatMap {
          case PublishedSbtProject.Unpack(deps) =>
            val scalaFiles  = Printer(lib.packageTree, mainPackageName)
            val sourcesDir  = RelPath("src") / 'main / 'scala
            val metadataOpt = Try(Await.result(metadataFetcher(lib.source, logger), 2.seconds)).toOption.flatten

            val sbtLayout = ContentSbtProject(
              v               = versions,
              comments        = lib.packageTree.comments,
              organization    = organization,
              name            = lib.libName,
              version         = VersionHack.TemplateValue,
              publishUser     = publishUser,
              localDeps       = deps.values.to[Seq],
              facadeDeps      = Set(),
              scalaFiles      = scalaFiles.map { case (relPath, content) => sourcesDir / relPath -> content },
              projectName     = projectName,
              metadataOpt     = metadataOpt,
              declaredVersion = Some(lib.libVersion)
            )

            go(
              logger             = logger,
              deps               = deps,
              source             = source,
              name               = lib.libName,
              sbtLayout          = sbtLayout,
              compilerPaths      = CompilerPaths.of(versions, targetFolder, lib.libName),
              dependencies       = Set(),
              deleteUnknownFiles = true,
              makeVersion        = lib.libVersion.version,
              metadataOpt        = metadataOpt
            )
        }
    }

  def go(logger:             Logger[Unit],
         deps:               Map[Source, PublishedSbtProject],
         source:             Source,
         name:               String,
         sbtLayout:          SbtProjectLayout[RelPath, Array[Byte]],
         compilerPaths:      CompilerPaths,
         dependencies:       Set[FacadeJson.Dep],
         deleteUnknownFiles: Boolean,
         makeVersion:        Digest => String,
         metadataOpt:        Option[Npmjs.Data]): PhaseRes[Source, PublishedSbtProject] = {

    val digest                = Digest.of(sbtLayout.all collect ScalaFiles)
    val finalVersion          = makeVersion(digest)
    val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)
    val written               = files.sync(allFilesProperVersion.all, compilerPaths.baseDir, deleteUnknownFiles)

    val sbtProject = SbtProject(
      name,
      organization,
      versions.sjs(name),
      finalVersion
    )(compilerPaths.baseDir, deps, metadataOpt)

    val existing: IvyLayout[Path, Synced] =
      IvyLayout[Synced](sbtProject, Synced.Unchanged, Synced.Unchanged, Synced.Unchanged, Synced.Unchanged)
        .mapFiles(publishFolder / _)

    if (existing.all.keys forall exists) {
      logger warn s"Using cached build of ${sbtProject.name}"
      PhaseRes.Ok(PublishedSbtProject(sbtProject)(existing, None))
    } else {
      rm(compilerPaths.classesDir)
      mkdir(compilerPaths.classesDir)

      val compileWithCachedFailures = {
        val isFailure: PartialFunction[Result, Result.Failed] = {
          case x: Result.Failed
              /* protect against flaky errors */
              if !x.problems.exists(_.problem.message().contains("bad option: -P:scalajs:sjsDefinedByDefault")) && x.t.isEmpty =>
            x
        }

        val localClassPath: Seq[AbsolutePath] =
          deps.values.to[Seq] map { x =>
            x.localIvyFiles.all
              .collectFirst {
                case (path, _) if path.name.endsWith(".jar") && !path.name.contains("sources") =>
                  AbsolutePath(path.toIO)
              }
              .getOrElse(logger.fatal(s"Couldn't resolve jar for ${x.project.name} ${x.localIvyFiles}"))
          }

        val externalClasspath: Set[AbsolutePath] =
          dependencies.flatMap(
            dep =>
              DependencyResolution.resolve(dep.org, versions.sjs(dep.artifact), dep.version, bloopLogger)(scheduler)
          )

        import ResultFailedJsonCodec._

        Phase3CompileBloop.taskPartial(
          failureCacheDir / name / finalVersion,
          logger,
          bloop.compileLib(compilerPaths, localClassPath ++ externalClasspath),
          extract = isFailure
        )
      }

      val ret: Task[PhaseRes[Source, PublishedSbtProject]] =
        compileWithCachedFailures.map {
          case Compiler.Result.Success(_, _, elapsed) =>
            logger warn s"Built ${sbtProject.name} in $elapsed ms"

            val writtenIvyFiles: IvyLayout[Path, Synced] =
              build
                .ContentForPublish(versions, compilerPaths, sbtProject, ZonedDateTime.now(), allFilesProperVersion)
                .mapFiles(p => publishFolder / p)
                .mapValues(files.softWriteBytes)

            logger.info(("published local", writtenIvyFiles.all.keys))

            PhaseRes.Ok(PublishedSbtProject(sbtProject)(writtenIvyFiles, None))

          case Compiler.Result.Failed(problems, _, _) =>
            problems foreach { p =>
              val logLevel: LogLevel = p.problem.severity match {
                case Severity.Info  => LogLevel.info
                case Severity.Warn  => LogLevel.warn
                case Severity.Error => LogLevel.error
              }

              implicit val line = sourcecode.Line(p.problem.position.line().orElse(-1))
              implicit val file = sourcecode.File(p.problem.position.sourcePath.orElse("unknown file"))
              logger(logLevel, (p.problem.message, Back.LightGray(p.problem.position.lineContent)))
            }

            PhaseRes.Failure(Map(source -> Right(s"Compilation failed")))

          case other => logger.fatal(other.toString)
        }

      Await.result(
        ret
          .doOnFinish(_ => Task(rm(compilerPaths.classesDir)))
          .runAsync(scheduler),
        Duration.Inf
      )
    }
  }
}
private object Phase3CompileBloop {
  def taskPartial[K, V, VV <: V: Encoder: Decoder](cachedFile: Path,
                                                   logger:  Logger[Unit],
                                                   run:     Task[V],
                                                   extract: PartialFunction[V, VV]): Task[V] = {
    def persisted(v: V): V = {
      extract.lift(v).foreach(vv => Json.persist(cachedFile)(vv))
      v
    }
    cachedFile match {
      case files.Exists(existingFile) =>
        decode[VV](files content InFile(existingFile)) match {
          case Left(error) =>
            logger.warn(s"Couldn't decode cached file $existingFile: $error")
            run.map(persisted)
          case Right(file) => Task.pure(file)
        }

      case _ => run.map(persisted)
    }
  }

}
