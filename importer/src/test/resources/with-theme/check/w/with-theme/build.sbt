organization := "com.olvind.scalablytyped"
name := "with-theme"
version := "0.0-unknown-9b6eb4"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-1140f3",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-b2c6b6",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        