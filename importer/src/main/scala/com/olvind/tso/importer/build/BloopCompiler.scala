package com.olvind.tso
package importer
package build

import java.io.File
import java.util.Optional

import ammonite.ops.{ls, Path}
import bloop.Compiler.Result
import bloop.io.{AbsolutePath, Paths}
import bloop.logging.DebugFilter
import bloop.reporter.{Problem, ProblemPerPhase, Reporter, ReporterConfig}
import bloop.{CompileInputs, CompileMode, Compiler, CompilerCache, DependencyResolution, ScalaInstance, SimpleIRStore}
import ch.epfl.scala.bsp.StatusCode
import com.olvind.logging.{Formatter, Logger}
import coursier.Cache
import coursier.core.Repository
import coursier.maven.MavenRepository
import monix.eval.Task
import sbt.internal.inc.bloop.ZincInternals
import xsbti.ComponentProvider
import xsbti.compile._

import scala.concurrent.{ExecutionContext, Promise}
import scala.util.Try

class BloopFactory(logger: Logger[Unit]) {
  val irStore = SimpleIRStore(Array())

  class LoggerAdapter(logger: Logger[Unit]) extends bloop.logging.Logger {
    override def name: String = "bloop-scala-logger"
    override def asVerbose  = this
    override def asDiscrete = this
    override def ansiCodesSupported(): Boolean = false
    override def error(msg: String): Unit = logger.error(msg)
    override def warn(msg:  String): Unit = logger.warn(msg)
    override def info(msg:  String): Unit = logger.info(msg)
    override def debug(msg: String): Unit = logger.debug(msg)
    override def debug(msg: String)(implicit ctx: DebugFilter): Unit = logger.debug(msg)
    override def trace(t:   Throwable): Unit = logger.debug(t.getMessage)
    override def isVerbose:   Boolean     = true
    override def debugFilter: DebugFilter = DebugFilter.All
    override def printDebug(line: String): Unit = logger.debug(line)
  }

  object NoLogger extends bloop.logging.Logger {
    override def name: String = "no-logger"
    override def asVerbose  = this
    override def asDiscrete = this
    override def ansiCodesSupported(): Boolean = false
    override def error(msg: String): Unit = ()
    override def warn(msg:  String): Unit = ()
    override def info(msg:  String): Unit = ()
    override def debug(msg: String): Unit = ()
    override def debug(msg: String)(implicit ctx: DebugFilter): Unit = ()
    override def trace(t:   Throwable): Unit = ()
    override def isVerbose:   Boolean     = true
    override def debugFilter: DebugFilter = DebugFilter.All
    override def printDebug(line: String): Unit = ()
  }

  val bloopLogger = new LoggerAdapter(logger)

  val provider: ComponentProvider =
    ZincInternals.getComponentProvider(Paths.getCacheDirectory("components"))

  val jars: AbsolutePath =
    Paths.getCacheDirectory("scala-jars")

  val singleCompilerCache: CompilerCache =
    new CompilerCache(provider, jars, bloopLogger, Nil)

