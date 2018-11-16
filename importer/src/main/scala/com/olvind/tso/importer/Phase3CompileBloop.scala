package com.olvind.tso
package importer

import java.time.ZonedDateTime

import ammonite.ops._
import bloop.Compiler
import bloop.io.AbsolutePath
import com.olvind.logging.{Formatter, LogLevel, Logger}
import com.olvind.tso.importer.build._
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs._
import fansi.Back
import xsbti.Severity

object Phase3CompileBloop {
  //todo: formalize a bit
  def fromName(name: Name): String =
    name.unescaped.replaceAll("\\.", "_dot_")
}

class Phase3CompileBloop(versions:        Versions,
                         bloopFactory:    BloopFactory,
                         targetFolder:    Path,
                         mainPackageName: Name,
                         projectName:     String,
                         organization:    String,
                         publishFolder:   Path)
    extends Phase[TsSource, LibScalaJs[TsSource], PublishedSbtProject] {

  private val bloop = bloopFactory.forVersion(versions)

  val ScalaFiles: PartialFunction[(RelPath, Array[Byte]), Array[Byte]] = {
    case (path, value) if path.segments.last.endsWith(".scala") || path.segments.last.endsWith(".sbt") =>
      value
  }

  implicit val PathFormatter: Formatter[Path] = _.toString

  override def apply(source:  TsSource,
                     lib:     LibScalaJs[TsSource],
                     getDeps: GetDeps[TsSource, PublishedSbtProject],
                     v4:      IsCircular,
                     logger:  Logger[Unit]): PhaseRes[TsSource, PublishedSbtProject] =
    //
    getDeps(lib.dependencies map (_.source)) flatMap { deps: Map[TsSource, PublishedSbtProject] =>
      val name       = Phase3CompileBloop.fromName(lib.libName)
      val scalaFiles = Printer(lib, mainPackageName)
      val sbtLayout = ContentSbtProject(
        v            = versions,
        comments     = lib.packageSymbol.comments,
        organization = organization,
        name         = name,
        version      = VersionHack.TemplateValue,
        deps         = deps.values.to[Seq],
        scalaFiles   = scalaFiles,
        projectName  = projectName
      )
      val finalVersion          = lib.libVersion.version(Digest.of(sbtLayout.all collect ScalaFiles))
      val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)
      val compilerPaths         = CompilerPaths.of(versions, targetFolder, name)
      val written               = files.sync(allFilesProperVersion.all, compilerPaths.baseDir)
      val sbtProject            = SbtProject(name, organization, versions.sjs(name), finalVersion)(written, deps)

      val existing: IvyLayout[Path, Synced] =
        IvyLayout[Synced](sbtProject, Synced.Unchanged, Synced.Unchanged, Synced.Unchanged, Synced.Unchanged)
          .mapFiles(publishFolder / _)

      if (existing.all.keys forall exists) {
        logger warn s"Using cached build of ${sbtProject.name}"
        PhaseRes.Ok(PublishedSbtProject(sbtProject)(existing, None))
      } else {

        val localClassPath: Seq[AbsolutePath] =
          deps.values.to[Seq] map { x =>
            x.localIvyFiles.all
              .collectFirst {
                case (path, _) if path.name.endsWith(".jar") && !path.name.contains("sources") =>
                  AbsolutePath(path.toIO)
              }
              .getOrElse(logger.fatal(s"Couldn't resolve jar for ${x.project.name} ${x.localIvyFiles}"))
          }

        rm(compilerPaths.classesDir)

        val ret: PhaseRes[TsSource, PublishedSbtProject] =
          bloop.compileLib(compilerPaths, localClassPath) match {
            case Compiler.Result.Success(_, _, elapsed) =>
              logger warn s"Built ${sbtProject.name} in $elapsed ms"

              val relativeLayout: IvyLayout[RelPath, Array[Byte]] =
                build.ContentForPublish(versions, compilerPaths, sbtProject, ZonedDateTime.now(), allFilesProperVersion)

              val writtenIvyFiles: IvyLayout[Path, Synced] =
                relativeLayout
                  .mapFiles(p => publishFolder / p)
                  .mapValues(files.softWriteBytes)

              logger.info(("published local", writtenIvyFiles.all.keys))

              PhaseRes.Ok(PublishedSbtProject(sbtProject)(writtenIvyFiles, None))

            case Compiler.Result.Failed(problems, _) =>
              problems foreach { p =>
                val logLevel: LogLevel = p.severity match {
                  case Severity.Info  => LogLevel.info
                  case Severity.Warn  => LogLevel.warn
                  case Severity.Error => LogLevel.error
                }

                implicit val line = sourcecode.Line(p.position.line().orElse(-1))
                implicit val file = sourcecode.File(p.position.sourcePath.orElse("unknown file"))
                logger(logLevel, (p.message, Back.LightGray(p.position.lineContent)))
              }
              PhaseRes.Failure(Map(source -> Right(s"Compilation failed")))

            case other => logger.fatal(other.toString)
          }

        rm(compilerPaths.classesDir)

        ret
      }
    }
}
