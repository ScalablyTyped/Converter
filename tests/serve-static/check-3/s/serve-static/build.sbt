organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-8c7c06"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-bb05e6",
  "org.scalablytyped" %%% "mime" % "2.0-75b268",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5bb426")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
