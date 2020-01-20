package org.scalablytyped.converter.plugin

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import org.scalablytyped.converter
import org.scalablytyped.converter.internal.constants
import sbt.Keys.{libraryDependencies, scalacOptions, sourceGenerators}
import sbt.plugins.JvmPlugin
import sbt.{inConfig, settingKey, taskKey, AutoPlugin, Compile, Def, File}

object ScalablyTypedPluginBase extends AutoPlugin {
  object autoImport {
    type Selection[T] = converter.Selection[T]
    val Selection = converter.Selection
    type Flavour = converter.plugin.Flavour
    val Flavour = converter.plugin.Flavour
    type PrettyStringType = converter.plugin.PrettyStringType
    val PrettyStringType = converter.plugin.PrettyStringType

    val stImport = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val stIgnore = settingKey[List[String]]("completely ignore libraries or modules")
    val stGenerateCompanions = settingKey[Boolean](
      "Whether to generate companion objects with apply methods for most traits",
    )
    val stFlavour = settingKey[Flavour]("The type of react binding to use")
    val stEnableScalaJsDefined = settingKey[Selection[String]](
      "Generate @ScalaJSDefined traits when necessary. This enables you to `new` them, but it may require tons of compilation time",
    )

    /**
      * A list of library names you don't care too much about.
      * The idea is that we can limit compile time (by a lot!)
      */
    val stMinimize = settingKey[Selection[String]]("")

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
    val stStdlib = settingKey[List[String]](
      "Which versions of typescript library to include (same as `lib` in tsconfig.json)",
    )
    val stTypescriptVersion = settingKey[String](
      "The version of the typescript library that it should use",
    )
    val stOutputPackage = settingKey[String](
      "The top-level package to put generated code in",
    )
  }

  override def requires = JvmPlugin && PlatformDepsPlugin

  lazy val stOutsideConfig: Seq[Def.Setting[_]] = {
    import PlatformDepsPlugin.autoImport._
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

  lazy val stDefaults: Seq[Def.Setting[_]] = {
    import autoImport._
    Seq(
      stFlavour := converter.plugin.Flavour.Plain,
      stEnableScalaJsDefined := converter.Selection.All,
      stTypescriptVersion := "3.7.2",
      stGenerateCompanions := true,
      stStdlib := List("es6"),
      stIgnore := List("typescript"),
      stOutputPackage := {
        stFlavour.value match {
          case Flavour.Plain        => "typingsPlain"
          case Flavour.Normal       => "typingsNormal"
          case Flavour.Slinky       => "typingsSlinky"
          case Flavour.SlinkyNative => "typingsSlinky"
          case Flavour.Japgolly     => "typingsJapgolly"
        }
      },
      stMinimize := converter.Selection.None,
      sourceGenerators in Compile += stImport.taskValue,
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(stDefaults) ++ stOutsideConfig
}
