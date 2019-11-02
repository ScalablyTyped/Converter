lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(TsoPlugin)
    .settings(
      Compile / tsoReactBinding := ReactBinding.Slinky,
      Compile / tsoIgnore += "csstype",
      Compile / tsoMinimize := Selection.AllExcept("react-dom"),
      Compile / npmDependencies ++= Seq(
        "@types/react-dom" -> "16.9.1",
        "@types/react" -> "16.9.5",
        "react-dom" -> "16.9",
        "react" -> "16.9",
        "semantic-ui-react" -> "0.88.1",
      ),
      libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.6.2",
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.1",
      organization := "net.leibman",
    )
