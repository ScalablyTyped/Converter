package org.scalablytyped.converter.internal
package scalajs

import io.circe013.{Decoder, Encoder}

object Versions {
  val sbtVersion = "1.9.6"

  // this accepts any nightly or milestone with the same binversion as a major release. good enough for now
  private val Version = "(\\d+).(\\d+).(\\d+).*".r

  case class Scala(scalaVersion: String) {
    val is3 = scalaVersion.startsWith("3.")

    val scalaOrganization: String =
      "org.scala-lang"

    val compiler: Dep =
      if (is3) Dep.Scala(scalaOrganization, "scala3-compiler", scalaVersion)
      else Dep.Java(scalaOrganization, "scala-compiler", scalaVersion)

    val library: Dep.Java =
      if (is3) Scala213.library
      else Dep.Java(scalaOrganization, "scala-library", scalaVersion)

    val dottyLibrary: Option[Dep.Java] =
      if (is3) Some(Dep.Java(scalaOrganization, "scala3-library", scalaVersion))
      else None

    val binVersion: String = scalaVersion match {
      case Version("3", _, _)     => s"3"
      case Version("2", minor, _) => s"2.$minor"
      case other                  => other
    }

    val compilerBridge: Option[Dep.Java] =
      scalaVersion match {
        case Version("3", _, _) => Some(Dep.Java(scalaOrganization, "scala3-sbt-bridge", scalaVersion))
        case Version("2", "13", n) if n.toInt >= 12 =>
          Some(Dep.Java(scalaOrganization, "scala2-sbt-bridge", scalaVersion))
        case _ => None
      }
  }

  object Scala {
    implicit val encodes: Encoder[Scala] = Encoder[String].contramap(_.scalaVersion)
    implicit val decodes: Decoder[Scala] = Decoder[String].map(Scala.apply)
  }

  val Scala212 = Scala("2.12.20")
  val Scala213 = Scala("2.13.12")
  val Scala3   = Scala("3.3.1")

  case class ScalaJs(scalaJsVersion: String) {
    val scalaJsBinVersion: String =
      scalaJsVersion match {
        case Version("1", _, _)   => "1"
        case Version("0", "6", _) => "0.6"
        case other                => other
      }

    val scalaJsOrganization = "org.scala-js"
    val sbtPlugin           = Dep.Scala(scalaJsOrganization, "sbt-scalajs", scalaJsVersion)
  }

  object ScalaJs {
    implicit val encodes: Encoder[ScalaJs] = Encoder[String].contramap(_.scalaJsVersion)
    implicit val decodes: Decoder[ScalaJs] = Decoder[String].map(ScalaJs.apply)
  }

  implicit val encodes: Encoder[Versions] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[Versions] = io.circe013.generic.semiauto.deriveDecoder

  val ScalaJs1 = ScalaJs("1.11.0")
}

case class Versions(scala: Versions.Scala, scalaJs: Versions.ScalaJs) {
  val scalacOptions: List[String] =
    if (scala.is3)
      List(
        "-encoding",
        "utf-8",
        "-feature",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
        "-no-indent",
        "-source:future",
//        "-Yexplicit-nulls"
      )
    else
      List(
        "-encoding",
        "utf-8",
        "-feature",
        "-g:notailcalls",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
      )

  val scalaJsLibrary: Dep =
    Dep
      .Scala(scalaJs.scalaJsOrganization, "scalajs-library", scalaJs.scalaJsVersion)
      .for3Use2_13(scala.is3)

  val scalaJsTestInterface: Dep =
    Dep
      .Scala(scalaJs.scalaJsOrganization, "scalajs-test-interface", scalaJs.scalaJsVersion)
      .for3Use2_13(scala.is3)

  val scalaJsCompiler: Option[Dep.ScalaFullVersion] =
    if (scala.is3) None
    else Some(Dep.ScalaFullVersion(scalaJs.scalaJsOrganization, "scalajs-compiler", scalaJs.scalaJsVersion))

  val runtime      = Dep.ScalaJs("com.olvind", "scalablytyped-runtime", "2.4.2")
  val scalaJsDom   = Dep.ScalaJs("org.scala-js", "scalajs-dom", "2.3.0")
  val slinkyWeb    = Dep.ScalaJs("me.shadaj", "slinky-web", "0.7.2")
  val slinkyNative = Dep.ScalaJs("me.shadaj", "slinky-native", "0.7.2").for3Use2_13(scala.is3)
  val scalajsReact = Dep.ScalaJs("com.github.japgolly.scalajs-react", "core", "2.1.1")
}
