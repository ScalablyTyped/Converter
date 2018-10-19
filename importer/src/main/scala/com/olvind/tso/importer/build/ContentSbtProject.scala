package com.olvind.tso
package importer.build

import ammonite.ops.RelPath
import com.olvind.tso.stringUtils.quote

object ContentSbtProject {
  import versions._

  val sourcesDir: RelPath = RelPath("src") / 'main / 'scala
  val classesDir: RelPath = RelPath("target") / s"scala-$binVersion" / 'classes

  val Fixed: List[String] =
    List(
      `version%%%`(scalaJsOrganization, "scalajs-dom", scalaJsDomVersion),
      `version%%%`(constants.organization, "runtime", scalablyTypedRuntimeVersion)
    )

  def asSbt(s: SbtProject) = `version%%%`(s.organization, s.name, s.version)

  def apply(comments:     Comments,
            organization: String,
            name:         String,
            version:      String,
            deps:         Seq[PublishedSbtProject],
            scalaFiles:   Map[RelPath, Array[Byte]]): SbtProjectLayout[RelPath, Array[Byte]] = {
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
          |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
          |bintrayRepository := ${quote(constants.Project)}
        """.stripMargin
    }

    val pluginsSbt =
      s"""|addSbtPlugin(${`version%%`(scalaJsOrganization, "sbt-scalajs", scalaJsVersion)})
          |addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")
          |""".stripMargin

    val readme = comments.cs.map(_.raw).mkString("```\n", "", "```")

    SbtProjectLayout(
      RelPath("build.sbt") -> buildSbt.getBytes(constants.Utf8),
      RelPath("project") / "build.properties" -> s"sbt.version=$sbtVersion".getBytes(constants.Utf8),
      RelPath("project") / "plugins.sbt" -> pluginsSbt.getBytes(constants.Utf8),
      RelPath("readme.md") -> readme.getBytes(constants.Utf8),
      scalaFiles.map { case (relPath, content) => sourcesDir / relPath -> content }
    )
  }
}
