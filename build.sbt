import scala.sys.process.stringToProcess

lazy val latestTag = "git tag -l --sort=committerdate".!!.linesIterator.toVector.last.drop( /* 'v' */ 1)

// BSP setup to use with bloop
Global / bloopExportJarClassifiers := Some(Set("sources"))
Global / bspEnabled := false
autoStartServer := false
Global / excludeLintKeys += autoStartServer

lazy val core = project
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.ammoniteOps, Deps.osLib, Deps.sourcecode) ++ Deps.circe)

lazy val logging = project
  .configure(baseSettings)
  .settings(libraryDependencies ++= Seq(Deps.sourcecode, Deps.fansi))

lazy val ts = project
  .configure(baseSettings, optimize)
  .dependsOn(core, logging)
  .settings(libraryDependencies += Deps.parserCombinators)

lazy val docs = project
  .in(file("converter-docs"))
  .settings(
    mdocVariables := Map("VERSION" -> latestTag),
    moduleName := "converter-docs",
    skip in publish := true,
  )
  .enablePlugins(MdocPlugin, DocusaurusPlugin)

lazy val scalajs = project
  .dependsOn(core, logging)
  .configure(baseSettings, optimize)
  .settings(libraryDependencies ++= Seq(Deps.scalaXml))

lazy val phases = project
  .dependsOn(core, logging)
  .configure(baseSettings, optimize)

lazy val `importer-portable` = project
  .configure(baseSettings, optimize)
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
  .configure(baseSettings, optimize)
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
  .configure(baseSettings)
  .settings(libraryDependencies += Deps.scopt)

lazy val `sbt-converter` = project
  .dependsOn(`importer-portable`)
  .enablePlugins(ScriptedPlugin)
  .configure(baseSettings)
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

lazy val `import-scalajs-definitions` = project
  .configure(baseSettings)
  .dependsOn(importer)
  .settings(
    libraryDependencies ++= List("org.scala-lang" % "scalap" % scalaVersion.value),
    publish / skip := true,
  )

lazy val root = project
  .in(file("."))
  .settings(
    name := "converter-root",
    skip in publish := true,
  )
  .configure(baseSettings)
  .aggregate(logging, core, phases, ts, scalajs, `importer-portable`, `sbt-converter`, importer, cli)

lazy val baseSettings: Project => Project =
  _.settings(
    sonatypeCredentialHost := Sonatype.sonatype01,
    sonatypeProfileName := "org.scalablytyped",
    organization := "org.scalablytyped.converter",
    licenses += ("GPL-3.0", url("https://opensource.org/licenses/GPL-3.0")),
    homepage := Some(url("https://github.com/ScalablyTyped/Converter")),
    developers := List(
      Developer(
        "oyvindberg",
        "Øyvind Raddum Berg",
        "elacin@gmail.com",
        url("https://github.com/oyvindberg"),
      ),
    ),
    scalaVersion := "2.12.14",
    scalacOptions ~= (_.filterNot(Set("-Ywarn-unused:imports", "-Ywarn-unused:params", "-Xfatal-warnings"))),
    /* disable scaladoc */
    sources in (Compile, doc) := Nil,
  )

lazy val optimize: Project => Project =
  _.settings(
    scalacOptions ++= {
      if (insideCI.value || !isSnapshot.value)
        Seq(
          "-opt:l:inline",
          "-opt:l:method",
          "-opt:simplify-jumps",
          "-opt:compact-locals",
          "-opt:copy-propagation",
          "-opt:redundant-casts",
          "-opt:box-unbox",
          "-opt:nullness-tracking",
          "-opt-inline-from:org.scalablytyped.converter.internal.**",
          "-opt-warnings",
        )
      else Nil
    },
  )
