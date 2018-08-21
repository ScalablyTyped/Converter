organization := "com.olvind.scalablytyped"
name := "stdlib"
version := "Unknown"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.olvind" %%% "runtime" % "0.1-SNAPSHOT",

)
publishArtifact in packageDoc := false
