organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-a6928e"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-e97933",
  "org.scalablytyped" %%% "mime" % "2.0-732cd7",
  "org.scalablytyped" %%% "std" % "0.0-unknown-69de04")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
