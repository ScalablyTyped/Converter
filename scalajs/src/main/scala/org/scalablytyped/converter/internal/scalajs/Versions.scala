package org.scalablytyped.converter.internal.scalajs

import io.circe013.{Decoder, Encoder}

object Versions {
  val sbtVersion = "1.4.2"

  val runtime      = Dep.ScalaJs("com.olvind", "scalablytyped-runtime", "2.4.0")
  val scalaJsDom   = Dep.ScalaJs("org.scala-js", "scalajs-dom", "1.1.0")
  val slinkyWeb    = Dep.ScalaJs("me.shadaj", "slinky-web", "0.6.6")
  val slinkyNative = Dep.ScalaJs("me.shadaj", "slinky-native", "0.6.6")
  val scalajsReact = Dep.ScalaJs("com.github.japgolly.scalajs-react", "core", "1.7.5")

  private val StableVersion = "(\\d+).(\\d+).(\\d+)".r

  case class Scala(scalaVersion: String) {
    val scalaOrganization: String   = "org.scala-lang"
    val compiler:          Dep.Java = Dep.Java(scalaOrganization, "scala-compiler", scalaVersion)
    val library:           Dep.Java = Dep.Java(scalaOrganization, "scala-library", scalaVersion)

    val binVersion: String = scalaVersion match {
      case StableVersion(major, minor, _) => s"$major.$minor"
      case other                          => other
    }
  }
  object Scala {
    implicit val encodes: Encoder[Scala] = Encoder[String].contramap(_.scalaVersion)
    implicit val decodes: Decoder[Scala] = Decoder[String].map(Scala.apply)
  }

  val Scala212 = Scala("2.12.13")

  val Scala213 = Scala("2.13.3")

  case class ScalaJs(scalaJsVersion: String) {
    val scalaJsBinVersion: String =
      scalaJsVersion match {
        case StableVersion("1", _, _)   => "1"
        case StableVersion("0", "6", _) => "0.6"
        case other                      => other
      }

    val scalaJsOrganization = "org.scala-js"

    val scalacOptions: List[String] = {
      List(
        "-encoding",
        "utf-8",
        "-feature",
        "-g:notailcalls",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
      )
    }
    val library       = Dep.Scala(scalaJsOrganization, "scalajs-library", scalaJsVersion)
    val testInterface = Dep.Scala(scalaJsOrganization, "scalajs-test-interface", scalaJsVersion)
    val compiler      = Dep.ScalaFullVersion(scalaJsOrganization, "scalajs-compiler", scalaJsVersion)
    val sbtPlugin     = Dep.Scala(scalaJsOrganization, "sbt-scalajs", scalaJsVersion)
  }
  object ScalaJs {
    implicit val encodes: Encoder[ScalaJs] = Encoder[String].contramap(_.scalaJsVersion)
    implicit val decodes: Decoder[ScalaJs] = Decoder[String].map(ScalaJs.apply)
  }

  val ScalaJs1  = ScalaJs("1.3.0")
  val ScalaJs06 = ScalaJs("0.6.33")

  implicit val encodes: Encoder[Versions] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[Versions] = io.circe013.generic.semiauto.deriveDecoder
}

case class Versions(scala: Versions.Scala, scalaJs: Versions.ScalaJs) {
  val scalacOptions: List[String] = scalaJs.scalacOptions

  def sjs(artifact: String): String =
    s"${artifact}_sjs${scalaJs.scalaJsBinVersion}_${scala.binVersion}"
}
