package org.scalablytyped.converter
package internal

import java.io.File
import java.net.URLClassLoader
import java.time.Instant
import java.util.Optional
import java.util.function.Supplier

import com.olvind.logging
import com.olvind.logging.{LogLevel, Logger}
import lmcoursier.{CoursierConfiguration, CoursierDependencyResolution}
import org.scalablytyped.converter.internal.importer.build.{Compiler, CompilerPaths}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}
import sbt._
import sbt.internal.inc.classpath.ClassLoaderCache
import sbt.internal.inc.{AnalyzingCompiler, LoggedReporter, ScalaInstance, ZincLmUtil, ZincUtil}
import sbt.librarymanagement.DependencyResolution
import xsbti.CompileFailed
import xsbti.compile.{CompileOrder => _, _}

class ZincCompiler(inputs: Inputs, logger: Logger[Unit], versions: Versions, resolve: Dep => Array[File])
    extends Compiler {
  private lazy val incCompiler: IncrementalCompiler = ZincUtil.defaultIncrementalCompiler

  val sbtLogger = new ZincCompiler.WrapLogger(logger)

  def compile(
      name:          String,
      digest:        Digest,
      compilerPaths: CompilerPaths,
      deps:          Set[Compiler.InternalDep],
      externalDeps:  Set[Dep],
  ): Either[String, Unit] = {

    val cp =
      (inputs.options.classpath() ++ deps.collect { case Compiler.InternalDepJar(path) => path.toIO } ++ externalDeps
        .map(resolve)
        .flatten).distinct

    val updatedInputs = inputs
      .withOptions(
        inputs
          .options()
          .withClasspath(cp)
          .withSources(os.walk(compilerPaths.sourcesDir).filter(_.last.endsWith(".scala")).map(_.toIO).toArray)
          .withClassesDirectory(files.existing(compilerPaths.classesDir).toIO),
      )

    try {
      incCompiler.compile(updatedInputs, sbtLogger)
      Right(())
    } catch {
      case x: CompileFailed =>
        Left(s"$x: ${x.arguments.mkString(", ")} ${x.problems.mkString(", ")}")
    }
  }
}

