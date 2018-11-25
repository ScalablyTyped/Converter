package com.olvind.tso
package importer.build

import ammonite.ops.RelPath
import com.olvind.tso.stringUtils.quote

object ContentSbtProject {
  def apply(v:            Versions,
            comments:     Comments,
            organization: String,
            name:         String,
            version:      String,
            deps:         Seq[PublishedSbtProject],
            scalaFiles:   Map[RelPath, Array[Byte]],
            projectName:  String): SbtProjectLayout[RelPath, Array[Byte]] = {

    val Fixed: List[String] =
      List(
        v.%%%(v.scalaJsOrganization, "scalajs-dom", v.scalaJsDomVersion),
        v.%%%(v.RuntimeOrganization, v.RuntimeName, v.RuntimeVersion)
      )

    val buildSbt = {
      val ds =
        (Fixed ++ deps.map(d => v.%%%(d.project.organization, d.project.name, d.project.version))).sorted
          .mkString("Seq(\n  ", ",\n  ", ")")

      val scalacOptions =
        if (v.scalaJsBinVersion === "0.6") s"scalacOptions += ${quote("-P:scalajs:sjsDefinedByDefault")}"
        else ""

      s"""|organization := ${quote(organization)}
          |name := ${quote(name)}
          |version := ${quote(version)}
          |scalaVersion := ${quote(v.scalaVersion)}
          |enablePlugins(ScalaJSPlugin)
          |libraryDependencies ++= $ds
          |publishArtifact in packageDoc := false
          |$scalacOptions
          |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
          |bintrayRepository := ${quote(projectName)}
        """.stripMargin
    }

    val pluginsSbt =
      s"""|addSbtPlugin(${v.%%(v.scalaJsOrganization, "sbt-scalajs", v.scalaJsVersion)})
          |addSbtPlugin(${v.sbtBintray})
          |""".stripMargin

    val readme: Option[(RelPath, Array[Byte])] =
      comments.cs match {
        case Nil => None
        case cs  => Some(RelPath("readme.md") -> cs.map(_.raw).mkString("```\n", "", "```").getBytes(constants.Utf8))
      }

    SbtProjectLayout(
      RelPath("build.sbt") -> buildSbt.getBytes(constants.Utf8),
      RelPath("project") / "build.properties" -> s"sbt.version=${v.sbtVersion}".getBytes(constants.Utf8),
      RelPath("project") / "plugins.sbt" -> pluginsSbt.getBytes(constants.Utf8),
      readme,
      scalaFiles.map { case (relPath, content) => relPath -> content }
    )
  }
}
