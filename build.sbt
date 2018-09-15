import sbt.Def

import scala.sys.process.stringToProcess

val IntegrationTest = Configuration.of("IntegrationTest", "it") extend Test

val baseSettings: Project => Project =
  _.settings(
    scalaVersion := "2.12.6",
    organization := "com.olvind",
    version := "0.1-SNAPSHOT",
    scalacOptions ++= ScalacOptions.flags,
    scalacOptions in (Compile, console) ~= (_.filterNot(
      Set("-Ywarn-unused:imports", "-Xfatal-warnings")
    )),
    javaOptions in ThisBuild += "-Xmx8G"
  )

lazy val publicationSettings: Seq[Def.Setting[_]] =
  Seq(
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    homepage := Some(new URL("http://github.com/oyvindberg/tso")),
    startYear := Some(2018),
    licenses := Seq(("Apache 2", new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))),
    pomExtra := (
      <scm>
      <connection>scm:git:github.com:oyvindberg/tso</connection>
      <developerConnection>scm:git:git@github.com:oyvindberg/tso.git</developerConnection>
      <url>github.com:oyvindberg/tso.git</url>
    </scm>
      <developers>
        <developer>
          <id>oyvindberg</id>
          <name>Øyvind Raddum Berg</name>
        </developer>
      </developers>
    )
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

val runtime = project
  .configure(baseSettings)
  .enablePlugins(spray.boilerplate.BoilerplatePlugin, ScalaJSPlugin)
  .settings(
    publicationSettings,
    libraryDependencies += Deps.scalaJsDom.value,
    scalacOptions += "-P:scalajs:sjsDefinedByDefault"
  )
  .settings(version := "1.0.0-M1")

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
    libraryDependencies ++= Deps.circe ++ Seq(Deps.fansi, Deps.bloop),
    fork in run := true,
    mainClass := Some("com.olvind.tso.importer.Importer")
  )
