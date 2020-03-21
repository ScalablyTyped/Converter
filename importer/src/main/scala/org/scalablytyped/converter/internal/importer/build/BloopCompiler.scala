package org.scalablytyped.converter.internal
package importer
package build

import java.io.{ByteArrayOutputStream, PrintStream}
import java.nio.file.{Files, Path}

import bloop.Cli
import bloop.cli.{CliOptions, Commands, CommonOptions, ExitStatus}
import bloop.config.{Config => BloopConfig}
import bloop.engine.NoPool
import bloop.io.AbsolutePath
import bloop.logging.{DebugFilter, Logger => BloopLogger}
import com.olvind.logging.{Formatter, Logger}
import coursier.util.Task
import coursier.{Attributes, Dependency, Fetch, Module}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

object BloopCompiler {
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
    override def printDebug(line:       String):         Unit        = logger.debug(line)
    override def withOriginId(originId: Option[String]): BloopLogger = this
  }

  implicit val AbsolutePathFormatter: Formatter[AbsolutePath] = x => x.syntax

  def toCoursier(versions: Versions)(dep: Dep): Dependency =
    Dependency(
      Module(coursier.Organization(dep.org), coursier.ModuleName(dep.mangledArtifact(versions))),
      dep.version,
      attributes = Attributes(),
    )

  def resolve(versions: Versions, deps: Dep*)(implicit ec: ExecutionContext): Future[Array[AbsolutePath]] =
    Fetch[Task]()
      .withDependencies(deps map toCoursier(versions))
      .io
      .future()
      .map(files => files.map(f => AbsolutePath(f)).toArray)

  def apply(
      logger:                Logger[Unit],
      v:                     Versions,
      failureCacheFolderOpt: Option[Path],
  )(implicit ec:             ExecutionContext): Future[BloopCompiler] = {
    val scalaCompilerF       = resolve(v, v.scala.compiler)
    val globalClasspathBaseF = resolve(v, v.scalaJs.library, Versions.runtime)
    val scalaJsCompilerBaseF = resolve(v, v.scalaJs.compiler)

    for {
      scalaCompiler <- scalaCompilerF
      globalClasspathBase <- globalClasspathBaseF
      scalaJsCompilerBase <- scalaJsCompilerBaseF
    } yield {
      val bloopLogger: BloopLogger = new LoggerAdapter(logger)

      logger.warn(s"Initializing scala compiler ${v.scala.scalaVersion} with scala.js ${v.scalaJs.scalaJsVersion}")

      val globalClasspath: Array[AbsolutePath] =
        scalaCompiler.collect { case path if path.toString.contains("scala-library") => path } ++ globalClasspathBase

      val scalaJsCompiler =
        scalaJsCompilerBase.collectFirst { case f if f.syntax.contains("scalajs-compiler") => f }.head

      logger.warn(globalClasspath)
      logger.warn(scalaJsCompiler)

      new BloopCompiler(ec, failureCacheFolderOpt, v, globalClasspath, scalaCompiler, scalaJsCompiler, bloopLogger)
    }
  }
}

class BloopCompiler private (
    ec:                    ExecutionContext,
    failureCacheFolderOpt: Option[Path],
    versions:              Versions,
    globalClassPath:       Array[AbsolutePath],
    scalaJars:             Array[AbsolutePath],
    scalaJsCompiler:       AbsolutePath,
    bloopLogger:           BloopLogger,
) extends Compiler {
  override def compile(
      name:          String,
      digest:        Digest,
      compilerPaths: CompilerPaths,
      deps:          Set[Compiler.InternalDep],
      externalDeps:  Set[Dep],
  ): Either[String, Unit] = {
    val bloopFolder = compilerPaths.baseDir / ".bloop"

    val classPath = {
      val fromExternalDeps: Array[AbsolutePath] =
        Await.result(BloopCompiler.resolve(versions, externalDeps.toArray: _*)(ExecutionContext.global), Duration.Inf)

      val fromDependencyJars: Set[AbsolutePath] =
        deps.collect { case Compiler.InternalDepJar(jar) => AbsolutePath(jar.toIO) }

      val fromDependencyClassDirs: Set[AbsolutePath] =
        deps.collect { case Compiler.InternalDepClassFiles(_, path) => AbsolutePath(path.toIO) }

      (globalClassPath ++ fromExternalDeps ++ fromDependencyJars ++ fromDependencyClassDirs).map(_.underlying).toList
    }

    val projectFile = BloopConfig.File(
      "1.3.3",
      BloopConfig.Project(
        name         = name,
        directory    = compilerPaths.baseDir.toNIO,
        sources      = List(compilerPaths.sourcesDir.toNIO),
        dependencies = deps.collect { case Compiler.InternalDepClassFiles(name, _) => name }.toList,
        classpath    = classPath,
        out          = (compilerPaths.baseDir / "target").toNIO,
        classesDir   = compilerPaths.classesDir.toNIO,
        resources    = None,
        scala = Some(
          BloopConfig.Scala(
            organization = versions.scala.scalaOrganization,
            name         = "scala-compiler",
            version      = versions.scala.scalaVersion,
            options      = List("-Xplugin:" + scalaJsCompiler.syntax) ++ versions.scalacOptions,
            jars         = scalaJars.toList.map(_.underlying),
            analysis     = None,
            setup        = None,
          ),
        ),
        java         = None,
        sbt          = None,
        test         = None,
        platform     = None,
        resolution   = None,
        workspaceDir = None,
      ),
    )
    os.makeDir.all(bloopFolder)
    bloop.config.write(projectFile, (bloopFolder / (name + ".json")).toNIO)

    val outStream   = new ByteArrayOutputStream
    val printStream = new PrintStream(outStream)

    val cacheFileOpt = failureCacheFolderOpt.map(_ resolve name resolve digest.hexString)

    cacheFileOpt match {
      case Some(cacheFile) if Files.exists(cacheFile) =>
        Left(new String(Files.readAllBytes(cacheFile), constants.Utf8))
      case _ =>
        val status = Cli.run(
          bloop.engine.Run(
            Commands.Compile(
              projects    = List(name),
              incremental = true,
              cliOptions = CliOptions(
                configDir = Some(bloopFolder.toNIO),
                common    = CommonOptions(err = printStream, out = printStream),
              ),
            ),
          ),
          NoPool,
        )

        status match {
          case ExitStatus.Ok => Right(())
          case other =>
            val msg = outStream.toString(constants.Utf8.name)
            /* save failure, but guard against flaky errors */
            (other, cacheFileOpt) match {
              case (ExitStatus.CompilationError, Some(cacheFile)) if !msg.contains("Unexpected error when compiling") =>
                files.writeBytes(cacheFile, msg.getBytes(constants.Utf8.name))
              case _ => ()
            }

            Left(msg)
        }
    }
  }
}
