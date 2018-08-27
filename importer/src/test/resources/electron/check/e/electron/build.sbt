organization := "com.olvind.scalablytyped"
name := "electron"
version := "2.0.0-aa2822"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-601272",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-939f0e",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        