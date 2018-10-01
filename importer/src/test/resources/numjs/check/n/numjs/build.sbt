organization := "com.olvind.scalablytyped"
name := "numjs"
version := "0.0-unknown-b860a3"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "ndarray" % "0.0-unknown-e72c13",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-9016bf",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        