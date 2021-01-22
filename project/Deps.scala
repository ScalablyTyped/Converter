import sbt.{stringToOrganization, ModuleID}

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "2.3.8"
  val osLib             = "com.lihaoyi" %% "os-lib" % "0.7.1"
  val sourcecode        = "com.lihaoyi" %% "sourcecode" % "0.2.2"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.2.3"
  val fansi             = "com.lihaoyi" %% "fansi" % "0.2.9"
  val bloop             = "ch.epfl.scala" %% "bloop-frontend" % "1.4.5"
  val bintry            = "org.foundweekends" %% "bintry" % "0.5.2"
  val asyncHttpClient   = "com.ning" % "async-http-client" % "1.9.40"
  val scalaXml          = "org.scala-lang.modules" %% "scala-xml" % "1.3.0"
  val scopt             = "com.github.scopt" %% "scopt" % "4.0.0"
  val awssdkS3          = "software.amazon.awssdk" % "s3" % "2.15.28"
  val java8Compat       = "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.1"

  val circe: Seq[ModuleID] =
    Seq("core", "generic", "parser", "jackson29").map(s => "io.circe013" %% s"circe-$s" % "0.13.0")
}
