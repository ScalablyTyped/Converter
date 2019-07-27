package com.olvind.tso
package importer

import java.io.FileWriter
import java.util.concurrent._

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

import scala.collection.immutable.SortedSet
import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.Try

class Main(config: Config) {
  import Main._

  private val pool               = new ForkJoinPool(config.parallelLibraries)
  private val ec                 = ExecutionContext.fromExecutorService(pool)
  private val storingErrorLogger = logging.storing()
  private val logsFolder         = existing(config.cacheFolder / 'logs)

  private val logger = {
    val logFile = new FileWriter((logsFolder / s"${config.runId}.log").toIO)
    val base    = logging appendable logFile zipWith (storingErrorLogger filter LogLevel.error)
    if (config.debugMode) base zipWith logging.stdout else base
  }

  /* we use this to always output to stdout during initialization (before the user interface comes up) */
  private val interfaceLogger = if (config.debugMode) logger.void else logging.stdout
  private val interfaceCmd    = new Cmd(interfaceLogger, None)

  val logRegistry = new LogRegistry[Source, TsIdentLibrary, Array[Stored]](
    logger.filter(LogLevel.warn).syncAccess.void,
    _.libName,
    _ => logging.storing(),
  )

  def run(): Unit = {

    val updatedTargetDirF: Future[TargetDirs] = Future {
      val targetFolder = config.cacheFolder / config.projectName
      if (os.exists(targetFolder)) {
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

      TargetDirs(
        targetFolder = targetFolder,
        failFolder   = existingEmpty(targetFolder / 'failures),
        facadeFolder = existing(targetFolder / 'facades),
      )
    }(ec)

    val compilerF = Future(
      BloopCompiler(
        logger.filter(LogLevel.debug).void,
        config.versions,
        ec,
        config.cacheFolder / 'compileFailures,
      ),
    )(ec)

    val dtFolderF: Future[InFolder] = Future(
      UpToDateDefinitelyTyped(interfaceCmd, config.offline, config.cacheFolder, constants.DefinitelyTypedRepo),
    )(ec)

    val localCleaningF: Future[Unit] = Future {
      if (config.conserveSpace) {
        interfaceLogger.warn(s"Cleaning old artifacts in ${config.publishFolder}")
        LocalCleanup(config.publishFolder, config.organization, keepNum = 2)
      }
    }(ec)

    val externalsFolderF: Future[InFolder] = dtFolderF.map { dtFolder =>
      val external: NotNeededPackages =
        Json[NotNeededPackages](dtFolder.path / os.up / "notNeededPackages.json")

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
      interfaceLogger.warn(s"Indexing ${dtFolder.path / os.up}")
      RepoLastChangedIndex(interfaceCmd, dtFolder.path / os.up)
    }(ec)

    val tsSourcesF: Future[SortedSet[Source]] = {
      implicit val s = ec
      for {
        externalsFolder <- externalsFolderF
        dtFolder <- dtFolderF
        target <- updatedTargetDirF
      } yield {
        val facadeSources: Set[Source] =
          os.list(target.facadeFolder).map(path => Source.FacadeSource(InFolder(path)): Source).to[Set]

        (
          TypescriptSources(externalsFolder, dtFolder, Libraries.ignored).sorted ++ facadeSources,
          config.wantedLibNames,
        ) match {
          case (sources, sets.EmptySet()) => sources
          case (sources, wantedLibsStrings) =>
            val wantedLibNames: Set[TsIdentLibrary] =
              wantedLibsStrings.map(libName => ModuleNameParser(TsLiteralString(libName)).inLibrary)

            sources.filter(s => wantedLibNames(s.libName))
        }
      }
    }

    val externalsFolder                                    = Await.result(externalsFolderF, Duration.Inf)
    val ()                                                 = Await.result(localCleaningF, Duration.Inf)
    val dtFolder                                           = Await.result(dtFolderF, Duration.Inf)
    val lastChangedIndex                                   = Await.result(lastChangedIndexF, Duration.Inf)
    val TargetDirs(targetFolder, failFolder, facadeFolder) = Await.result(updatedTargetDirF, Duration.Inf)
    val compiler                                           = Await.result(compilerF, Duration.Inf)
    val tsSources                                          = Await.result(tsSourcesF, Duration.Inf)

    val stdLibSource: Source =
      StdLibSource(
        InFile(externalsFolder.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
        TsIdentLibrarySimple("std"),
      )

    val bintray: Option[BinTrayPublisher] = config.publish.map {
      case PublishConfig(user, password) =>
        BinTrayPublisher(
          existing(config.cacheFolder / 'bintray),
          config.ScalablyTypedRepo,
          user,
          password,
          config.projectName,
        )(ec)
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
          new Phase3Compile(
            resolve         = resolve,
            versions        = config.versions,
            compiler        = compiler,
            targetFolder    = targetFolder,
            mainPackageName = config.outputPkg,
            projectName     = config.projectName,
            organization    = config.organization,
            publishUser     = bintray.fold("oyvindberg")(_.user),
            publishFolder   = config.publishFolder,
            metadataFetcher = Npmjs.GigahorseFetcher(existing(config.cacheFolder / 'npmjs))(ec),
            softWrites      = config.softWrites,
          ),
          "build",
        )
        .nextOpt(bintray.map(Phase4Publish), "publish")

    val interface = new Interface(config.debugMode, storingErrorLogger)
    interface.start()

    val results: Seq[PhaseRes[Source, PublishedSbtProject]] =
      if (config.sequential)
        tsSources.toVector.map(source => PhaseRunner.go(Phase, source, Nil, logRegistry.get, interface))
      else {
        val par = tsSources.toVector.par
        par.tasksupport = new ForkJoinTaskSupport(pool)
        par
          .map(source => PhaseRunner.go(Phase, source, Nil, logRegistry.get, interface))
          .seq
      }

    val summary = interface.finish()

    pool.shutdown()

    interfaceLogger warn "Writing logs"

    logRegistry.logs.foreach {
      case (libName, storeds) =>
        val failLog = failFolder / os.RelPath(libName.`__value` + ".log")

        if (summary.failures.contains(libName)) {
          files.softWrite(failLog) { w1 =>
            storeds.underlying.foreach { stored =>
              val str = LogPatternLibrary(stored.message, stored.throwable, stored.metadata, stored.ctx).plainText
              w1.append(str)
              w1.append("\n")
            }
          }
        } else Try(os.remove.all(failLog))

        files.softWrite(logsFolder / os.RelPath(libName.`__value` + ".log")) { w1 =>
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
    val gitIgnore             = targetFolder / ".gitignore"
    val readme                = targetFolder / "readme.md"
    val librariesByName       = targetFolder / "libraries_by_name.md"
    val librariesByScore      = targetFolder / "libraries_by_score.md"
    val librariesByDependents = targetFolder / "libraries_by_dependents.md"

    val locOutput = Try(interfaceCmd.run('loc)(targetFolder)).toOption.map(_.out.string)
    files.softWrite(readme)(_.print(Readme(summary, config.runId, locOutput)))
    files.softWrite(librariesByName)(_.print(lists.byName))
    files.softWrite(librariesByScore)(_.print(lists.byScore))
    files.softWrite(librariesByDependents)(_.print(lists.byDependents))
    files.softWrite(gitIgnore)(_.println("""
target/
.idea/
.bloop/
"""))

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
        Seq(sbtProjectDir, failFolder, readme, librariesByScore, librariesByName, librariesByDependents, gitIgnore),
      )(
        targetFolder,
      )
    }

    System.exit(0)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val Config(config) = args
    /* I havent found a way to configure bloop to customize the global ExecutionContext, so this is it */
    System.setProperty("scala.concurrent.context.numThreads", config.parallelScalas.toString)
    new Main(config).run()
  }

  def existing(p: os.Path): os.Path = {
    os.makeDir.all(p)
    p
  }
  def existingEmpty(p: os.Path): os.Path = {
    Try(os.remove.all(p))
    existing(p)
  }

  case class TargetDirs(targetFolder: os.Path, failFolder: os.Path, facadeFolder: os.Path)
}
