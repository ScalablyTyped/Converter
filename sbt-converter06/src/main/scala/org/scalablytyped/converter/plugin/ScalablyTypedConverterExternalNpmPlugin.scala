package org.scalablytyped.converter.plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.ConversionOptions
import org.scalablytyped.converter.internal.importer.jsonCodecs.PackageJsonDepsDecoder
import org.scalablytyped.converter.internal.scalajs.{Dep, Name, Versions}
import org.scalablytyped.converter.internal.ts.{PackageJsonDeps, TsIdentLibrary}
import org.scalablytyped.converter.internal.{
  constants,
  BuildInfo,
  Deps,
  Digest,
  IArray,
  ImportTypings,
  InFolder,
  Json,
  WrapSbtLogger,
}
import sbt.Keys._
import sbt._

import scala.util.Try

object ScalablyTypedConverterExternalNpmPlugin extends AutoPlugin {
  implicit val PathFormatter: Formatter[Path] = _.toString

  object autoImport {
    val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
  }

  import ScalablyTypedPluginBase.autoImport._
  import autoImport._

  override def requires = ScalablyTypedPluginBase

  lazy val stImportTask = Def.taskDyn {
    val projectName     = name.value
    val folder          = os.Path(externalNpm.value)
    val packageJsonFile = folder / "package.json"
    val nodeModules     = InFolder(folder / "node_modules")
    val ignored         = stIgnore.value.to[Set]
    val sbtLog          = streams.value.log
    val outputDir       = os.Path(streams.value.cacheDirectory)
    val cacheDir        = (Global / stDir).value
    val outputPackage   = Name(stOutputPackage.value)

    val stLogger: logging.Logger[Unit] =
      if ((Global / stQuiet).value) logging.Logger.DevNull
      else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)

    val wantedLibs: Set[TsIdentLibrary] =
      Json.force[PackageJsonDeps](packageJsonFile).dependencies.getOrElse(Map()).keys.to[Set].map(TsIdentLibrary.apply)

    val versions = Versions(
      Versions.Scala(scalaVersion = (Compile / Keys.scalaVersion).value),
      Versions.ScalaJs(org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion),
    )

    val conversion = ConversionOptions(
      useScalaJsDomTypes    = stUseScalaJsDom.value,
      flavour               = stFlavour.value,
      outputPackage         = outputPackage,
      enableScalaJsDefined  = stEnableScalaJsDefined.value.map(TsIdentLibrary.apply),
      stdLibs               = IArray.fromTraversable(stStdlib.value),
      expandTypeMappings    = stInternalExpandTypeMappings.value.map(TsIdentLibrary.apply),
      ignoredLibs           = ignored.map(TsIdentLibrary.apply),
      ignoredModulePrefixes = ignored.map(_.split("/").toList),
      versions              = versions,
      organization          = "org.scalablytyped",
    )

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
      case Some((`input`, output)) if output.allJars.forall(os.exists) =>
        Def.task {
          stLogger.withContext(runCache).info(s"Using cached result :)")
          output.deps.map(Deps.asModuleID(versions))
        }

      case _ =>
        Def.task {
          ImportTypings(
            input              = input,
            logger             = stLogger,
            parseCacheDirOpt   = Some(cacheDir.toPath resolve "parse"),
            compiler           = ScalablyTypedPluginBase.stInternalZincCompiler.value,
            publishLocalFolder = constants.defaultLocalPublishFolder,
          ) match {
            case Right(output) =>
              Json.persist[InOut](runCache)((input, output))
              output.deps.map(Deps.asModuleID(versions))
            case Left(errors) =>
              errors.foreach {
                case (_, Left(th)) => throw th
                case _             => ()
              }

              sys.error(errors.mkString("\n").take(2000))
          }
        }
    }
  }

  override lazy val projectSettings =
    Seq(
      stImport := stImportTask.tag(Tags.Compile, Tags.CPU, Tags.Disk, ScalablyTypedTag).value,
    )
}
