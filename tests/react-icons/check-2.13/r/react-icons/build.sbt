organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-5eafc8"
scalaVersion := "2.13.5"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-c84133",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-fe36dc",
  "org.scalablytyped" %%% "std" % "0.0-unknown-47c6f9")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
