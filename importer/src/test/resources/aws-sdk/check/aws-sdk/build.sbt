organization := "com.olvind.scalablytyped"
name := "aws-sdk"
version := "2.247.1"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.olvind" %%% "runtime" % "0.1-SNAPSHOT",
  "com.olvind.scalablytyped" %%% "stdlib" % "Unknown"
)
publishArtifact in packageDoc := false
