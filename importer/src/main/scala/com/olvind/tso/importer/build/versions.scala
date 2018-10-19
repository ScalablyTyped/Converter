package com.olvind.tso
package importer.build

import stringUtils.quote

object versions {
  val scalaOrganization   = "org.scala-lang"
  val scalaVersion        = "2.12.7"
  val binVersion          = "2.12"
  val scalaJsOrganization = "org.scala-js"
//  val scalaJsVersion              = "1.0.0-M3"
//  val scalaJsBinVersion           = "1.0.0-M3"

  val scalaJsVersion    = "0.6.25"
  val scalaJsBinVersion = "0.6"

  val scalaJsDomVersion           = "0.9.5"
  val scalablyTypedRuntimeVersion = "1.0.0-M1"
  val sbtVersion                  = "1.2.3"

  def s(artifact: String): String =
    s"${artifact}_$binVersion"

  def sjs(artifact: String): String =
    s"${artifact}_sjs${scalaJsBinVersion}_$binVersion"

  def `version%%%`(org: String, artifact: String, version: String): String =
    s"${quote(org)} %%% ${quote(artifact)} % ${quote(version)}"

  def `version%%`(org: String, artifact: String, version: String): String =
    s"${quote(org)} %% ${quote(artifact)} % ${quote(version)}"

  def `version%`(org: String, artifact: String, version: String): String =
    s"${quote(org)} % ${quote(artifact)} % ${quote(version)}"
}
