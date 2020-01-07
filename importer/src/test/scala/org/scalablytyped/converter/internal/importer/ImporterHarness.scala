package org.scalablytyped.converter.internal
package importer

import java.io.StringWriter
import java.nio.file.Files

import ammonite.ops.{%, %%, ShelloutException}
import com.olvind.logging
import com.olvind.logging.{LogLevel, LogRegistry}
import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.importer.Source.{StdLibSource, TsLibSource}
import org.scalablytyped.converter.internal.importer.build.{BloopCompiler, PublishedSbtProject, Versions}
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.Name
import org.scalablytyped.converter.internal.scalajs.flavours.Flavour
import org.scalablytyped.converter.internal.ts._
import org.scalatest.{Assertion, FunSuiteLike}

import scala.collection.immutable.{SortedMap, TreeMap}
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

private object GitLock

trait ImporterHarness extends FunSuiteLike {
  val failureCacheDir = os.root / 'tmp / 'scalablytyped / 'compileFailures
  os.makeDir.all(failureCacheDir)

  private val testLogger = logging.stdout.filter(LogLevel.error)
  private val testCmd    = new Cmd(testLogger, None)
  private val version    = Versions.`scala 2.12 with scala.js 0.6`
  private val bloop      = BloopCompiler(testLogger, version, ExecutionContext.Implicits.global, failureCacheDir)

  val OutputPkg:  Name                  = Name("typings")
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  private def runImport(
      source:        InFolder,
      targetFolder:  os.Path,
      pedantic:      Boolean,
      logRegistry:   LogRegistry[Source, TsIdentLibrary, StringWriter],
      publishFolder: os.Path,
      flavour:       Flavour,
  ): PhaseRes[Source, SortedMap[Source, PublishedSbtProject]] = {
    val stdLibSource: StdLibSource =
      StdLibSource(InFolder(source.path), IArray(InFile(source.path / "stdlib.d.ts")), TsIdentLibrarySimple("std"))

    val resolve          = new LibraryResolver(stdLibSource, IArray(source), None)
    val lastChangedIndex = DTLastChangedIndex(testCmd, source.path)

    val phase: RecPhase[Source, PublishedSbtProject] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            resolve                 = resolve,
            calculateLibraryVersion = new DTVersions(lastChangedIndex),
            ignored                 = Set.empty,
            ignoredModulePrefixes   = Set.empty,
            stdlibSource            = stdLibSource,
            pedantic                = pedantic,
            parser                  = parser.parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(pedantic, PrettyString.Regular, enableScalaJsDefined = Selection.None), "scala.js")
        .next(new PhaseFlavour(flavour, PrettyString.Regular), flavour.toString)
        .next(
          new Phase3Compile(
            resolve         = resolve,
            versions        = version,
            compiler        = bloop,
            targetFolder    = targetFolder,
            projectName     = "ScalablyTyped",
            organization    = "org.scalablytyped",
            publishUser     = "oyvindberg",
            publishFolder   = publishFolder,
            metadataFetcher = Npmjs.No,
            softWrites      = false,
            flavour         = flavour,
          ),
          "build",
        )

    val found: Set[TsLibSource] =
      TypescriptSources.forFolder(InFolder(source.path), Set.empty)

    PhaseRes.sequenceMap(
      TreeMap.empty[TsLibSource, PhaseRes[Source, PublishedSbtProject]] ++ found
        .map(s => s -> PhaseRunner(phase, logRegistry.get, NoListener)(s)),
    )
  }

  def assertImportsOk(
      testName: String,
      pedantic: Boolean,
      update:   Boolean,
      flavour:  Flavour = Flavour.Normal(true),
  ): Assertion = {
    val testFolder = getClass.getClassLoader.getResource(testName) match {
      case null  => sys.error(s"Could not find test resource folder $testName")
      case other =>
        // The test can be run from various working directories, so find the correct directory this way :/
        InFolder(os.Path(other.getFile) / os.up / os.up / os.up / os.up / 'src / 'test / 'resources / testName)
    }
    val source       = InFolder(testFolder.path / 'in)
    val targetFolder = os.Path(Files.createTempDirectory("scalablytyped-test-"))
    val checkFolder = testFolder.path / (flavour match {
      case Flavour.Plain           => "check-plain"
      case Flavour.Normal(_)       => "check"
      case Flavour.Slinky(_)       => "check-slinky"
      case Flavour.SlinkyNative(_) => "check-slinky-native"
      case Flavour.Japgolly(_)     => "check-japgolly"
    })

    val logRegistry =
      new LogRegistry[Source, TsIdentLibrary, StringWriter](
        testLogger,
        _.libName,
        _ => logging.appendable(new StringWriter()),
      )

    val publishFolder = os.root / 'tmp / "scalablytyped-published-tests" / testName

    runImport(source, targetFolder, pedantic, logRegistry, publishFolder, flavour) match {
      case PhaseRes.Ok(_) =>
        implicit val wd = os.pwd

        /* we don't checkin these files, so also don't compare them */
        os.walk(targetFolder).foreach {
          case x if x.last == ".bloop" => os.remove.all(x)
          case _                       => ()
        }

        if (update) {
          if (!os.isDir(targetFolder) && os.list(targetFolder).isEmpty) {
            fail("There is nothing to copy from target into check, something failed upstream")
          }
          os.remove.all(checkFolder)
          os.copy(targetFolder, checkFolder)
          GitLock.synchronized(%("git", "add", checkFolder))
        }

        Try(%%("diff", "-Naur", checkFolder, targetFolder)) match {
          case Success(_) => if (update) pending else succeed
          case Failure(th: ShelloutException) =>
            val diff = %%("diff", "-r", checkFolder, targetFolder).out.string
            fail(s"Output for test $testFolder was not as expected : $diff", th)
          case Failure(th) => throw th
        }

      case PhaseRes.Failure(errors) =>
        if (update) {
          implicit val wd = os.pwd
          if (os.isDir(targetFolder) && os.list(targetFolder).isEmpty) {
            fail("There is nothing to copy from target into check, something failed upstream")
          }
          os.remove.all(checkFolder)
          os.copy(targetFolder, checkFolder)
          synchronized(%("git", "add", checkFolder))
        }
        errors foreach {
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
