organization := "com.olvind.scalablytyped"
name := "sax"
version := "1.x-3c1462"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "9.6.x-35cddf",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-f7b8fe",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        