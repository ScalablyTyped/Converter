package com.olvind
package tso
package importer

import java.io.StringWriter
import java.nio.file.Files

import ammonite.ops.{%, %%, ShelloutException}
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.Source.TsLibSource
import com.olvind.tso.importer.build.{BloopCompiler, PublishedSbtProject, Versions}
import com.olvind.tso.importer.documentation.Npmjs
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs.Name
import com.olvind.tso.ts._
import org.scalatest.{Assertion, FunSuiteLike}

import scala.collection.immutable.{SortedMap, TreeMap}
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

trait ImporterHarness extends FunSuiteLike {
  val failureCacheDir = os.root / 'tmp / 'tso / 'compileFailures
  os.makeDir.all(failureCacheDir)

  private val testLogger = logging.stdout.filter(LogLevel.error)
  private val testCmd    = new Cmd(testLogger, None)
  private val version    = Versions.`scala 2.13 with scala.js 1`
  private val bloop      = BloopCompiler(testLogger, version, ExecutionContext.Implicits.global, failureCacheDir)

  val OutputPkg:  Name                  = Name("typings")
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  private def runImport(
      source:        InFolder,
      targetFolder:  os.Path,
      pedantic:      Boolean,
      logRegistry:   LogRegistry[Source, TsIdentLibrary, StringWriter],
      publishFolder: os.Path,
  ): PhaseRes[Source, SortedMap[Source, PublishedSbtProject]] = {
    val stdLibSource: Source =
      Source.StdLibSource(InFile(source.path / "stdlib.d.ts"), TsIdentLibrarySimple("std"))

    val resolve          = new LibraryResolver(stdLibSource, Seq(source), None)
    val lastChangedIndex = RepoLastChangedIndex(testCmd, source.path)

    val phase: RecPhase[Source, PublishedSbtProject] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            resolve,
            new CalculateLibraryVersion(lastChangedIndex, "test"),
            Set.empty,
            stdLibSource,
            pedantic,
            parser.parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(pedantic, OutputPkg), "scala.js")
        .next(
          new Phase3Compile(
            resolve         = resolve,
            versions        = version,
            compiler        = bloop,
            targetFolder    = targetFolder,
            mainPackageName = OutputPkg,
            projectName     = "ScalablyTyped",
            organization    = "org.scalablytyped",
            publishUser     = "oyvindberg",
            publishFolder   = publishFolder,
            metadataFetcher = Npmjs.No,
            softWrites      = false,
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

  def assertImportsOk(testName: String, pedantic: Boolean, update: Boolean): Assertion = {
    val testFolder = getClass.getClassLoader.getResource(testName) match {
      case null  => sys.error(s"Could not find test resource folder $testName")
      case other =>
        // The test can be run from various working directories, so find the correct directory this way :/
        InFolder(os.Path(other.getFile) / os.up / os.up / os.up / os.up / 'src / 'test / 'resources / testName)
    }
    val source       = InFolder(testFolder.path / 'in)
    val targetFolder = os.Path(Files.createTempDirectory("tso-test-"))
    val checkFolder  = testFolder.path / 'check

    val logRegistry =
      new LogRegistry[Source, TsIdentLibrary, StringWriter](
        testLogger,
        _.libName,
        _ => logging.appendable(new StringWriter()),
      )

    val publishFolder = os.root / 'tmp / "tso-published-tests" / testName

    runImport(source, targetFolder, pedantic, logRegistry, publishFolder) match {
      case PhaseRes.Ok(_) =>
        implicit val wd = os.pwd

        /* we don't checkin these files, so also don't compare them */
        os.walk(targetFolder).foreach {
          case x if x.last == ".bloop" => os.remove.all(x)
          case _                       => ()
        }

        if (update) {
          os.remove.all(checkFolder)
          os.copy(targetFolder, checkFolder)
          synchronized(%("git", "add", checkFolder))
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
