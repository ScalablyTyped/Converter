organization := "com.olvind.scalablytyped"
name := "sax"
version := "1.x-89c38c"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "9.6.x-e650f0",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-f10689",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        