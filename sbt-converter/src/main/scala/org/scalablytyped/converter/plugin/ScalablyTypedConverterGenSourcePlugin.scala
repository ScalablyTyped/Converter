package org.scalablytyped.converter
package plugin

import com.olvind.logging.LogLevel
import org.scalablytyped.converter.internal.*
import org.scalablytyped.converter.internal.orphanCodecs.{FileDecoder, FileEncoder}
import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import os.Path
import sbt.*
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.util.Try

object ScalablyTypedConverterGenSourcePlugin extends AutoPlugin {
  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  object autoImport extends GenSourceKeys {
    type SourceGenMode = plugin.SourceGenMode
    val SourceGenMode: plugin.SourceGenMode.type = plugin.SourceGenMode
    @deprecated(message = "Use stImportSources instead.", since = "1.0.0-beta42")
    val stImport = stImportSources
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = {
    import ScalablyTypedPluginBase.autoImport.*
    import autoImport.*
    import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.*

    Seq(
      stSourceGenMode := SourceGenMode.ResourceGenerator,
      Compile / Keys.sourceGenerators ++= {
        stSourceGenMode.value match {
          case SourceGenMode.ResourceGenerator => List(stImportSources.taskValue)
          case SourceGenMode.Manual(_, _)      => Nil
        }
      },
      Keys.libraryDependencies ++= {
        val conversion = stConversionOptions.value
        conversion.flavourImpl.dependencies.map(dep => Utils.asModuleID(dep.concrete(conversion.versions))).to(Seq)
      },
      stMinimize := Selection.None,
      stMinimizeKeep := Nil,
      ScalaJsBundlerHack.adaptScalaJSBundlerPackageJson,
      ScalaJsBundlerHack.adaptNpmInstallJSResources,
      stImportSources := {
        val stLogger   = WrapSbtLogger.task.value
        val conversion = stConversionOptions.value

        if (conversion.outputPackage == Name.typings) {
          stLogger.fatal("You must set `stOutputPackage` to a custom package")
        }

        val minimizeKeep = IArray
          .fromTraversable(stMinimizeKeep.value)
          .map(str => QualifiedName(conversion.outputPackage +: QualifiedName(str).parts))

        (Compile / npmUpdate).value

        val (toDir, overrideTargetFolder) = stSourceGenMode.value match {
          case SourceGenMode.ResourceGenerator =>
            (os.Path((Compile / Keys.sourceManaged).value / "scalablytyped"), Map.empty[TsIdentLibrary, Path])
          case SourceGenMode.Manual(toDir, overrideToDir) =>
            (os.Path(toDir), overrideToDir.map {
              case (libNameStr, file) => (TsIdentLibrary(libNameStr), os.Path(file))
            })
        }

        val nodeModulesDir = os.Path((Compile / npmUpdate / Keys.crossTarget).value / "node_modules")
        val globalCacheDir = (Global / stDir).value
        val cachedInputs   = os.Path(Keys.streams.value.cacheDirectory / "input.json")
        val cachedOutputs  = os.Path(Keys.streams.value.cacheDirectory / "output.json")

        val input = ImportTypingsGenSources.Input(
          converterVersion     = BuildInfo.version,
          conversion           = conversion,
          fromFolder           = InFolder(nodeModulesDir),
          targetFolder         = toDir,
          overrideTargetFolder = overrideTargetFolder,
          wantedLibs           = WantedLibs.setting.value,
          minimize             = stMinimize.value.map(TsIdentLibrary.apply),
          minimizeKeep         = minimizeKeep,
        )

        (Try(Json.force[ImportTypingsGenSources.Input](cachedInputs)).toOption, Json.opt[Seq[File]](cachedOutputs)) match {
          case (Some(`input`), Some(output)) =>
            stLogger.info("Nothing to do")
            output
          case _ =>
            ImportTypingsGenSources(
              input,
              stLogger.filter(LogLevel.warn),
              parseCacheDirOpt = Some(globalCacheDir.toPath.resolve("parse")),
              os.Path(globalCacheDir),
            ) match {
              case Right(files) =>
                val seqFiles = files.to(Seq)
                Json.persist(cachedInputs)(input)
                Json.persist(cachedOutputs)(seqFiles)
                seqFiles
              case Left(errors) =>
                sys.error(errors.mkString("\n"))
            }
        }
      },
    )
  }
}
