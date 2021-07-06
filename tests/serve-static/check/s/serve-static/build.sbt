organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-646616"
scalaVersion := "3.0.1-RC2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-1b9264",
  "org.scalablytyped" %%% "mime" % "2.0-3938e3",
  "org.scalablytyped" %%% "std" % "0.0-unknown-3ca3e0")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
