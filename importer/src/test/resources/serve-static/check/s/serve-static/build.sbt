organization := "com.olvind.scalablytyped"
name := "serve-static"
version := "0.0-unknown-7a3b41"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-b1f8cd",
  "com.olvind.scalablytyped" %%% "mime" % "2.0-cdc49b",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-0f7ed7",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        