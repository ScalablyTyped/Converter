lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(ScalablyTypedConverterGenSourcePlugin)
    .settings(
      useYarn := true,
      Compile / npmDependencies ++= Seq(
        "@types/express" -> "4.17.2",
      ),
      stMinimize := Selection.AllExcept("express", "node"),
      stStdlib := List("es5"),
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.2",
      organization := "com.olvind",
    )
