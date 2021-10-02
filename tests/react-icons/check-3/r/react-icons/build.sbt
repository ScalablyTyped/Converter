organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-c3d328"
scalaVersion := "3.0.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-617bc9",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-3f3567",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5d365e")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
