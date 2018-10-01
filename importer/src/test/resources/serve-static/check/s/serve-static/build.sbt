organization := "com.olvind.scalablytyped"
name := "serve-static"
version := "0.0-unknown-dddf3b"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-c8123a",
  "com.olvind.scalablytyped" %%% "mime" % "2.0-5763bd",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-9016bf",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        