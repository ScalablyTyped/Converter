organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-3be6d8"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-657876",
  "org.scalablytyped" %%% "node" % "0.0-unknown-ff2158",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a76578")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
