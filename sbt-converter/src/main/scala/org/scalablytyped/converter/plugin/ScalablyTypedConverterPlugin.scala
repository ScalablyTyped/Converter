package org.scalablytyped.converter
package plugin

import _root_.io.circe013.syntax.*
import com.olvind.logging.LogLevel
import org.scalablytyped.converter.internal.*
import org.scalablytyped.converter.internal.RunCache.Present
import sbt.*
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.concurrent.ExecutionContext

object ScalablyTypedConverterPlugin extends AutoPlugin {
  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  private[plugin] val stInternalZincCompiler = taskKey[ZincCompiler]("Hijack compiler settings")

  object autoImport extends ConverterKeys

  import ScalablyTypedPluginBase.autoImport.*
  import autoImport.*
  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.*

  private[plugin] val stImportTask = Def.taskDyn[ImportTypings.InOut] {
    val cacheDir           = os.Path((Global / stDir).value)
    val stLogger           = WrapSbtLogger.task.value
    val conversion         = stConversionOptions.value
    val publishLocalFolder = Utils.IvyLocal.value
    val fromFolder         = InFolder(os.Path((Compile / npmUpdate / Keys.crossTarget).value / "node_modules"))
    val targetFolder       = os.Path(Keys.streams.value.cacheDirectory) / "sources"

    val input = new ImportTypings.Input(
      converterVersion = BuildInfo.version,
      conversion       = conversion,
      wantedLibs       = WantedLibs.setting.value,
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
      Keys.allDependencies ++= stImport.value._2.moduleIds.toSeq,
      stImport := stImportTask.value,
      stInternalZincCompiler := ZincCompiler.task.value,
      ScalaJsBundlerHack.adaptScalaJSBundlerPackageJson,
      stPublishCache := RunCache.publishCacheTask(stImport).value,
    )
}
