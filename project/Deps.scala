import sbt.{stringToOrganization, ModuleID}

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "1.6.9"
  val osLib             = "com.lihaoyi" %% "os-lib" % "0.3.0"
  val sourcecode        = "com.lihaoyi" %% "sourcecode" % "0.1.7"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.0.8"
  val fansi             = "com.lihaoyi" %% "fansi" % "0.2.7"
  val bloop             = "ch.epfl.scala" %% "bloop-frontend" % "1.3.2"
  val bintry            = "org.foundweekends" %% "bintry" % "0.5.2"
  val asyncHttpClient   = "com.ning" % "async-http-client" % "1.8.17"

  val circe: Seq[ModuleID] =
    Seq("core", "generic", "parser").map(s => "io.circe" %% s"circe-$s" % "0.11.1")
}
