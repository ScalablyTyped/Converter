organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-369df1"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-c9d184",
  "org.scalablytyped" %%% "mime" % "2.0-c466ef",
  "org.scalablytyped" %%% "std" % "0.0-unknown-474a0a")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
