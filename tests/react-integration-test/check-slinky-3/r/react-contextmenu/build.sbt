organization := "org.scalablytyped"
name := "react-contextmenu"
version := "2.13.0-d78f9d"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.7.2",
  "org.scalablytyped" %%% "react" % "16.9.2-d793cd",
  "org.scalablytyped" %%% "std" % "0.0-unknown-7f073b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
