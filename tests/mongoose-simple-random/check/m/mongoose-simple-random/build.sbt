organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-6eb32d"
scalaVersion := "3.0.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-ab07a7",
  "org.scalablytyped" %%% "node" % "0.0-unknown-1cdf89",
  "org.scalablytyped" %%% "std" % "0.0-unknown-303e28")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
