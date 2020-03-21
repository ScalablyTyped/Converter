package org.scalablytyped.converter.internal
package importer

import java.io.FileWriter
import java.nio.file.Path
import java.time.LocalDateTime
import java.util.concurrent._

import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import org.scalablytyped.converter.internal.importer.Source.StdLibSource
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.importer.documentation.{NpmjsFetcher, Readme, TopLists}
import org.scalablytyped.converter.internal.importer.jsonCodecs._
import org.scalablytyped.converter.internal.phases.{PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.sets.SetOps
import org.scalablytyped.converter.internal.ts._
import org.scalablytyped.converter.{Flavour, Selection}

import scala.collection.immutable.SortedSet
import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.Try

object Ci {
  case class TargetDirs(targetFolder: os.Path, facadeFolder: os.Path)

  case class Paths(
      bintray:       Path,
      npmjs:         Path,
      parseCache:    Option[Path],
      cacheFolder:   os.Path,
      publishFolder: os.Path,
  )

  case class Config(
      shared:           SharedInput,
      publish:          Option[PublishConfig],
      offline:          Boolean,
      pedantic:         Boolean,
      parallel:         Boolean,
      forceCommit:      Boolean,
      conserveSpace:    Boolean,
      enableParseCache: Boolean,
      dontCleanProject: Boolean,
      softWrites:       Boolean, // only overwrite changed files to play better with tooling like intellij
      debugMode:        Boolean,
      projectName:      String,
      repo:             String,
      organization:     String,
  ) {
    // change in source code for now, lazy...
    val parallelLibraries = 20
    val parallelScalas    = 4
  }

  object Config {
    def unapply(args: Array[String]): Some[Config] =
      args partition (_ startsWith "-") match {
        case (flags, rest) =>
          val publish: Option[PublishConfig] = if (flags contains "-publish") {
            val values: Map[String, String] =
              files
                .content(InFile(os.home / ".bintray" / ".credentials"))
                .split("\n")
                .map(_.split("=").map(_.trim).filter(_.nonEmpty).toList)
                .collect { case List(k, v) => (k, v) }
                .toMap

            Some(PublishConfig(values("user"), values("password")))
          } else None

          val wantedLibNames
              : Set[TsIdentLibrary] = (if (flags contains "-demoSet") Libraries.DemoSet else Set()) ++ rest
            .map(TsIdentLibrary.apply)

          val shouldUseScalaJsDomTypes = flags contains "-useScalaJsDomTypes"

          val (flavour: Flavour, outputPackage: Name, projectName: String, repo: String, organization: String) =
            if (flags.contains("-flavourSlinky"))
              (
                Flavour.Slinky,
                Name("typingsSlinky"),
                "SlinkyTyped",
                "https://github.com/ScalablyTyped/SlinkyTyped.git",
                "org.scalablytyped.slinky",
              )
            else if (flags.contains("-flavourSlinkyNative"))
              (
                Flavour.SlinkyNative,
                Name("typingsSlinky"),
                "SlinkyNativeTyped",
                "https://github.com/ScalablyTyped/SlinkyNativeTypes.git",
                "org.scalablytyped.slinkynative",
              )
            else if (flags.contains("-flavourJapgolly"))
              (
                Flavour.Japgolly,
                Name("typingsJapgolly"),
                "ScalajsReactTyped",
                "https://github.com/ScalablyTyped/ScalajsReactTyped.git",
                "org.scalablytyped.japgolly",
              )
            else
              (
                Flavour.Normal,
                Name.typings,
                "ScalablyTyped",
                "https://github.com/oyvindberg/ScalablyTyped.git",
                "org.scalablytyped",
              )

          val enableScalaJsDefined: Selection[TsIdentLibrary] =
            if (flags contains "-enableScalaJsDefined")
              Selection.AllExcept(Libraries.Slow.to[Seq]: _*)
            else Selection.None

          val isParallel = flags contains "-parallel"

          val ignoredLibs: Set[TsIdentLibrary] =
            Libraries.ignored(!isParallel)

          Some(
            Config(
              shared = SharedInput(
                shouldUseScalaJsDomTypes = shouldUseScalaJsDomTypes,
                outputPackage            = outputPackage,
                enableScalaJsDefined     = enableScalaJsDefined,
                flavour                  = flavour,
                wantedLibs               = wantedLibNames,
                ignoredLibs              = ignoredLibs,
                ignoredModulePrefixes    = Set(),
                stdLibs                  = IArray("esnext.full"),
                expandTypeMappings       = EnabledTypeMappingExpansion.DefaultSelection,
                versions = Versions(
                  if (flags contains "-scala212") Versions.Scala212 else Versions.Scala213,
                  if (flags contains ("-scalajs1")) Versions.ScalaJs1 else Versions.ScalaJs06,
                ),
              ),
              publish          = publish,
              offline          = flags contains "-offline",
              pedantic         = flags contains "-pedantic",
              parallel         = isParallel,
              forceCommit      = flags contains "-forceCommit",
              conserveSpace    = flags contains "-conserveSpace",
              enableParseCache = flags contains "-enableParseCache",
              dontCleanProject = flags contains "-dontCleanProject",
              softWrites       = flags contains "-softWrites",
              debugMode        = wantedLibNames.nonEmpty || (flags contains "-debugMode"),
              projectName      = projectName,
              repo             = repo,
              organization     = organization,
            ),
          )
      }
  }
}

class Ci(config: Ci.Config, paths: Ci.Paths) {
  val RunId                      = constants.DateTimePattern format LocalDateTime.now
  val t0                         = System.currentTimeMillis
  private val pool               = new ForkJoinPool(config.parallelLibraries)
  private val ec                 = ExecutionContext.fromExecutorService(pool)
  private val storingErrorLogger = logging.storing()
  private val logsFolder         = files.existing(paths.cacheFolder / 'logs)

  private val logger = {
    val logFile = new FileWriter((logsFolder / s"${RunId}.log").toIO)
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

  def updatedTargetDir(): Future[Ci.TargetDirs] =
    Future {
      val projectFolder = paths.cacheFolder / config.projectName
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
          implicit val wd = paths.cacheFolder
          interfaceCmd.runVerbose git ('clone, config.repo)
        } recover {
          case _ =>
            os.makeDir(projectFolder)

            implicit val wd = projectFolder
            interfaceCmd.runVerbose git 'init
            interfaceCmd.runVerbose git ("remote", "add", "origin", config.repo)
        }

      Ci.TargetDirs(targetFolder = projectFolder, facadeFolder = files.existing(projectFolder / 'facades))
    }(ec)

  def bintrayFor(projectName: String, repo: String, cachePath: Path): Option[BinTrayPublisher] =
    config.publish.map {
      case PublishConfig(user, password) => BinTrayPublisher(cachePath, repo, user, password, projectName)(ec)
    }

  def tsSourcesF(
      externalsFolderF:  Future[InFolder],
      dtFolderF:         Future[InFolder],
      updatedTargetDirF: Future[Ci.TargetDirs],
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
        TypescriptSources(externalsFolder, dtFolder, config.shared.ignoredLibs).sorted ++ facadeSources,
        config.shared.wantedLibs,
      ) match {
        case (sources, sets.EmptySet()) => sources
        case (sources, wantedLibs)      => sources.filter(s => wantedLibs(s.libName))
      }
    }
  }

  def run(): Unit = {
    val compilerF: Future[BloopCompiler] =
      BloopCompiler(
        logger                = logger.filter(LogLevel.debug).void,
        v                     = config.shared.versions,
        failureCacheFolderOpt = Some((paths.cacheFolder / 'compileFailures).toNIO),
      )(ec)

    val dtFolderF: Future[InFolder] =
      Future(
        DTUpToDate(interfaceCmd, config.offline, paths.cacheFolder, constants.DefinitelyTypedRepo),
      )(ec)

    val externalsFolderF: Future[InFolder] =
      dtFolderF.map { dtFolder =>
        val external: NotNeededPackages =
          Json.force[NotNeededPackages](dtFolder.path / os.up / "notNeededPackages.json")

        UpToDateExternals(
          interfaceLogger,
          interfaceCmd,
          files.existing(paths.cacheFolder / 'npm),
          external.packages
            .map(_.typingsPackageName)
            .toSet + TsIdentLibrary("typescript") ++ Libraries.extraExternals,
          config.shared.ignoredLibs,
          config.conserveSpace,
          config.offline,
        )
      }(ec)

    val lastChangedIndexF: Future[DTLastChangedIndex] =
      dtFolderF.map { dtFolder =>
        interfaceLogger.warn(s"Indexing ${dtFolder.path / os.up}")
        DTLastChangedIndex(interfaceCmd, dtFolder.path / os.up)
      }(ec)

    val localCleaningF = Future {
      if (config.conserveSpace) {
        interfaceLogger.warn(s"Cleaning old artifacts in ${paths.publishFolder}")
        LocalCleanup(paths.publishFolder, config.organization, keepNum = 1)
      }
    }(ec)

    val updatedTargetDirF = updatedTargetDir()
    val tsSourcesFF       = tsSourcesF(externalsFolderF, dtFolderF, updatedTargetDirF)

    val externalsFolder                           = Await.result(externalsFolderF, Duration.Inf)
    val dtFolder                                  = Await.result(dtFolderF, Duration.Inf)
    val lastChangedIndex                          = Await.result(lastChangedIndexF, Duration.Inf)
    val compiler                                  = Await.result(compilerF, Duration.Inf)
    val ()                                        = Await.result(localCleaningF, Duration.Inf)
    val Ci.TargetDirs(targetFolder, facadeFolder) = Await.result(updatedTargetDirF, Duration.Inf)
    val tsSources                                 = Await.result(tsSourcesFF, Duration.Inf)

    val stdLibSource: StdLibSource = {
      val folder = externalsFolder.path / "typescript" / "lib"

      require(os.exists(folder), s"You must add typescript as a dependency. $folder must exist.")
      require(!config.shared.ignoredLibs.contains(TsIdent.std), "You cannot ignore std")

      StdLibSource(
        InFolder(folder),
        config.shared.stdLibs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }

    val bintray     = bintrayFor(config.projectName, config.repo, paths.bintray)
    val publishUser = bintray.fold("oyvindberg")(_.user)
    val flavour     = flavourImpl.fromInput(config.shared)

    val Pipeline: RecPhase[Source, PublishedSbtProject] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            calculateLibraryVersion = new DTVersions(lastChangedIndex),
            resolve                 = new LibraryResolver(stdLibSource, IArray(dtFolder, externalsFolder), None),
            ignored                 = config.shared.ignoredLibs,
            ignoredModulePrefixes   = config.shared.ignoredModulePrefixes,
            stdlibSource            = stdLibSource,
            pedantic                = config.pedantic,
            parser                  = PersistingParser(paths.parseCache, IArray(externalsFolder, dtFolder), logger.void),
            expandTypeMappings      = config.shared.expandTypeMappings,
          ),
          "typescript",
        )
        .next(
          new Phase2ToScalaJs(
            config.pedantic,
            enableScalaJsDefined = config.shared.enableScalaJsDefined,
            outputPkg            = config.shared.outputPackage,
          ),
          "scala.js",
        )
        .next(new PhaseFlavour(flavour), flavour.toString)
        .next(
          new Phase3Compile(
            resolve                    = new LibraryResolver(stdLibSource, IArray(dtFolder, externalsFolder), Some(InFolder(facadeFolder))),
            versions                   = config.shared.versions,
            compiler                   = compiler,
            targetFolder               = targetFolder,
            projectName                = config.projectName,
            organization               = config.organization,
            publishUser                = publishUser,
            publishFolder              = paths.publishFolder,
            metadataFetcher            = NpmjsFetcher(paths.npmjs)(ec),
            softWrites                 = config.softWrites,
            flavour                    = flavour,
            generateScalaJsBundlerFile = true,
            ensureSourceFilesWritten   = true,
          ),
          "build",
        )
        .nextOpt(bintray.map(Phase4Publish), "publish")

    val results: Map[Source, PhaseRes[Source, PublishedSbtProject]] =
      Interface(config.debugMode, storingErrorLogger) {
        case listener if config.parallel =>
          val par = tsSources.toVector.par
          par.tasksupport = new ForkJoinTaskSupport(pool)
          par
            .map(source => source -> PhaseRunner.go(Pipeline, source, Nil, logRegistry.get, listener))
            .seq
            .toMap

        case listener =>
          tsSources.toVector
            .map(source => source -> PhaseRunner.go(Pipeline, source, Nil, logRegistry.get, listener))
            .toMap
      }

    val successes: Map[Source, PublishedSbtProject] = {
      def go(source: Source, p: PublishedSbtProject): Map[Source, PublishedSbtProject] =
        Map(source -> p) ++ p.project.deps.flatMap { case (k, v) => go(k, v) }

      results.collect { case (s, PhaseRes.Ok(res)) => go(s, res) }.reduceOption(_ ++ _).getOrElse(Map.empty)
    }

    val failures: Map[Source, Either[Throwable, String]] =
      results.collect { case (_, PhaseRes.Failure(errors)) => errors }.reduceOption(_ ++ _).getOrElse(Map.empty)

    val summary               = Summary(successes.keys.to[Set].map(_.libName), failures.keys.to[Set].map(_.libName))
    val lists                 = TopLists(successes.values.to[Set])
    val gitIgnore             = targetFolder / ".gitignore"
    val readme                = targetFolder / "readme.md"
    val librariesByName       = targetFolder / "libraries_by_name.md"
    val librariesByScore      = targetFolder / "libraries_by_score.md"
    val librariesByDependents = targetFolder / "libraries_by_dependents.md"

    val locOutput = Try(interfaceCmd.run('loc)(targetFolder)).toOption.map(_.out.string)
    files.softWrite(readme)(_.print(Readme(summary, RunId, locOutput)))
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
      val existingOpt = Try(Json.force[Summary](summaryFile)).toOption
      val diff        = Summary.diff(BuildInfo.gitSha.take(6), existingOpt, summary)
      Json.persist(summaryFile)(summary)
      Summary.formatDiff(diff)
    }
    interfaceLogger.warn(formattedDiff)
    val td = System.currentTimeMillis - t0
    interfaceLogger warn td

    if (config.debugMode && !config.forceCommit) {
      interfaceLogger warn s"Not committing because of non-empty args ${config.shared.wantedLibs.mkString(", ")}"
    } else {
      interfaceLogger warn "Generating sbt plugin..."

      val sbtProjectDir = targetFolder / s"sbt-${config.projectName}"

      GenerateSbtPlugin(
        versions      = config.shared.versions,
        organization  = config.organization,
        projectName   = config.projectName,
        projectDir    = sbtProjectDir,
        projects      = successes.values.to[Set],
        pluginVersion = RunId,
        publishUser   = publishUser,
        action        = if (bintray.isDefined) "^publish" else "publishLocal",
      )

      CommitChanges(
        interfaceCmd,
        summary,
        successes.values.map(_.project.baseDir).to[Vector],
        Vector(sbtProjectDir, readme, librariesByScore, librariesByName, librariesByDependents, gitIgnore, summaryFile),
        formattedDiff,
      )(targetFolder)
    }

    pool.shutdown()

    interfaceLogger warn "Writing logs"

    logRegistry.logs.foreach {
      case (libName, storeds) =>
        val failLog = files.existingEmpty(paths.cacheFolder / 'failures) / os.RelPath(libName.`__value` + ".log")

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
  }
}
