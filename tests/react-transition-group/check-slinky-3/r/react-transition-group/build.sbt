organization := "org.scalablytyped"
name := "react-transition-group"
version := "2.0-d051d2"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.6.8+10-ca6379d6",
  "org.scalablytyped" %%% "react" % "0.0-unknown-dab676",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a7a73b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
