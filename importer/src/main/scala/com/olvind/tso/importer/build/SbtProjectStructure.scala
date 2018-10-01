package com.olvind.tso
package importer.build

import ammonite.ops.RelPath
import com.olvind.tso.scalajs.{LibScalaJs, PublishedSbtProject, SbtProject}
import com.olvind.tso.stringUtils.quote

object SbtProjectStructure {
  import versions._

  val Fixed = List(
    `version%%%`(scalaJsOrganization, "scalajs-dom", scalaJsDomVersion),
    `version%%%`(constants.organization, "runtime", scalablyTypedRuntimeVersion)
  )

  def asSbt(s: SbtProject) = `version%%%`(s.organization, s.name, s.version)

  def apply(lib:          LibScalaJs[_],
            organization: String,
            name:         String,
            version:      String,
            deps:         Seq[PublishedSbtProject]): OutRelFiles = {
    val buildSbt = {
      val ds = (Fixed ++ deps.map(d => asSbt(d.project))).sorted.mkString("Seq(\n  ", ",\n  ", ")")

      s"""|organization := ${quote(organization)}
          |name := ${quote(name)}
          |version := ${quote(version)}
          |scalaVersion := ${quote(scalaVersion)}
          |enablePlugins(ScalaJSPlugin)
          |libraryDependencies ++= $ds
          |publishArtifact in packageDoc := false
          |scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        """.stripMargin
    }

    val pluginsSbt = s"addSbtPlugin(${`version%%`(scalaJsOrganization, "sbt-scalajs", scalaJsVersion)})"
    val readme     = lib.packageSymbol.comments.cs.map(_.raw).mkString("```\n", "", "```")

    OutRelFiles(
      Map(
        OutRelFile(RelPath("build.sbt")) -> buildSbt.getBytes(constants.Utf8),
        OutRelFile(RelPath("project") / "build.properties") -> s"sbt.version=$sbtVersion".getBytes(constants.Utf8),
        OutRelFile(RelPath("project") / "plugins.sbt") -> pluginsSbt.getBytes(constants.Utf8),
        OutRelFile(RelPath("readme.md")) -> readme.getBytes(constants.Utf8)
      )
    )
  }
}
