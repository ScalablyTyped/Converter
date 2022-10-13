organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-32033b"
scalaVersion := "3.2.2-RC1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-5fbd67",
  "org.scalablytyped" %%% "mime" % "2.0-510b0c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5ee2fd")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