  def forVersion(v: Versions, ec: ExecutionContext): BloopCompiler = {
    logger.warn(s"Initializing scala compiler ${v.scalaVersion} with scala.js ${v.scalaJsVersion}")

    val compilerInstance: ScalaInstance = {
      val allPaths: Array[AbsolutePath] =
        DependencyResolution.resolve(v.scalaOrganization, "scala-compiler", v.scalaVersion, bloopLogger)(ec)

      val allJars: Array[AbsolutePath] =
        allPaths.collect {
          case path if path.underlying.toString.endsWith(".jar") => path
        }

      ScalaInstance(v.scalaOrganization, "scala-compiler", v.scalaVersion, allJars, bloopLogger)(ec)
    }

    val repos: Array[Repository] =
      Array(Cache.ivy2Local, Cache.ivy2Cache, MavenRepository("https://repo1.maven.org/maven2"))

    val globalClasspath: Array[AbsolutePath] =
      Array(
        DependencyResolution.resolve(
          v.scalaJsOrganization,
          v.s("scalajs-library"),
          v.scalaJsVersion,
          bloopLogger,
          repos
        )(ec),
        DependencyResolution.resolve(
          v.RuntimeOrganization,
          v.sjs(v.RuntimeName),
          v.RuntimeVersion,
          bloopLogger,
          repos
        )(ec),
      ).flatten

    val scalaJsCompiler =
      DependencyResolution
        .resolve(
          v.scalaJsOrganization,
          s"scalajs-compiler_${v.scalaVersion}",
          v.scalaJsVersion,
          bloopLogger,
          repos
        )(ec)
        .collectFirst { case f if f.syntax.contains("scalajs-compiler") => f }
        .head

    implicit val AbsolutePathFormatter: Formatter[AbsolutePath] = x => x.syntax

    logger.warn(globalClasspath)
    logger.warn(scalaJsCompiler)

    val classPathOptions: ClasspathOptions = {
      val bootLibrary   = true
      val compiler      = false
      val extra         = false
      val autoBoot      = true
      val filterLibrary = true

      ClasspathOptions.of(bootLibrary, compiler, extra, autoBoot, filterLibrary)
    }

    val compileInputs = (paths: CompilerPaths, localClassPath: Seq[AbsolutePath]) => {
      def toAbs(p: Path) = AbsolutePath(p.toNIO)

      object reporter extends Reporter(NoLogger, toAbs(paths.baseDir), identity, ReporterConfig.defaultFormat) {
        override protected def logFull(problem: Problem): Unit = ()

        override def reportEndCompilation(previousAnalysis: Option[CompileAnalysis],
                                          analysis:         Option[CompileAnalysis],
                                          code:             StatusCode): Unit = ()

        override def reportStartIncrementalCycle(sources: scala.Seq[File], outputDirs: scala.Seq[File]): Unit = ()

        override def printSummary(): Unit = ()

        override def reportCompilationProgress(progress: Long, total: Long): Unit = ()

        override def reportCancelledCompilation(): Unit = ()

        override def reportStartCompilation(previousProblems: List[ProblemPerPhase]): Unit = ()

        override def reportEndIncrementalCycle(durationMs: Long, result: Try[Unit]): Unit = ()
      }

      val scalacOptions = Array("-Xplugin:" + scalaJsCompiler.syntax) ++
        Array("-P:scalajs:sjsDefinedByDefault").filter(_ => v.scalaJsBinVersion === "0.6")

      val foo: Array[AbsolutePath] =
        ls.rec(paths.sourcesDir).filter(_.ext === "scala").map(toAbs).toArray

      CompileInputs(
        scalaInstance          = compilerInstance,
        compilerCache          = singleCompilerCache,
        sources                = foo,
        classpath              = globalClasspath ++ localClassPath,
        classesDir             = toAbs(paths.classesDir),
        baseDirectory          = toAbs(paths.baseDir),
        scalacOptions          = scalacOptions,
        javacOptions           = Array(),
        classpathOptions       = classPathOptions,
        previousResult         = PreviousResult.of(Optional.empty(), Optional.empty()),
        reporter               = reporter,
        compileOrder           = CompileOrder.ScalaThenJava,
        previousCompilerResult = Result.Empty,
        mode                   = CompileMode.Sequential,
        dependentResults       = Map.empty,
        store                  = irStore,
        cancelPromise          = Promise()
//        mode                   = CompileMode.Parallel(2),
//        store                  = new EmptyIRStore
      )
    }

    logger.warn(s"Initialized scala ${compilerInstance.actualVersion}")
    new BloopCompiler(repos, compileInputs)
  }
}

class BloopCompiler(repos: Array[Repository], compileInputs: (CompilerPaths, Seq[AbsolutePath]) => CompileInputs) {
  def compileLib(paths: CompilerPaths, localClassPath: Seq[AbsolutePath]): Task[Compiler.Result] =
    bloop.Compiler.compile(compileInputs(paths, localClassPath))
}
