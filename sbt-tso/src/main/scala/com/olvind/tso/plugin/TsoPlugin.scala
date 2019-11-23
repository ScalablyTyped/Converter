package com.olvind.tso
package plugin

import com.olvind.logging.LogLevel
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

sealed trait ReactBinding

object ReactBindingNative extends ReactBinding

object ReactBindingSlinky extends ReactBinding

object ReactBindingJagpolly extends ReactBinding

object TsoPlugin extends AutoPlugin {
  object autoImport {
    val tsoImport       = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val tsoReactBinding = settingKey[ReactBinding]("The type of react binding to use")

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
    val tsoStdlib =
      settingKey[List[String]]("Which versions of typescript library to include (same as `lib` in tsconfig.json)")
    val tsoTypescriptVersion = settingKey[String]("The version of the typescript library that it should use")

    import ScalaJSBundlerPlugin.autoImport._

    lazy val baseTSOImportSettings: Seq[Def.Setting[_]] = Seq(
      //Make sure we always include the stdlib
      npmDependencies in Compile ++= {
        //Make sure it doesn't already exist
        (npmDependencies in Compile).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (tsoTypescriptVersion).value))(_ => Seq.empty)
      },
      tsoReactBinding := ReactBindingNative,
      tsoTypescriptVersion := "3.6.3",
      tsoStdlib := List("es6"),
      tsoImport := {
        println(s">>>>>>>>>>>>>>>>>>>>>>>>> Using ${(tsoReactBinding).value} value")
        val tsoLogger = WrapSbtLogger(streams.value.log).filter(LogLevel.warn).void
        //TODO check to see if nothing has changed, if nothing has changed, then do nothing.
        ImportTypings.runImport(
          (npmDependencies in Compile).value.to[Seq],
          InFolder(os.Path((npmInstallDependencies in Compile).value / "node_modules")),
          os.Path((sourceManaged in Compile).value / "tso"),
          tsoLogger,
          (tsoReactBinding).value,
          tsoStdlib.value,
        ) match {
          case Right(files) => files
          case Left(errors) =>
            errors foreach System.err.println
            Nil
        }
      },
      sourceGenerators in Compile += tsoImport.taskValue,
    )
  }

  import autoImport._
  override def requires = JvmPlugin && ScalaJSBundlerPlugin

  override def trigger = allRequirements

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = inConfig(Compile)(baseTSOImportSettings)

  override lazy val buildSettings: Seq[Nothing] = Seq()

  override lazy val globalSettings: Seq[Nothing] = Seq()
}
