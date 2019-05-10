package com.olvind.tso
package importer

import java.nio.file.attribute.FileTime
import java.time.{Instant, ZonedDateTime}

import ammonite.ops._
import bloop.io.AbsolutePath
import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.importer.Phase2Res.{Facade, LibScalaJs}
import com.olvind.tso.importer.build._
import com.olvind.tso.importer.documentation.Npmjs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs._
import com.olvind.tso.sets.SetOps
import com.olvind.tso.ts.TsIdentLibrarySimple

import scala.collection.immutable.SortedSet
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Try

class Phase3Compile(
    resolve:         LibraryResolver,
    versions:        Versions,
    compiler:        BloopCompiler,
    targetFolder:    Path,
    mainPackageName: Name,
    projectName:     String,
    organization:    String,
    publishUser:     String,
    publishFolder:   Path,
    metadataFetcher: Npmjs.Fetcher,
    softWrites:      Boolean,
) extends Phase[Source, Phase2Res, PublishedSbtProject] {

  val ScalaFiles: PartialFunction[(RelPath, Array[Byte]), Array[Byte]] = {
    case (path, value) if path.ext === "scala" || path.ext === "sbt" => value
  }

  implicit val PathFormatter: Formatter[Path] = _.toString

  override def apply(
      source:  Source,
      _lib:    Phase2Res,
      getDeps: GetDeps[Source, PublishedSbtProject],
      v4:      IsCircular,
      logger:  Logger[Unit],
  ): PhaseRes[Source, PublishedSbtProject] =
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
                  Right(s"Couldn't resolve $t"),
                ),
            ),
          )

        dependencies flatMap (x => getDeps(x.sorted)) flatMap {
          case PublishedSbtProject.Unpack(deps) =>
            val sourceFilesBase: Map[RelPath, (Array[Byte], FileTime)] =
              ls.rec(source.path / 'src)
                .collect { case files.IsNormalFile(path) => path }
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
              declaredVersion = None,
            )

            go(
              logger             = logger,
              deps               = deps,
              externalDeps       = buildJson.dependencies,
              source             = source,
              name               = source.libName.value,
              sbtLayout          = sbtLayout,
              compilerPaths      = CompilerPaths(versions, source.path),
              deleteUnknownFiles = false,
              makeVersion        = digest => s"${constants.DateTimePattern.format(newestChange)}-${digest.hexString.take(6)}",
              metadataOpt        = metadataOpt,
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
              declaredVersion = Some(lib.libVersion),
            )

            go(
              logger             = logger,
              deps               = deps,
              externalDeps       = Set(),
              source             = source,
              name               = lib.libName,
              sbtLayout          = sbtLayout,
              compilerPaths      = CompilerPaths.of(versions, targetFolder, lib.libName),
              deleteUnknownFiles = true,
              makeVersion        = lib.libVersion.version,
              metadataOpt        = metadataOpt,
            )
        }
    }

  def go(
      logger:             Logger[Unit],
      deps:               Map[Source, PublishedSbtProject],
      externalDeps:       Set[FacadeJson.Dep],
      source:             Source,
      name:               String,
      sbtLayout:          SbtProjectLayout[RelPath, Array[Byte]],
      compilerPaths:      CompilerPaths,
      deleteUnknownFiles: Boolean,
      makeVersion:        Digest => String,
      metadataOpt:        Option[Npmjs.Data],
  ): PhaseRes[Source, PublishedSbtProject] = {

    val digest                = Digest.of(sbtLayout.all collect ScalaFiles)
    val finalVersion          = makeVersion(digest)
    val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)
    files.sync(allFilesProperVersion.all, compilerPaths.baseDir, deleteUnknownFiles, softWrites)

    val sbtProject =
      SbtProject(name, organization, versions.sjs(name), finalVersion)(compilerPaths.baseDir, deps, metadataOpt)

    val existing: IvyLayout[Path, Synced] =
      IvyLayout[Synced](sbtProject, Synced.Unchanged, Synced.Unchanged, Synced.Unchanged, Synced.Unchanged)
        .mapFiles(publishFolder / _)

    if (existing.all.keys forall exists) {
      logger warn s"Using cached build of ${sbtProject.name}"
      PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, existing, None))
    } else {
      {
        implicit val wd = home
        % rm ("-Rf", compilerPaths.classesDir)
      }
      mkdir(compilerPaths.classesDir)

      val jarDeps = deps.values.to[Seq] map { x =>
        x.localIvyFiles.all
          .collectFirst {
            case (path, _) if path.name.endsWith(".jar") && !path.name.contains("sources") =>
              BloopCompiler.InternalDepJar(AbsolutePath(path.toIO))
          }
          .getOrElse(logger.fatal(s"Couldn't resolve jar for ${x.project.name} ${x.localIvyFiles}"))
      }

      logger warn s"Building ${sbtProject.name}..."
      val t0 = System.currentTimeMillis()
      val ret: PhaseRes[Source, PublishedSbtProject] =
        compiler.compile(name, digest, compilerPaths, jarDeps, externalDeps) match {
          case Right(()) =>
            val elapsed = System.currentTimeMillis - t0
            logger warn s"Built ${sbtProject.name} in $elapsed ms"

            val writtenIvyFiles: IvyLayout[Path, Synced] =
              build
                .ContentForPublish(
                  versions,
                  compilerPaths,
                  sbtProject,
                  ZonedDateTime.now(),
                  allFilesProperVersion,
                  externalDeps,
                )
                .mapFiles(p => publishFolder / p)
                .mapValues(files.softWriteBytes)

            logger.info(("published local", writtenIvyFiles.all.keys))

            PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, writtenIvyFiles, None))

          case Left(err) =>
            logger.error(err)
            PhaseRes.Failure(Map(source -> Right(s"Compilation failed")))
        }

      {
        implicit val wd = home
        % rm ("-Rf", compilerPaths.targetDir)
      }

      ret
    }
  }
}
