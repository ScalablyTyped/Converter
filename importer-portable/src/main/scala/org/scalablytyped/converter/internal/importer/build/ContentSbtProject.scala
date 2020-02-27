package org.scalablytyped.converter.internal
package importer
package build

import org.scalablytyped.converter.internal.importer.documentation.{Npmjs, ProjectReadme}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}
import org.scalablytyped.converter.internal.stringUtils.quote

object ContentSbtProject {
  def apply(
      v:               Versions,
      comments:        Comments,
      organization:    String,
      name:            String,
      version:         String,
      publishUser:     String,
      localDeps:       IArray[PublishedSbtProject],
      deps:            Set[Dep],
      scalaFiles:      Map[os.RelPath, Array[Byte]],
      resources:       Map[os.RelPath, Array[Byte]],
      projectName:     String,
      metadataOpt:     Option[Npmjs.Data],
      declaredVersion: Option[LibraryVersion],
  ): SbtProjectLayout[os.RelPath, Array[Byte]] = {

    val buildSbt = {
      val allDeps    = IArray.fromTraversable(deps) ++ IArray(Versions.runtime) ++ localDeps.map(d => d.project.reference)
      val depsString = allDeps.map(_.asSbt(v)).distinct.sorted.mkString("Seq(\n  ", ",\n  ", ")")

      s"""|organization := ${quote(organization)}
          |name := ${quote(name)}
          |version := ${quote(version)}
          |scalaVersion := ${quote(v.scala.scalaVersion)}
          |enablePlugins(ScalaJSPlugin)
          |libraryDependencies ++= $depsString
          |publishArtifact in packageDoc := false
          |scalacOptions ++= ${v.scalacOptions.map(quote).mkString("List(", ", ", ")")}
          |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
          |bintrayRepository := ${quote(projectName)}
          |resolvers += Resolver.bintrayRepo(${quote(publishUser)}, ${quote(projectName)})
          |""".stripMargin
    }

    val pluginsSbt =
      s"""|addSbtPlugin(${v.scalaJs.sbtPlugin.asSbt(v)})
          |addSbtPlugin(${Versions.sbtBintray.asSbt(v)})
          |""".stripMargin

    val readme: (os.RelPath, Array[Byte]) =
      os.RelPath("readme.md") -> ProjectReadme(name, declaredVersion, metadataOpt, comments).getBytes(constants.Utf8)

    SbtProjectLayout(
      os.RelPath("build.sbt") -> buildSbt.getBytes(constants.Utf8),
      os.RelPath("project") / "build.properties" -> s"sbt.version=${Versions.sbtVersion}".getBytes(constants.Utf8),
      os.RelPath("project") / "plugins.sbt" -> pluginsSbt.getBytes(constants.Utf8),
      readme,
      scalaFiles,
      resources,
    )
  }
}
