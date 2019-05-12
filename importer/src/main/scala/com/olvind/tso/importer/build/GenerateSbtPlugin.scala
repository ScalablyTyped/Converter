package com.olvind.tso
package importer
package build

import ammonite.ops._
import com.olvind.tso.scalajs.{Name, ObjectMembers, ScalaNameEscape}
import com.olvind.tso.stringUtils.quote

object GenerateSbtPlugin {
  def apply(
      versions:      Versions,
      organization:  String,
      projectName:   String,
      projectDir:    Path,
      projects:      Set[PublishedSbtProject],
      pluginVersion: String,
      action:        String,
  ) = {
    files.sync(
      contents(versions, organization, projectName, projects, pluginVersion),
      projectDir,
      deleteUnknowns = true,
    )
    implicit val wd = projectDir
    % sbt action
  }

  def contents(
      v:             Versions,
      organization:  String,
      projectName:   String,
      projects:      Set[PublishedSbtProject],
      pluginVersion: String,
  ): Map[RelPath, Array[Byte]] = {

    val buildSbt = s"""name := "sbt-$projectName"
      |organization := ${quote(organization)}
      |version := ${quote(pluginVersion)}
      |sbtPlugin := true
      |scalaVersion := ${quote(v.scalaVersion)}
      |bintrayRepository := ${quote(projectName)}
      |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
      |publishMavenStyle := true
      |crossSbtVersions := Vector("0.13.16", ${quote(v.sbtVersion)})
      |""".stripMargin

    /* we have at least a `clone` and a `notify` library - of course */
    def fix(name: String): String =
      ObjectMembers.byName.get(Name(name)) match {
        case Some(_) => s"_$name"
        case None    => name
      }

    val projectsByLetter =
      projects
        .map(_.project)
        .groupBy(_.name.head)
        .to[Seq]
        .sortBy(_._1)
        .map {
          case (letter, ps) =>
            s"""|      object ${ScalaNameEscape(letter.toUpper.toString)} {
                |${ps
                 .to[Seq]
                 .distinct
                 .sortBy(_.name)
                 .map(
                   p =>
                     s"|        val ${ScalaNameEscape(fix(p.name))} = ${v.%(p.organization, p.artifactId, p.version)}",
                 )
                 .mkString("", "\n", "")}
        |      }""".stripMargin
        }
        .mkString("\n")

    val pluginSource = s"""
      |package $organization.sbt
      |
      |import sbt._
      |import sbt.Keys._
      |
      |object ${projectName}Plugin extends AutoPlugin {
      |  override def trigger = allRequirements
      |  override def requires = sbt.plugins.JvmPlugin
      |
      |  object autoImport {
      |    object $projectName {
      |$projectsByLetter
      |    }
      |  }
      |}""".stripMargin

    val pluginSourcePath = RelPath("src") / 'main / 'scala / 'com / 'olvind / 'sbt / "ScalablytypedPlugin.scala"

    Map(
      RelPath("build.sbt") -> buildSbt.getBytes(constants.Utf8),
      RelPath("project") / "plugins.sbt" -> s"""addSbtPlugin(${v.sbtBintray})""".getBytes(constants.Utf8),
      RelPath("project") / "build.properties" -> s"sbt.version=${v.sbtVersion}".getBytes(constants.Utf8),
      pluginSourcePath -> pluginSource.getBytes(constants.Utf8),
    )
  }
}
