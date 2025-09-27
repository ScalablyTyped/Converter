organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-da8033"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-63ff0f",
  "org.scalablytyped" %%% "node" % "0.0-unknown-175e92",
  "org.scalablytyped" %%% "std" % "0.0-unknown-1c4c4c")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
