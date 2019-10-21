{
  val pluginVersion = System.getProperty("plugin.version")
  if (pluginVersion == null) {
    addSbtPlugin("com.olvind" % """sbt-tso""" % "0.1-SNAPSHOT")
  } else {
    addSbtPlugin("com.olvind" % """sbt-tso""" % pluginVersion)
  }
}
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.29")
addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.15.0-0.6")
