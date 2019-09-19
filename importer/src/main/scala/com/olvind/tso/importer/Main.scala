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
import com.olvind.tso.scalajs.flavours.Flavour
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
  private val logsFolder         = files.existing(config.cacheFolder / 'logs)

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
    _ => logging.storing().filter(LogLevel.warn),
  )

  def updatedTargetDir(flavour: Flavour): Future[TargetDirs] =
    Future {
      val projectFolder = config.cacheFolder / flavour.projectName
      if (os.exists(projectFolder)) {
        implicit val wd = projectFolder
        if (!config.offline) {
          Try(interfaceCmd.runVerbose git 'fetch)
        }
        if (!config.dontCleanProject) {
          Try(interfaceCmd.runVerbose git ("clean", "-fdX")) // remove ignored files/folders
          Try(interfaceCmd.runVerbose git ("clean", "-fd"))
          Try(interfaceCmd.runVerbose git ('reset, "--hard", "origin/master"))
          Try(interfaceCmd.runVerbose rm ("-f", ".git/gc.log"))
          Try(interfaceCmd.runVerbose git 'prune)
        }
      } else
        Try {
          implicit val wd = config.cacheFolder
          interfaceCmd.runVerbose git ('clone, flavour.repo)
        } recover {
          case _ =>
            os.makeDir(projectFolder)

            implicit val wd = projectFolder
            interfaceCmd.runVerbose git 'init
            interfaceCmd.runVerbose git ("remote", "add", "origin", flavour.repo)
        }

      TargetDirs(targetFolder = projectFolder, facadeFolder = files.existing(projectFolder / 'facades))
    }(ec)

  def localCleaning(flavour: Flavour): Future[Unit] =
    Future {
      if (config.conserveSpace) {
        interfaceLogger.warn(s"Cleaning old artifacts in ${config.publishFolder}")
        LocalCleanup(config.publishFolder, flavour.organization, keepNum = 2)
      }
    }(ec)

  def bintrayFor(flavour: Flavour): Option[BinTrayPublisher] =
    config.publish.map {
      case PublishConfig(user, password) =>
        BinTrayPublisher(
          files.existing(config.cacheFolder / 'bintray),
          flavour.repo,
          user,
          password,
          flavour.projectName,
        )(ec)
    }

  def tsSourcesF(
      externalsFolderF:  Future[InFolder],
      dtFolderF:         Future[InFolder],
      updatedTargetDirF: Future[TargetDirs],
  ): Future[SortedSet[Source]] = {
    implicit val s = ec
    for {
      externalsFolder <- externalsFolderF
      dtFolder <- dtFolderF
      target <- updatedTargetDirF
    } yield {
      val facadeSources: Set[Source] =
        os.list(target.facadeFolder).map(path => Source.FacadeSource(InFolder(path)): Source).to[Set]

      (
        TypescriptSources(externalsFolder, dtFolder, Libraries.ignored(config.sequential)).sorted ++ facadeSources,
        config.wantedLibNames,
      ) match {
        case (sources, sets.EmptySet())   => sources
        case (sources, wantedLibsStrings) => sources.filter(s => wantedLibsStrings(s.libName))
      }
    }
  }

  def run(): Unit = {
    val compilerF: Future[BloopCompiler] =
      Future(
        BloopCompiler(
          logger.filter(LogLevel.debug).void,
          config.versions,
          ec,
          config.cacheFolder / 'compileFailures,
        ),
      )(ec)

    val dtFolderF: Future[InFolder] =
      Future(
        DTUpToDate(interfaceCmd, config.offline, config.cacheFolder, constants.DefinitelyTypedRepo),
      )(ec)

    val externalsFolderF: Future[InFolder] =
      dtFolderF.map { dtFolder =>
        val external: NotNeededPackages =
          Json[NotNeededPackages](dtFolder.path / os.up / "notNeededPackages.json")

        UpToDateExternals(
          interfaceLogger,
          interfaceCmd,
          files.existing(config.cacheFolder / 'npm),
          external.packages
            .map(_.typingsPackageName)
            .to[Set] + TsIdentLibrary("typescript") ++ Libraries.extraExternals,
          Libraries.ignored(config.sequential),
          config.conserveSpace,
          config.offline,
        )
      }(ec)

    val lastChangedIndexF: Future[DTLastChangedIndex] =
      dtFolderF.map { dtFolder =>
        interfaceLogger.warn(s"Indexing ${dtFolder.path / os.up}")
        DTLastChangedIndex(interfaceCmd, dtFolder.path / os.up)
      }(ec)

    val externalsFolder  = Await.result(externalsFolderF, Duration.Inf)
    val dtFolder         = Await.result(dtFolderF, Duration.Inf)
    val lastChangedIndex = Await.result(lastChangedIndexF, Duration.Inf)
    val compiler         = Await.result(compilerF, Duration.Inf)

    val stdLibSource: StdLibSource = {
      val folder = externalsFolder.path / "typescript" / "lib"
      StdLibSource(InFolder(folder), List(InFile(folder / "lib.esnext.full.d.ts")), TsIdent.std)
    }

    // keep as `val`, it comes with a cache meaning we reuse the work of the first two phases for all flavours
    val CommonPhases = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          calculateLibraryVersion = new DTVersions(lastChangedIndex),
          resolve                 = new LibraryResolver(stdLibSource, Seq(dtFolder, externalsFolder), None),
          ignored                 = Libraries.ignored(config.sequential),
          ignoredModulePrefixes   = Set.empty,
          stdlibSource            = stdLibSource,
          pedantic                = config.pedantic,
          parser =
            if (config.enableParseCache)
              PersistingFunction(nameAndMtimeUnder(files.existing(config.cacheFolder / 'parse)), logger.void)(
                parseFile,
              )
            else parseFile,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(config.pedantic, PrettyString.Regular), "scala.js")

    config.flavours.foreach { flavour =>
      val bintray                                = bintrayFor(flavour)
      val publishUser                            = bintray.fold("oyvindberg")(_.user)
      val localCleaningF                         = localCleaning(flavour)
      val updatedTargetDirF                      = updatedTargetDir(flavour)
      val tsSourcesFF                            = tsSourcesF(externalsFolderF, dtFolderF, updatedTargetDirF)
      val ()                                     = Await.result(localCleaningF, Duration.Inf)
      val TargetDirs(targetFolder, facadeFolder) = Await.result(updatedTargetDirF, Duration.Inf)
      val tsSources                              = Await.result(tsSourcesFF, Duration.Inf)

      val Pipeline: RecPhase[Source, PublishedSbtProject] =
        CommonPhases
          .next(new PhaseFlavour(flavour, PrettyString.Regular), flavour.toString)
          .next(
            new Phase3Compile(
              resolve         = new LibraryResolver(stdLibSource, Seq(dtFolder, externalsFolder), Some(InFolder(facadeFolder))),
              versions        = config.versions,
              compiler        = compiler,
              targetFolder    = targetFolder,
              projectName     = flavour.projectName,
              organization    = flavour.organization,
              publishUser     = publishUser,
              publishFolder   = config.publishFolder,
              metadataFetcher = Npmjs.GigahorseFetcher(files.existing(config.cacheFolder / 'npmjs))(ec),
              softWrites      = config.softWrites,
              flavour         = flavour,
            ),
            "build",
          )
          .nextOpt(bintray.map(Phase4Publish), "publish")

      val results: Map[Source, PhaseRes[Source, PublishedSbtProject]] =
        Interface(config.debugMode, storingErrorLogger) {
          case listener if config.sequential =>
            tsSources.toVector
              .map(source => source -> PhaseRunner.go(Pipeline, source, Nil, logRegistry.get, listener))
              .toMap

          case listener =>
            val par = tsSources.toVector.par
            par.tasksupport = new ForkJoinTaskSupport(pool)
            par
              .map(source => source -> PhaseRunner.go(Pipeline, source, Nil, logRegistry.get, listener))
              .seq
              .toMap

        }

      val successes: Set[PublishedSbtProject] = {
        def go(p: PublishedSbtProject): Set[PublishedSbtProject] =
          p.project.deps.values.flatMap(go).to[Set] + p

        results.collect { case (_, PhaseRes.Ok(res)) => go(res) }.flatten.to[Set]
      }

      val summary               = Summary(results)
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

      val summaryFile = targetFolder / Summary.path

      val formattedDiff: String = {
        val existingOpt = Try(Json[Summary](summaryFile)).toOption
        val diff        = Summary.diff(BuildInfo.gitSha.take(6), existingOpt, summary)
        Json.persist(summaryFile)(summary)
        Summary.formatDiff(diff)
      }
      interfaceLogger.warn(formattedDiff)

      if (config.debugMode && !config.forceCommit) {
        interfaceLogger warn s"Not committing because of non-empty args ${config.wantedLibNames.mkString(", ")}"
      } else {
        interfaceLogger warn "Generating sbt plugin..."

        val sbtProjectDir = targetFolder / s"sbt-${flavour.projectName}"
        GenerateSbtPlugin(
          versions      = config.versions,
          organization  = flavour.organization,
          projectName   = flavour.projectName,
          projectDir    = sbtProjectDir,
          projects      = successes,
          pluginVersion = config.runId,
          publishUser   = publishUser,
          action        = if (bintray.isDefined) "^publish" else "publishLocal",
        )

        CommitChanges(
          interfaceCmd,
          summary,
          successes.map(_.project.baseDir).to[Seq],
          Seq(
            sbtProjectDir,
            readme,
            librariesByScore,
            librariesByName,
            librariesByDependents,
            gitIgnore,
            summaryFile,
          ),
          formattedDiff,
        )(targetFolder)
      }
    }

    pool.shutdown()

    interfaceLogger warn "Writing logs"

    logRegistry.logs.foreach {
      case (libName, storeds) =>
        val failLog = files.existingEmpty(config.cacheFolder / 'failures) / os.RelPath(libName.`__value` + ".log")

        storeds.underlying.filter(_.metadata.logLevel === LogLevel.error) match {
          case empty if empty.isEmpty =>
            Try(os.remove.all(failLog))
          case errors =>
            files.softWrite(failLog) { w1 =>
              errors.foreach { errorLog =>
                val str =
                  LogPatternLibrary(errorLog.message, errorLog.throwable, errorLog.metadata, errorLog.ctx).plainText
                w1.append(str)
                w1.append("\n")
              }
            }

            files.softWrite(logsFolder / os.RelPath(libName.`__value` + ".log")) { w1 =>
              storeds.underlying.foreach { stored =>
                val str = LogPatternLibrary(stored.message, stored.throwable, stored.metadata, stored.ctx).plainText
                w1.append(str)
                w1.append("\n")
              }
            }
        }
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

  case class TargetDirs(targetFolder: os.Path, facadeFolder: os.Path)
}
