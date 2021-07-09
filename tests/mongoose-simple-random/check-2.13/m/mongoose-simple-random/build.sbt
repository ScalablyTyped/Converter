organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-7ea1db"
scalaVersion := "2.13.5"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-09bf07",
  "org.scalablytyped" %%% "node" % "0.0-unknown-96601a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-735661")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
