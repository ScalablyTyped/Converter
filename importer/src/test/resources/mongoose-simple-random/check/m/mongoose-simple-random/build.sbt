organization := "com.olvind.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-4cbec2"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "mongoose" % "0.0-unknown-faa99e",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-219ea2",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-447754",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        