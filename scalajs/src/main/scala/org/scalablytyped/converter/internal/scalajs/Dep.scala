package org.scalablytyped.converter.internal.scalajs

import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.stringUtils.quote

import scala.xml.Elem

sealed trait Dep {
  def org:     String
  def version: String

  def asSbt: String =
    this match {
      case Dep.Mangled(_, dep) =>
        dep.asSbt
      case Dep.Java(_, artifact, _) =>
        s"${quote(org)} % ${quote(artifact)} % ${quote(version)}"
      case Dep.Scala(_, artifact, _) =>
        s"${quote(org)} %% ${quote(artifact)} % ${quote(version)}"
      case Dep.ScalaJs(_, artifact, _) =>
        s"${quote(org)} %%% ${quote(artifact)} % ${quote(version)}"
      case Dep.ScalaFullVersion(_, artifact, _) =>
        s"${quote(org)} % ${quote(artifact)} % ${quote(version)} cross CrossVersion.Full()"
    }

  def concrete(versions: Versions): Dep.Concrete =
    this match {
      case concrete: Dep.Concrete => concrete
      case Dep.Scala(_, artifact, _) =>
        Dep.Mangled(s"${artifact}_${versions.scala.binVersion}", this)
      case Dep.ScalaJs(_, artifact, _) =>
        Dep.Mangled(versions.sjs(artifact), this)
      case Dep.ScalaFullVersion(_, artifact, _) =>
        Dep.Mangled(s"${artifact}_${versions.scala.scalaVersion}", this)
    }
}

object Dep {
  sealed trait Concrete extends Dep {
    def mangledArtifact: String

    def asMangledSbt: String =
      s"${quote(org)} % ${quote(mangledArtifact)} % ${quote(version)}"

    def asIvy(config: String = "compile->default(compile)"): Elem =
      <dependency org={org} name={mangledArtifact} rev={version} conf={config}/>

    // format: off
    def asMaven: Elem =
    <dependency>
      <groupId>{org}</groupId>
      <artifactId>{mangledArtifact}</artifactId>
      <version>{version}</version>
    </dependency>

    def asMavenTest: Elem =
    <dependency>
      <groupId>{org}</groupId>
      <artifactId>{mangledArtifact}</artifactId>
      <version>{version}</version>
      <scope>test</scope>
    </dependency>
    // format: on
  }

  case class Java(org: String, name: String, version: String) extends Concrete {
    override def mangledArtifact: String = name
  }
  case class Scala(org:            String, name: String, version: String) extends Dep
  case class ScalaFullVersion(org: String, name: String, version: String) extends Dep
  case class ScalaJs(org:          String, name: String, version: String) extends Dep

  case class Mangled(mangledArtifact: String, dep: Dep) extends Concrete {
    override def org:     String = dep.org
    override def version: String = dep.version
  }

  implicit val DepDecoder: Decoder[Dep] = io.circe013.generic.semiauto.deriveDecoder[Dep]
  implicit val DepEncoder: Encoder[Dep] = io.circe013.generic.semiauto.deriveEncoder[Dep]
}
