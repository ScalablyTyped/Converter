package org.scalablytyped.converter.plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.jsonCodecs.PackageJsonDepsDecoder
import org.scalablytyped.converter.internal.ts.{PackageJsonDeps, TsIdentLibrary}
import org.scalablytyped.converter.internal._
import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._
import sbt._
import sbt.librarymanagement.ModuleID

import scala.util.Try

object ScalablyTypedConverterExternalNpmPlugin extends AutoPlugin {
  private implicit val PathFormatter: Formatter[Path] = _.toString

  private[plugin] val stInternalZincCompiler = taskKey[ZincCompiler]("Hijack compiler settings")

  object autoImport {
    val stImport    = taskKey[Set[ModuleID]]("Imports all the bundled npm and generates bindings")
    val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
  }

  import ScalablyTypedPluginBase.autoImport._
  import autoImport._

  override val requires = ScalablyTypedPluginBase && ScalaJSPlugin

  private[plugin] lazy val stImportTask = Def.taskDyn {
    val projectName     = name.value
    val folder          = os.Path(externalNpm.value)
    val packageJsonFile = folder / "package.json"
    val nodeModules     = InFolder(folder / "node_modules")
    val sbtLog          = streams.value.log
    val outputDir       = os.Path(streams.value.cacheDirectory)
    val cacheDir        = (Global / stDir).value

    val stLogger: logging.Logger[Unit] =
      if ((Global / stQuiet).value) logging.Logger.DevNull
      else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)

    val wantedLibs: Set[TsIdentLibrary] =
      Json.force[PackageJsonDeps](packageJsonFile).dependencies.getOrElse(Map()).keys.to[Set].map(TsIdentLibrary.apply)

    val conversion = stConversionOptions.value

    val input = ImportTypings.Input(
      converterVersion = BuildInfo.version,
      packageJsonHash  = Digest.of(List(os.read.bytes(packageJsonFile))).hexString,
      conversion       = conversion,
      fromFolder       = nodeModules,
      targetFolder     = outputDir / "sources",
      wantedLibs       = wantedLibs,
    )

    val runCache = (cacheDir / "runs" / s"${input.hashCode}.json").toPath

    type InOut = (ImportTypings.Input, ImportTypings.Output)

    Try(Json.force[InOut](runCache)).toOption match {
      case Some((`input`, output)) if output.allJars.forall(files.exists) =>
        Def.task {
          stLogger.withContext(runCache).info(s"Using cached result :)")
          output.deps.map(Deps.asModuleID(conversion.versions))
        }

      case _ =>
        val t = Def.task {
          ImportTypings(
            input              = input,
            logger             = stLogger,
            parseCacheDirOpt   = Some(cacheDir.toPath resolve "parse"),
            compiler           = stInternalZincCompiler.value,
            publishLocalFolder = ivyPaths.value.ivyHome.fold(constants.defaultLocalPublishFolder)(os.Path(_) / "local"),
          ) match {
            case Right(output) =>
              Json.persist[InOut](runCache)((input, output))
              output.deps.map(Deps.asModuleID(conversion.versions))
            case Left(errors) =>
              errors.foreach {
                case (_, Left(th)) => throw th
                case _             => ()
              }

              sys.error(errors.mkString("\n").take(2000))
          }
        }

        t.tag(Tags.Compile, Tags.CPU, Tags.Disk, ScalablyTypedTag)
    }
  }

  override lazy val projectSettings =
    Seq(
      stImport := stImportTask.value,
      /* This is where we add our generated artifacts to the project for compilation */
      allDependencies ++= stImport.value.toSeq,
      stInternalZincCompiler := ZincCompiler.task.value,
    )
}
