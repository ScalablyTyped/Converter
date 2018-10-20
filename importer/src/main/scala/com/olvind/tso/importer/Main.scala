package com.olvind.tso
package importer

import java.io.FileWriter
import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime}
import java.util.concurrent._

import ammonite.ops._
import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.PersistingFunction.nameAndMtimeUnder
import com.olvind.tso.importer.build.{BinTrayPublisher, BloopCompiler, GenerateSbtPlugin, PublishedSbtProject}
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.phases.{PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs._
import com.olvind.tso.ts.TsSource.StdLibSource
import com.olvind.tso.ts._
import com.olvind.tso.ts.parser.parseFile

import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.ExecutionContext
import scala.util.Try

object Main extends App {
  val debugMode    = args.nonEmpty
  val cacheFolder  = home / 'tmp / "tso-cache"
  val targetFolder = cacheFolder / Name.OutputPkg.value
  val failFolder   = targetFolder / 'failures
  val logsFolder   = cacheFolder / 'logs

  mkdir(targetFolder)
  rm(failFolder)
  mkdir(failFolder)
  mkdir(logsFolder)

  if (!exists(targetFolder / ".git")) {
    if (constants.freshRepo) {
      implicit val wd = targetFolder
      % git 'init
      val gitIgnore = wd / ".gitignore"
      files.softWrite(gitIgnore) { pw =>
        pw.println("target/")
        pw.println(".idea/")
      }
      %%('git, 'add, gitIgnore)
      %% git ('remote, 'add, 'origin, constants.ScalablyTypedRepo)
      %% git ('branch, 'add, "--set-upstream-to=origin/master")

    } else {
      implicit val wd = cacheFolder
      % git ('clone, constants.ScalablyTypedRepo)
    }
  } else {
    implicit val wd = targetFolder
    if (!constants.offline) {
      % git 'fetch
    }
    % git ("clean", "-fd")
    % git ('reset, "--hard", "origin/master")
    % rm ("-f", ".git/gc.log")
    % git 'prune
  }

  val storingErrorLogger = logging.storing()

  val logger = {
    val logFile = new FileWriter((logsFolder / s"${Instant.now()}.log").toIO)
    val base    = logging.appendable(logFile).zipWith(storingErrorLogger.filter(LogLevel.error))
    if (debugMode) base.zipWith(logging.stdout) else base
  }

  val logRegistry = new LogRegistry[TsSource, TsIdentLibrary, Array[Stored]](
    logger.filter(LogLevel.warn).syncAccess.void,
    _.inLibrary.libName,
    _ => logging.storing()
  )

  val dtFolder: InFolder =
    UpToDateDefinitelyTyped(cacheFolder, constants.DefinitelyTypedRepo)

  val external: NotNeededPackages =
    Json[NotNeededPackages](dtFolder.path / up / "notNeededPackages.json")

  val externalsFolder: InFolder =
    UpToDateExternals(
      logger.void,
      cacheFolder / 'npm,
      external.packages.map(_.typingsPackageName).to[Set] + "typescript" ++ constants.extraExternals,
      constants.ignored
    )

  val stdLibSource: TsSource =
    StdLibSource(InFile(externalsFolder.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
                 TsIdentLibrarySimple("std"))

  val sources: Seq[InFolder] = Seq(dtFolder, externalsFolder)

  val persistedParser: InFile => Either[String, TsParsedFile] =
    PersistingFunction(nameAndMtimeUnder(cacheFolder / 'parse / BuildInfo.parserHash.toString), logger.void)(
      parseFile
    )

  val tsSources: Set[TsSource] =
    (TypescriptSources(externalsFolder, dtFolder, constants.ignored), args.to[List]) match {
      case (sources, Nil) => sources
      case (sources, wantedLibsStrings) =>
        val wantedLibNames: Set[TsIdentLibrary] =
          wantedLibsStrings.map(libName => ModuleNameParser(TsLiteralString(libName)).inLibrary).to[Set]

        sources.filter(s => wantedLibNames(s.inLibrary.libName))
    }

  val bloop = BloopCompiler(logger.filter(LogLevel.debug).void)

  val bintray: Option[BinTrayPublisher] =
    if (args.contains("publish")) {
      val values: Map[String, String] =
        files
          .content(InFile(home / ".bintray" / ".credentials"))
          .split("\n")
          .map(_.split("=").map(_.trim).filter(_.nonEmpty).toList)
          .collect { case List(k, v) => (k, v) }
          .toMap

      import ExecutionContext.Implicits.global

      Some(new BinTrayPublisher(values("user"), values("password"), constants.Project))
    } else None

  val Phase: RecPhase[TsSource, PublishedSbtProject] =
    RecPhase[TsSource]
      .next(new Phase1ReadTypescript(sources, constants.ignored, stdLibSource, persistedParser), "typescript")
      .next(Phase2ToScalaJs, "scala.js")
      .next(Phase3CompileBloop(bloop, OutFolder(targetFolder), Name.OutputPkg, home / ".ivy2" / "local"), "build")
      .nextOpt(bintray.map(Phase4Publish), "publish")

  val interface = new Interface(debugMode, storingErrorLogger)
  interface.start()

  /* todo: parallel collections suck, but are super easy to use. We'll settle with that for now */
  val par  = tsSources.par
  val pool = new ForkJoinPool(3)

  par.tasksupport = new ForkJoinTaskSupport(pool)
  val results: Set[PhaseRes[TsSource, PublishedSbtProject]] =
    par.map(source => PhaseRunner.go(Phase, source, Nil, logRegistry.get, interface)).seq

  pool.shutdown()

  val summary = interface.finish()

  logger.warn("Writing logs")

  logRegistry.logs.foreach {
    case (libName, storeds) =>
      val failLog = failFolder / RelPath(libName.`__value` + ".log")

      if (summary.failures.contains(libName)) {
        files.softWrite(failLog) { w1 =>
          storeds.underlying.foreach { stored =>
            val str = LogPatternLibrary(stored.message, stored.throwable, stored.metadata, stored.ctx).plainText
            w1.append(str)
            w1.append("\n")
          }
        }
      } else Try(rm(failLog))

      files.softWrite(logsFolder / RelPath(libName.`__value` + ".log")) { w1 =>
        storeds.underlying.foreach { stored =>
          val str = LogPatternLibrary(stored.message, stored.throwable, stored.metadata, stored.ctx).plainText
          w1.append(str)
          w1.append("\n")
        }
      }
  }

  val successes: Set[PublishedSbtProject] = {
    def go(p: PublishedSbtProject): Set[PublishedSbtProject] =
      p.project.deps.values.flatMap(go).to[Set] + p

    results.collect { case PhaseRes.Ok(res) => go(res) }.flatten
  }

  if (debugMode) {
    logger.warn(s"Not committing because of non-empty args ${args.mkString(", ")}")
  } else {
    val sbtProjectDir = targetFolder / s"sbt-${constants.Project}"

    if (bintray.isDefined) {
      logger.warn("Generating sbt plugin...")
      val pattern = DateTimeFormatter.ofPattern("ddMMyyyyhhmm")
      GenerateSbtPlugin(sbtProjectDir, successes, pattern.format(LocalDateTime.now()))
    }

    logger.warn("Commiting...")
    val summaryString = CommitChanges(summary, Seq(sbtProjectDir, failFolder))(targetFolder)
    logger.warn(summaryString)
  }

  System.exit(0)
}
