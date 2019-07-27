package com.olvind.tso
package importer
package build

import com.olvind.tso.importer.documentation.{Npmjs, ProjectReadme}
import com.olvind.tso.stringUtils.quote
import sets.SetOps

object ContentSbtProject {
  def apply(
      v:               Versions,
      comments:        Comments,
      organization:    String,
      name:            String,
      version:         String,
      publishUser:     String,
      localDeps:       Seq[PublishedSbtProject],
      facadeDeps:      Set[FacadeJson.Dep],
      scalaFiles:      Map[os.RelPath, Array[Byte]],
      projectName:     String,
      metadataOpt:     Option[Npmjs.Data],
      declaredVersion: Option[LibraryVersion],
  ): SbtProjectLayout[os.RelPath, Array[Byte]] = {

    val buildSbt = {
      val fixed    = List(v.%%%(v.RuntimeOrganization, v.RuntimeName, v.RuntimeVersion))
      val external = facadeDeps.map(d => v.%%%(d.org, d.artifact, d.version))
      val local    = localDeps.map(d => v.%%%(d.project.organization, d.project.name, d.project.version))

      val ds = (external ++ fixed ++ local).sorted.mkString("Seq(\n  ", ",\n  ", ")")

      s"""|organization := ${quote(organization)}
          |name := ${quote(name)}
          |version := ${quote(version)}
          |scalaVersion := ${quote(v.scalaVersion)}
          |enablePlugins(ScalaJSPlugin)
          |libraryDependencies ++= $ds
          |publishArtifact in packageDoc := false
          |scalacOptions ++= ${v.scalacOptions.map(quote).mkString("List(", ", ", ")")}
          |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
          |bintrayRepository := ${quote(projectName)}
          |resolvers += Resolver.bintrayRepo(${quote(publishUser)}, ${quote(projectName)})
        """.stripMargin
    }

    val pluginsSbt =
      s"""|addSbtPlugin(${v.%%(v.scalaJsOrganization, "sbt-scalajs", v.scalaJsVersion)})
          |addSbtPlugin(${v.sbtBintray})
          |""".stripMargin

    val readme: (os.RelPath, Array[Byte]) =
      os.RelPath("readme.md") -> ProjectReadme(name, declaredVersion, metadataOpt, comments).getBytes(constants.Utf8)

    SbtProjectLayout(
      os.RelPath("build.sbt") -> buildSbt.getBytes(constants.Utf8),
      os.RelPath("project") / "build.properties" -> s"sbt.version=${v.sbtVersion}".getBytes(constants.Utf8),
      os.RelPath("project") / "plugins.sbt" -> pluginsSbt.getBytes(constants.Utf8),
      readme,
      scalaFiles.map { case (relPath, content) => relPath -> content },
    )
  }
}
