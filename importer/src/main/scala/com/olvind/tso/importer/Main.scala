package com.olvind.tso
package importer

import java.io.FileWriter
import java.util.concurrent._

import ammonite.ops._
import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.PersistingFunction.nameAndMtimeUnder
import com.olvind.tso.importer.Source.StdLibSource
import com.olvind.tso.importer.build._
import com.olvind.tso.importer.documentation.{Npmjs, Readme, TopLists}
import com.olvind.tso.importer.jsonCodecs._
import com.olvind.tso.phases.{PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.sets.SetOps
import com.olvind.tso.ts._
import com.olvind.tso.ts.parser.parseFile
import monix.execution.Scheduler

import scala.collection.immutable.SortedSet
import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.Try

object Main {

  def main(args: Array[String]): Unit = {
    val Config(config) = args
    run(config)
  }

  def existing(p: Path): Path = {
    mkdir(p)
    p
  }
  def existingEmpty(p: Path): Path = {
    Try(rm(p))
    existing(p)
  }

  def run(config: Config): Unit = {
    val logsFolder       = existing(config.cacheFolder / 'logs)
    val pool             = new ForkJoinPool(config.parallelLibraries)
    val ec               = ExecutionContext.fromExecutor(pool)
    val compilePool      = new ForkJoinPool(config.parallelScalas)
    val compileScheduler = Scheduler(compilePool)

    val storingErrorLogger = logging.storing()

    val logger = {
      val logFile = new FileWriter((logsFolder / s"${config.runId}.log").toIO)
      val base    = logging appendable logFile zipWith (storingErrorLogger filter LogLevel.error)
      if (config.debugMode) base zipWith logging.stdout else base
    }

    /* we use this to always output to stdout during initialization (before the user interface comes up) */
    val interfaceLogger = if (config.debugMode) logger.void else logging.stdout
    val interfaceCmd    = new Cmd(interfaceLogger, None)

    val logRegistry = new LogRegistry[Source, TsIdentLibrary, Array[Stored]](
      logger.filter(LogLevel.warn).syncAccess.void,
      _.libName,
      _ => logging.storing(),
    )

    case class TargetDir(targetFolder: Path, failFolder: Path, facadeFolder: Path)

    val updatedTargetDirF: Future[TargetDir] = Future {
      val targetFolder = config.cacheFolder / config.projectName
      if (exists(targetFolder)) {
        implicit val wd = targetFolder
        if (!config.offline) {
          interfaceCmd.runVerbose git 'fetch
        }
        if (!config.dontCleanProject) {
          interfaceCmd.runVerbose git ("clean", "-fdX") // remove ignored files/folders
          interfaceCmd.runVerbose git ("clean", "-fd")
          interfaceCmd.runVerbose git ('reset, "--hard", "origin/master")
          interfaceCmd.runVerbose rm ("-f", ".git/gc.log")
          interfaceCmd.runVerbose git 'prune
        }

      } else {
        implicit val wd = config.cacheFolder
        interfaceCmd.runVerbose git ('clone, config.ScalablyTypedRepo)
      }

      TargetDir(
        targetFolder = targetFolder,
        failFolder   = existingEmpty(targetFolder / 'failures),
        facadeFolder = existing(targetFolder / 'facades),
      )
    }(ec)

    val dtFolderF: Future[InFolder] =
      Future(UpToDateDefinitelyTyped(interfaceCmd, config.offline, config.cacheFolder, constants.DefinitelyTypedRepo))(
        ec,
      )

    val localCleaning: Future[Unit] = Future {
      if (config.conserveSpace) {
        interfaceLogger.warn(s"Cleaning old artifacts in ${config.publishFolder}")
        LocalCleanup(config.publishFolder, config.organization, keepNum = 2)
      } else ()
    }(ec)

    val externalsFolderF: Future[InFolder] = dtFolderF.map { dtFolder =>
      val external: NotNeededPackages =
        Json[NotNeededPackages](dtFolder.path / up / "notNeededPackages.json")

      UpToDateExternals(
        interfaceLogger,
        interfaceCmd,
        existing(existing(config.cacheFolder / 'npm)),
        external.packages.map(_.typingsPackageName).to[Set] + "typescript" ++ Libraries.extraExternals,
        Libraries.ignored,
        config.conserveSpace,
        config.offline,
      )
    }(ec)

    val lastChangedIndexF = dtFolderF.map { dtFolder =>
      interfaceLogger.warn(s"Indexing ${dtFolder.path / up}")
      RepoLastChangedIndex(interfaceCmd, dtFolder.path / up)
    }(ec)

    val bloopFactoryF = Future(new BloopFactory(logger.filter(LogLevel.debug).void))(ec)

    val externalsFolder                                   = Await.result(externalsFolderF, Duration.Inf)
    val ()                                                = Await.result(localCleaning, Duration.Inf)
    val dtFolder                                          = Await.result(dtFolderF, Duration.Inf)
    val lastChangedIndex                                  = Await.result(lastChangedIndexF, Duration.Inf)
    val TargetDir(targetFolder, failFolder, facadeFolder) = Await.result(updatedTargetDirF, Duration.Inf)
    val bloopFactory                                      = Await.result(bloopFactoryF, Duration.Inf)

    val stdLibSource: Source =
      StdLibSource(
        InFile(externalsFolder.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
        TsIdentLibrarySimple("std"),
      )

    val facadeSources: Set[Source] =
      ls(facadeFolder).map(path => Source.FacadeSource(InFolder(path)): Source).to[Set]

    val tsSources: SortedSet[Source] =
      (TypescriptSources(externalsFolder, dtFolder, Libraries.ignored).sorted ++ facadeSources, config.wantedLibNames) match {
        case (sources, sets.EmptySet()) => sources
        case (sources, wantedLibsStrings) =>
          val wantedLibNames: Set[TsIdentLibrary] =
            wantedLibsStrings.map(libName => ModuleNameParser(TsLiteralString(libName)).inLibrary)

          sources.filter(s => wantedLibNames(s.libName))
      }

    val bintray: Option[BinTrayPublisher] =
      config.publish.map {
        case PublishConfig(user, password) =>
          BinTrayPublisher(
            existing(config.cacheFolder / 'bintray),
            config.ScalablyTypedRepo,
            user,
            password,
            config.projectName,
          )(
            ExecutionContext.Implicits.global,
          )
      }

    val resolve = new LibraryResolver(
      stdLibSource,
      sourceFolders = Seq(dtFolder, externalsFolder),
      facadesFolder = Some(InFolder(facadeFolder)),
    )

    val Phase: RecPhase[Source, PublishedSbtProject] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            calculateLibraryVersion = new CalculateLibraryVersion(lastChangedIndex, BuildInfo.gitSha),
            resolve                 = resolve,
            ignored                 = Libraries.ignored,
            stdlibSource            = stdLibSource,
            pedantic                = config.pedantic,
            parser =
              if (config.enableParseCache)
                PersistingFunction(nameAndMtimeUnder(existing(config.cacheFolder / 'parse)), logger.void)(parseFile)
              else parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(config.pedantic, config.outputPkg), "scala.js")
        .next(
          new Phase3CompileBloop(
            versions        = config.versions,
            bloop           = bloopFactory.forVersion(config.versions, compileScheduler),
            bloopLogger     = bloopFactory.bloopLogger,
            targetFolder    = targetFolder,
            mainPackageName = config.outputPkg,
            projectName     = config.projectName,
            organization    = config.organization,
            publishUser     = bintray.fold("oyvindberg")(_.user),
            publishFolder   = config.publishFolder,
            resolve         = resolve,
            scheduler       = compileScheduler,
            failureCacheDir = existing(config.cacheFolder / 'compileFailures),
            metadataFetcher = Npmjs.GigahorseFetcher(existing(config.cacheFolder / 'npmjs))(compileScheduler),
          ),
          "build",
        )
        .nextOpt(bintray.map(Phase4Publish), "publish")

    val interface = new Interface(config.debugMode, storingErrorLogger)
    interface.start()

    val par = tsSources.toVector.par
    par.tasksupport = new ForkJoinTaskSupport(pool)
    val summary = interface.finish()
    val results: Seq[PhaseRes[Source, PublishedSbtProject]] =
      par.map(source => PhaseRunner.go(Phase, source, Nil, logRegistry.get, interface)).seq

    pool.shutdown()
    compilePool.shutdown()

    interfaceLogger warn "Writing logs"

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

    val lists                 = TopLists(successes)
    val readme                = targetFolder / "readme.md"
    val librariesByName       = targetFolder / "libraries_by_name.md"
    val librariesByScore      = targetFolder / "libraries_by_score.md"
    val librariesByDependents = targetFolder / "libraries_by_dependents.md"

    val locOutput = Try(interfaceCmd.run('loc)(targetFolder)).toOption.map(_.out.string)
    files.softWrite(readme)(_.print(Readme(summary, config.runId, locOutput)))
    files.softWrite(librariesByName)(_.print(lists.byName))
    files.softWrite(librariesByScore)(_.print(lists.byScore))
    files.softWrite(librariesByDependents)(_.print(lists.byDependents))

    if (config.debugMode && !config.forceCommit) {
      interfaceLogger warn s"Not committing because of non-empty args ${config.wantedLibNames.mkString(", ")}"
    } else {
      interfaceLogger warn "Generating sbt plugin..."

      val sbtProjectDir = targetFolder / s"sbt-${config.projectName}"
      GenerateSbtPlugin(
        versions      = config.versions,
        organization  = config.organization,
        projectName   = config.projectName,
        projectDir    = sbtProjectDir,
        projects      = successes,
        pluginVersion = config.runId,
        action        = if (bintray.isDefined) "^publish" else "publishLocal",
      )

      CommitChanges(
        interfaceCmd,
        summary,
        successes.map(_.project.baseDir).to[Seq],
        Seq(sbtProjectDir, failFolder, readme, librariesByScore, librariesByName, librariesByDependents),
      )(
        targetFolder,
      )
    }

    System.exit(0)
  }
}
