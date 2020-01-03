package org.scalablytyped.converter.plugin

import com.olvind.logging.LogLevel
import org.scalablytyped.converter
import org.scalablytyped.converter.internal.importer.Json
import org.scalablytyped.converter.internal.importer.jsonCodecs.{FileDecoder, FileEncoder, PackageJsonDepsDecoder}
import org.scalablytyped.converter.internal.ts.{PackageJsonDeps, TsIdentLibrary}
import org.scalablytyped.converter.internal.{BuildInfo, ImportTypings, InFolder, WrapSbtLogger}
import sbt.Keys._
import sbt._

import scala.util.Try

object ScalablyTypedConverterExternalNpmPlugin extends AutoPlugin {
  object autoImport {
    val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
  }

  override def requires = ScalablyTypedPluginBase

  lazy val stExternalNpmIntegration: Seq[Def.Setting[_]] = {
    import ScalablyTypedPluginBase.autoImport._
    import autoImport._

    Seq(
      stImport := {
        val cacheDirectory       = streams.value.cacheDirectory
        val flavour              = stFlavour.value
        val enableScalaJsDefined = stEnableScalaJsDefined.value.map(TsIdentLibrary.apply)
        val stLogger             = WrapSbtLogger(streams.value.log).filter(LogLevel.warn).void
        val folder               = os.Path(externalNpm.value)
        val packageJson          = folder / "package.json"
        val nodeModules          = InFolder(folder / "node_modules")
        val stdLib               = stStdlib.value
        val targetFolder         = os.Path((sourceManaged in Compile).value / "scalablytyped")
        val npmDeps              = Json[PackageJsonDeps](packageJson).dependencies.getOrElse(Map())
        val ignored              = stIgnore.value.to[Set]
        val minimize             = stMinimize.value.map(TsIdentLibrary.apply)
        val prettyStringType     = stPrettyStringType.value
        val generateCompanions   = stGenerateCompanions.value

        val config = ImportTypings.Input(
          BuildInfo.gitSha,
          os.read(packageJson).hashCode,
          npmDeps.to[List],
          nodeModules,
          targetFolder,
          flavour,
          generateCompanions,
          enableScalaJsDefined,
          prettyStringType,
          stdLib,
          ignored,
          minimize,
        )

        val inputPath  = os.Path(cacheDirectory / "scalablytyped" / "input.json")
        val outputPath = os.Path(cacheDirectory / "scalablytyped" / "output.json")

        (Try(Json[ImportTypings.Input](inputPath)).toOption, Json.opt[Seq[File]](outputPath)) match {
          case (Some(`config`), Some(output)) =>
            stLogger.warn("Nothing to do")
            output
          case _ =>
            converter.internal.ImportTypings(config, stLogger) match {
              case Right(files) =>
                val seqFiles = files.to[Seq]
                Json.persist(inputPath)(config)
                Json.persist(outputPath)(seqFiles)
                seqFiles
              case Left(errors) =>
                sys.error(errors.mkString("\n"))
            }
        }
      },
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(stExternalNpmIntegration)
}