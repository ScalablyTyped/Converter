organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-6d487a"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-e6d6f7",
  "org.scalablytyped" %%% "mime" % "2.0-17e4a7",
  "org.scalablytyped" %%% "std" % "0.0-unknown-20bbb4")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        