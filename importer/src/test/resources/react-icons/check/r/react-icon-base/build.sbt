organization := "com.olvind.scalablytyped"
name := "react-icon-base"
version := "2.1-89c8a4"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-d10e15",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-d934bb",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        