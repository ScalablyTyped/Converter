package com.olvind.tso
package importer

import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent._

import ammonite.ops._
import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.PersistingFunction.nameAndMtimeUnder
import com.olvind.tso.importer.build._
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.phases.{PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.ts.TsSource.StdLibSource
import com.olvind.tso.ts._
import com.olvind.tso.ts.parser.parseFile

import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.ExecutionContext
import scala.util.Try

object Main extends App {
  val Config(config) = args

  val RunId = {
    val pattern = DateTimeFormatter ofPattern "ddMMyyyyhhmm"
    pattern format LocalDateTime.now
  }

  val targetFolder     = config.cacheFolder / config.projectName
  val failFolder       = targetFolder / 'failures
  val logsFolder       = config.cacheFolder / 'logs
  val parseCacheFolder = config.cacheFolder / 'parse / BuildInfo.parserHash.toString

  (exists(targetFolder / ".git"), config.cleanRepo) match {
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
      %% git ('remote, 'add, 'origin, config.ScalablyTypedRepo)
//      %% git ('branch, "--set-upstream-to=origin/master")
    case (true, false) =>
      implicit val wd = targetFolder
      if (!config.offline) {
        % git 'fetch
      }
      % git ("clean", "-fdX") // remove ignored files/folders
      % git ("clean", "-fd")
      % git ('reset, "--hard", "origin/master")
      % rm ("-f", ".git/gc.log")
      % git 'prune
    case (false, false) =>
      implicit val wd = config.cacheFolder
      % git ('clone, config.ScalablyTypedRepo)
  }

  rm(failFolder)
  mkdir(failFolder)

  val storingErrorLogger = logging.storing()

  val logger = {
    mkdir(logsFolder)
    val logFile = new FileWriter((logsFolder / s"$RunId.log").toIO)
    val base    = logging appendable logFile zipWith (storingErrorLogger filter LogLevel.error)
    if (config.debugMode) base zipWith logging.stdout else base
  }

  val logRegistry = new LogRegistry[TsSource, TsIdentLibrary, Array[Stored]](
    logger.filter(LogLevel.warn).syncAccess.void,
    _.inLibrary.libName,
    _ => logging.storing()
  )

  val dtFolder: InFolder =
    UpToDateDefinitelyTyped(config.offline, config.cacheFolder, constants.DefinitelyTypedRepo)

  val external: NotNeededPackages =
    Json[NotNeededPackages](dtFolder.path / up / "notNeededPackages.json")

  val externalsFolder: InFolder =
    UpToDateExternals(
      logger.void,
      config.cacheFolder / 'npm,
      external.packages.map(_.typingsPackageName).to[Set] + "typescript" ++ Libraries.extraExternals,
      Libraries.ignored
    )

  val stdLibSource: TsSource =
    StdLibSource(InFile(externalsFolder.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
                 TsIdentLibrarySimple("std"))

  val tsSources: Set[TsSource] =
    (TypescriptSources(externalsFolder, dtFolder, Libraries.ignored), config.wantedLibNames.to[List]) match {
      case (sources, Nil) => sources
      case (sources, wantedLibsStrings) =>
        val wantedLibNames: Set[TsIdentLibrary] =
          wantedLibsStrings.map(libName => ModuleNameParser(TsLiteralString(libName)).inLibrary).to[Set]

        sources.filter(s => wantedLibNames(s.inLibrary.libName))
    }

  val bintray: Option[BinTrayPublisher] =
    if (config.publish) {
      val values: Map[String, String] =
        files
          .content(InFile(home / ".bintray" / ".credentials"))
          .split("\n")
          .map(_.split("=").map(_.trim).filter(_.nonEmpty).toList)
          .collect { case List(k, v) => (k, v) }
          .toMap

      Some(
        new BinTrayPublisher(config.ScalablyTypedRepoPublic, values("user"), values("password"), config.projectName)(
          ExecutionContext.Implicits.global
        )
      )
    } else None

  val bloopFactory = new BloopFactory(logger.filter(LogLevel.debug).void)

  val Phase: RecPhase[TsSource, PublishedSbtProject] =
    RecPhase[TsSource]
      .next(
        new Phase1ReadTypescript(
          sources      = Seq(dtFolder, externalsFolder),
          ignored      = Libraries.ignored,
          stdlibSource = stdLibSource,
          pedantic     = config.pedantic,
          parser       = PersistingFunction(nameAndMtimeUnder(parseCacheFolder), logger.void)(parseFile)
        ),
        "typescript"
      )
      .next(new Phase2ToScalaJs(config.pedantic, config.outputPkg), "scala.js")
      .next(
        new Phase3CompileBloop(
          versions        = config.versions,
          bloopFactory    = bloopFactory,
          targetFolder    = targetFolder,
          mainPackageName = config.outputPkg,
          projectName     = config.projectName,
          organization    = config.organization,
          publishFolder   = config.publishFolder
        ),
        "build"
      )
      .nextOpt(bintray.map(Phase4Publish), "publish")

  val interface = new Interface(config.debugMode, storingErrorLogger)
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

  if (config.debugMode) {
    logger error s"Not committing because of non-empty args ${config.wantedLibNames.mkString(", ")}"
  } else {
    logger error "Generating sbt plugin..."

    val sbtProjectDir = targetFolder / s"sbt-${config.projectName}"
    GenerateSbtPlugin(
      versions      = config.versions,
      organization  = config.organization,
      projectName   = config.projectName,
      projectDir    = sbtProjectDir,
      projects      = successes,
      pluginVersion = RunId,
      action        = if (bintray.isDefined) "^publish" else "^publishLocal"
    )

    logger error "Committing..."
    val summaryString = CommitChanges(summary, Seq(sbtProjectDir, failFolder))(targetFolder)
    logger error summaryString
  }

  System.exit(0)
}
