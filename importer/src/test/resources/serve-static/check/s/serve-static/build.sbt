organization := "com.scalablytyped"
name := "serve-static"
version := "0.0-unknown-bd3058"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-60e7b5",
  "com.scalablytyped" %%% "mime" % "2.0-5f042a",
  "com.scalablytyped" %%% "std" % "0.0-unknown-1c98bf",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        