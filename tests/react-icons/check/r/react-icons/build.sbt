organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-602000"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-cf265a",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-0aa94f",
  "org.scalablytyped" %%% "std" % "0.0-unknown-1b9629")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
