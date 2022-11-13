package org.scalablytyped.converter.internal
package importer

import ammonite.ops.{%, %%, ShelloutException}
import com.olvind.logging
import com.olvind.logging.{LogLevel, LogRegistry}
import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.importer.build.{BloopCompiler, PublishedSbtProject}
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.flavours._
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.ts._
import org.scalatest.Assertion
import org.scalatest.funsuite.AnyFunSuite

import java.io.StringWriter
import java.nio.file.Files
import scala.collection.immutable.SortedMap
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}
import scala.util.{Failure, Success, Try}

private object GitLock

sealed trait Mode
object Mode {
  val isCi        = sys.env.contains("CI")
  val isRelease   = sys.env.contains("CI_COMMIT_TAG")
  val isLocalhost = !isCi
  def releaseOnly = if (isLocalhost || isRelease) RunDontStore else Skip
  def normal      = Normal(update = isLocalhost) // update files locally but not in CI

  object Skip extends Mode
  sealed abstract class Run(val update:  Boolean) extends Mode
  case class Normal(override val update: Boolean) extends Run(update)
  object RunDontStore extends Run(false)
}

trait ImporterHarness extends AnyFunSuite {
  val baseDir = sys.env.get("CI_TEST_CACHE") match {
    case Some(value) if value.startsWith("/") || value.contains(":") =>
      os.Path(value)
    case Some(value) =>
      os.pwd / os.RelPath(value)
    case None =>
      constants.defaultCacheFolder / 'tests
  }
  val failureCacheDir = baseDir / 'compileFailures
  os.makeDir.all(failureCacheDir)

  val testLogger = logging.stdout.filter(LogLevel.warn)
  def version: Versions
  def mode:    Mode

  private lazy val bloop = Await.result(
    BloopCompiler(testLogger, version, Some(failureCacheDir.toNIO))(ExecutionContext.Implicits.global),
    Duration.Inf,
  )

  private def runImport(
      source:             InFolder,
      targetFolder:       os.Path,
      pedantic:           Boolean,
      logRegistry:        LogRegistry[LibTsSource, TsIdentLibrary, StringWriter],
      publishLocalFolder: os.Path,
      flavour:            FlavourImpl,
      maybePrivateWithin: Option[Name],
  ): PhaseRes[LibTsSource, SortedMap[LibTsSource, PublishedSbtProject]] = {
    val stdLibSource: LibTsSource.StdLibSource =
      LibTsSource.StdLibSource(
        InFolder(source.path),
        IArray(InFile(source.path / "stdlib.d.ts")),
        TsIdentLibrarySimple("std"),
      )

    val allSources = Bootstrap.findSources(IArray(source))
    val ignored    = Set.empty[TsIdentLibrary]
    val resolver   = new LibraryResolver(stdLibSource, allSources, ignored)

    val phase: RecPhase[LibTsSource, PublishedSbtProject] =
      RecPhase[LibTsSource]
        .next(
          new Phase1ReadTypescript(
            resolve                 = resolver,
            calculateLibraryVersion = new DTVersions(DTLastChangedIndex.No, includeGitPart = false),
            ignored                 = ignored,
            ignoredModulePrefixes   = Set.empty,
            pedantic                = pedantic,
            parser                  = parser.parseFile,
            expandTypeMappings      = EnabledTypeMappingExpansion.DefaultSelection,
          ),
          "typescript",
        )
        .next(
          new Phase2ToScalaJs(
            pedantic,
            scalaVersion             = version.scala,
            enableScalaJsDefined     = Selection.All,
            outputPkg                = flavour.outputPkg,
            flavour                  = flavour,
            useDeprecatedModuleNames = false,
          ),
          "scala.js",
        )
        .next(new PhaseFlavour(flavour, maybePrivateWithin), flavour.toString)
        .next(
          new Phase3Compile(
            versions                   = version,
            compiler                   = bloop,
            targetFolder               = targetFolder,
            organization               = "org.scalablytyped",
            publishLocalFolder         = publishLocalFolder,
            metadataFetcher            = Npmjs.No,
            softWrites                 = true,
            flavour                    = flavour,
            generateScalaJsBundlerFile = true,
            ensureSourceFilesWritten   = true,
          ),
          "build",
        )

    val results: SortedMap[LibTsSource, PhaseRes[LibTsSource, PublishedSbtProject]] =
      allSources
        .map(s => (s: LibTsSource) -> PhaseRunner(phase, logRegistry.get, PhaseListener.NoListener)(s))
        .toMap
        .toSorted

    PhaseRes.sequenceMap(results).map(PublishedSbtProject.Unpack.apply)
  }

