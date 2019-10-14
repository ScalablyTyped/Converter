package com.olvind.tso
package importer
package build

import java.io.{ByteArrayOutputStream, OutputStream, PrintStream}

import bloop.DependencyResolution.resolve
import bloop.cli.{CliOptions, Commands, CommonOptions, ExitStatus}
import bloop.config.{Config => BloopConfig}
import bloop.engine.NoPool
import bloop.io.AbsolutePath
import bloop.logging.{DebugFilter, Logger => BloopLogger}
import bloop.{Cli, DependencyResolution}
import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.scalajs.Dep

import scala.concurrent.ExecutionContext

object BloopCompiler {
  sealed trait InternalDep
  case class InternalDepClassFiles(name: String, path: AbsolutePath) extends InternalDep
  case class InternalDepJar(path:        AbsolutePath) extends InternalDep

  class LoggerAdapter(logger: Logger[Unit]) extends BloopLogger {
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

  implicit val AbsolutePathFormatter: Formatter[AbsolutePath] = x => x.syntax

  def apply(logger: Logger[Unit], v: Versions, ec: ExecutionContext, failureCacheFolder: os.Path): BloopCompiler = {
    val bloopLogger: BloopLogger = new LoggerAdapter(logger)

    logger.warn(s"Initializing scala compiler ${v.scalaVersion} with scala.js ${v.scalaJsVersion}")

    val scalaCompiler: Array[AbsolutePath] =
      resolve(v.scalaOrganization, "scala-compiler", v.scalaVersion, bloopLogger)(ec)

    val globalClasspath: Array[AbsolutePath] =
      Array(
        scalaCompiler.collect { case path if path.underlying.toString.contains("scala-library") => path },
        resolve(v.scalaJsOrganization, v.s("scalajs-library"), v.scalaJsVersion, bloopLogger)(ec),
        resolve(v.RuntimeOrganization, v.sjs(v.RuntimeName), v.RuntimeVersion, bloopLogger)(ec),
      ).flatten

    val scalaJsCompiler =
      resolve(v.scalaJsOrganization, s"scalajs-compiler_${v.scalaVersion}", v.scalaJsVersion, bloopLogger)(ec).collectFirst {
        case f if f.syntax.contains("scalajs-compiler") => f
      }.head

    logger.warn(globalClasspath)
    logger.warn(scalaJsCompiler)

    new BloopCompiler(ec, failureCacheFolder, v, globalClasspath, scalaCompiler, scalaJsCompiler, bloopLogger)
  }

  object NullOutputStream extends OutputStream {
    override def write(b: Int): Unit = ()
  }

  object NullPrinter extends PrintStream(NullOutputStream)
}

class BloopCompiler private (
    ec:                 ExecutionContext,
    failureCacheFolder: os.Path,
    versions:           Versions,
    globalClassPath:    Array[AbsolutePath],
    scalaJars:          Array[AbsolutePath],
    scalaJsCompiler:    AbsolutePath,
    bloopLogger:        BloopLogger,
) {
  def compile(
      name:          String,
      digest:        Digest,
      compilerPaths: CompilerPaths,
      deps:          Seq[BloopCompiler.InternalDep],
      externalDeps:  Set[Dep],
  ): Either[String, Unit] = {
    val bloopFolder = compilerPaths.baseDir / ".bloop"
    val classPath = {
      val fromExternalDeps: Set[AbsolutePath] =
        externalDeps.flatMap(
          dep => DependencyResolution.resolve(dep.org, versions.sjs(dep.artifact), dep.version, bloopLogger)(ec),
        )

      val fromDependencyJars: Seq[AbsolutePath] =
        deps.collect {
          case BloopCompiler.InternalDepJar(jar) => jar
        }

      val fromDependencyClassDirs: Seq[AbsolutePath] =
        deps.collect {
          case BloopCompiler.InternalDepClassFiles(_, path) => path
        }

      (globalClassPath ++ fromExternalDeps ++ fromDependencyJars ++ fromDependencyClassDirs).map(_.underlying).toList
    }
    val projectFile = BloopConfig.File(
      "1.3.2",
      BloopConfig.Project(
        name         = name,
        directory    = compilerPaths.baseDir.toNIO,
        sources      = List(compilerPaths.sourcesDir.toNIO),
        dependencies = deps.collect { case BloopCompiler.InternalDepClassFiles(name, _) => name }.toList,
        classpath    = classPath,
        out          = (compilerPaths.baseDir / "target").toNIO,
        classesDir   = compilerPaths.classesDir.toNIO,
        resources    = None,
        scala = Some(
          BloopConfig.Scala(
            organization = versions.scalaOrganization,
            name         = "scala-compiler",
            version      = versions.scalaVersion,
            options      = List("-Xplugin:" + scalaJsCompiler.syntax) ++ versions.scalacOptions,
            jars         = scalaJars.toList.map(_.underlying),
            analysis     = None,
            setup        = None,
          ),
        ),
        java       = None,
        sbt        = None,
        test       = None,
        platform   = None,
        resolution = None,
      ),
    )
    os.makeDir.all(bloopFolder)
    bloop.config.write(projectFile, (bloopFolder / (name + ".json")).toNIO)

    val errorStream    = new ByteArrayOutputStream
    val errPrintStream = new PrintStream(errorStream)

    val cacheFile = failureCacheFolder / name / digest.hexString

    if (os.exists(cacheFile)) Left(files.content(InFile(cacheFile)))
    else {
      val status = Cli.run(
        bloop.engine.Run(
          Commands.Compile(
            projects    = List(name),
            incremental = true,
            cliOptions = CliOptions(
              configDir = Some(bloopFolder.toNIO),
              common    = CommonOptions(err = errPrintStream, out = BloopCompiler.NullPrinter),
            ),
          ),
        ),
        NoPool,
      )

      status match {
        case ExitStatus.Ok => Right(())
        case other =>
          val msg = errorStream.toString(constants.Utf8.name)
          /* save failure, but guard against flaky errors */
          other match {
            case ExitStatus.CompilationError if !msg.contains("Unexpected error when compiling") =>
              files.writeBytes(cacheFile, msg.getBytes(constants.Utf8.name))
            case _ => ()
          }

          Left(msg)
      }
    }
  }
}
