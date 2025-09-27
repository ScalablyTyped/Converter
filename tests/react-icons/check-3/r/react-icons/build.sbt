organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-4522cd"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-f18e77",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-d09269",
  "org.scalablytyped" %%% "std" % "0.0-unknown-d01dfd")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
