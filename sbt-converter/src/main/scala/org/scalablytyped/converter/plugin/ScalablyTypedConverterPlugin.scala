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
  ZincCompiler,
}
import sbt.Keys._
import sbt._
import sbt.librarymanagement.ModuleID
import scalajsbundler.sbtplugin.{PackageJsonTasks, ScalaJSBundlerPlugin}

import scala.org.scalablytyped.converter.internal.ScalaJsBundlerHack
import scala.util.Try

object ScalablyTypedConverterPlugin extends AutoPlugin {
  private implicit val PathFormatter: Formatter[Path] = _.toString

  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  private[plugin] val stInternalZincCompiler = taskKey[ZincCompiler]("Hijack compiler settings")

  object autoImport {
    val stImport = taskKey[Set[ModuleID]]("Imports all the bundled npm and generates bindings")
  }

  import ScalablyTypedPluginBase.autoImport._
  import autoImport._
  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

  private[plugin] val stImportTask = Def.taskDyn[Set[ModuleID]] {
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
      enableImplicitOps     = stExperimentalEnableImplicitOps.value,
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
            compiler           = stInternalZincCompiler.value,
            publishLocalFolder = ivyPaths.value.ivyHome.fold(constants.defaultLocalPublishFolder)(os.Path(_) / "local"),
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
      /* This is where we add our generated artifacts to the project for compilation */
      allDependencies ++= stImport.value.toSeq,
      stImport := stImportTask.value,
      stInternalZincCompiler := ZincCompiler.task.value,
      ScalaJsBundlerHack.adaptScalaJSBundlerPackageJson,
    )
  }
}
