package org.scalablytyped.converter
package internal

import java.util.Optional
import java.util.function.Supplier

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.build.{Compiler, CompilerPaths}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}
import sbt.internal.inc.ZincUtil
import xsbti.CompileFailed
import xsbti.compile.{CompileOrder, DefaultExternalHooks, IncrementalCompiler, Inputs}

class ZincCompiler(inputs: Inputs, logger: Logger[Unit], versions: Versions) extends Compiler {
  private lazy val incCompiler: IncrementalCompiler = ZincUtil.defaultIncrementalCompiler

  val sbtLogger = new ZincCompiler.WrapLogger(logger)

  def compile(
      name:          String,
      digest:        Digest,
      compilerPaths: CompilerPaths,
      deps:          Set[Compiler.InternalDep],
      externalDeps:  Set[Dep],
  ): Either[String, Unit] = {
    val sources = os.walk(compilerPaths.sourcesDir).filter(_.last.endsWith(".scala")).map(_.toIO).toArray

    val jars = deps.collect { case Compiler.InternalDepJar(path) => path.toIO }

    val scalaJsPlugin = inputs.options().scalacOptions().collectFirst {
      case x if x.startsWith("-Xplugin") && x.contains("scalajs-compiler") => x
    }

    val updatedInputs = inputs
      .withOptions(
        inputs
          .options()
          .withScalacOptions((versions.scalaJs.scalacOptions ++ scalaJsPlugin).toArray)
          .withClasspath(inputs.options.classpath() ++ jars)
          .withSources(sources)
          .withClassesDirectory(files.existing(compilerPaths.classesDir).toIO)
          .withOrder(CompileOrder.ScalaThenJava),
      )
      .withSetup(
        inputs.setup
          .withIncrementalCompilerOptions(
            inputs.setup.incrementalCompilerOptions
              .withEnabled(false)
              .withExternalHooks(new DefaultExternalHooks(Optional.empty(), Optional.empty())),
          ),
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
