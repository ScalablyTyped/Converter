organization := "com.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-43c88a"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "mongoose" % "0.0-unknown-26ae85",
  "com.scalablytyped" %%% "node" % "0.0-unknown-6822cc",
  "com.scalablytyped" %%% "std" % "0.0-unknown-589abf",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        