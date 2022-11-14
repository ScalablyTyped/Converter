organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-2339e0"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-8682a3",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-dac5aa",
  "org.scalablytyped" %%% "std" % "0.0-unknown-29edba")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
