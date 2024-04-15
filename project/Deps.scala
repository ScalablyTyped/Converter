import sbt.{stringToOrganization, ModuleID}

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
  val ammoniteOps       = "com.lihaoyi" %% "ammonite-ops" % "2.4.0"
  val osLib             = "com.lihaoyi" %% "os-lib" % "0.9.3"
  val sourcecode        = "com.lihaoyi" %% "sourcecode" % "0.3.1"
  val scalatest         = "org.scalatest" %% "scalatest" % "3.2.17"
  val fansi             = "com.lihaoyi" %% "fansi" % "0.4.0"
  val bloop             = "ch.epfl.scala" %% "bloop-frontend" % "1.5.4"
  val scalaXml          = "org.scala-lang.modules" %% "scala-xml" % "2.3.0"
  val scopt             = "com.github.scopt" %% "scopt" % "4.1.0"
  val awssdkS3          = "software.amazon.awssdk" % "s3" % "2.15.28"
  val coursier          = "io.get-coursier" %% "coursier" % "2.1.8"

  val circe: Seq[ModuleID] =
    Seq(
      "org.scalablytyped.circe013" %% "circe-generic" % "0.13.0-shaded-2",
      "org.scalablytyped.circe013" %% "circe-jackson29" % "0.13.0-shaded-2",
    )
}
