package org.scalablytyped.converter
package plugin

import _root_.io.circe013.syntax._
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.RunCache.Present
import org.scalablytyped.converter.internal._
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.concurrent.ExecutionContext

object ScalablyTypedConverterPlugin extends AutoPlugin {
  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  private[plugin] val stInternalZincCompiler = taskKey[ZincCompiler]("Hijack compiler settings")

  object autoImport {
    val stImport       = taskKey[ImportTypings.InOut]("Imports all the bundled npm and generates bindings")
    val stPublishCache = taskKey[Unit]("Publish all necessary files to cache")
  }

  import ScalablyTypedPluginBase.autoImport._
  import autoImport._
  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

  private[plugin] val stImportTask = Def.taskDyn[ImportTypings.InOut] {
    val cacheDir           = os.Path((Global / stDir).value)
    val stLogger           = WrapSbtLogger.task.value
    val allDeps            = (Compile / npmDependencies).value ++ (Test / npmDependencies).value
    val wantedLibs         = allDeps.map { case (name, version) => TsIdentLibrary(name) -> version }.toMap.toSorted
    val conversion         = stConversionOptions.value
    val publishLocalFolder = Utils.IvyLocal.value
    val fromFolder         = InFolder(os.Path((Compile / npmUpdate / crossTarget).value / "node_modules"))
    val targetFolder       = os.Path(streams.value.cacheDirectory) / "sources"

    val input = ImportTypings.Input(
      converterVersion = BuildInfo.version,
      conversion       = conversion,
      wantedLibs       = wantedLibs,
    )

    val runCacheKey = RunCache.Key(input)

    stLogger.debug(input.asJson.spaces2)
    stLogger.debug(input.packageJsonHash)
    stLogger.debug(runCacheKey)

    val completeRunPresent = RunCache.fetch(
      (Global / stRemoteCache).value,
      runCacheKey,
      cacheDir,
      publishLocalFolder,
      stLogger,
    )(ExecutionContext.global)

    completeRunPresent match {
      case Present.Yes(output) =>
        Def.task((input, output))
      case Present.No =>
        val t = Def.task {
          (Compile / npmInstallDependencies).value

          ImportTypings(
            input              = input,
            logger             = stLogger.filter(LogLevel.warn),
            parseCacheDirOpt   = Some(cacheDir.toNIO.resolve("parse")),
            publishLocalFolder = publishLocalFolder,
            fromFolder         = fromFolder,
            targetFolder       = targetFolder,
            compiler           = stInternalZincCompiler.value,
          ) match {
            case Right(output) =>
              Json.persist[ImportTypings.InOut](runCacheKey.path(cacheDir))((input, output))
              (input, output)
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
      /* This is where we add our generated artifacts to the project for compilation */
      allDependencies ++= stImport.value._2.moduleIds.toSeq,
      stImport := stImportTask.value,
      stInternalZincCompiler := ZincCompiler.task.value,
      ScalaJsBundlerHack.adaptScalaJSBundlerPackageJson,
      stPublishCache := RunCache.publishCacheTask(stImport).value,
    )
}
