package com.olvind.tso.plugin

import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

object ReactBinding extends Enumeration {
  type ReactBinding = Value
  val native, slinky, jagpolly = Value
}
import com.olvind.tso.plugin.ReactBinding._

object TsoPlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin && scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

  object autoImport {
    val importTypings = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val reactBinding = settingKey[ReactBinding]("The type of react binding to use")

    lazy val tsoPluginSettings: Seq[Def.Setting[_]] = Seq(
      importTypings := {ImportTyping(sources.value, (reactBinding in importTypings).value)},
      reactBinding in importTypings := ReactBinding.native
    )
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    reactBinding := ReactBinding.native
  )

  override lazy val buildSettings = Seq()

  override lazy val globalSettings = Seq()

  //TODO Here's what the plugin should do
  //TODO run npm on a set of projects
  //TODO run the importer on those projects
  //TODO compile the results of the importer
}

object ImportTyping {
  def apply(sources: Seq[File], reactBinding: ReactBinding): Seq[File] = {
    println("==============> Doing the import thing here")
    sources
  }
}

