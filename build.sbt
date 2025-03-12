import scala.sys.process.stringToProcess

lazy val latestTag =
  "git tag -l --sort=committerdate".!!.linesIterator.toVector.lastOption.fold("no-version")(_.drop( /* 'v' */ 1))

Global / onChangedBuildSource := ReloadOnSourceChanges
// BSP setup to use with bloop
Global / bloopExportJarClassifiers := Some(Set("sources"))

ThisBuild / dynverSonatypeSnapshots := true

// bloop hasn't upgraded to scala-xml 2 yet
ThisBuild / libraryDependencySchemes ++= Seq("org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always)

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
    publish / skip := true,
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
      Deps.coursier,
      Deps.scalatest % Test,
    ),
    Test / fork := true,
    assembly / test := {},
    assembly / mainClass := Some("org.scalablytyped.converter.Main"),
    /* meh meh meh */
    assembly / assemblyMergeStrategy := {
      case foo if foo.contains("io/github/soc/directories/")         => MergeStrategy.first
      case foo if foo.contains("reflect.properties")                 => MergeStrategy.first
      case foo if foo.contains("scala-collection-compat.properties") => MergeStrategy.first
      case foo if foo.endsWith("module-info.class")                  => MergeStrategy.discard
      case foo if foo.contains("org/fusesource")                     => MergeStrategy.first
      case foo if foo.contains("META-INF/native/")                   => MergeStrategy.first
      case foo if foo.contains("scala/annotation")                   => MergeStrategy.last
      case foo if foo.contains("META-INF/sisu/javax.inject.Named")   => MergeStrategy.discard
      case other                                                     => (assembly / assemblyMergeStrategy).value(other)
    },
    Test / testOptions += Tests.Argument("-P4"),
  )

lazy val cli = project
  .dependsOn(importer)
  .configure(baseSettings)
  .settings(
    libraryDependencies += Deps.scopt,
  )

lazy val `sbt-converter` = project
  .dependsOn(`importer-portable`)
  .enablePlugins(ScriptedPlugin)
  .configure(baseSettings)
  .settings(
    name := "sbt-converter",
    addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.21.1"),
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.18.2"),
    sbtPlugin := true,
    // set up 'scripted; sbt plugin for testing sbt plugins
    scriptedBufferLog := false,
    scriptedLaunchOpts ++= Seq("-Xmx2048M", "-Dplugin.version=" + version.value),
    watchSources ++= {
      (sourceDirectory.value ** "*").get
    },
    libraryDependencies ++= Seq(Deps.awssdkS3),
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
    publish / skip := true,
  )
  .configure(baseSettings)
  .aggregate(logging, core, phases, ts, scalajs, `importer-portable`, `sbt-converter`, importer, cli)

lazy val baseSettings: Project => Project =
  _.settings(
    credentials += Credentials(Path.userHome / ".sbt" / "kurusugawa.credentials"),
    publishTo := {
      val suffix =
        if (isVersionStable.value) {
          "release"
        } else {
          "snapshot"
        }
      Some("kurusugawa nexus".at(s"https://kurusugawa.jp/nexus3/content/repositories/KRSPUBLIC-$suffix/"))
    },
    organization := "jp.kurusugawa.scalablytyped",
    licenses += ("GPL-3.0", url("https://opensource.org/licenses/GPL-3.0")),
    homepage := Some(url("https://github.com/kurusugawa-computer/ScalablyTypedConverter")),
    developers := List(
      Developer(
        "oyvindberg",
        "Øyvind Raddum Berg",
        "elacin@gmail.com",
        url("https://github.com/oyvindberg"),
      ),
    ),
    scalaVersion := "2.12.20",
    scalacOptions ~= (_.filterNot(Set("-Ywarn-unused:imports", "-Ywarn-unused:params", "-Xfatal-warnings"))),
    /* disable scaladoc */
    Compile / doc / sources := Nil,
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
