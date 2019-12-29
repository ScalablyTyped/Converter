lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(ScalablyTypedConverterPlugin)
    .settings(
      useYarn := true,
      Compile / npmDependencies ++= Seq(
        "@types/react-dom" -> "16.9.1",
        "@types/react" -> "16.9.5",
        "@types/node" -> "12.12.14",
        "react-dom" -> "16.9",
        "react" -> "16.9",
        "semantic-ui-react" -> "0.88.1",
      ),
      Compile / tsoFlavour := Flavour.Japgolly,
      Compile / tsoIgnore += "csstype",
      Compile / tsoMinimize := Selection.All(),
      libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.5.0-RC2",
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.1",
      organization := "net.leibman",
    )
