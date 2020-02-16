package org.scalablytyped
package converter
package internal

import java.util.Optional

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.build.{Compiler, CompilerPaths, Versions}
import org.scalablytyped.converter.internal.scalajs.Dep
import sbt.CompileOrder
import sbt.internal.inc.ZincUtil
import xsbti.CompileFailed
import xsbti.compile.{DefaultExternalHooks, IncrementalCompiler, Inputs}

class ZincCompiler(inputs: Inputs, logger: Logger[Unit], versions: Versions) extends Compiler {
  private lazy val incCompiler: IncrementalCompiler = ZincUtil.defaultIncrementalCompiler

  val sbtLogger = new AsSbtLogger(logger)

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
