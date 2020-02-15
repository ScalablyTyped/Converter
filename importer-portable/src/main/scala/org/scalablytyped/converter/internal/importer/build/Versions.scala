package org.scalablytyped.converter.internal
package importer.build

import org.scalablytyped.converter.internal.stringUtils.quote

object Versions {
  val sbtVersion = "1.3.8"

  case class Scala(scalaVersion: String, binVersion: String) {
    val scalaOrganization = "org.scala-lang"
  }

  val Scala212 = Scala("2.12.10", "2.12")

  val Scala213 = Scala("2.13.1", "2.13")

  case class ScalaJs(scalaJsVersion: String, scalaJsBinVersion: String) {
    val scalaJsOrganization = "org.scala-js"
    def scalacOptions: List[String] = {
      val base = List("-encoding", "utf-8", "-g:notailcalls")
      if (scalaJsVersion.startsWith("0.6")) base :+ "-P:scalajs:sjsDefinedByDefault"
      else base
    }
  }

  val ScalaJs1  = ScalaJs("1.0.0", "1")
  val ScalaJs06 = ScalaJs("0.6.31", "0.6")

  val current = Versions(Scala212, ScalaJs06)
  val next    = Versions(Scala213, ScalaJs1)
}

case class Versions(scala: Versions.Scala, scalaJs: Versions.ScalaJs) {
  val scalacOptions: List[String] = scalaJs.scalacOptions

  val sbtBintray = %("org.foundweekends", "sbt-bintray", "0.5.4")

  def s(artifact: String): String =
    s"${artifact}_${scala.binVersion}"

  def sjs(artifact: String): String =
    s"${artifact}_sjs${scalaJs.scalaJsBinVersion}_${scala.binVersion}"

  def %%%(org: String, artifact: String, version: String): String =
    s"${quote(org)} %%% ${quote(artifact)} % ${quote(version)}"

  def %%(org: String, artifact: String, version: String): String =
    s"${quote(org)} %% ${quote(artifact)} % ${quote(version)}"

  def %(org: String, artifact: String, version: String): String =
    s"${quote(org)} % ${quote(artifact)} % ${quote(version)}"
}
