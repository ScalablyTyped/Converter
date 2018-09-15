organization := "com.olvind.scalablytyped"
name := "serve-static"
version := "0.0-unknown-78737a"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-fa3829",
  "com.olvind.scalablytyped" %%% "mime" % "2.0-648ec9",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-cf7be0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        