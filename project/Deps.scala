import sbt.{stringToOrganization, Def}
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Deps {
  val circeVersion = "0.11.1"
  val fansi      = Def.setting("com.lihaoyi" %%% "fansi" % "0.2.7")
  val geny      = Def.setting("com.lihaoyi" %%% "geny" % "0.1.8")
  val sourcecode = Def.setting("com.lihaoyi" %%% "sourcecode" % "0.1.7")
  val circeCore = Def.setting("io.circe" %%% s"circe-core" % circeVersion)
  val circeGeneric = Def.setting("io.circe" %%% s"circe-generic" % circeVersion)
  val circeParser = Def.setting("io.circe" %%% s"circe-parser" % circeVersion)
  val parserCombinators = Def.setting("org.scala-lang.modules" %%% "scala-parser-combinators" % "1.1.2")

  val circeJackson      = "io.circe" %% s"circe-jackson29" % "0.11.1"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "1.6.9"
  val osLib             = "com.lihaoyi" %% "os-lib" % "0.3.0"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.0.8"
  val bloop             = "ch.epfl.scala" %% "bloop-frontend" % "1.3.2"
  val bintry            = "org.foundweekends" %% "bintry" % "0.5.2"
  val asyncHttpClient   = "com.ning" % "async-http-client" % "1.8.17"

}
