package org.scalablytyped.converter
package plugin

import com.olvind.logging.LogLevel
import org.scalablytyped.converter.internal._
import org.scalablytyped.converter.internal.orphanCodecs.{FileDecoder, FileEncoder}
import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.util.Try

object ScalablyTypedConverterGenSourcePlugin extends AutoPlugin {
  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  object autoImport {
    sealed trait SourceGenMode
    object SourceGenMode {
      case object ResourceGenerator extends SourceGenMode
      case class Manual(toDir: File) extends SourceGenMode
    }

    val stSourceGenMode = settingKey[SourceGenMode]("Whether to run automatically as source generator or manually")

    /**
      * A list of library names you don't care too much about.
      * The idea is that we can limit compile time (by a lot!)
      */
    val stMinimize = settingKey[Selection[String]]("Specify which libraries you want minimized")

    /**
      * If you care about a small set of specific things from a library you can explicitly say you want that.
      * Examples:
      * - `angularCommon.mod.AsyncPipe`
      * - `std.console`
      */
    val stMinimizeKeep = settingKey[List[String]]("a list of things you want to keep from minimized libraries")

    val stImport = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = {
    import ScalablyTypedPluginBase.autoImport._
    import autoImport._
    import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

    Seq(
      stSourceGenMode := SourceGenMode.ResourceGenerator,
      Compile / sourceGenerators ++= {
        stSourceGenMode.value match {
          case SourceGenMode.ResourceGenerator => List(stImport.taskValue)
          case SourceGenMode.Manual(_)         => Nil
        }
      },
      libraryDependencies ++= {
        val conversion = stConversionOptions.value
        conversion.flavourImpl.dependencies.map(dep => Utils.asModuleID(dep.concrete(conversion.versions))).to[Seq]
      },
      stMinimize := Selection.None,
      stMinimizeKeep := Nil,
      ScalaJsBundlerHack.adaptScalaJSBundlerPackageJson,
      ScalaJsBundlerHack.adaptNpmInstallJSResources,
      stImport := {
        val stLogger   = WrapSbtLogger.task.value
        val conversion = stConversionOptions.value

        if (conversion.outputPackage == Name.typings) {
          stLogger.fatal("You must set `stOutputPackage` to a custom package")
        }

        val minimizeKeep = IArray
          .fromTraversable(stMinimizeKeep.value)
          .map(str => QualifiedName(conversion.outputPackage +: QualifiedName(str).parts))

        (Compile / npmUpdate).value

        val toDir = stSourceGenMode.value match {
          case SourceGenMode.ResourceGenerator =>
            os.Path((Compile / sourceManaged).value / "scalablytyped")
          case SourceGenMode.Manual(toDir) =>
            os.Path(toDir)
        }

        val nodeModulesDir = os.Path((Compile / npmUpdate / crossTarget).value / "node_modules")
        val globalCacheDir = (Global / stDir).value
        val cachedInputs   = os.Path(streams.value.cacheDirectory / "input.json")
        val cachedOutputs  = os.Path(streams.value.cacheDirectory / "output.json")

        val input = ImportTypingsGenSources.Input(
          converterVersion = BuildInfo.version,
          conversion       = conversion,
          fromFolder       = InFolder(nodeModulesDir),
          targetFolder     = toDir,
          wantedLibs       = WantedLibs.setting.value,
          minimize         = stMinimize.value.map(TsIdentLibrary.apply),
          minimizeKeep     = minimizeKeep,
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
                val seqFiles = files.to[Seq]
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
