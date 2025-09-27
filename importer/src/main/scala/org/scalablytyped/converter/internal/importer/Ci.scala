package org.scalablytyped.converter
package internal
package importer

import java.io.FileWriter
import java.net.URI
import java.nio.file.Path
import java.time.LocalDateTime
import java.util.concurrent._

import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.importer.documentation.{NpmjsFetcher, Readme, TopLists}
import org.scalablytyped.converter.internal.phases.{PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.ts._

import scala.collection.immutable.SortedSet
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.Try

object Ci {

  case class Paths(
      npmjs:              Path,
      parseCache:         Option[Path],
      cacheFolder:        os.Path,
      publishLocalFolder: os.Path,
      gitCache:           os.Path,
  )

  case class Config(
      conversion:       ConversionOptions,
      wantedLibs:       SortedSet[TsIdentLibrary],
      offline:          Boolean,
      pedantic:         Boolean,
      forceCommit:      Boolean,
      conserveSpace:    Boolean,
      enableParseCache: Boolean,
      dontCleanProject: Boolean,
      softWrites:       Boolean, // only overwrite changed files to play better with tooling like intellij
      debugMode:        Boolean,
      projectName:      ProjectName,
      repo:             URI,
      benchmark:        Boolean,
  ) {
    // change in source code for now, lazy...
    val parallelLibraries = 20
    val parallelScalas    = 4
  }

  object Config {
    def unapply(args: Array[String]): Some[Config] =
      args.partition(_.startsWith("-")) match {
        case (flags, rest) =>
          val wantedLibNames: SortedSet[TsIdentLibrary] =
            (if (flags contains "-demoSet") Libraries.DemoSet else SortedSet[TsIdentLibrary]()) ++ rest.map(
              TsIdentLibrary.apply,
            )

          val shouldUseScalaJsDomTypes = flags contains "-useScalaJsDomTypes"

          val (flavour: Flavour, outputPackage: Name, projectName, repo, organization: String) =
            if (flags.contains("-flavourSlinky"))
              (
                Flavour.Slinky,
                Name("typingsSlinky"),
                ProjectName("SlinkyTyped"),
                new URI("https://github.com/ScalablyTyped/SlinkyTyped.git"),
                "org.scalablytyped.slinky",
              )
            else if (flags.contains("-flavourSlinkyNative"))
              (
                Flavour.SlinkyNative,
                Name("typingsSlinky"),
                ProjectName("SlinkyNativeTyped"),
                new URI("https://github.com/ScalablyTyped/SlinkyNativeTypes.git"),
                "org.scalablytyped.slinkynative",
              )
            else if (flags.contains("-flavourJapgolly"))
              (
                Flavour.ScalajsReact,
                Name("typingsJapgolly"),
                ProjectName("ScalajsReactTyped"),
                new URI("https://github.com/ScalablyTyped/ScalajsReactTyped.git"),
                "org.scalablytyped.japgolly",
              )
            else
              (
                Flavour.Normal,
                Name.typings,
                ProjectName("ScalablyTyped"),
                new URI("https://github.com/oyvindberg/ScalablyTyped.git"),
                "org.scalablytyped",
              )

          Some(
            Config(
              conversion = ConversionOptions(
                useScalaJsDomTypes   = shouldUseScalaJsDomTypes,
                outputPackage        = outputPackage,
                enableScalaJsDefined = Selection.All,
                flavour              = flavour,
                ignored              = Libraries.ignored.map(_.value),
                stdLibs              = SortedSet("esnext.full"),
                expandTypeMappings   = EnabledTypeMappingExpansion.DefaultSelection,
                versions = Versions(
                  if (flags contains "-scala213") Versions.Scala213
                  else if (flags contains "-scala212") Versions.Scala212
                  else Versions.Scala3,
                  Versions.ScalaJs1,
                ),
                organization             = organization,
                enableReactTreeShaking   = Selection.None,
                enableLongApplyMethod    = false,
                privateWithin            = None,
                useDeprecatedModuleNames = false,
              ),
              wantedLibs       = wantedLibNames,
              offline          = flags contains "-offline",
              pedantic         = flags contains "-pedantic",
              forceCommit      = flags contains "-forceCommit",
              conserveSpace    = flags contains "-conserveSpace",
              enableParseCache = flags contains "-enableParseCache",
              dontCleanProject = flags contains "-dontCleanProject",
              softWrites       = flags contains "-softWrites",
              debugMode        = wantedLibNames.nonEmpty || (flags contains "-debugMode"),
              projectName      = projectName,
              repo             = repo,
              benchmark        = flags contains "-benchmark",
            ),
          )
      }
  }
}

class Ci(config: Ci.Config, paths: Ci.Paths, pool: ForkJoinPool, ec: ExecutionContext) {
  val RunId              = constants.DateTimePattern.format(LocalDateTime.now)
  private val logsFolder = files.existing(paths.cacheFolder / 'logs)

  private val logger = {
    val logFile = new FileWriter((logsFolder / s"${RunId}.log").toIO)
    val base    = logging.appendable(logFile)
    if (config.debugMode) base.zipWith(logging.stdout) else base
  }

  /* we use this to always output to stdout during initialization (before the user interface comes up) */
  private val interfaceLogger = if (config.debugMode) logger.void else logging.stdout
  private val interfaceCmd    = new Cmd(interfaceLogger, None)

  val logRegistry = new LogRegistry[LibTsSource, TsIdentLibrary, Array[Stored]](
    logger.filter(LogLevel.warn).syncAccess.void,
    _.libName,
    _ => logging.storing().filter(LogLevel.warn),
  )

  def updatedTargetDir(): Future[os.Path] =
    Future {
      val projectFolder = paths.cacheFolder / config.projectName.value
      if (files.exists(projectFolder)) {
        implicit val wd = projectFolder
        if (!config.offline) {
          Try(interfaceCmd.runVerbose.git('fetch))
        }
        if (!config.dontCleanProject) {
          Try(interfaceCmd.runVerbose.git("clean", "-fdX")) // remove ignored files/folders
          Try(interfaceCmd.runVerbose.git("clean", "-fd"))
          Try(interfaceCmd.runVerbose.git('reset, "--hard", "origin/master"))
          Try(files.deleteAll(projectFolder / ".git/gc.log"))
          Try(interfaceCmd.runVerbose.git('prune))
        }
      } else
        Try {
          implicit val wd = paths.cacheFolder
          interfaceCmd.runVerbose.git('clone, config.repo.toString)
        }.recover {
          case _ =>
            os.makeDir(projectFolder)

            implicit val wd = projectFolder
            interfaceCmd.runVerbose.git('init)
            interfaceCmd.runVerbose.git("remote", "add", "origin", config.repo.toString)
        }

      projectFolder
    }(ec)

  def bootstrappedF(
      externalsFolderF: Future[InFolder],
      dtFolderF:        Future[InFolder],
  ): Future[Bootstrap.Bootstrapped] = {
    implicit val s = ec
    for {
      externalsFolder <- externalsFolderF
      dtFolder <- dtFolderF
    } yield Bootstrap.forCi(externalsFolder, dtFolder, config.conversion, config.wantedLibs)
  }

  val compilerF: Future[BloopCompiler] =
    BloopCompiler(
      logger                = logger.filter(LogLevel.debug).void,
      v                     = config.conversion.versions,
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

      val wanted = external.packages
        .map(_._2.libraryName)
        .toSet + TsIdentLibrary("typescript") ++ Libraries.extraExternals

      UpToDateExternals(
        interfaceLogger,
        interfaceCmd,
        files.existing(paths.cacheFolder / 'npm),
        wanted -- config.conversion.ignoredLibs,
        config.conserveSpace,
        config.offline,
      )
    }(ec)

  val lastChangedIndexF: Future[DTLastChangedIndex] =
    dtFolderF.map { dtFolder =>
      interfaceLogger.warn(s"Indexing ${dtFolder.path / os.up}")
      DTLastChangedIndex(interfaceCmd, dtFolder.path / os.up, paths.gitCache)
    }(ec)

  val localCleaningF = Future {
    if (config.conserveSpace) {
      interfaceLogger.warn(s"Cleaning old artifacts in ${paths.publishLocalFolder}")
      LocalCleanup(paths.publishLocalFolder, config.conversion.organization, keepNum = 1)
    }
  }(ec)

  val updatedTargetDirF = updatedTargetDir()

  def run(): Option[Long] = {
    val externalsFolder  = Await.result(externalsFolderF, Duration.Inf)
    val dtFolder         = Await.result(dtFolderF, Duration.Inf)
    val lastChangedIndex = Await.result(lastChangedIndexF, Duration.Inf)
    val compiler         = Await.result(compilerF, Duration.Inf)
    val ()               = Await.result(localCleaningF, Duration.Inf)
    val targetFolder     = Await.result(updatedTargetDirF, Duration.Inf)
    val bootstrapped     = Await.result(bootstrappedF(externalsFolderF, dtFolderF), Duration.Inf)

    val t0 = System.currentTimeMillis

    val Pipeline: RecPhase[LibTsSource, PublishedSbtProject] =
      RecPhase[LibTsSource]
        .next(
          new Phase1ReadTypescript(
            calculateLibraryVersion = new DTVersions(lastChangedIndex, includeGitPart = true),
            resolve                 = bootstrapped.libraryResolver,
            ignored                 = config.conversion.ignoredLibs,
            ignoredModulePrefixes   = config.conversion.ignoredModulePrefixes,
            pedantic                = config.pedantic,
            parser                  = PersistingParser(paths.parseCache, IArray(externalsFolder, dtFolder), logger.void),
            expandTypeMappings      = config.conversion.expandTypeMappings,
          ),
          "typescript",
        )
        .next(
          new Phase2ToScalaJs(
            config.pedantic,
            scalaVersion             = config.conversion.versions.scala,
            enableScalaJsDefined     = config.conversion.enableScalaJsDefined,
            outputPkg                = config.conversion.outputPackage,
            flavour                  = config.conversion.flavourImpl,
            useDeprecatedModuleNames = config.conversion.useDeprecatedModuleNames,
          ),
          "scala.js",
        )
        .next(
          new PhaseFlavour(config.conversion.flavourImpl, maybePrivateWithin = config.conversion.privateWithin),
          config.conversion.flavourImpl.toString,
        )
        .next(
          new Phase3Compile(
            versions                   = config.conversion.versions,
            compiler                   = compiler,
            targetFolder               = targetFolder,
            organization               = config.conversion.organization,
            publishLocalFolder         = paths.publishLocalFolder,
            metadataFetcher            = NpmjsFetcher(paths.npmjs)(ec),
            softWrites                 = config.softWrites,
            flavour                    = config.conversion.flavourImpl,
            generateScalaJsBundlerFile = true,
            ensureSourceFilesWritten   = true,
          ),
          "build",
        )

    val initial = bootstrapped.initialLibs match {
      case Left(unresolved) =>
        sys.error(unresolved.msg)
      case Right(sources) => sources
    }

    val results: Map[LibTsSource, PhaseRes[LibTsSource, PublishedSbtProject]] =
      Interface(config.debugMode) { listener =>
        initial
          .map(source => source -> PhaseRunner(Pipeline, logRegistry.get, listener)(source))
          .toMap
      }

    if (config.benchmark) {
      return Some(System.currentTimeMillis - t0)
    }

    val successes: Map[LibTsSource, PublishedSbtProject] = {
      def go(source: LibTsSource, p: PublishedSbtProject): Map[LibTsSource, PublishedSbtProject] =
        Map(source -> p) ++ p.project.deps.flatMap { case (k, v) => go(k, v) }

      results.collect { case (s, PhaseRes.Ok(res)) => go(s, res) }.reduceOption(_ ++ _).getOrElse(Map.empty)
    }

    val failures: Map[LibTsSource, Either[Throwable, String]] =
      results.collect { case (_, PhaseRes.Failure(errors)) => errors }.reduceOption(_ ++ _).getOrElse(Map.empty)

    val summary               = Summary(successes.keys.to(Set).map(_.libName), failures.keys.to(Set).map(_.libName))
    val lists                 = TopLists(successes.values.to(Set))
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

    if (config.debugMode && !config.forceCommit) {
      interfaceLogger.warn(s"Not committing because of non-empty args ${config.wantedLibs.mkString(", ")}")
    } else {
      interfaceLogger.warn("Generating sbt plugin...")

      val sbtProjectDir = targetFolder / s"sbt-${config.projectName.value}"

      GenerateSbtPlugin(
        isDeprecated  = true,
        organization  = config.conversion.organization,
        projectName   = config.projectName,
        projectDir    = sbtProjectDir,
        projects      = successes.values.to(Set),
        pluginVersion = RunId,
        action        = "publishLocal",
      )

      CommitChanges(
        interfaceCmd,
        summary,
        successes.values.map(_.project.baseDir).to(Vector),
        Vector(sbtProjectDir, readme, librariesByScore, librariesByName, librariesByDependents, gitIgnore, summaryFile),
        formattedDiff,
      )(targetFolder)
    }

    pool.shutdown()

    interfaceLogger.warn("Writing logs")

    logRegistry.logs.foreach {
      case (libName, storeds) =>
        val failLog = files.existingEmpty(paths.cacheFolder / 'failures) / os.RelPath(libName.`__value` + ".log")

        storeds.underlying.filter(_.metadata.logLevel === LogLevel.error) match {
          case empty if empty.isEmpty =>
            Try(files.deleteAll(failLog))
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
    None
  }
}
