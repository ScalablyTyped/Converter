organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-ca2927"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-a65908",
  "org.scalablytyped" %%% "node" % "0.0-unknown-57c4ce",
  "org.scalablytyped" %%% "std" % "0.0-unknown-d633e0")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        