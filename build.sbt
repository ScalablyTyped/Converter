// shadow sbt-scalajs' crossProject and CrossType from Scala.js 0.6.x
import sbtcrossproject.CrossPlugin.autoImport.crossProject
import sbtcrossproject.CrossType
import scala.sys.process.stringToProcess

val baseSettings: Project => Project =
  _.settings(
    scalaVersion := "2.12.9",
    organization := "com.olvind",
    version := "0.1-SNAPSHOT",
    scalacOptions ++= ScalacOptions.flags,
    scalacOptions in (Compile, console) ~= (_.filterNot(
      Set("-Ywarn-unused:imports", "-Xfatal-warnings"),
    )),
  )

val utils = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(
    libraryDependencies ++= Seq(
      Deps.sourcecode.value,
      Deps.circeCore.value,
      Deps.circeGeneric.value,
      Deps.circeParser.value,
    ),
  )
  .configure(baseSettings)

val utilsJVM = utils.jvm.settings(
  name := "utilsJVM",
  libraryDependencies ++= Seq(Deps.osLib, Deps.circeJackson),
)
val utilsJS = utils.js.settings(
  name := "utilsJS",
  libraryDependencies ++= Seq(Deps.geny.value),
)

val logging = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.sourcecode.value, Deps.fansi.value))

val loggingJVM = logging.jvm.settings(name := "loggingJVM")
val loggingJS  = logging.js.settings(name := "loggingJS")

val ts = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .configure(baseSettings)
  .dependsOn(utils, logging)
  .settings(libraryDependencies += Deps.parserCombinators.value)

val tsJVM = ts.jvm.settings(name := "jsJVM")
val tsJS  = ts.js.settings(name := "tsJS")

val scalajs = project
  .dependsOn(utilsJVM, loggingJVM)
  .configure(baseSettings)

val phases = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .dependsOn(utils, logging)
  .configure(baseSettings)

val phasesJVM = phases.jvm.settings(name := "phasesJVM")
val phasesJS  = phases.js.settings(name := "phasesJS")

val importer = project
  .dependsOn(tsJVM, scalajs, phasesJVM)
  .configure(baseSettings)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoPackage := "com.olvind.tso",
    buildInfoKeys := Seq[BuildInfoKey](
      "gitSha" -> "git rev-parse -1 HEAD".!!.split("\n").last.trim,
    ),
    libraryDependencies ++= Seq(
      Deps.ammoniteOps,
      Deps.bloop,
      Deps.bintry,
      Deps.asyncHttpClient,
      Deps.scalatest % Test,
    ),
    fork in run := true,
    javaOptions in run += "-Xmx12G",
    mainClass := Some("com.olvind.tso.importer.Importer"),
    // fork to keep CI happy with memory usage
    fork in Test := true,
    testOptions in Test += Tests.Argument("-P4"),
  )
