import scala.sys.process.stringToProcess

lazy val latestTag = "git tag -l --sort=committerdate".!!.linesIterator.toVector.last.drop( /* 'v' */ 1)

// BSP setup to use with bloop
Global / bloopExportJarClassifiers := Some(Set("sources"))
Global / bspEnabled := false
autoStartServer := false
Global / excludeLintKeys += autoStartServer

lazy val utils = project
  .configure(baseSettings, publicationSettings)
  .settings(libraryDependencies ++= Seq(Deps.ammoniteOps, Deps.osLib, Deps.sourcecode) ++ Deps.circe)

lazy val logging = project
  .configure(baseSettings, publicationSettings)
  .settings(libraryDependencies ++= Seq(Deps.sourcecode, Deps.fansi))

lazy val ts = project
  .configure(baseSettings, publicationSettings, optimize)
  .dependsOn(utils, logging)
  .settings(libraryDependencies += Deps.parserCombinators)

lazy val docs = project
  .in(file("converter-docs"))
  .settings(
    mdocVariables := Map("VERSION" -> latestTag),
    moduleName := "converter-docs",
  )
  .configure(preventPublication)
  .enablePlugins(MdocPlugin, DocusaurusPlugin)

lazy val scalajs = project
  .dependsOn(utils, logging)
  .configure(baseSettings, publicationSettings, optimize)
  .settings(libraryDependencies ++= Seq(Deps.scalaXml))

lazy val phases = project
  .dependsOn(utils, logging)
  .configure(baseSettings, publicationSettings, optimize)

lazy val `importer-portable` = project
  .configure(baseSettings, publicationSettings, optimize)
  .dependsOn(ts, scalajs, phases)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoPackage := "org.scalablytyped.converter.internal",
    buildInfoKeys := Seq[BuildInfoKey](
      "gitSha" -> "git rev-parse -1 HEAD".!!.split("\n").last.trim,
      "version" -> version.value,
    ),
  )

lazy val importer = project
  .dependsOn(`importer-portable`)
  .configure(baseSettings, publicationSettings, optimize)
  .settings(
    libraryDependencies ++= Seq(
      Deps.bloop,
      Deps.scalatest % Test,
    ),
    test in assembly := {},
    mainClass in assembly := Some("org.scalablytyped.converter.Main"),
    /* meh meh meh */
    assemblyMergeStrategy in assembly := {
      case foo if foo.contains("io/github/soc/directories/") => MergeStrategy.first
      case foo if foo.endsWith("module-info.class")          => MergeStrategy.discard
      case foo if foo.contains("org/fusesource")             => MergeStrategy.first
      case foo if foo.contains("META-INF/native/")           => MergeStrategy.first
      case other                                             => (assembly / assemblyMergeStrategy).value(other)
    },
    testOptions in Test += Tests.Argument("-P4"),
  )

lazy val cli = project
  .dependsOn(importer)
  .configure(baseSettings, publicationSettings)
  .settings(libraryDependencies += Deps.scopt)

lazy val `sbt-converter` = project
  .dependsOn(`importer-portable`)
  .enablePlugins(ScriptedPlugin)
  .configure(baseSettings, publicationSettings)
  .settings(
    name := "sbt-converter",
    addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.20.0"),
    sbtPlugin := true,
    // set up 'scripted; sbt plugin for testing sbt plugins
    scriptedBufferLog := false,
    scriptedLaunchOpts ++= Seq("-Xmx2048M", "-Dplugin.version=" + version.value),
    watchSources ++= {
      (sourceDirectory.value ** "*").get
    },
    libraryDependencies ++= Seq(Deps.awssdkS3, Deps.java8Compat),
  )

lazy val root = project
  .in(file("."))
  .settings(name := "converter-root")
  .configure(baseSettings, preventPublication)
  .aggregate(
    logging,
    utils,
    phases,
    ts,
    scalajs,
    `importer-portable`,
    `sbt-converter`,
    importer,
    cli,
  )

lazy val baseSettings: Project => Project =
  _.settings(
    licenses += ("GPL-3.0", url("https://opensource.org/licenses/GPL-3.0")),
    scalaVersion := "2.12.13",
    organization := "org.scalablytyped.converter",
    scalacOptions ~= (_.filterNot(
      Set(
        "-Ywarn-unused:imports",
        "-Ywarn-unused:params",
        "-Xfatal-warnings",
      ),
    )),
    /* disable scaladoc */
    sources in (Compile, doc) := Nil,
    publishArtifact in (Compile, packageDoc) := false,
    resolvers += Resolver.bintrayRepo("oyvindberg", "converter"),
  )

lazy val optimize: Project => Project =
  _.settings(
    scalacOptions ++= Seq(
      "-opt:l:inline",
      "-opt:l:method",
      "-opt:simplify-jumps",
      "-opt:compact-locals",
      "-opt:copy-propagation",
      "-opt:redundant-casts",
      "-opt:box-unbox",
      "-opt:nullness-tracking",
      //      "-opt:closure-invocations",
      "-opt-inline-from:org.scalablytyped.converter.internal.**",
      "-opt-warnings",
    ),
  )

lazy val publicationSettings: Project => Project = _.settings(
  publishMavenStyle := true,
  homepage := Some(new URL("https://github.com/oyvindberg/ScalablyTypedConverter")),
  startYear := Some(2019),
  pomExtra := (
    <scm>
      <connection>scm:git:github.com:/oyvindberg/ScalablyTypedConverter</connection>
      <developerConnection>scm:git:git@github.com:oyvindberg/ScalablyTypedConverter.git</developerConnection>
      <url>github.com:oyvindberg/ScalablyTypedConverter.git</url>
    </scm>
      <developers>
        <developer>
          <id>oyvindberg</id>
          <name>Øyvind Raddum Berg</name>
        </developer>
      </developers>
  ),
)

lazy val preventPublication: Project => Project =
  _.settings(
    skip in publish := true,
  )
