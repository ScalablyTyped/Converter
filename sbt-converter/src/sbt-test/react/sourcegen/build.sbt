lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(ScalablyTypedConverterGenSourcePlugin)
    .settings(
      stUseYarn := true,
      Compile / stNpmDependencies ++= Seq(
        "@types/express" -> "4.17.2",
      ),
      stMinimize := Selection.AllExcept("express", "node"),
      stStdlib := List("es5"),
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.2",
      organization := "com.olvind",
      stOutputPackage := "mytypings",
    )
