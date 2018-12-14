package com.olvind.tso
package importer.build

import com.olvind.tso.stringUtils.quote

object Versions {
  object `scala 2.12 with scala.js 0.6.25` extends Versions {
    val scalaOrganization   = "org.scala-lang"
    val scalaVersion        = "2.12.7"
    val binVersion          = "2.12"
    val scalaJsOrganization = "org.scala-js"
    val scalaJsVersion      = "0.6.25"
    val scalaJsBinVersion   = "0.6"
  }

  object `scala 2.12 with scala.js 1.0.0` extends Versions {
    val scalaOrganization   = "org.scala-lang"
    val scalaVersion        = "2.12.7"
    val binVersion          = "2.12"
    val scalaJsOrganization = "org.scala-js"
    val scalaJsVersion      = "1.0.0-M6"
    val scalaJsBinVersion   = "1.0.0-M6"
  }
}

trait Versions {
  val scalaOrganization:   String
  val scalaVersion:        String
  val binVersion:          String
  val scalaJsOrganization: String
  val scalaJsVersion:      String
  val scalaJsBinVersion:   String

  val scalaJsDomVersion   = "0.9.6"
  val RuntimeOrganization = "com.olvind"
  val RuntimeName         = "scalablytyped-runtime"
  val RuntimeVersion      = "1.0.0"
  val sbtVersion          = "1.2.6"
  val sbtBintray          = %("org.foundweekends", "sbt-bintray", "0.5.4")

  def s(artifact: String): String =
    s"${artifact}_$binVersion"

  def sjs(artifact: String): String =
    s"${artifact}_sjs${scalaJsBinVersion}_$binVersion"

  def %%%(org: String, artifact: String, version: String): String =
    s"${quote(org)} %%% ${quote(artifact)} % ${quote(version)}"

  def %%(org: String, artifact: String, version: String): String =
    s"${quote(org)} %% ${quote(artifact)} % ${quote(version)}"

  def %(org: String, artifact: String, version: String): String =
    s"${quote(org)} % ${quote(artifact)} % ${quote(version)}"
}
