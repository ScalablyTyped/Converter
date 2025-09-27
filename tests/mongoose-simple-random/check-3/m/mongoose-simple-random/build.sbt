organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-58cb7f"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-e3d3aa",
  "org.scalablytyped" %%% "node" % "0.0-unknown-4d9c4b",
  "org.scalablytyped" %%% "std" % "0.0-unknown-73c9cd")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