  def findTestFolder(testName: String): InFolder = {
    def go(p: os.Path): os.Path =
      if (files.exists(p / "build.sbt")) p / "tests" / testName
      else if (p == os.root) sys.error("couldnt find test folder")
      else go(p / os.up)

    InFolder(go(os.pwd))
  }

  def assertImportsOk(
      testName: String,
      pedantic: Boolean,
      flavour: FlavourImpl = NormalFlavour(
        shouldUseScalaJsDomTypes = false,
        enableLongApplyMethod    = false,
        outputPkg                = Name.typings,
        versions                 = version,
      ),
      maybePrivateWithin: Option[Name] = None,
  ): Assertion =
    mode match {
      case Mode.Skip => pending
      case run: Mode.Run =>
        val testFolder   = findTestFolder(testName)
        val source       = InFolder(testFolder.path / 'in)
        val targetFolder = os.Path(Files.createTempDirectory("scalablytyped-test-"))

        val flavourFolderPart = flavour match {
          case _: NormalFlavour       => "check"
          case _: SlinkyFlavour       => "check-slinky"
          case _: SlinkyNativeFlavour => "check-slinky-native"
          case _: JapgollyFlavour     => "check-japgolly"
          case other => sys.error(s"Unexpected $other")
        }

        val checkFolder = testFolder.path / (s"$flavourFolderPart-${version.scala.binVersion}")

        val logRegistry =
          new LogRegistry[LibTsSource, TsIdentLibrary, StringWriter](
            testLogger,
            _.libName,
            _ => logging.appendable(new StringWriter()),
          )

        val publishFolder = baseDir / "artifacts" / testName

        runImport(source, targetFolder, pedantic, logRegistry, publishFolder, flavour, maybePrivateWithin) match {
          case PhaseRes.Ok(_) if run == Mode.RunDontStore => succeed
          case PhaseRes.Ok(_) =>
            implicit val wd = os.pwd

            /* we don't checkin these files, so also don't compare them */
            os.walk(targetFolder).foreach {
              case x if x.last == ".bloop" => files.deleteAll(x)
              case _                       => ()
            }

            if (run.update) {
              if (!os.isDir(targetFolder) && os.list(targetFolder).isEmpty) {
                fail("There is nothing to copy from target into check, something failed upstream")
              }
              files.deleteAll(checkFolder)
              os.copy(targetFolder, checkFolder)
              GitLock.synchronized(%("git", "add", checkFolder))
            }

            Try(%%("diff", "-Naur", checkFolder, targetFolder)) match {
              case Success(_) => if (run.update) pending else succeed
              case Failure(th: ShelloutException) =>
                val diff = %%("diff", "-r", checkFolder, targetFolder).out.string
                fail(s"Output for test $testFolder was not as expected : $diff", th)
              case Failure(th) => throw th
            }

          case PhaseRes.Failure(errors) =>
            if (run.update) {
              implicit val wd = os.pwd
              if (os.isDir(targetFolder) && os.list(targetFolder).isEmpty) {
                fail("There is nothing to copy from target into check, something failed upstream")
              }
              files.deleteAll(checkFolder)
              os.copy(targetFolder, checkFolder)
              synchronized(%("git", "add", checkFolder))
            }
            errors.foreach {
              case (fromSource, detail) =>
                logRegistry.logs.foreach {
                  case (name, logger) =>
                    println(("-" * 10) + name)
                    println(logger.underlying.toString)
                }

                detail match {
                  case Left(th)   => fail(s"Could not import $fromSource", th)
                  case Right(msg) => fail(s"Could not import $fromSource: $msg")
                }
            }
            fail("should not happen")

          case PhaseRes.Ignore() =>
            pending
        }
    }
}
