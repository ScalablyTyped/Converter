{
  val pluginVersion = System.getProperty("plugin.version")
  if (pluginVersion == null) {
    addSbtPlugin("com.olvind" % """sbt-scalablytypedconverter""" % "0.1-SNAPSHOT")
  } else {
    addSbtPlugin("com.olvind" % """sbt-scalablytypedconverter""" % pluginVersion)
  }
}
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.31")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.15.0-0.6")
