// *****************************************************************************
// Projects
// *****************************************************************************

import java.nio.file.Files
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

lazy val start = TaskKey[Unit]("start")

lazy val dist = TaskKey[File]("dist")

lazy val newarch =
  project
    .in(file("."))
    .enablePlugins(ScalaJSPlugin)
    .configure(bundlerSettings, browserProject, tsoSettings)
    .settings(commonSettings)
    .settings(
      webpackDevServerPort := 8009,
      libraryDependencies ++= Seq(
        library.scalaCheck % Test,
        library.scalaTest  % Test,
        "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
        "com.github.japgolly.scalajs-react" %%% "core" % "1.4.2",
      ),
      Compile / npmDependencies ++= Seq(
        "typescript" -> "3.6.3", //TODO Probably can remove this
        "react-dom" -> "16.9",
        "@types/react-dom" -> "16.9.1",
        "react" -> "16.9",
        "@types/react" -> "16.9.5",
        "semantic-ui-react" -> "0.88.1",
      ),
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val scalaCheck = "1.14.0"
      val scalaTest  = "3.0.8"
    }
    val scalaCheck = "org.scalacheck" %% "scalacheck" % Version.scalaCheck
    val scalaTest  = "org.scalatest"  %% "scalatest"  % Version.scalaTest
  }

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
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8"
    ),
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
  )

lazy val tsoSettings: Project => Project =
  _.enablePlugins(TsoPlugin)
    .settings()

lazy val bundlerSettings: Project => Project =
  _.enablePlugins(ScalaJSBundlerPlugin)
    .configure(application)
    .settings(
      /* Specify current versions and modes */
      startWebpackDevServer / version := "3.1.10",
      webpack / version := "4.26.1",
      Compile / fastOptJS / webpackExtraArgs += "--mode=development",
      Compile / fullOptJS / webpackExtraArgs += "--mode=production",
      Compile / fastOptJS / webpackDevServerExtraArgs += "--mode=development",
      Compile / fullOptJS / webpackDevServerExtraArgs += "--mode=production",
      useYarn := true,
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
    }
  )

lazy val application: Project => Project =
  _.settings(
    scalaJSUseMainModuleInitializer := true,
    /* disabled because it somehow triggers many warnings */
    emitSourceMaps := false,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
  )
