import scala.sys.process.stringToProcess

val baseSettings: Project => Project =
  _.settings(
    scalaVersion := "2.12.10",
    organization := "com.olvind",
    version := "0.1-SNAPSHOT",
    scalacOptions ++= ScalacOptions.flags,
    scalacOptions in (Compile, console) ~= (_.filterNot(
      Set("-Ywarn-unused:imports", "-Xfatal-warnings")
    )),
    /* disable scaladoc */
    sources in (Compile,doc) := Seq.empty,
    publishArtifact in (Compile, packageDoc) := false
  )

val utils = project
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.ammoniteOps, Deps.osLib, Deps.sourcecode) ++ Deps.circe)

val logging = project
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.sourcecode, Deps.fansi))

val ts: Project = project
  .configure(baseSettings)
  .dependsOn(utils, logging)
  .settings(libraryDependencies += Deps.parserCombinators)

val scalajs = project
  .dependsOn(utils, logging)
  .configure(baseSettings)

val phases = project
  .dependsOn(utils, logging)
  .configure(baseSettings)

val importer = project
  .dependsOn(ts, scalajs, phases)
  .configure(baseSettings)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoPackage := "com.olvind.tso",
    buildInfoKeys := Seq[BuildInfoKey](
      "gitSha" -> "git rev-parse -1 HEAD".!!.split("\n").last.trim
    ),
    libraryDependencies ++= Seq(
      Deps.bloop,
      Deps.bintry,
      Deps.asyncHttpClient,
      Deps.scalatest % Test
    ),
    fork in run := true,
    javaOptions in run += "-Xmx12G",
    mainClass := Some("com.olvind.tso.importer.Importer"),
    // fork to keep CI happy with memory usage
    fork in Test := true,
    testOptions in Test += Tests.Argument("-P4")
  )

val `sbt-tso` = project
  .dependsOn(importer)
  .enablePlugins(ScriptedPlugin)
  .configure(baseSettings)
  .settings(
    sbtPlugin := true,
    name := "sbt-tso",
    // set up 'scripted; sbt plugin for testing sbt plugins
    scriptedBufferLog := false,
    scriptedLaunchOpts ++= Seq("-Xmx1024M", "-Dplugin.version=" + version.value),
    watchSources       ++= { (sourceDirectory.value ** "*").get },
    addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.15.0-0.6")
)
