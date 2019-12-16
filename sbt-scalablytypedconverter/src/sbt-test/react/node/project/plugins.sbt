{
  val pluginVersion = System.getProperty("plugin.version")
  if (pluginVersion == null) {
    addSbtPlugin("com.olvind" % """sbt-scalablytypedconverter1""" % "0.1-SNAPSHOT")
  } else {
    addSbtPlugin("com.olvind" % """sbt-scalablytypedconverter1""" % pluginVersion)
  }
}
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.0.0-RC1")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.16.0")
