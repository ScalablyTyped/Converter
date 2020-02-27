{
  val pluginVersion = System.getProperty("plugin.version")
  if(pluginVersion == null)
    throw new RuntimeException("""|The system property 'plugin.version' is not defined.
                                  |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
  else addSbtPlugin("org.scalablytyped.converter" % """sbt-converter06""" % pluginVersion)
}
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.31")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler-sjs06" % "0.17.0")
