package com.olvind.tso
package importer
package build

import ammonite.ops._
import com.olvind.tso.importer.build.versions.{`version%`, sbtVersion}
import com.olvind.tso.scalajs.{PublishedSbtProject, ScalaNameEscape}

object GenerateSbtPlugin {
  def apply(projectDir: Path, projects: Set[PublishedSbtProject], pluginVersion: String) = {
    files.sync(contents(projects, pluginVersion), projectDir)
    implicit val wd = projectDir
    % sbt "publishLocal"
  }

  def contents(projects: Set[PublishedSbtProject], pluginVersion: String): OutRelFiles = {

    val buildSbt = s"""
name := "sbt-${constants.Project}"
organization := ${stringUtils.quote(constants.organization)}
version := ${stringUtils.quote(pluginVersion)}
sbtPlugin := true
scalaVersion := ${stringUtils.quote(versions.scalaVersion)}
"""

    val projectsByLetter =
      projects
        .map(_.project)
        .groupBy(_.name.head)
        .to[Seq]
        .sortBy(_._1)
        .map {
          case (letter, ps) =>
            s"""  object ${ScalaNameEscape(letter.toUpper.toString)} {
          ${ps.to[Seq]
              .sortBy(_.name)
              .map { p =>
                val pIdent = ScalaNameEscape(ImportName.rewrite(p.name, "", capitalize = true))
                s"    val $pIdent = ${`version%`(p.organization, p.artifactId, p.version)}"
              }
              .mkString("\n", "\n", "\n")}
        }"""
        }
        .mkString("\n")

    val pluginSource = s"""
package ${constants.organization}.sbt

import sbt._
import sbt.Keys._

object ${constants.Project}Plugin extends AutoPlugin {
  override def trigger = allRequirements
  override def requires = sbt.plugins.JvmPlugin

  object autoImport {
    object ${constants.Project} {
      $projectsByLetter
    }
  }
}"""

    val pluginSourcePath = OutRelFile(
      RelPath("src") / 'main / 'scala / 'com / 'olvind / 'sbt / "ScalablytypedPlugin.scala"
    )

    OutRelFiles(
      Map(
        OutRelFile(RelPath("build.sbt")) -> buildSbt.getBytes(constants.Utf8),
        OutRelFile(RelPath("project") / "build.properties") -> s"sbt.version=$sbtVersion".getBytes(constants.Utf8),
        pluginSourcePath -> pluginSource.getBytes(constants.Utf8)
      )
    )
  }
}