object ZincCompiler {
  val task = Def.task {
    import Keys._
    import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._

    val _sbtLogger = streams.value.log

    val logger: logging.Logger[Unit] =
      if ((Global / stQuiet).value) logging.Logger.DevNull
      else WrapSbtLogger(_sbtLogger, Instant.now).filter(LogLevel.warn).void.withContext("project", name.value)

    val sbtLogger = new ZincCompiler.WrapLogger(logger)

    val v = Versions(
      Versions.Scala(
        scalaVersion = (Compile / scalaVersion).value,
        binVersion   = (Compile / scalaBinaryVersion).value,
      ),
      Versions.ScalaJs(org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion),
    )

    val resolver = DependencyResolution(new CoursierDependencyResolution(CoursierConfiguration()))

    def resolve(dep: Dep): Array[File] =
      resolver.retrieve(
        Deps.asModuleID(v)(dep),
        scalaModuleInfo.value,
        file("tmp"),
        sbtLogger,
      ) match {
        case Left(warning)   => throw warning.resolveException
        case Right(resolved) => resolved.toArray
      }

    val scalaCompiler   = resolve(v.scala.compiler)
    val scalaLibrary    = resolve(v.scala.library)
    val runtime         = resolve(v.scalaJs.library)
    val scalaJsCompiler = resolve(v.scalaJs.compiler)
    val allJars         = scalaCompiler ++ runtime ++ scalaLibrary ++ scalaJsCompiler

    val st      = state.value
    val g       = BuildPaths.getGlobalBase(st)
    val zincDir = BuildPaths.getZincDirectory(st, g)

    val instance = mkScalaInstance(
      version          = v.scala.scalaVersion,
      allJars          = allJars,
      libraryJars      = scalaLibrary.collect { case path if path.toString.contains("scala-library") => path },
      compilerJar      = scalaCompiler.collectFirst { case f if f.getName.contains("scala-compiler") => f }.head,
      classLoaderCache = st.classLoaderCache,
    )

    val scalac: AnalyzingCompiler =
      ZincLmUtil.scalaCompiler(
        scalaInstance        = instance,
        classpathOptions     = classpathOptions.value,
        globalLock           = appConfiguration.value.provider.scalaProvider.launcher.globalLock,
        componentProvider    = appConfiguration.value.provider.components,
        secondaryCacheDir    = Option(zincDir),
        dependencyResolution = resolver,
        compilerBridgeSource = scalaCompilerBridgeSource.value,
        scalaJarsTarget      = zincDir,
        classLoaderCache     = None,
        log                  = sbtLogger,
      )

    val compilers: Compilers =
      ZincUtil.compilers(
        instance         = instance,
        classpathOptions = classpathOptions.value,
        javaHome         = javaHome.value,
        scalac,
      )

    object lookup extends PerClasspathEntryLookup {
      private val cachedAnalysisMap                = Defaults.analysisMap(Attributed.blankSeq(allJars))
      private val cachedPerEntryDefinesClassLookup = classpathEntryDefinesClass.value

      override def analysis(classpathEntry: File): Optional[CompileAnalysis] =
        cachedAnalysisMap(classpathEntry) match {
          case Some(value) => Optional.of(value)
          case None        => Optional.empty()
        }

      override def definesClass(classpathEntry: File): DefinesClass =
        cachedPerEntryDefinesClassLookup(classpathEntry)
    }

    val scalaJsCompilerJar: File =
      scalaJsCompiler.collectFirst { case f if f.getName.contains("scalajs-compiler") => f }.head

    val inputs = Inputs.of(
      compilers,
      CompileOptions
        .of()
        .withClasspath(allJars)
        .withScalacOptions(Array("-Xplugin:" + scalaJsCompilerJar) ++ v.scalacOptions)
        .withOrder(CompileOrder.ScalaThenJava),
      Setup.of(
        lookup,
        false,
        streams.value.cacheDirectory / (Compile / compileAnalysisFilename).value,
        compilerCache.value,
        IncOptions.of().withEnabled(false),
        new LoggedReporter(maxErrors.value, sbtLogger),
        Optional.empty(),
        Array.empty,
      ),
      PreviousResult.create(Optional.empty(), Optional.empty()),
    )

    new ZincCompiler(inputs, logger, v, dep => resolve(dep))
  }

  def mkScalaInstance(
      version:          String,
      allJars:          Seq[File],
      libraryJars:      Array[File],
      compilerJar:      File,
      classLoaderCache: ClassLoaderCache,
  ): ScalaInstance = {
    val allJarsDistinct = allJars.distinct
    val libraryLoader   = classLoaderCache(libraryJars.toList)
    class ScalaLoader extends URLClassLoader(allJarsDistinct.map(_.toURI.toURL).toArray, libraryLoader)
    val fullLoader = classLoaderCache.cachedCustomClassloader(
      allJarsDistinct.toList,
      () => new ScalaLoader,
    )
    new ScalaInstance(
      version,
      fullLoader,
      libraryLoader,
      libraryJars,
      compilerJar,
      allJarsDistinct.toArray,
      Some(version),
    )
  }

  final class WrapLogger(val underlying: Logger[Unit]) extends xsbti.Logger {
    override def error(msg: Supplier[String]): Unit = underlying.error(msg.get())

    override def warn(msg: Supplier[String]): Unit = underlying.warn(msg.get())

    override def info(msg: Supplier[String]): Unit = underlying.info(msg.get())

    override def debug(msg: Supplier[String]): Unit = underlying.debug(msg.get())

    // trace? throwable? whaat
    override def trace(exception: Supplier[Throwable]): Unit =
      underlying.warn("traced exception from sbt", exception.get())
  }
}
