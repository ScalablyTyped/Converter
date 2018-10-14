organization := "com.olvind.scalablytyped"
name := "serve-static"
version := "0.0-unknown-b323d0"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-edd243",
  "com.olvind.scalablytyped" %%% "mime" % "2.0-95e0bf",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-29643d",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        