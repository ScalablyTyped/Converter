import sbt.{ModuleID, stringToOrganization}

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "2.0.4"
  val osLib             = "com.lihaoyi" %% "os-lib" % "0.6.3"
  val sourcecode        = "com.lihaoyi" %% "sourcecode" % "0.2.0"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.1.0"
  val fansi             = "com.lihaoyi" %% "fansi" % "0.2.8"
  val bloop             = "ch.epfl.scala" %% "bloop-frontend" % "1.3.5"
  val bintry            = "org.foundweekends" %% "bintry" % "0.5.2"
  val asyncHttpClient   = "com.ning" % "async-http-client" % "1.9.40"

  val circe: Seq[ModuleID] =
    Seq("core", "generic", "parser", "jackson29").map(s => "io.circe" %% s"circe-$s" % "0.11.1")
}
