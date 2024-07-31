organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-4fdd76"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-a943d3",
  "org.scalablytyped" %%% "node" % "0.0-unknown-c2c08f",
  "org.scalablytyped" %%% "std" % "0.0-unknown-9c4e6c")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
