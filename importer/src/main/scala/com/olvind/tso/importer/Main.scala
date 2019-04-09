package com.olvind.tso
package importer

import java.io.FileWriter
import java.time.LocalDateTime
import java.util.concurrent._

import ammonite.ops._
import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.PersistingFunction.nameAndMtimeUnder
import com.olvind.tso.importer.Source.StdLibSource
import com.olvind.tso.importer.build._
import com.olvind.tso.importer.documentation.Readme
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.phases.{PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.sets.SetOps
import com.olvind.tso.ts._
import com.olvind.tso.ts.parser.parseFile
import monix.execution.Scheduler

import scala.collection.immutable.SortedSet
import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.ExecutionContext
import scala.util.Try

object Main extends App {
  val Config(config)         = args
  val RunId                  = constants.DateTimePattern format LocalDateTime.now
  val logsFolder             = config.cacheFolder / 'logs
  val parseCacheFolder       = config.cacheFolder / 'parse / BuildInfo.parserHash.toString
  val targetFolder           = config.cacheFolder / config.projectName
  val bintrayCacheFolder     = config.cacheFolder / 'bintray
  val compileFailureCacheDir = config.cacheFolder / 'compileFailures
  val failFolder             = targetFolder / 'failures
  val contribFolder          = targetFolder / 'contrib

  mkdir(targetFolder)

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
    case (true, false) =>
      implicit val wd = targetFolder
      if (!config.offline) {
        % git 'fetch
      }
      if (!config.dontCleanProject) {
        % git ("clean", "-fdX") // remove ignored files/folders
        % git ("clean", "-fd")
        % git ('reset, "--hard", "origin/master")
        % rm ("-f", ".git/gc.log")
        % git 'prune
      }
    case (false, false) =>
      implicit val wd = config.cacheFolder
      % git ('clone, config.ScalablyTypedRepo)
  }

  rm(failFolder)
  mkdir(failFolder)
  mkdir(contribFolder)
  mkdir(logsFolder)
  mkdir(bintrayCacheFolder)
  mkdir(compileFailureCacheDir)

  val storingErrorLogger = logging.storing()

  val logger = {
    val logFile = new FileWriter((logsFolder / s"$RunId.log").toIO)
    val base    = logging appendable logFile zipWith (storingErrorLogger filter LogLevel.error)
    if (config.debugMode) base zipWith logging.stdout else base
  }

  val logRegistry = new LogRegistry[Source, TsIdentLibrary, Array[Stored]](
    logger.filter(LogLevel.warn).syncAccess.void,
    _.libName,
    _ => logging.storing()
  )

  val dtFolder: InFolder =
    UpToDateDefinitelyTyped(config.offline, config.cacheFolder, constants.DefinitelyTypedRepo)

  val external: NotNeededPackages =
    Json[NotNeededPackages](dtFolder.path / up / "notNeededPackages.json")

  if (config.conserveSpace) {
    logger.warn(s"Cleaning old artifacts in ${config.publishFolder}")
    LocalCleanup(config.publishFolder, config.organization, keepNum = 2)
  }

  val externalsFolder: InFolder =
    UpToDateExternals(
      logger.void,
      config.cacheFolder / 'npm,
      external.packages.map(_.typingsPackageName).to[Set] + "typescript" ++ Libraries.extraExternals,
      Libraries.ignored,
      config.conserveSpace,
      config.offline
    )

  val stdLibSource: Source =
    StdLibSource(InFile(externalsFolder.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
                 TsIdentLibrarySimple("std"))

  val contribSources: Set[Source] =
    ls(contribFolder).map(path => Source.ContribSource(InFolder(path)): Source).to[Set]

  val tsSources: SortedSet[Source] =
    (TypescriptSources(externalsFolder, dtFolder, Libraries.ignored).sorted ++ contribSources, config.wantedLibNames) match {
      case (sources, sets.EmptySet()) => sources
      case (sources, wantedLibsStrings) =>
        val wantedLibNames: Set[TsIdentLibrary] =
          wantedLibsStrings.map(libName => ModuleNameParser(TsLiteralString(libName)).inLibrary)

        sources.filter(s => wantedLibNames(s.libName))
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
        new BinTrayPublisher(bintrayCacheFolder,
                             config.ScalablyTypedRepoPublic,
                             values("user"),
                             values("password"),
                             config.projectName)(
          ExecutionContext.Implicits.global
        )
      )
    } else None

  val bloopFactory = new BloopFactory(logger.filter(LogLevel.debug).void)
  val resolve = new LibraryResolver(
    stdLibSource,
    sourceFolders = Seq(dtFolder, externalsFolder),
    contribFolder = Some(InFolder(contribFolder))
  )

  val compilePool = new ForkJoinPool(config.parallelScalas)
  val scheduler   = Scheduler(compilePool)
  logger.warn(s"Indexing ${dtFolder.path / up}")
  val lastChangedIndex = RepoLastChangedIndex(dtFolder.path / up)

  val Phase: RecPhase[Source, PublishedSbtProject] =
    RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          lastChangedIndex = lastChangedIndex,
          resolve          = resolve,
          ignored          = Libraries.ignored,
          stdlibSource     = stdLibSource,
          pedantic         = config.pedantic,
          parser =
            if (config.enableParseCache) PersistingFunction(nameAndMtimeUnder(parseCacheFolder), logger.void)(parseFile)
            else parseFile
        ),
        "typescript"
      )
      .next(new Phase2ToScalaJs(config.pedantic, config.outputPkg), "scala.js")
      .next(
        new Phase3CompileBloop(
          versions        = config.versions,
          bloop           = bloopFactory.forVersion(config.versions, scheduler),
          bloopLogger     = bloopFactory.bloopLogger,
          targetFolder    = targetFolder,
          mainPackageName = config.outputPkg,
          projectName     = config.projectName,
          organization    = config.organization,
          publishFolder   = config.publishFolder,
          resolve         = resolve,
          scheduler       = scheduler,
          failureCacheDir = compileFailureCacheDir
        ),
        "build"
      )
      .nextOpt(bintray.map(Phase4Publish), "publish")

  val interface = new Interface(config.debugMode, storingErrorLogger)
  interface.start()

  /* todo: parallel collections suck, but are super easy to use. We'll settle with that for now */
  val par  = tsSources.toVector.par
  val pool = new ForkJoinPool(config.parallelLibraries)

  par.tasksupport = new ForkJoinTaskSupport(pool)
  val results: Seq[PhaseRes[Source, PublishedSbtProject]] =
    par.map(source => PhaseRunner.go(Phase, source, Nil, logRegistry.get, interface)).seq

  pool.shutdown()
  compilePool.shutdown()

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

    results.collect { case PhaseRes.Ok(res) => go(res) }.flatten.to[Set]
  }

  val readme    = targetFolder / "readme.md"
  val locOutput = Try(%%('loc)(targetFolder)).toOption.map(_.out.string)
  files.softWrite(readme)(_.print(Readme(summary, RunId, locOutput)))

  if (config.debugMode && !config.forceCommit) {
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
      action        = if (bintray.isDefined) "^publish" else "publishLocal"
    )

    logger error "Committing..."
    val summaryString =
      CommitChanges(summary, successes.map(_.project.baseDir).to[Seq], Seq(sbtProjectDir, failFolder, readme))(
        targetFolder
      )
    logger error summaryString
  }

  System.exit(0)
}
