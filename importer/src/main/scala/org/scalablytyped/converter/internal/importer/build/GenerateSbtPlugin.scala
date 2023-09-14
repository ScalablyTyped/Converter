package org.scalablytyped.converter.internal
package importer
package build

import ammonite.ops.%
import org.scalablytyped.converter.internal.scalajs.{Name, ScalaJsClasses, ScalaNameEscape, Versions}
import org.scalablytyped.converter.internal.stringUtils.quote

object GenerateSbtPlugin {
  def apply(
      isDeprecated:  Boolean,
      organization:  String,
      projectName:   ProjectName,
      projectDir:    os.Path,
      projects:      Set[PublishedSbtProject],
      pluginVersion: String,
      action:        String,
  ): Unit = {
    files.sync(
      contents(isDeprecated, organization, projectName, projects, pluginVersion),
      projectDir,
      deleteUnknowns = true,
      soft           = true,
    )
    implicit val wd = projectDir
    %.extend(
      Nil,
      Map(
        "JVM_OPTS" -> "-Xmx1G",
        "JAVA_TOOL_OPTIONS" -> "-XX:MaxInlineLevel=24 -Xmx1G -Xss2M",
      ),
    )('sbt, action)
  }

  def contents(
      isDeprecated:  Boolean,
      organization:  String,
      projectName:   ProjectName,
      projects:      Set[PublishedSbtProject],
      pluginVersion: String,
  ): IArray[(os.RelPath, String)] = {

    val buildSbt = s"""name := "sbt-${projectName.value}"
      |organization := ${quote(organization)}
      |version := ${quote(pluginVersion)}
      |sbtPlugin := true
      |licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
      |publishMavenStyle := true
      |crossSbtVersions := Vector("0.13.16", ${quote(Versions.sbtVersion)})
      |""".stripMargin

    /* we have at least a `clone` and a `notify` library - of course */
    def fix(name: String): String =
      ScalaJsClasses.jsObjectMembersByName.get(Name(name)) match {
        case Some(_) => s"_$name"
        case None    => name
      }

    val projectsByLetter =
      projects
        .map(_.project)
        .groupBy(_.name.head)
        .to(Array)
        .sortBy(_._1)
        .map {
          case (letter, ps) =>
            s"""|      object ${ScalaNameEscape(letter.toUpper.toString)} {
                |${ps
                 .to(Vector)
                 .distinct
                 .sortBy(_.name)
                 .map(p => s"|        val ${ScalaNameEscape(fix(p.name))} = ${p.reference.asMangledSbt}")
                 .mkString("", "\n", "")}
        |      }""".stripMargin
        }
        .mkString("\n")

    val deprecationNotice =
      if (isDeprecated)
        """
          |@deprecated("The pre-built distribution you're using of ScalablyTyped is deprecated. Please see https://www.scalablytyped.org for the new sbt plugin", "2020-04-19")""".stripMargin
      else ""

    val pluginSource = s"""
      |package $organization.sbt
      |
      |import sbt._
      |import sbt.Keys._
      |$deprecationNotice
      |object ${projectName.value}Plugin extends AutoPlugin {
      |  override def trigger = allRequirements
      |  override def requires = sbt.plugins.JvmPlugin
      |  object autoImport {
      |    object ${projectName.value} {
      |$projectsByLetter
      |    }
      |  }
      |}""".stripMargin

    val pluginSourcePath = os.RelPath("src") / 'main / 'scala / 'com / 'olvind / 'sbt / "ScalablytypedPlugin.scala"

    IArray(
      os.RelPath("build.sbt") -> buildSbt,
      os.RelPath("project") / "build.properties" -> s"sbt.version=${Versions.sbtVersion}",
      pluginSourcePath -> pluginSource,
    )
  }
}
