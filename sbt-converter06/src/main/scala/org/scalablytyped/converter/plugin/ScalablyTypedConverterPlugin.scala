package org.scalablytyped.converter
package plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.jsonCodecs.{FileDecoder, FileEncoder}
import org.scalablytyped.converter.internal.importer.{Json, SharedInput}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import org.scalablytyped.converter.internal.{
  BuildInfo,
  Digest,
  IArray,
  ImportTypings,
  InFolder,
  WrapSbtLogger,
  ZincCompiler,
}
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.{NpmUpdateTasks, PackageJsonTasks, ScalaJSBundlerPlugin}

import scala.util.Try

object ScalablyTypedConverterPlugin extends AutoPlugin {
  implicit val PathFormatter: Formatter[Path] = _.toString

  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  import ScalablyTypedPluginBase.autoImport._
  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

  val stImportTask = Def.task[Seq[Attributed[File]]] {

    val projectName     = name.value
    val packageJsonFile = (npmUpdate / crossTarget).value / "package.json"
    val ignored         = stIgnore.value.to[Set]
    val sbtLog          = streams.value.log
    val outputDir       = os.Path(streams.value.cacheDirectory)
    val cacheDir        = (Global / stDir).value
    val outputPackage   = Name((Compile / stOutputPackage).value)

    val stLogger: logging.Logger[Unit] =
      if ((Global / stQuiet).value) logging.Logger.DevNull
      else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)

    val wantedLibs: Set[TsIdentLibrary] =
      ((Compile / npmDependencies).value ++ (Test / npmDependencies).value)
        .map(_._1)
        .to[Set]
        .map(TsIdentLibrary.apply)

    val ScalaVersion = Versions.Scala(
      scalaVersion = (Compile / Keys.scalaVersion).value,
      binVersion   = (Compile / Keys.scalaBinaryVersion).value,
    )
    val ScalaJsVersion = Versions.ScalaJs(org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion)

    val versions = Versions(ScalaVersion, ScalaJsVersion)
    val compiler = new ZincCompiler((stInternalCompileInputs in compile).value, stLogger, versions)

    val shared = SharedInput(
      shouldUseScalaJsDomTypes = (Compile / stUseScalaJsDom).value,
      wantedLibs               = wantedLibs,
      flavour                  = (Compile / stFlavour).value,
      outputPackage            = outputPackage,
      enableScalaJsDefined     = stEnableScalaJsDefined.value.map(TsIdentLibrary.apply),
      stdLibs                  = IArray.fromTraversable(stStdlib.value),
      expandTypeMappings       = stInternalExpandTypeMappings.value.map(TsIdentLibrary.apply),
      ignoredLibs              = ignored.map(TsIdentLibrary.apply),
      ignoredModulePrefixes    = ignored.map(_.split("/").toList),
      versions                 = versions,
    )

    val fromFolder = InFolder(os.Path((stInternalNpmInstallDependencies).value / "node_modules"))

    val input = ImportTypings.Input(
      converterVersion = BuildInfo.version,
      packageJsonHash  = Digest.of(List(os.read.bytes(os.Path(packageJsonFile)))).hexString,
      shared           = shared,
      fromFolder       = fromFolder,
      targetFolder     = outputDir / "sources",
    )

    val runCache = (cacheDir / "runs" / s"${input.hashCode}.json").toPath

    type InOut = (ImportTypings.Input, Seq[File])

    Try(Json[InOut](runCache)).toOption match {
      case Some((`input`, output)) if output.forall(_.exists()) =>
        stLogger.withContext(runCache).warn(s"Using cached result :)")
        Attributed.blankSeq(output)
      case _ =>
        val ran = ImportTypings(
          input            = input,
          logger           = stLogger,
          parseCacheDirOpt = Some(cacheDir.toPath resolve "parse"),
          compiler         = compiler,
          publishFolder    = os.Path(cacheDir) / 'artifacts,
        )
        ran match {
          case Right(files) =>
            val outSeq = files.to[Seq]
            Json.persist[InOut](runCache)((input, outSeq))
            Attributed.blankSeq(outSeq)
          case Left(errors) =>
            errors.foreach {
              case (_, Left(th)) => throw th
              case _             => ()
            }

            sys.error(errors.mkString("\n").take(2000))
        }

    }
  }

  val stInternalNpmInstallDependenciesTask = Def.task[File] {
    val packageJson = PackageJsonTasks.writePackageJson(
      (crossTarget in npmUpdate).value,
      npmDependencies.value,
      npmDevDependencies.value,
      npmResolutions.value,
      additionalNpmConfig.value,
      Nil,
      configuration.value,
      (version in webpack).value,
      (version in startWebpackDevServer).value,
      webpackCliVersion.value,
      streams.value,
    )

    NpmUpdateTasks.npmInstallDependencies(
      baseDirectory.value,
      (crossTarget in npmUpdate).value,
      packageJson.file,
      useYarn.value,
      streams.value,
      npmExtraArgs.value,
      yarnExtraArgs.value,
    )
  }

  lazy val stScalaJsBundlerIntegration: Seq[Def.Setting[_]] = {

    Seq(
      /* Make sure we always include typescript for the stdlib if it wasnt already added */
      npmDependencies ++= {
        npmDependencies.value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (stTypescriptVersion).value))(_ => Nil)
      },
      /** This is duplicated/inlined from scalajs-bundler.
        *  The point is that we cannot reference unmanaged here,
        *  because we exploit it to add our generated artifacts later */
      stInternalNpmInstallDependencies := stInternalNpmInstallDependenciesTask.value,
      stImport := stImportTask.tag(Tags.Compile, Tags.CPU, Tags.Disk, ScalablyTypedTag).value,
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(stScalaJsBundlerIntegration)
}
