{
  val pluginVersion = System.getProperty("plugin.version")
  if(pluginVersion == null)
    throw new RuntimeException("""|The system property 'plugin.version' is not defined.
                                  |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
  else addSbtPlugin("com.olvind" % """sbt-scalablytypedconverter""" % pluginVersion)
}
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.0.0-RC1")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.16.0")
