organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-3021f3"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-ba18c4",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-d9530d",
  "org.scalablytyped" %%% "std" % "0.0-unknown-da431d")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
