organization := "org.scalablytyped"
name := "lit-element"
version := "0.0-unknown-8a92c7"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.0",
  "com.raquo" %%% "laminar" % "0.13.0",
  "org.scala-js" %%% "scalajs-dom" % "1.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-0cf7a7")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
