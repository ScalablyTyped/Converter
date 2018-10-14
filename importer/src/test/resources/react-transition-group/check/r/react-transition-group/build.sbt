organization := "com.olvind.scalablytyped"
name := "react-transition-group"
version := "2.0-e48d88"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-eeafbd",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-b81700",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        