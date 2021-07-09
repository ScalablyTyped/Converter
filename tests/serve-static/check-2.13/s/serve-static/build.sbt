organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-cf7379"
scalaVersion := "2.13.5"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-5aa85d",
  "org.scalablytyped" %%% "mime" % "2.0-7bff5e",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a59996")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
