package org.scalablytyped.converter.internal.scalajs

import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.stringUtils.quote

import scala.xml.Elem

sealed trait Dep {
  def org:     String
  def version: String

  def mangledArtifact(versions: Versions): String =
    this match {
      case Dep.Java(_, artifact, _) =>
        artifact
      case Dep.Scala(_, artifact, _) =>
        s"${artifact}_${versions.scala.binVersion}"
      case Dep.ScalaJs(_, artifact, _) =>
        versions.sjs(artifact)
      case Dep.ScalaFullVersion(_, artifact, _) =>
        s"${artifact}_${versions.scala.scalaVersion}"
    }

  def asSbt(versions: Versions): String =
    this match {
      case Dep.Java(_, artifact, _) =>
        s"${quote(org)} % ${quote(artifact)} % ${quote(version)}"
      case Dep.Scala(_, artifact, _) =>
        s"${quote(org)} %% ${quote(artifact)} % ${quote(version)}"
      case Dep.ScalaJs(_, artifact, _) =>
        s"${quote(org)} %%% ${quote(artifact)} % ${quote(version)}"
      case Dep.ScalaFullVersion(_, artifact, _) =>
        s"${quote(org)} % ${quote(artifact)} % ${quote(version)} cross CrossVersion.Full()"
    }

  def asMangledSbt(versions: Versions): String =
    s"${quote(org)} % ${quote(mangledArtifact(versions))} % ${quote(version)}"

  def asIvy(versions: Versions, config: String = "compile->default(compile)"): Elem =
    <dependency org={org} name={mangledArtifact(versions)} rev={version} conf={config}/>

  def asMaven(versions: Versions): Elem =
    <dependency>
      <groupId>{org}</groupId>
      <artifactId>{mangledArtifact(versions)}</artifactId>
      <version>{version}</version>
    </dependency>

  def asMavenTest(versions: Versions): Elem =
    <dependency>
      <groupId>{org}</groupId>
      <artifactId>{mangledArtifact(versions)}</artifactId>
      <version>{version}</version>
      <scope>test</scope>
    </dependency>
}

object Dep {
  case class Java(org:             String, artifact: String, version: String) extends Dep
  case class Scala(org:            String, artifact: String, version: String) extends Dep
  case class ScalaFullVersion(org: String, artifact: String, version: String) extends Dep
  case class ScalaJs(org:          String, artifact: String, version: String) extends Dep

  implicit val DepDecoder: Decoder[Dep] = io.circe.generic.semiauto.deriveDecoder[Dep]
  implicit val DepEncoder: Encoder[Dep] = io.circe.generic.semiauto.deriveEncoder[Dep]
}
