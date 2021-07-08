organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-9b0dfe"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-fb6382",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-e13b11",
  "org.scalablytyped" %%% "std" % "0.0-unknown-33f030")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
