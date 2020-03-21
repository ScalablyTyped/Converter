package org.scalablytyped.converter.plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.jsonCodecs.PackageJsonDepsDecoder
import org.scalablytyped.converter.internal.importer.{Json, SharedInput}
import org.scalablytyped.converter.internal.scalajs.{Dep, Name, Versions}
import org.scalablytyped.converter.internal.ts.{PackageJsonDeps, TsIdentLibrary}
import org.scalablytyped.converter.internal.{BuildInfo, Deps, Digest, IArray, ImportTypings, InFolder, WrapSbtLogger}
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

  lazy val stImportTask = Def.task {
    val projectName     = name.value
    val folder          = os.Path(externalNpm.value)
    val packageJsonFile = folder / "package.json"
    val ignored         = stIgnore.value.to[Set]
    val sbtLog          = streams.value.log
    val outputDir       = os.Path(streams.value.cacheDirectory)
    val cacheDir        = (Global / stDir).value
    val outputPackage   = Name(stOutputPackage.value)

    val stLogger: logging.Logger[Unit] =
      if ((Global / stQuiet).value) logging.Logger.DevNull
      else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)

    val wantedLibs: Set[TsIdentLibrary] =
      Json[PackageJsonDeps](packageJsonFile).dependencies.getOrElse(Map()).keys.to[Set].map(TsIdentLibrary.apply)

    val versions = Versions(
      Versions.Scala(
        scalaVersion = (Compile / Keys.scalaVersion).value,
        binVersion   = (Compile / Keys.scalaBinaryVersion).value,
      ),
      Versions.ScalaJs(org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion),
    )
    val compiler = ScalablyTypedPluginBase.stInternalZincCompiler.value

    val shared = SharedInput(
      shouldUseScalaJsDomTypes = stUseScalaJsDom.value,
      wantedLibs               = wantedLibs,
      flavour                  = stFlavour.value,
      outputPackage            = outputPackage,
      enableScalaJsDefined     = stEnableScalaJsDefined.value.map(TsIdentLibrary.apply),
      stdLibs                  = IArray.fromTraversable(stStdlib.value),
      expandTypeMappings       = stInternalExpandTypeMappings.value.map(TsIdentLibrary.apply),
      ignoredLibs              = ignored.map(TsIdentLibrary.apply),
      ignoredModulePrefixes    = ignored.map(_.split("/").toList),
      versions                 = versions,
    )

    val fromFolder = InFolder(folder / "node_modules")

    val input = ImportTypings.Input(
      converterVersion = BuildInfo.version,
      packageJsonHash  = Digest.of(List(os.read.bytes(packageJsonFile))).hexString,
      shared           = shared,
      fromFolder       = fromFolder,
      targetFolder     = outputDir / "sources",
    )

    val runCache = (cacheDir / "runs" / s"${input.hashCode}.json").toPath

    type InOut = (ImportTypings.Input, ImportTypings.Output)

    val result: Set[Dep] =
      Try(Json[InOut](runCache)).toOption match {
        case Some((`input`, output)) if output.allJars.forall(os.exists) =>
          stLogger.withContext(runCache).info(s"Using cached result :)")
          output.deps
        case _ =>
          val ran = ImportTypings(
            input            = input,
            logger           = stLogger,
            parseCacheDirOpt = Some(cacheDir.toPath resolve "parse"),
            compiler         = compiler,
            publishFolder    = os.home / ".ivy2" / "local",
          )
          ran match {
            case Right(output) =>
              Json.persist[InOut](runCache)((input, output))
              output.deps
            case Left(errors) =>
              errors.foreach {
                case (_, Left(th)) => throw th
                case _             => ()
              }

              sys.error(errors.mkString("\n").take(2000))
          }
      }

    result.map(Deps.asModuleID(versions))
  }

  override lazy val projectSettings =
    Seq(
      stImport := stImportTask.tag(Tags.Compile, Tags.CPU, Tags.Disk, ScalablyTypedTag).value,
    )
}
