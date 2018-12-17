import sbt.{stringToOrganization, ModuleID}

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "1.2.1"
  val sourcecode        = "com.lihaoyi" %% "sourcecode" % "0.1.5"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.0.5"
  val fansi             = "com.lihaoyi" %% "fansi" % "0.2.5"
  val bloop             = "ch.epfl.scala" %% "bloop-backend" % "1.1.1"
  val bsp4s             = "ch.epfl.scala" %% "bsp4s" % "2.0.0-M2"
  val bintry            = "org.foundweekends" %% "bintry" % "0.5.2"
  val dispatch          = "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
  val asyncHttpClient   = "com.ning" % "async-http-client" % "1.8.10"

  val circe: Seq[ModuleID] =
    Seq("core", "generic", "parser").map(s => "io.circe" %% s"circe-$s" % "0.10.1")
}
