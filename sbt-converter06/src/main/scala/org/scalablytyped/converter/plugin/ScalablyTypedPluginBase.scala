package org.scalablytyped.converter.plugin

import java.io.File

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import org.scalablytyped.converter
import org.scalablytyped.converter.internal.importer.EnabledTypeMappingExpansion
import org.scalablytyped.converter.internal.{constants, ZincCompiler}
import sbt.Tags.Tag
import sbt._
import sbt.librarymanagement.ModuleID
import sbt.plugins.JvmPlugin
import xsbti.compile.{CompileOrder => _, ScalaInstance => _}

object ScalablyTypedPluginBase extends AutoPlugin {

  private[plugin] val stInternalZincCompiler = taskKey[ZincCompiler]("Hijack compiler settings")

  object autoImport {
    type Selection[T] = converter.Selection[T]
    val Selection = converter.Selection
    type Flavour = converter.Flavour
    val Flavour = converter.Flavour

    val ScalablyTypedTag: Tag = Tag("ScalablyTyped")

    val stImport  = taskKey[Set[ModuleID]]("Imports all the bundled npm and generates bindings")
    val stDir     = settingKey[File]("Directory used for caches, built artifacts and so on")
    val stIgnore  = settingKey[List[String]]("completely ignore libraries or modules")
    val stFlavour = settingKey[Flavour]("The type of react binding to use")
    val stEnableScalaJsDefined = settingKey[Selection[String]](
      "Generate @ScalaJSDefined traits when necessary. This enables you to `new` them, but it may require tons of compilation time",
    )

    val stUseScalaJsDom = settingKey[Boolean]("Use types from scala-js-dom instead of from std when possible")

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

    val stQuiet = settingKey[Boolean]("remove all output")

    val stInternalExpandTypeMappings = settingKey[Selection[String]]("Experimental: enable type mapping expansion")
  }

  override def requires = JvmPlugin && PlatformDepsPlugin

  import autoImport._
  import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion

  /* work around private[sbt] */
  def cleanIvyHack = {
    import scala.language.reflectiveCalls
    (Keys: { val cleanIvy: TaskKey[Unit] }).cleanIvy
  }

  override lazy val projectSettings =
    Seq(
      /* This is where we add our generated artifacts to the project for compilation */
      Keys.allDependencies ++= stImport.value.toSeq,
      /* This originally ended up calling `allDependencies`, which is inconvenient  */
      cleanIvyHack := {},
      Keys.scalacOptions ++= {
        val isScalaJs1 = !scalaJSVersion.startsWith("0.6")

        val old = Keys.scalacOptions.value
        if (old.contains("-P:scalajs:sjsDefinedByDefault") || isScalaJs1) Nil
        else Seq("-P:scalajs:sjsDefinedByDefault")
      },
      stInternalExpandTypeMappings := EnabledTypeMappingExpansion.DefaultSelection.map(_.value),
      stEnableScalaJsDefined := converter.Selection.None,
      stFlavour := converter.Flavour.Normal,
      stIgnore := List("typescript"),
      stOutputPackage := "typings",
      stStdlib := List("es6"),
      stTypescriptVersion := "3.8",
      stUseScalaJsDom := true,
      stInternalZincCompiler := ZincCompiler.task.value,
    )

  override lazy val globalSettings =
    Seq(
      stQuiet := false,
      stDir := constants.defaultCacheFolder.toIO,
    )
}
