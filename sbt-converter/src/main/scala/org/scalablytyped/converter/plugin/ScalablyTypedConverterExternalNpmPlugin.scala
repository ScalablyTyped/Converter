package org.scalablytyped.converter.plugin

import _root_.io.circe013.syntax.*
import com.olvind.logging.LogLevel
import org.scalablytyped.converter.internal.*
import org.scalablytyped.converter.internal.RunCache.Present
import org.scalablytyped.converter.internal.ts.{PackageJson, TsIdentLibrary}
import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.*

import scala.collection.immutable.SortedMap
import scala.concurrent.ExecutionContext

object ScalablyTypedConverterExternalNpmPlugin extends AutoPlugin {
  private[plugin] val stInternalZincCompiler = taskKey[ZincCompiler]("Hijack compiler settings")

  object autoImport extends ConverterKeys with ExternalNpmKeys

  import ScalablyTypedPluginBase.autoImport.*
  import autoImport.*

  override val requires = ScalablyTypedPluginBase && ScalaJSPlugin

  private[plugin] lazy val stImportTask: Def.Initialize[Task[ImportTypings.InOut]] = Def.taskDyn {
    val folder             = os.Path(externalNpm.value)
    val packageJsonFile    = folder / "package.json"
    val nodeModules        = InFolder(folder / "node_modules")
    val outputDir          = os.Path(Keys.streams.value.cacheDirectory)
    val cacheDir           = (Global / stDir).value
    val publishLocalFolder = Utils.IvyLocal.value
    val stLogger           = WrapSbtLogger.task.value

    val wantedLibs: SortedMap[TsIdentLibrary, String] =
      Json.force[PackageJson](packageJsonFile).allLibs(dev = stIncludeDev.value, peer = false)

    val conversion = stConversionOptions.value

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
      os.Path(cacheDir),
      publishLocalFolder,
      stLogger,
    )(ExecutionContext.global)

    completeRunPresent match {
      case Present.Yes(output) =>
        Def.task((input, output))

      case Present.No =>
        val t = Def.task {
          ImportTypings(
            input              = input,
            logger             = stLogger.filter(LogLevel.warn),
            parseCacheDirOpt   = Some(cacheDir.toPath.resolve("parse")),
            publishLocalFolder = publishLocalFolder,
            fromFolder         = nodeModules,
            targetFolder       = outputDir / "sources",
            compiler           = stInternalZincCompiler.value,
          ) match {
            case Right(output) =>
              Json.persist[ImportTypings.InOut](runCacheKey.path(os.Path(cacheDir)))((input, output))
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
      stImport := stImportTask.value,
      /* This is where we add our generated artifacts to the project for compilation */
      Keys.allDependencies ++= stImport.value._2.moduleIds.toSeq,
      stInternalZincCompiler := ZincCompiler.task.value,
      stPublishCache := RunCache.publishCacheTask(stImport).value,
    )
}
