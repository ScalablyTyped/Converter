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
      stStdlib := List("es2015"),
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.18",
      organization := "com.olvind",
      stOutputPackage := "mytypings",
    )
