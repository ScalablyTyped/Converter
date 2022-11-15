package org.scalablytyped.converter.internal
package importer
package build

import bloop.Cli
import bloop.cli.{CliOptions, Commands, CommonOptions, ExitStatus}
import bloop.config.{Config => BloopConfig}
import bloop.engine.NoPool
import bloop.io.AbsolutePath
import com.olvind.logging.{Formatter, Logger}
import coursier.cache.FileCache
import coursier.error.CoursierError
import coursier.util.Task
import coursier.{Dependency, Fetch, Module}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}

import java.io.{ByteArrayOutputStream, PrintStream}
import java.nio.file.{Files, Path}
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

object BloopCompiler {
  implicit val AbsolutePathFormatter: Formatter[AbsolutePath] = x => x.syntax

  def toCoursier(dep: Dep.Concrete): Dependency =
    Dependency(
      Module(coursier.Organization(dep.org), coursier.ModuleName(dep.mangledArtifact)),
      dep.version,
    )

  // I've experienced `checksum not found` errors from coursier in test
  val fileCache = FileCache[Task]().withChecksums(List(None))

  def resolve(deps: Dep.Concrete*)(implicit ec: ExecutionContext): Future[Array[AbsolutePath]] = {
    def go(remainingAttempts: Int): Future[Array[AbsolutePath]] =
      Fetch[Task](fileCache)
        .withDependencies(deps.map(toCoursier))
        .io
        .future()
        .map(files => files.map(f => AbsolutePath(f)).toArray)
        .recoverWith {
          case _: CoursierError if remainingAttempts > 0 => go(remainingAttempts - 1)
        }

    go(remainingAttempts = 3)
  }

  def apply(
      logger:                Logger[Unit],
      v:                     Versions,
      failureCacheFolderOpt: Option[Path],
  )(implicit ec:             ExecutionContext): Future[BloopCompiler] = {
    val scalaCompilerF       = resolve(v.scala.compiler.concrete(v))
    val globalClasspathBaseF = resolve(v.scalaJsLibrary.concrete(v), v.runtime.concrete(v))
    val scalaJsCompilerBaseF = resolve(v.scalaJsCompiler.toList.map(_.concrete(v)): _*)

    for {
      scalaCompiler <- scalaCompilerF
      globalClasspathBase <- globalClasspathBaseF
      scalaJsCompilerBase <- scalaJsCompilerBaseF
    } yield {
      logger.warn(s"Initializing scala compiler ${v.scala.scalaVersion} with scala.js ${v.scalaJs.scalaJsVersion}")

      val globalClasspath: Array[AbsolutePath] =
        scalaCompiler.collect { case path if path.toString.contains("scala-library") => path } ++ globalClasspathBase

      val scalaJsCompiler =
        scalaJsCompilerBase.collectFirst { case f if f.syntax.contains("scalajs-compiler") => f }

      logger.warn(globalClasspath)
      logger.warn(scalaJsCompiler.toString)

      new BloopCompiler(logger, failureCacheFolderOpt, v, globalClasspath, scalaCompiler, scalaJsCompiler)
    }
  }
}

class BloopCompiler private (
    logger:                Logger[Unit],
    failureCacheFolderOpt: Option[Path],
    versions:              Versions,
    globalClassPath:       Array[AbsolutePath],
    scalaJars:             Array[AbsolutePath],
    scalaJsCompiler:       Option[AbsolutePath],
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
        Await.result(
          BloopCompiler.resolve(externalDeps.toArray.map(_.concrete(versions)): _*)(ExecutionContext.global),
          Duration.Inf,
        )

      val fromDependencyJars: Set[AbsolutePath] =
        deps.collect { case Compiler.InternalDepJar(jar) => AbsolutePath(jar.toIO) }

      val fromDependencyClassDirs: Set[AbsolutePath] =
        deps.collect { case Compiler.InternalDepClassFiles(_, path) => AbsolutePath(path.toIO) }

      (globalClassPath ++ fromExternalDeps ++ fromDependencyJars ++ fromDependencyClassDirs).map(_.underlying).toList
    }

    val classesDir = compilerPaths.classesDir
    val outDir     = compilerPaths.baseDir / "target"

    val scalaJsOption: String =
      if (versions.scala.is3) "-scalajs"
      else scalaJsCompiler.map(scalaJsCompiler => "-Xplugin:" + scalaJsCompiler.syntax).get

    val projectFile = BloopConfig.File(
      "1.5.0",
      BloopConfig.Project(
        name         = name,
        directory    = compilerPaths.baseDir.toNIO,
        sources      = List(compilerPaths.sourcesDir.toNIO),
        dependencies = deps.collect { case Compiler.InternalDepClassFiles(name, _) => name }.toList,
        classpath    = classPath,
        out          = outDir.toNIO,
        classesDir   = compilerPaths.classesDir.toNIO,
        resources    = None,
        scala = Some(
          BloopConfig.Scala(
            organization = versions.scala.scalaOrganization,
            name         = "scala-compiler",
            version      = versions.scala.scalaVersion,
            options      = scalaJsOption :: versions.scalacOptions,
            jars         = scalaJars.toList.map(_.underlying),
            analysis     = None,
            setup        = None,
          ),
        ),
        java             = None,
        sbt              = None,
        test             = None,
        platform         = None,
        resolution       = None,
        workspaceDir     = None,
        sourcesGlobs     = None,
        sourceRoots      = None,
        tags             = None,
        sourceGenerators = None,
      ),
    )
    os.makeDir.all(bloopFolder)
    bloop.config.write(projectFile, (bloopFolder / (name + ".json")).toNIO)

    val outStream   = new ByteArrayOutputStream
    val printStream = new PrintStream(outStream)

    val cacheFileOpt = failureCacheFolderOpt.map(_.resolve(name).resolve(digest.hexString))

    cacheFileOpt match {
      case Some(cacheFile) if Files.exists(cacheFile) =>
        Left(new String(Files.readAllBytes(cacheFile), constants.Utf8))
      case _ =>
        val status = Cli.run(
          bloop.engine.Run(
            Commands.Compile(
              projects    = List(name),
              incremental = false,
              cliOptions = CliOptions(
                configDir = Some(bloopFolder.toNIO),
                common    = CommonOptions(err = printStream, out = printStream),
              ),
            ),
          ),
          NoPool,
        )

        status match {
          case ExitStatus.Ok =>
            outStream.toString(constants.Utf8.name).linesIterator.filter(_.contains("[W]")).toVector match {
              case Vector() => ()
              case warnings => warnings.foreach(warning => logger.warn(warning))
            }

            /** bloop 1.4.3 apparently doesnt use `classesDir` as the path where it puts class files anymore.
              * Move them back to where we expect them
              */
            os.move.over(outDir / "bloop-bsp-clients-classes" / "classes-bloop-cli", classesDir)

            Right(())
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
