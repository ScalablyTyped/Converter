lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(TsoPlugin)
    .settings(
      Compile / npmDependencies ++= Seq(
        "@types/express" -> "4.17.2",
      ),
      Compile / tsoMinimize := Selection.AllOf("std"),
      Compile / tsoStdlib := List("es5"),
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.12.8",
      organization := "com.olvind",
    )
