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
import com.olvind.tso.ts._
import fansi.Back
import xsbti.Severity

object PhaseCompileBloop {
  //todo: formalize a bit
  def fromName(name: Name): String =
    name.unescaped.replaceAll("\\.", "_dot_")
}

case class PhaseCompileBloop(bloop: BloopCompiler, targetFolder: OutFolder, mainPackageName: Name, publishFolder: Path)
    extends Phase[TsSource, LibScalaJs[TsSource], PublishedSbtProject] {

  val ScalaFiles: PartialFunction[(OutRelFile, Array[Byte]), Array[Byte]] = {
    case (path, value) if path.file.segments.last.endsWith(".scala") || path.file.segments.last.endsWith(".sbt") =>
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
      val organization          = s"com.olvind.${PhaseCompileBloop.fromName(mainPackageName).toLowerCase}"
      val name                  = PhaseCompileBloop.fromName(lib.libName)
      val artifactId            = versions.sjs(name)
      val depsSeq               = deps.values.to[Seq]
      val sbtFiles              = SbtProjectStructure(lib, organization, name, VersionHack.TemplateValue, depsSeq)
      val scalaFiles            = Printer(lib, versions.sourcesDir, mainPackageName)
      val allFiles              = scalaFiles ++ sbtFiles
      val finalVersion          = lib.libVersion.version(Digest.of(allFiles.files collect ScalaFiles))
      val allFilesProperVersion = VersionHack.templateVersion(allFiles, finalVersion)
      val paths                 = ProjectPaths.of(targetFolder, name)
      val written               = files.sync(allFilesProperVersion, paths.baseDir)
      val sbtProject            = SbtProject(name, organization, artifactId, finalVersion)(written, depsSeq)
      val ivyLayout             = new Publisher.IvyLayoutFiles(sbtProject)
      val publishedFiles        = ivyLayout.all.map(rel => publishFolder / rel.file)

      if (publishedFiles forall exists) {
        logger warn s"Using cached build of ${sbtProject.name}"
        val unchanged = publishedFiles.map(x => x -> Synced.Unchanged).toMap
        PhaseRes.Ok(PublishedSbtProject(sbtProject)(unchanged))
      } else {

        val localClassPath: Seq[AbsolutePath] =
          depsSeq map { x =>
            x.written
              .collectFirst {
                case (path, _) if path.name.endsWith(".jar") && !path.name.contains("sources") =>
                  AbsolutePath(path.toIO)
              }
              .getOrElse(
                logger.fatal(s"Couldn't resolve jar for ${x.project.name} ${x.written}")
              )
          }

        rm(paths.classesDir)

        val ret: PhaseRes[TsSource, PublishedSbtProject] =
          bloop.compileLib(paths, localClassPath) match {
            case Compiler.Result.Success(_, _, elapsed) =>
              logger warn s"Built ${sbtProject.name} in $elapsed ms"

              val published = files.write(
                Publisher.ivyLayout(ivyLayout, paths, sbtProject, ZonedDateTime.now(), allFilesProperVersion),
                publishFolder
              )

              logger.info(("published", published.keys))
              PhaseRes.Ok(PublishedSbtProject(sbtProject)(published))

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

        rm(paths.classesDir)

        ret
      }
    }
}
