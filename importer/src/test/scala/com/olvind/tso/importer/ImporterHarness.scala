package com.olvind
package tso
package importer

import java.io.StringWriter
import java.nio.file.Files

import ammonite.ops.{root, up, Path}
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.build.{BloopFactory, PublishedSbtProject, Versions}
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs.Name
import com.olvind.tso.ts.TsSource.TsLibSource
import com.olvind.tso.ts._
import org.scalatest.{Assertion, FunSuiteLike}

import scala.util.{Failure, Success, Try}

trait ImporterHarness extends FunSuiteLike {
  private val testLogger   = logging.stdout.filter(LogLevel.error)
  private val version      = Versions.`scala 2.12 with scala.js 0.6.25`
  private val bloopFactory = new BloopFactory(testLogger)

  val OutputPkg:  Name                    = Name("typings")
  val NoListener: PhaseListener[TsSource] = (_, _, _) => ()

  private def runImport(
      source:        InFolder,
      targetFolder:  Path,
      pedantic:      Boolean,
      logRegistry:   LogRegistry[TsSource, TsIdentLibrary, StringWriter],
      publishFolder: Path
  ): PhaseRes[TsSource, Map[TsSource, PublishedSbtProject]] = {
    val stdLibSource: TsSource =
      TsSource.StdLibSource(InFile(source.path / "stdlib.d.ts"), TsIdentLibrarySimple("std"))

    val phase: RecPhase[TsSource, PublishedSbtProject] =
      RecPhase[TsSource]
        .next(new Phase1ReadTypescript(Seq(source), Set.empty, stdLibSource, pedantic, parser.parseFile), "typescript")
        .next(new Phase2ToScalaJs(pedantic, OutputPkg), "scala.js")
        .next(
          new Phase3CompileBloop(
            versions = version,
            bloopFactory = bloopFactory,
            targetFolder = targetFolder,
            mainPackageName = OutputPkg,
            projectName = "ScalablyTyped",
            organization = "com.scalablytyped",
            publishFolder = publishFolder
          ),
          "build"
        )

    val found: Set[TsLibSource] =
      TypescriptSources.forFolder(InFolder(source.path), Set.empty)

    PhaseRes.sequenceMap(found.map(s => s -> PhaseRunner(phase, logRegistry.get, NoListener)(s)).toMap)
  }

  def assertImportsOk(testName: String, pedantic: Boolean, update: Boolean): Assertion = {
    val testFolder = getClass.getClassLoader.getResource(testName) match {
      case null  => sys.error(s"Could not find test resource folder $testName")
      case other =>
        // The test can be run from various working directories, so find the correct directory this way :/
        InFolder(Path(other.getFile) / up / up / up / up / 'src / 'test / 'resources / testName)
    }
    val source       = InFolder(testFolder.path / 'in)
    val targetFolder = Path(Files.createTempDirectory("tso-test-"))
    val checkFolder  = testFolder.path / 'check

    val logRegistry =
      new LogRegistry[TsSource, TsIdentLibrary, StringWriter](
        testLogger,
        _.inLibrary.libName,
        _ => logging.appendable(new StringWriter())
      )

    val publishFolder = root / 'tmp / "tso-published-tests" / testName

    runImport(source, targetFolder, pedantic, logRegistry, publishFolder) match {
      case PhaseRes.Ok(_) =>
        import ammonite.ops._
        import ImplicitWd.implicitCwd

        if (update) {
          rm(checkFolder)
          cp(targetFolder, checkFolder)
          %("git", "add", checkFolder)
        }

        Try(%%("diff", "-Naur", checkFolder, targetFolder)) match {
          case Success(_) => if (update) pending else succeed
          case Failure(th: ShelloutException) => {
            import ImplicitWd.implicitCwd
            rm(checkFolder)
            cp(targetFolder, checkFolder)
            %("git", "add", checkFolder)
          }
          val diff = %%("diff", "-r", checkFolder, targetFolder).out.string
          fail(s"Output for test $testFolder was not as expected : $diff", th)
        case Failure(th) => throw th
        }

      case PhaseRes.Failure(errors) =>
        if (update) {
          import ammonite.ops._
          import ImplicitWd.implicitCwd

          rm(checkFolder)
          cp(targetFolder, checkFolder)
          %("git", "add", checkFolder)
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
