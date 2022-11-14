organization := "org.scalablytyped"
name := "react-select"
version := "0.0-unknown-82d66a"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.7.2",
  "org.scalablytyped" %%% "react" % "16.9.2-e0bfc4",
  "org.scalablytyped" %%% "std" % "0.0-unknown-939dc8")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
