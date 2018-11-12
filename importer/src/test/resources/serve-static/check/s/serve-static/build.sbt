organization := "com.scalablytyped"
name := "serve-static"
version := "0.0-unknown-5d8773"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-a37b94",
  "com.scalablytyped" %%% "mime" % "2.0-f83510",
  "com.scalablytyped" %%% "std" % "0.0-unknown-f00535",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        