ThisBuild / scalaVersion := "2.13.18"
ThisBuild / organization := "com.olvind"

lazy val root =
  project
    .in(file("."))
    .aggregate(app, lib)

lazy val app =
  project
    .enablePlugins(ScalablyTypedConverterPlugin)
    .dependsOn(lib)
    .settings(
      useYarn := true,
      scalaJSUseMainModuleInitializer := true,
      stOutputPackage := "mytypings",
    )

lazy val lib =
  project
    .enablePlugins(ScalablyTypedConverterGenSourcePlugin)
    .settings(
      useYarn := true,
      Compile / npmDependencies ++= Seq(
        "@types/express" -> "4.17.2",
      ),
      stMinimize := Selection.AllExcept("express", "node"),
      stStdlib := List("es2015"),
      stOutputPackage := "mytypings",
    )
