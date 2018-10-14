organization := "com.olvind.scalablytyped"
name := "react-bootstrap"
version := "0.32-82599f"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-76eed0",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-a7c637",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        