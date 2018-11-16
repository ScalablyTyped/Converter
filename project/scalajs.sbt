val scalaJSVersion =
  Option(System.getenv("SCALAJS_VERSION")).getOrElse("0.6.25")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)