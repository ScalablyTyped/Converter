package org.scalablytyped.converter
package plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.ConversionOptions
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import org.scalablytyped.converter.internal.{
  constants,
  files,
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
import scalajsbundler.sbtplugin.{PackageJsonTasks, ScalaJSBundlerPlugin}

import scala.util.Try

object ScalablyTypedConverterPlugin extends AutoPlugin {
  implicit val PathFormatter: Formatter[Path] = _.toString

  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  import ScalablyTypedPluginBase.autoImport._
  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

  val stImportTask = Def.taskDyn[Set[ModuleID]] {
    val projectName   = name.value
    val ignored       = stIgnore.value.to[Set]
    val sbtLog        = streams.value.log
    val cacheDir      = (Global / stDir).value
    val outputPackage = Name(stOutputPackage.value)

    val stLogger: logging.Logger[Unit] =
      if ((Global / stQuiet).value) logging.Logger.DevNull
      else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)

    val allDeps = (Compile / npmDependencies).value ++ (Test / npmDependencies).value

    val wantedLibs: Set[TsIdentLibrary] =
      allDeps.map(_._1).to[Set].map(TsIdentLibrary.apply)

    val ScalaVersion = Versions.Scala(
      scalaVersion = (Compile / Keys.scalaVersion).value,
    )
    val ScalaJsVersion = Versions.ScalaJs(org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion)

    val versions = Versions(ScalaVersion, ScalaJsVersion)

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

    val fromFolder = InFolder(os.Path((Compile / npmUpdate / crossTarget).value / "node_modules"))

    val input = ImportTypings.Input(
      converterVersion = BuildInfo.version,
      packageJsonHash  = Digest.of(allDeps.map { case (name, v) => s"$name $v" }.sorted).hexString,
      conversion       = conversion,
      fromFolder       = fromFolder,
      targetFolder     = os.Path(streams.value.cacheDirectory) / "sources",
      wantedLibs       = wantedLibs,
    )

    val runCache = (cacheDir / "runs" / s"${input.hashCode}.json").toPath

    type InOut = (ImportTypings.Input, ImportTypings.Output)

    Try(Json.force[InOut](runCache)).toOption match {
      case Some((`input`, output)) if output.allJars.forall(files.exists) =>
        Def.task {
          stLogger.withContext(runCache).info(s"Using cached result :)")
          output.deps.map(Deps.asModuleID(versions))
        }

      case _ =>
        val t = Def.task {
          (Compile / npmInstallDependencies).value

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

        t.tag(Tags.Compile, Tags.CPU, Tags.Disk, ScalablyTypedTag)
    }
  }

  override lazy val projectSettings = {
    /* workaround private definition */
    val scalaJSBundlerPackageJson =
      TaskKey[BundlerFile.PackageJson](
        "scalaJSBundlerPackageJson",
        "Write a package.json file defining the NPM dependencies of project",
        KeyRanks.Invisible,
      )

    Seq(
      stImport := stImportTask.value,
      Compile / scalaJSBundlerPackageJson := {
        val deps = (Compile / npmDependencies).value
        /* Make sure we always include typescript for the stdlib if it wasnt already added */
        val withTypescript: Seq[(String, String)] =
          if (deps.exists { case (lib, _) => lib == "typescript" }) deps
          else deps :+ ("typescript" -> stTypescriptVersion.value)

        PackageJsonTasks.writePackageJson(
          (Compile / npmUpdate / crossTarget).value,
          withTypescript,
          (Compile / npmDevDependencies).value,
          (Compile / npmResolutions).value,
          (Compile / additionalNpmConfig).value,
          fullClasspath = Nil,
          Compile,
          (Compile / webpack / version).value,
          (Compile / startWebpackDevServer / version).value,
          (Compile / webpackCliVersion).value,
          (Compile / scalaJSBundlerPackageJson / streams).value,
        )
      },
    )
  }
}
