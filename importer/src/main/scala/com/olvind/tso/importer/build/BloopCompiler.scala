package com.olvind.tso.importer.build

import java.util.Optional

import ammonite.ops.Path
import bloop.io.{AbsolutePath, Paths}
import bloop.reporter.{LogReporter, ReporterConfig}
import bloop.{CompileInputs, Compiler, CompilerCache, DependencyResolution, ScalaInstance}
import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.Seq
import coursier.Cache
import coursier.core.Repository
import coursier.maven.MavenRepository
import sbt.internal.inc.bloop.ZincInternals
import xsbti.ComponentProvider
import xsbti.compile.{ClasspathOptions, PreviousResult}

object BloopCompiler {
  import versions._

  class LoggerAdapter(logger: Logger[Unit]) extends bloop.logging.Logger {
    override def name: String = "bloop-scala-logger"
    override def asVerbose  = this
    override def asDiscrete = this
    override def ansiCodesSupported(): Boolean = false
    override def error(msg: String):    Unit = logger.error(msg)
    override def warn(msg:  String):    Unit = logger.warn(msg)
    override def info(msg:  String):    Unit = logger.info(msg)
    override def debug(msg: String):    Unit = logger.debug(msg)
    override def trace(t:   Throwable): Unit = logger.debug(t.getMessage)
    override def isVerbose: Boolean = true
  }

  object NoLogger extends bloop.logging.Logger {
    override def name: String = "no-logger"
    override def asVerbose  = this
    override def asDiscrete = this
    override def ansiCodesSupported(): Boolean = false
    override def error(msg: String):    Unit = ()
    override def warn(msg:  String):    Unit = ()
    override def info(msg:  String):    Unit = ()
    override def debug(msg: String):    Unit = ()
    override def trace(t:   Throwable): Unit = ()
    override def isVerbose: Boolean = true
  }

  def apply(logger: Logger[Unit]) = {
    logger.warn("Initializing scala compiler")

    val bloopLogger = new LoggerAdapter(logger)

    val provider: ComponentProvider =
      ZincInternals.getComponentProvider(Paths.getCacheDirectory("components"))

    val jars: AbsolutePath =
      Paths.getCacheDirectory("scala-jars")

    val singleCompilerCache: CompilerCache =
      new CompilerCache(provider, jars, bloopLogger, Nil)

    val compilerInstance: ScalaInstance = {
      val allPaths: Array[AbsolutePath] =
        DependencyResolution.resolve(scalaOrganization, "scala-compiler", scalaVersion, bloopLogger)

      val allJars: Array[AbsolutePath] =
        allPaths.collect {
          case path if path.underlying.toString.endsWith(".jar") => path
        }

      ScalaInstance(scalaOrganization, "scala-compiler", scalaVersion, allJars, bloopLogger)
    }

    val repos: Array[Repository] =
      Array(Cache.ivy2Local, Cache.ivy2Cache, MavenRepository("https://repo1.maven.org/maven2"))

    val globalClasspath: Array[AbsolutePath] =
      Array(
        DependencyResolution.resolve(scalaJsOrganization, s("scalajs-library"), scalaJsVersion, bloopLogger, repos),
        DependencyResolution.resolve(scalaJsOrganization, sjs("scalajs-dom"), scalaJsDomVersion, bloopLogger, repos),
        DependencyResolution.resolve("com.olvind", sjs("runtime"), scalablyTypedRuntimeVersion, bloopLogger, repos),
      ).flatten

    val scalaJsCompiler =
      DependencyResolution
        .resolve(
          scalaJsOrganization,
          s"scalajs-compiler_$scalaVersion",
          scalaJsVersion,
          bloopLogger,
          repos
        )
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

    val compileInputs = (paths: ProjectPaths, localClassPath: Seq[AbsolutePath]) => {
      def toAbs(p: Path) = AbsolutePath(p.toNIO)

      CompileInputs(
        scalaInstance = compilerInstance,
        compilerCache = singleCompilerCache,
        sources = Array(toAbs(paths.sourcesDir)),
        classpath = globalClasspath ++ localClassPath,
        classesDir = toAbs(paths.classesDir),
        baseDirectory = toAbs(paths.baseDir),
        scalacOptions = Array(
          "-Xplugin:" + scalaJsCompiler.syntax,
          "-P:scalajs:sjsDefinedByDefault"
        ),
        javacOptions = Array(),
        classpathOptions = classPathOptions,
        previousResult = PreviousResult.of(Optional.empty(), Optional.empty()),
        reporter = new LogReporter(NoLogger, toAbs(paths.baseDir), identity, ReporterConfig.defaultFormat),
        logger = NoLogger
      )
    }

    logger.warn(s"Initialized scala ${compilerInstance.actualVersion}")
    new BloopCompiler(repos, compileInputs)
  }
}

class BloopCompiler(repos: Array[Repository], compileInputs: (ProjectPaths, Seq[AbsolutePath]) => CompileInputs) {
  def compileLib(paths: ProjectPaths, localClassPath: Seq[AbsolutePath]): Compiler.Result =
    bloop.Compiler.compile(compileInputs(paths, localClassPath))
}
