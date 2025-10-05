import scala.sys.process.stringToProcess

lazy val latestTag = "git tag -l --sort=committerdate".!!.linesIterator.toVector.last.drop( /* 'v' */ 1)

ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always,
  "org.scala-lang.modules" %% "scala-parser-combinators" % VersionScheme.Always,
  "org.scala-lang.modules" %% "scala-collection-compat" % VersionScheme.Always,
)

lazy val core = project
  .configure(baseSettings)
  .settings(
    libraryDependencies ++= Seq(
      Deps.osLib.cross(CrossVersion.for3Use2_13),
      Deps.sourcecode.exclude("org.scala-lang.modules", "scala-collection-compat_3"),
      Deps.ammoniteOps.cross(CrossVersion.for3Use2_13),
    ) ++ Deps.circe.map(_.exclude("org.scala-lang.modules", "scala-collection-compat_3")),
  )

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
    libraryDependencies ++= {
      val base = Seq(
        Deps.coursier.cross(CrossVersion.for3Use2_13).exclude("org.scala-lang.modules", "scala-xml_2.13"),
        Deps.scalaXml,
        Deps.scalatest % Test,
      )
      // Parallel collections are built-in for Scala 2.12, need external library for 2.13+
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, 12)) => base
        case _             => base :+ (Deps.parallelCollections % Test)
      }
    },
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
  .dependsOn(`importer-portable` % "compile->compile;test->test")
  .enablePlugins(ScriptedPlugin)
  .configure(baseSettings)
  .settings(
    name := "sbt-converter",
    scalaVersion := scala212, // Always use Scala 2.12 for this project
    crossScalaVersions := Seq(scala212), // For now, keep SBT 1.x only
    addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.21.1"),
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.20.1"),
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
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, 12)) =>
          List(
            "org.scala-lang" % "scalap" % scala212,
            Deps.coursier,
          )
        case _ => // Scala 3
          List(
            "org.scala-lang" % "scalap" % "2.13.16",
            Deps.coursier.cross(CrossVersion.for3Use2_13).exclude("org.scala-lang.modules", "scala-xml_2.13"),
          )
      }
    },
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

lazy val scala212 = "2.12.20"
lazy val scala3   = "3.3.4"

lazy val baseSettings: Project => Project =
  _.settings(
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
    pgpSigningKey := Some("763825CAF9034C05E56A042EF5BAF6416BD9F936"),
    scalaVersion := scala212,
    crossScalaVersions := Seq(scala212, scala3),
    scalacOptions ~= (_.filterNot(Set("-Ywarn-unused:imports", "-Ywarn-unused:params", "-Xfatal-warnings"))),
    scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) =>
          Seq("-no-indent", "-source:3.3")
        case _ =>
          Seq()
      }
    },
    /* disable scaladoc */
    Compile / doc / sources := Nil,
  )

lazy val optimize: Project => Project =
  _.settings(
    scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, _)) if insideCI.value || !isSnapshot.value =>
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
        case _ => Nil
      }
    },
  )
