organization := "com.olvind.scalablytyped"
name := "lodash_dot_add"
version := "3.7-859f42"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "lodash" % "4.14-d12e9b",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-e6f64f",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        