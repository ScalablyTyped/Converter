import sbt.{stringToOrganization, ModuleID}

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "2.3.8"
  val osLib             = "com.lihaoyi" %% "os-lib" % "0.7.4"
  val sourcecode        = "com.lihaoyi" %% "sourcecode" % "0.2.5"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.2.7"
  val fansi             = "com.lihaoyi" %% "fansi" % "0.2.12"
  val bloop             = "ch.epfl.scala" %% "bloop-frontend" % "1.4.5"
  val scalaXml          = "org.scala-lang.modules" %% "scala-xml" % "1.3.0"
  val scopt             = "com.github.scopt" %% "scopt" % "4.0.1"
  val awssdkS3          = "software.amazon.awssdk" % "s3" % "2.15.28"
  val java8Compat       = "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.1"

  val circe: Seq[ModuleID] =
    Seq(
      "org.scalablytyped.circe013" %% "circe-generic" % "0.13.0-shaded-2",
      "org.scalablytyped.circe013" %% "circe-jackson29" % "0.13.0-shaded-2"
    )
}
