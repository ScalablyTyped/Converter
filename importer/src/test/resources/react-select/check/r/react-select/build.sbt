organization := "com.olvind.scalablytyped"
name := "react-select"
version := "0.0-unknown-13bcf1"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-346328",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-1ad883",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        