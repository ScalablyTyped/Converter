organization := "com.olvind.scalablytyped"
name := "numjs"
version := "0.0-unknown-8e0c7f"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "ndarray" % "0.0-unknown-38ad9b",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-cf7be0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        