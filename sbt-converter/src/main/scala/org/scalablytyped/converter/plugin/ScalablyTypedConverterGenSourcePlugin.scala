package org.scalablytyped.converter
package plugin

import java.time.Instant

import com.olvind.logging
import com.olvind.logging.LogLevel
import org.scalablytyped.converter.internal.importer.jsonCodecs.{FileDecoder, FileEncoder}
import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import org.scalablytyped.converter.internal._
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.org.scalablytyped.converter.internal.ScalaJsBundlerHack
import scala.util.Try

object ScalablyTypedConverterGenSourcePlugin extends AutoPlugin {
  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  object autoImport {

    /**
      * A list of library names you don't care too much about.
      * The idea is that we can limit compile time (by a lot!)
      */
    val stMinimize = settingKey[Selection[String]]("")

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
      Compile / sourceGenerators += stImport.taskValue,
      libraryDependencies ++= {
        val conversion = stConversionOptions.value
        conversion.flavourImpl.dependencies.map(Deps.asModuleID(conversion.versions)).to[Seq]
      },
      stMinimize := Selection.None,
      stMinimizeKeep := Nil,
      ScalaJsBundlerHack.adaptScalaJSBundlerPackageJson,
      ScalaJsBundlerHack.adaptNpmInstallJSResources,
      stImport := {
        val logger: logging.Logger[Unit] = {
          val projectName = name.value
          val sbtLog      = streams.value.log

          if ((Global / stQuiet).value) logging.Logger.DevNull
          else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)
        }
        val conversion = stConversionOptions.value

        if (conversion.outputPackage == Name.typings) {
          logger.fatal("You must set `stOutputPackage` to a custom package")
        }

        val minimizeKeep = IArray
          .fromTraversable(stMinimizeKeep.value)
          .map(str => QualifiedName(conversion.outputPackage +: QualifiedName(str).parts))

        (Compile / npmUpdate).value

        val fromDir        = os.Path((Compile / npmUpdate / crossTarget).value / "node_modules")
        val toDir          = os.Path((Compile / sourceManaged).value / "scalablytyped")
        val globalCacheDir = (Global / stDir).value
        val cachedInputs   = os.Path(streams.value.cacheDirectory / "input.json")
        val cachedOutputs  = os.Path(streams.value.cacheDirectory / "output.json")

        val wantedLibs = {
          val allDeps = (Compile / npmDependencies).value ++ (Test / npmDependencies).value
          allDeps.map(_._1).to[Set].map(TsIdentLibrary.apply)
        }

        val input = ImportTypingsGenSources.Input(
          converterVersion = BuildInfo.version,
          conversion       = conversion,
          fromFolder       = InFolder(fromDir),
          targetFolder     = toDir,
          wantedLibs       = wantedLibs,
          minimize         = stMinimize.value.map(TsIdentLibrary.apply),
          minimizeKeep     = minimizeKeep,
        )

        (Try(Json.force[ImportTypingsGenSources.Input](cachedInputs)).toOption, Json.opt[Seq[File]](cachedOutputs)) match {
          case (Some(`input`), Some(output)) =>
            logger.warn("Nothing to do")
            output
          case _ =>
            ImportTypingsGenSources(
              input,
              logger,
              parseCacheDirOpt = Some(globalCacheDir.toPath resolve "parse"),
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
