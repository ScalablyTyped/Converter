package org.scalablytyped.converter.internal
package importer
package build

import bleep.{model, yaml}
import org.scalablytyped.converter.internal.importer.documentation.{Npmjs, ProjectReadme}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}
import org.scalablytyped.converter.internal.stringUtils.quote

object ContentSbtProject {
  def apply(
      versions:        Versions,
      comments:        Comments,
      organization:    String,
      name:            String,
      version:         String,
      scalaFiles:      IArray[(os.RelPath, String)],
      resources:       IArray[(os.RelPath, String)],
      metadataOpt:     Option[Npmjs.Data],
      declaredVersion: Option[LibraryVersion],
      bleepBuildFile:  model.BuildFile,
      allDeps:         IArray[Dep],
  ): SbtProjectLayout[os.RelPath, String] = {

    val buildSbt = {
      val depsString = allDeps.map(_.asSbt).distinct.sorted.mkString("Seq(\n  ", ",\n  ", ")")

      s"""|organization := ${quote(organization)}
          |name := ${quote(name)}
          |version := ${quote(version)}
          |scalaVersion := ${quote(versions.scala.scalaVersion)}
          |enablePlugins(ScalaJSPlugin)
          |libraryDependencies ++= $depsString
          |publishArtifact in packageDoc := false
          |scalacOptions ++= ${versions.scalacOptions.map(quote).mkString("List(", ", ", ")")}
          |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
          |""".stripMargin
    }

    val pluginsSbt = IArray(versions.scalaJs.sbtPlugin)
      .map(dep => s"addSbtPlugin(${dep.asSbt})")
      .mkString("", "\n", "\n")

    val readme: (os.RelPath, String) =
      os.RelPath("readme.md") -> ProjectReadme(name, declaredVersion, metadataOpt, comments)

    SbtProjectLayout(
      os.RelPath("build.sbt") -> buildSbt,
      os.RelPath("project") / "build.properties" -> s"sbt.version=${Versions.sbtVersion}",
      os.RelPath("project") / "plugins.sbt" -> pluginsSbt,
      readme,
      os.RelPath("bleep.yaml") -> yaml.encodeShortened(bleepBuildFile),
      scalaFiles,
      resources,
    )
  }
}
