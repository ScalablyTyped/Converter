package com.olvind.tso
package importer
package build

import ammonite.ops._
import com.olvind.tso.importer.build.versions.{`version%`, sbtVersion}
import com.olvind.tso.scalajs.{Name, ObjectMembers, ScalaNameEscape}

object GenerateSbtPlugin {
  def apply(projectDir: Path, projects: Set[PublishedSbtProject], pluginVersion: String, action: String) = {
    files.sync(contents(projects, pluginVersion), projectDir)
    implicit val wd = projectDir
    % sbt action
  }

  def contents(projects: Set[PublishedSbtProject], pluginVersion: String): Map[RelPath, Array[Byte]] = {

    val buildSbt = s"""name := "sbt-${constants.Project}"
      |organization := ${stringUtils.quote(constants.organization)}
      |version := ${stringUtils.quote(pluginVersion)}
      |sbtPlugin := true
      |scalaVersion := ${stringUtils.quote(versions.scalaVersion)}
      |bintrayRepository := ${stringUtils.quote(constants.Project)}
      |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
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
                 .sortBy(_.name)
                 .map(
                   p =>
                     s"|        val ${ScalaNameEscape(fix(p.name))} = ${`version%`(p.organization, p.artifactId, p.version)}"
                 )
                 .mkString("", "\n", "")}
        |      }""".stripMargin
        }
        .mkString("\n")

    val pluginSource = s"""
      |package ${constants.organization}.sbt
      |
      |import sbt._
      |import sbt.Keys._
      |
      |object ${constants.Project}Plugin extends AutoPlugin {
      |  override def trigger = allRequirements
      |  override def requires = sbt.plugins.JvmPlugin
      |
      |  object autoImport {
      |    object ${constants.Project} {
      |$projectsByLetter
      |    }
      |  }
      |}""".stripMargin

    val pluginSourcePath = RelPath("src") / 'main / 'scala / 'com / 'olvind / 'sbt / "ScalablytypedPlugin.scala"

    Map(
      RelPath("build.sbt") -> buildSbt.getBytes(constants.Utf8),
      RelPath("project") / "plugins.sbt" -> s"""addSbtPlugin(${versions.sbtBintray})""".getBytes(constants.Utf8),
      RelPath("project") / "build.properties" -> s"sbt.version=$sbtVersion".getBytes(constants.Utf8),
      pluginSourcePath -> pluginSource.getBytes(constants.Utf8)
    )
  }
}
