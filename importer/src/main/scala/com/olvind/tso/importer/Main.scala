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
import com.olvind.tso.scalajs.Name
import com.olvind.tso.ts.TsSource.StdLibSource
import com.olvind.tso.ts._
import com.olvind.tso.ts.parser.parseFile

import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.ExecutionContext
import scala.util.Try

case class Flags(publish: Boolean, offline: Boolean, cleanRepo: Boolean, wantedLibNames: Array[String]) {
  def debugMode: Boolean = wantedLibNames.nonEmpty
}

object Flags {
  def unapply(args: Array[String]): Some[Flags] =
    args.partition(_.startsWith("-")) match {
      case (flags, rest) =>
        Some(
          Flags(
            publish        = flags.contains("-publish"),
            offline        = flags.contains("-offline"),
            cleanRepo      = flags.contains("-cleanRepo"),
            wantedLibNames = rest
          )
        )
    }
}

object Main extends App {
  val Flags(flags) = args
  println(flags)
  val cacheFolder  = home / 'tmp / "tso-cache"
  val targetFolder = cacheFolder / constants.Project
  val failFolder   = targetFolder / 'failures
  val logsFolder   = cacheFolder / 'logs

  (exists(targetFolder / ".git"), flags.cleanRepo) match {
    case (existed, true) =>
      if (existed) {
        rm(targetFolder)
        assert(!exists(targetFolder))
      }

      mkdir(targetFolder)

      implicit val wd = targetFolder
      % git 'init
      val gitIgnore = wd / ".gitignore"
      files.softWrite(gitIgnore) { pw =>
        pw.println("target/")
        pw.println(".idea/")
      }
      %% git ('add, gitIgnore)
      %% git ('remote, 'add, 'origin, constants.ScalablyTypedRepo)
//      %% git ('branch, "--set-upstream-to=origin/master")
    case (true, false) =>
      implicit val wd = targetFolder
      if (!flags.offline) {
        % git 'fetch
      }
      % git ("clean", "-fdX") // remove ignored files/folders
      % git ("clean", "-fd")
      % git ('reset, "--hard", "origin/master")
      % rm ("-f", ".git/gc.log")
      % git 'prune
    case (false, false) =>
      implicit val wd = cacheFolder
      % git ('clone, constants.ScalablyTypedRepo)
  }

  rm(failFolder)
  mkdir(failFolder)

  val storingErrorLogger = logging.storing()

  val logger = {
    mkdir(logsFolder)
    val logFile = new FileWriter((logsFolder / s"${Instant.now()}.log").toIO)
    val base    = logging.appendable(logFile).zipWith(storingErrorLogger.filter(LogLevel.error))
    if (flags.debugMode) base.zipWith(logging.stdout) else base
  }

  val logRegistry = new LogRegistry[TsSource, TsIdentLibrary, Array[Stored]](
    logger.filter(LogLevel.warn).syncAccess.void,
    _.inLibrary.libName,
    _ => logging.storing()
  )

  val dtFolder: InFolder =
    UpToDateDefinitelyTyped(flags.offline, cacheFolder, constants.DefinitelyTypedRepo)

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
    (TypescriptSources(externalsFolder, dtFolder, constants.ignored), flags.wantedLibNames.to[List]) match {
      case (sources, Nil) => sources
      case (sources, wantedLibsStrings) =>
        val wantedLibNames: Set[TsIdentLibrary] =
          wantedLibsStrings.map(libName => ModuleNameParser(TsLiteralString(libName)).inLibrary).to[Set]

        sources.filter(s => wantedLibNames(s.inLibrary.libName))
    }

  val bloop = BloopCompiler(logger.filter(LogLevel.debug).void)

  val bintray: Option[BinTrayPublisher] =
    if (flags.publish) {
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

  val interface = new Interface(flags.debugMode, storingErrorLogger)
  interface.start()

  /* todo: parallel collections suck, but are super easy to use. We'll settle with that for now */
  val par  = tsSources.par
  val pool = new ForkJoinPool(3)

  par.tasksupport = new ForkJoinTaskSupport(pool)
  val results: Set[PhaseRes[TsSource, PublishedSbtProject]] =
    par.map(source => PhaseRunner.go(Phase, source, Nil, logRegistry.get, interface)).seq

  pool.shutdown()

  val summary = interface.finish()

  logger error "Writing logs"

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

  if (flags.debugMode) {
    logger error s"Not committing because of non-empty args ${flags.wantedLibNames.mkString(", ")}"
  } else {
    logger error "Generating sbt plugin..."

    val sbtProjectDir = targetFolder / s"sbt-${constants.Project}"
    val pattern       = DateTimeFormatter ofPattern "ddMMyyyyhhmm"
    GenerateSbtPlugin(
      projectDir    = sbtProjectDir,
      projects      = successes,
      pluginVersion = pattern format LocalDateTime.now,
      action        = if (bintray.isDefined) "publish" else "publishLocal"
    )

    logger error "Committing..."
    val summaryString = CommitChanges(summary, Seq(sbtProjectDir, failFolder))(targetFolder)
    logger error summaryString
  }

  System.exit(0)
}
