organization := "com.olvind.scalablytyped"
name := "angular-agility"
version := "0.0-unknown-c7c3d7"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "angular" % "1.6-59ef1b",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-c45498",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        