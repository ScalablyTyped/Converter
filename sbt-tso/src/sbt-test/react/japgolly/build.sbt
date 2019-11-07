import java.nio.file.Files
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

import com.olvind.tso.plugin.ReactBinding.Japgolly
// *****************************************************************************
// Projects
// *****************************************************************************
lazy val start = TaskKey[Unit]("start")

lazy val dist = TaskKey[File]("dist")

lazy val debugDist = TaskKey[File]("debugDist")

lazy val japgolly =
  project
    .in(file("."))
    .enablePlugins(ScalaJSPlugin, TsoPlugin)
    .configure(bundlerSettings, browserProject)
    .settings(commonSettings)
    .settings(commonDependencies)

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val commonDependencies = Seq(
  libraryDependencies ++= Seq(
    "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
    "com.github.japgolly.scalajs-react" %%% "core" % "1.4.2" withSources(),
    "com.github.japgolly.scalajs-react" %%% "extra" % "1.4.2" withSources(),
    "com.github.pathikrit" %% "better-files" % "3.8.0",
    "org.scalatest" %% "scalatest" % "3.0.8" % "test" withSources(),
  ),
)

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val commonSettings =
  Seq(
    // scalaVersion from .travis.yml via sbt-travisci
    scalaVersion := "2.12.10",
    organization := "net.leibman",
    organizationName := "Roberto Leibman",
    startYear := Some(2019),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= Seq(
      "-P:scalajs:sjsDefinedByDefault",
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8"
    ),
    Global / onChangedBuildSource := ReloadOnSourceChanges,
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    Compile / tsoReactBinding := Japgolly,
    Compile / tsoIgnore += "csstype",
    Compile / tsoMinimize := Selection.AllExcept("semantic-ui-react", "react-dropzone", "@stardust-ui", "react-big-calendar", "moment"),
    webpackDevServerPort := 8009,
  )

lazy val bundlerSettings: Project => Project =
  _.enablePlugins(ScalaJSBundlerPlugin)
    .configure(application)
    .settings(
      /* Specify current versions and modes */
      startWebpackDevServer / version := "3.1.10",
      webpack / version := "4.28.3",
      Compile / fastOptJS / webpackExtraArgs += "--mode=development",
      Compile / fullOptJS / webpackExtraArgs += "--mode=production",
      Compile / fastOptJS / webpackDevServerExtraArgs += "--mode=development",
      Compile / fullOptJS / webpackDevServerExtraArgs += "--mode=production",
      useYarn := true,
      Compile / npmDependencies ++= Seq(
        "react-dom" -> "16.9",
        "@types/react-dom" -> "16.9.1",
        "react" -> "16.9",
        "@types/react" -> "16.9.5",
        "semantic-ui-react" -> "0.88.1",
      ),
    )

lazy val browserProject: Project => Project =
  _.settings(
    start := {
      (Compile / fastOptJS / startWebpackDevServer).value
      val indexFrom = baseDirectory.value / "assets/index.html"
      val indexTo = (Compile / fastOptJS / crossTarget).value / "index.html"
      Files.copy(indexFrom.toPath, indexTo.toPath, REPLACE_EXISTING)
    },
    dist := {
      val artifacts = (Compile / fullOptJS / webpack).value
      val artifactFolder = (Compile / fullOptJS / crossTarget).value
      val distFolder = (ThisBuild / baseDirectory).value / "docs" / moduleName.value

      distFolder.mkdirs()
      artifacts.foreach { artifact =>
        val target = artifact.data.relativeTo(artifactFolder) match {
          case None => distFolder / artifact.data.name
          case Some(relFile) => distFolder / relFile.toString
        }

        println(s"Trying to copy ${artifact.data.toPath} to ${target.toPath}")
        Files.copy(artifact.data.toPath, target.toPath, REPLACE_EXISTING)
      }

      val indexFrom = baseDirectory.value / "assets/index.html"
      val indexTo = distFolder / "index.html"

      val indexPatchedContent = {
        import collection.JavaConverters._
        Files
          .readAllLines(indexFrom.toPath, IO.utf8)
          .asScala
          .map(_.replaceAllLiterally("-fastopt-", "-opt-"))
          .mkString("\n")
      }

      Files.write(indexTo.toPath, indexPatchedContent.getBytes(IO.utf8))
      distFolder
    },
      debugDist := {
      val artifacts = (Compile / fastOptJS / webpack).value
      val artifactFolder = (Compile / fastOptJS / crossTarget).value
      val debugFolder = (ThisBuild / baseDirectory).value / "docs" / moduleName.value

      debugFolder.mkdirs()
      artifacts.foreach { artifact =>
        val target = artifact.data.relativeTo(artifactFolder) match {
          case None => debugFolder / artifact.data.name
          case Some(relFile) => debugFolder / relFile.toString
        }

        println(s"Trying to copy ${artifact.data.toPath} to ${target.toPath}")
        Files.copy(artifact.data.toPath, target.toPath, REPLACE_EXISTING)
      }

      val indexFrom = baseDirectory.value / "assets/index.html"
      val indexTo = debugFolder / "index.html"

      val indexPatchedContent = {
        import collection.JavaConverters._
        Files
          .readAllLines(indexFrom.toPath, IO.utf8)
          .asScala
//          .map(_.replaceAllLiterally("-fastopt-", "-opt-"))
          .mkString("\n")
      }

      Files.write(indexTo.toPath, indexPatchedContent.getBytes(IO.utf8))
      debugFolder
    }
  )

lazy val application: Project => Project =
  _.settings(
    scalaJSUseMainModuleInitializer := true,
    /* disabled because it somehow triggers many warnings */
    emitSourceMaps := false,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
  )
