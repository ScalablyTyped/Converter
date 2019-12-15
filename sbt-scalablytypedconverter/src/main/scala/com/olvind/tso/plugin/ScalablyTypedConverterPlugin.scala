package com.olvind.tso
package plugin

import com.olvind.tso.importer.jsonCodecs.{FileDecoder, FileEncoder, PackageJsonDepsDecoder}
import com.olvind.logging.LogLevel
import com.olvind.tso.importer.Json
import com.olvind.tso.ts.{PackageJsonDeps, TsIdentLibrary}
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

object ScalablyTypedConverterExternalNpmPlugin extends AutoPlugin {
  object autoImport {
    val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
  }

  override def requires = ScalablyTypedPluginBase

  lazy val tsoExternalNpmIntegration: Seq[Def.Setting[_]] = {
    import ScalablyTypedPluginBase.autoImport._
    import autoImport._

    Seq(
      tsoImport := {
        val cacheDirectory   = streams.value.cacheDirectory
        val flavour          = tsoFlavour.value
        val tsoLogger        = WrapSbtLogger(streams.value.log).filter(LogLevel.warn).void
        val folder           = os.Path(externalNpm.value)
        val packageJson      = folder / "package.json"
        val nodeModules      = InFolder(folder / "node_modules")
        val stdLib           = tsoStdlib.value
        val targetFolder     = os.Path((sourceManaged in Compile).value / "tso")
        val npmDeps          = Json[PackageJsonDeps](packageJson).dependencies.getOrElse(Map())
        val ignored          = tsoIgnore.value.to[Set]
        val minimize         = tsoMinimize.value.map(TsIdentLibrary.apply)
        val prettyStringType = tsoPrettyStringType.value

        val config = ImportTypings.Input(
          os.read(packageJson).hashCode,
          npmDeps.to[Seq],
          nodeModules,
          targetFolder,
          flavour,
          prettyStringType,
          stdLib,
          ignored,
          minimize,
        )

        val inputPath  = os.Path(cacheDirectory / "tso" / "input.json")
        val outputPath = os.Path(cacheDirectory / "tso" / "output.json")

        (Json.opt[ImportTypings.Input](inputPath), Json.opt[Seq[File]](outputPath)) match {
          case (Some(`config`), Some(output)) =>
            tsoLogger.warn("Nothing to do")
            output
          case _ =>
            ImportTypings(config, tsoLogger) match {
              case Right(files) =>
                val seqFiles = files.to[Seq]
                Json.persist(inputPath)(config)
                Json.persist(outputPath)(seqFiles)
                seqFiles
              case Left(errors) =>
                sys.error(errors.mkString("\n"))
            }
        }
      },
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(tsoExternalNpmIntegration)
}

object ScalablyTypedConverterPlugin extends AutoPlugin {
  override def requires = ScalablyTypedPluginBase && ScalaJSBundlerPlugin

  lazy val tsoScalaJsBundlerIntegration: Seq[Def.Setting[_]] = {
    import ScalablyTypedPluginBase.autoImport._
    import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

    Seq(
      //Make sure we always include the stdlib
      npmDependencies in Compile ++= {
        //Make sure it doesn't already exist
        (npmDependencies in Compile).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (tsoTypescriptVersion).value))(_ => Seq.empty)
      },
      tsoImport := {
        val cacheDirectory   = streams.value.cacheDirectory
        val flavour          = tsoFlavour.value
        val tsoLogger        = WrapSbtLogger(streams.value.log).filter(LogLevel.warn).void
        val packageJson      = (crossTarget in npmUpdate).value / "package.json"
        val nodeModules      = InFolder(os.Path((npmInstallDependencies in Compile).value / "node_modules"))
        val stdLib           = tsoStdlib.value
        val targetFolder     = os.Path((sourceManaged in Compile).value / "tso")
        val npmDeps          = (npmDependencies in Compile).value ++ (npmDependencies in Test).value
        val ignored          = tsoIgnore.value.to[Set]
        val minimize         = tsoMinimize.value.map(TsIdentLibrary.apply)
        val prettyStringType = tsoPrettyStringType.value

        val config = ImportTypings.Input(
          os.read(os.Path(packageJson)).hashCode,
          npmDeps.to[Seq],
          nodeModules,
          targetFolder,
          flavour,
          prettyStringType,
          stdLib,
          ignored,
          minimize,
        )

        val inputPath  = os.Path(cacheDirectory / "tso" / "input.json")
        val outputPath = os.Path(cacheDirectory / "tso" / "output.json")

        (Json.opt[ImportTypings.Input](inputPath), Json.opt[Seq[File]](outputPath)) match {
          case (Some(`config`), Some(output)) =>
            tsoLogger.warn("Nothing to do")
            output
          case _ =>
            ImportTypings(config, tsoLogger) match {
              case Right(files) =>
                val seqFiles = files.to[Seq]
                Json.persist(inputPath)(config)
                Json.persist(outputPath)(seqFiles)
                seqFiles
              case Left(errors) =>
                sys.error(errors.mkString("\n"))
            }
        }
      },
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(tsoScalaJsBundlerIntegration)
}

object ScalablyTypedPluginBase extends AutoPlugin {
  object autoImport {
    type Selection[T] = com.olvind.tso.plugin.Selection[T]
    val Selection = com.olvind.tso.plugin.Selection
    type Flavour = com.olvind.tso.plugin.Flavour
    val Flavour = com.olvind.tso.plugin.Flavour
    type PrettyStringType = com.olvind.tso.plugin.PrettyStringType
    val PrettyStringType = com.olvind.tso.plugin.PrettyStringType

    val tsoImport  = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val tsoIgnore  = settingKey[List[String]]("completely ignore libs")
    val tsoFlavour = settingKey[Flavour]("The type of react binding to use")
    val tsoPrettyStringType = settingKey[PrettyStringType](
      "Temporary, don't use unless you know what you're doing. Used to choose which name prettyfier will be used",
    )

    /**
      * A list of library names you don't care too much about.
      * The idea is that we can limit compile time (by a lot!)
      */
    val tsoMinimize = settingKey[Selection[String]]("")

    /** Options are
      * dom
      * dom.iterable
      * es2015.collection
      * es2015.core
      * es2015
      * es2015.generator
      * es2015.iterable
      * es2015.promise
      * es2015.proxy
      * es2015.reflect
      * es2015.symbol
      * es2015.symbol.wellknown
      * es2016.array.include
      * es2016
      * es2016.full
      * es2017
      * es2017.full
      * es2017.intl
      * es2017.object
      * es2017.sharedmemory
      * es2017.string
      * es2017.typedarrays
      * es2018.asyncgenerator
      * es2018.asynciterable
      * es2018
      * es2018.full
      * es2018.intl
      * es2018.promise
      * es2018.regexp
      * es2019.array
      * es2019
      * es2019.full
      * es2019.object
      * es2019.string
      * es2019.symbol
      * es2020
      * es2020.full
      * es2020.string
      * es2020.symbol.wellknown
      * es5
      * es6
      * esnext.array
      * esnext.asynciterable
      * esnext.bigint
      * esnext
      * esnext.full
      * esnext.intl
      * esnext.symbol
      * scripthost
      * webworker
      * webworker.importscripts
      */
    val tsoStdlib = settingKey[List[String]](
      "Which versions of typescript library to include (same as `lib` in tsconfig.json)",
    )
    val tsoTypescriptVersion = settingKey[String](
      "The version of the typescript library that it should use",
    )
  }

  override def requires = JvmPlugin && PlatformDepsPlugin

  lazy val tsoOutsideConfig: Seq[Def.Setting[_]] = {
    import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
    import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion
    Seq(
      libraryDependencies ++= Seq(constants.RuntimeOrg %%% constants.RuntimeName % constants.RuntimeVersion),
      scalacOptions ++= {
        val isScalaJs1 = !scalaJSVersion.startsWith("0.6")

        val old = scalacOptions.value
        if (old.contains("-P:scalajs:sjsDefinedByDefault") || isScalaJs1) Nil
        else Seq("-P:scalajs:sjsDefinedByDefault")
      },
    )
  }

  lazy val tsoDefaults: Seq[Def.Setting[_]] = {
    import autoImport._
    Seq(
      tsoFlavour := com.olvind.tso.plugin.Flavour.Plain,
      tsoPrettyStringType := com.olvind.tso.plugin.PrettyStringType.Regular,
      tsoTypescriptVersion := "3.7.2",
      tsoStdlib := List("es6"),
      tsoIgnore := List("typescript"),
      tsoMinimize := com.olvind.tso.plugin.Selection.None(),
      sourceGenerators in Compile += tsoImport.taskValue,
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(tsoDefaults) ++ tsoOutsideConfig
}
