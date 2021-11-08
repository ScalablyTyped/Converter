organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-280265"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-88d2cf",
  "org.scalablytyped" %%% "mime" % "2.0-e2ad1c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-e178b4")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
