lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(ScalablyTypedConverterPlugin)
    .settings(
      Compile / tsoFlavour := Flavour.Japgolly,
      Compile / tsoIgnore += "csstype",
      Compile / tsoMinimize := Selection.All(),
      Compile / npmDependencies ++= Seq(
        "@types/react-dom" -> "16.9.1",
        "@types/react" -> "16.9.5",
        "react-dom" -> "16.9",
        "react" -> "16.9",
        "semantic-ui-react" -> "0.88.1",
      ),
      libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.5.0-RC2",
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.12.10",
      organization := "net.leibman",
    )
