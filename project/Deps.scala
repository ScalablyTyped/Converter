import sbt.{stringToOrganization, ModuleID}

object Deps {
  val parserCombinators   = "org.scala-lang.modules" %% "scala-parser-combinators" % "2.4.0"
  val ammoniteOps         = "com.lihaoyi" %% "ammonite-ops" % "2.4.1"
  val osLib               = "com.lihaoyi" %% "os-lib" % "0.11.5"
  val sourcecode          = "com.lihaoyi" %% "sourcecode" % "0.4.4"
  val scalatest           = "org.scalatest" %% "scalatest" % "3.2.19"
  val fansi               = "com.lihaoyi" %% "fansi" % "0.5.1"
  val scalaXml            = "org.scala-lang.modules" %% "scala-xml" % "2.4.0"
  val scopt               = "com.github.scopt" %% "scopt" % "4.1.0"
  val awssdkS3            = "software.amazon.awssdk" % "s3" % "2.34.5"
  val collectionCompat    = "org.scala-lang.modules" %% "scala-collection-compat" % "2.13.0"
  val parallelCollections = "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0"
  val coursier            = "io.get-coursier" %% "coursier" % "2.1.24"

  val circe: Seq[ModuleID] =
    Seq(
      "io.circe" %% "circe-generic" % "0.14.15",
      "io.circe" %% "circe-parser" % "0.14.15",
      "io.circe" %% "circe-jackson212" % "0.14.2",
    )
}
