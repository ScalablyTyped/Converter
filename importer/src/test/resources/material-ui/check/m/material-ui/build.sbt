organization := "com.olvind.scalablytyped"
name := "material-ui"
version := "0.0-unknown-9b94ae"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-f0c08b",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-53e2b2",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        