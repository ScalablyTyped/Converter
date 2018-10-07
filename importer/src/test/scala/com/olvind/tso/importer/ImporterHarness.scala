package com.olvind
package tso
package importer

import java.io.StringWriter
import java.nio.file.Files

import ammonite.ops.{root, Path}
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.build.BloopCompiler
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs._
import com.olvind.tso.ts.TsSource.TsLibSource
import com.olvind.tso.ts._
import org.scalatest.{Assertion, FunSuiteLike}

import scala.util.{Failure, Success, Try}

trait ImporterHarness extends FunSuiteLike {
  private val testLogger = logging.stdout.filter(LogLevel.error)
  private val bloop      = BloopCompiler(testLogger)
  val NoListener: PhaseListener[TsSource] = (_, _, _) => ()

  private def runImport(
      source:        InFolder,
      targetFolder:  OutFolder,
      logRegistry:   LogRegistry[TsSource, TsIdentLibrary, StringWriter],
      publishFolder: Path
  ): PhaseRes[TsSource, Map[TsSource, PublishedSbtProject]] = {
    val stdLibSource: TsSource =
      TsSource.FromFile(InFile(source.path / "stdlib.d.ts"), TsIdentLibrarySimple("std"))

    val phase: RecPhase[TsSource, PublishedSbtProject] =
      RecPhase[TsSource]
        .next(new PhaseReadTypescript(Seq(source), Set.empty, stdLibSource, parser.parseFile), "typescript")
        .next(PhaseToScalaJs, "scala.js")
        .next(PhaseCompileBloop(bloop, targetFolder, Name(constants.pkg), publishFolder), "build")

    val found: Set[TsLibSource] =
      TypescriptSources.forFolder(InFolder(source.path), Set.empty)

    PhaseRes.sequenceMap(found.map(s => s -> PhaseRunner(phase, logRegistry.get, NoListener)(s)).toMap)
  }

  def assertImportsOk(testName: String, update: Boolean): Assertion = {
    val testFolder   = InFolder(ammonite.ops.pwd / 'importer / 'src / 'test / 'resources / testName)
    val source       = InFolder(testFolder.path / 'in)
    val targetFolder = OutFolder(Path(Files.createTempDirectory("tso-test-")))
    val checkFolder  = OutFolder(testFolder.path / 'check)

    val logRegistry =
      new LogRegistry[TsSource, TsIdentLibrary, StringWriter](
        testLogger,
        _.inLibrary.libName,
        _ => logging.appendable(new StringWriter())
      )

    val publishFolder = root / 'tmp / "tso-published-tests" / testName

    runImport(source, targetFolder, logRegistry, publishFolder) match {
      case PhaseRes.Ok(_) =>
        import ammonite.ops._
        import ImplicitWd.implicitCwd

        if (update) {
          rm(checkFolder.folder)
          cp(targetFolder.folder, checkFolder.folder)
          %("git", "add", checkFolder.folder)
        }

        Try(%%("diff", "-Naur", checkFolder.folder, targetFolder.folder)) match {
          case Success(_) => if (update) pending else succeed
          case Failure(th: ShelloutException) =>
            val diff = %%("diff", "-r", checkFolder.folder, targetFolder.folder).out.string
            fail(s"Output for test $testFolder was not as expected : $diff", th)
          case Failure(th) => throw th
        }

      case PhaseRes.Failure(errors) =>
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
