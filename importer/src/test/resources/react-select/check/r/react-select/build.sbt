organization := "com.olvind.scalablytyped"
name := "react-select"
version := "0.0-unknown-91071c"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-2f48e1",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-d23bbf",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        