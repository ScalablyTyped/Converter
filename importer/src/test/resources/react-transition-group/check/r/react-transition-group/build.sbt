organization := "com.olvind.scalablytyped"
name := "react-transition-group"
version := "2.0-fc8e84"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-c59a5c",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-dc2da5",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        