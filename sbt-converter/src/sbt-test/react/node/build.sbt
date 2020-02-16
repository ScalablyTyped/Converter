lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(ScalablyTypedConverterPlugin)
    .settings(
      useYarn := true,
      Compile / npmDependencies ++= Seq(
        "@types/express" -> "4.17.2",
      ),
      Compile / stStdlib := List("es5"),
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.1",
      organization := "com.olvind",
    )
