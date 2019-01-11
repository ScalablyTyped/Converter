import scala.sys.process.stringToProcess

val IntegrationTest = Configuration.of("IntegrationTest", "it") extend Test

val baseSettings: Project => Project =
  _.settings(
    scalaVersion := "2.12.8",
    organization := "com.olvind",
    version := "0.1-SNAPSHOT",
    scalacOptions ++= ScalacOptions.flags,
    scalacOptions in (Compile, console) ~= (_.filterNot(
      Set("-Ywarn-unused:imports", "-Xfatal-warnings")
    ))
  )

val utils = project
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.ammoniteOps, Deps.sourcecode))

val logging = project
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.sourcecode, Deps.fansi))

val testUtils = project
  .dependsOn(utils, logging)
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.scalatest, Deps.parserCombinators))

lazy val ts: Project = project
  .configure(baseSettings)
  .configs(IntegrationTest)
  .dependsOn(utils, logging, testUtils % Test)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    libraryDependencies += Deps.parserCombinators,
    Defaults.itSettings,
    buildInfoKeys := Seq[BuildInfoKey](
      name,
      version,
      scalaVersion,
      sbtVersion,
      "parserHash" -> SourceHash(
        sourceDirectory.value / "main" / "scala" / "com" / "olvind" / "tso" / "ts" / "parser"
      ),
      "gitSha" -> "git rev-parse -1 HEAD".!!.split("\n").last.trim
    ),
    buildInfoPackage := "com.olvind.tso.ts"
  )

val scalajs = project
  .dependsOn(utils, logging, testUtils % Test)
  .configure(baseSettings)

val phases = project
  .dependsOn(utils, logging, testUtils % Test)
  .configure(baseSettings)

val importer = project
  .dependsOn(ts, scalajs, phases, testUtils % Test)
  .configure(baseSettings)
  .settings(
    libraryDependencies ++= Deps.circe ++ Seq(Deps.fansi,
                                              Deps.bloop,
                                              Deps.bsp4s,
                                              Deps.bintry,
                                              Deps.dispatch,
                                              Deps.asyncHttpClient),
    fork in run := true,
    javaOptions in run += "-Xmx12G",
    mainClass := Some("com.olvind.tso.importer.Importer"),
    // fork to keep CI happy with memory usage
    fork in Test := true,
  )
