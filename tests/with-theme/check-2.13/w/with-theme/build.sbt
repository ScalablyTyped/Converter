organization := "org.scalablytyped"
name := "with-theme"
version := "0.0-unknown-72909d"
scalaVersion := "2.13.5"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-5a852a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-cac4c1")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
