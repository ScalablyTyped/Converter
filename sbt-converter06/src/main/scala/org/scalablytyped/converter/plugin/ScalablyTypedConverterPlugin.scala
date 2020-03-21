package org.scalablytyped.converter
package plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.{Json, SharedInput}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import org.scalablytyped.converter.internal.{BuildInfo, Deps, Digest, IArray, ImportTypings, InFolder, WrapSbtLogger}
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.{NpmUpdateTasks, PackageJsonTasks, ScalaJSBundlerPlugin}

import scala.util.Try

object ScalablyTypedConverterPlugin extends AutoPlugin {
  implicit val PathFormatter: Formatter[Path] = _.toString

  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  import ScalablyTypedPluginBase.autoImport._
  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

  /** This is duplicated/inlined from scalajs-bundler.
    *
    *  The point is that we need to deactivate the scalajs-bundler feature of looking for npm libs
    *  from special files on the classpath.
    *
    * Why? Because it would be a cyclic dependency, since we generate part of the classpath
    */
  private val stInternalNpmInstallDependencies = taskKey[File]("Install deps from npm")

  val stImportTask = Def.task[Set[ModuleID]] {

    val projectName     = name.value
    val packageJsonFile = (npmUpdate / crossTarget).value / "package.json"
    val ignored         = stIgnore.value.to[Set]
    val sbtLog          = streams.value.log
    val cacheDir        = (Global / stDir).value
    val outputPackage   = Name(stOutputPackage.value)

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

    val fromFolder = InFolder(os.Path(stInternalNpmInstallDependencies.value / "node_modules"))

    val input = ImportTypings.Input(
      converterVersion = BuildInfo.version,
      packageJsonHash  = Digest.of(List(os.read.bytes(os.Path(packageJsonFile)))).hexString,
      shared           = shared,
      fromFolder       = fromFolder,
      targetFolder     = os.Path(streams.value.cacheDirectory) / "sources",
    )

    val runCache = (cacheDir / "runs" / s"${input.hashCode}.json").toPath

    type InOut = (ImportTypings.Input, ImportTypings.Output)

    val result = Try(Json[InOut](runCache)).toOption match {
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

  val stInternalNpmInstallDependenciesTask = Def.task[File] {
    val packageJson = PackageJsonTasks.writePackageJson(
      (crossTarget in npmUpdate).value,
      (Compile / npmDependencies).value,
      (Compile / npmDevDependencies).value,
      (Compile / npmResolutions).value,
      (Compile / additionalNpmConfig).value,
      Nil,
      Compile,
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

  override lazy val projectSettings =
    Seq(
      stInternalNpmInstallDependencies := stInternalNpmInstallDependenciesTask.value,
      stImport := stImportTask.tag(Tags.Compile, Tags.CPU, Tags.Disk, ScalablyTypedTag).value,
      /* Make sure we always include typescript for the stdlib if it wasnt already added */
      Compile / npmDependencies ++= {
        (Compile / npmDependencies).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> stTypescriptVersion.value))(_ => Nil)
      },
    )
}
