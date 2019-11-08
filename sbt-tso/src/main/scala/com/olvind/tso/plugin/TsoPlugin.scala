package com.olvind.tso
package plugin

import com.olvind.logging.LogLevel
import com.olvind.tso.ts.TsIdentLibrary
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

object TsoPlugin extends AutoPlugin {
  object autoImport {
    type Selection[T] = com.olvind.tso.plugin.Selection[T]
    val Selection = com.olvind.tso.plugin.Selection
    type ReactBinding = com.olvind.tso.plugin.ReactBinding
    val ReactBinding = com.olvind.tso.plugin.ReactBinding

    val tsoImport       = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val tsoIgnore       = settingKey[List[String]]("completely ignore libs")
    val tsoReactBinding = settingKey[ReactBinding]("The type of react binding to use")

    /**
      *
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

  override def requires = JvmPlugin && ScalaJSBundlerPlugin && PlatformDepsPlugin

  override def trigger = allRequirements

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = {
    import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
    val outsideConfig = Seq(
      libraryDependencies ++= Seq(constants.RuntimeOrg %%% constants.RuntimeName % constants.RuntimeVersion),
      scalacOptions ++= {
        val old = scalacOptions.value
        if (old.contains("-P:scalajs:sjsDefinedByDefault")) Nil else Seq("-P:scalajs:sjsDefinedByDefault")
      },
    )
    inConfig(Compile)(baseTSOImportSettings) ++ outsideConfig
  }

  lazy val baseTSOImportSettings: Seq[Def.Setting[_]] = {
    import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._
    import autoImport._

    Seq(
      //Make sure we always include the stdlib
      npmDependencies in Compile ++= {
        //Make sure it doesn't already exist
        (npmDependencies in Compile).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (tsoTypescriptVersion).value))(_ => Seq.empty)
      },
      tsoReactBinding := com.olvind.tso.plugin.ReactBinding.Native,
      tsoTypescriptVersion := "3.6.3",
      tsoStdlib := List("es6"),
      tsoIgnore := List("typescript"),
      tsoMinimize := com.olvind.tso.plugin.Selection.All(),
      tsoImport := {
        val reactBinding = tsoReactBinding.value
        val tsoLogger    = WrapSbtLogger(streams.value.log).filter(LogLevel.warn).void
        val packageJson  = (crossTarget in npmUpdate).value / "package.json"
        val nodeModules  = InFolder(os.Path((npmInstallDependencies in Compile).value / "node_modules"))
        val stdLib       = tsoStdlib.value
        val targetFolder = os.Path((sourceManaged in Compile).value / "tso")
        val npmDeps      = (npmDependencies in Compile).value ++ (npmDependencies in Test).value
        val ignored      = tsoIgnore.value.to[Set]
        val minimize     = tsoMinimize.value.map(TsIdentLibrary.apply)
        val cachedFunction = FileFunction.cached(streams.value.cacheDirectory / "tso")(
          _ =>
            ImportTypings(
              npmDeps.to[Seq],
              nodeModules,
              targetFolder,
              tsoLogger,
              reactBinding,
              stdLib,
              ignored.map(TsIdentLibrary.apply),
              minimize,
            ) match {
              case Right(files) => files
              case Left(errors) =>
                errors foreach System.err.println
                Set.empty
            },
        )
        cachedFunction(Set(packageJson)).to[Seq]
      },
      sourceGenerators in Compile += tsoImport.taskValue,
    )
  }
}
