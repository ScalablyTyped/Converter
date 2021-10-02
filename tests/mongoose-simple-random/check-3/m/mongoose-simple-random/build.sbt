organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-1d4369"
scalaVersion := "3.0.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-1fa570",
  "org.scalablytyped" %%% "node" % "0.0-unknown-7960b4",
  "org.scalablytyped" %%% "std" % "0.0-unknown-f84e23")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
