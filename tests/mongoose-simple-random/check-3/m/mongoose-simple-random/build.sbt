organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-36bbf3"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-bf386a",
  "org.scalablytyped" %%% "node" % "0.0-unknown-08715b",
  "org.scalablytyped" %%% "std" % "0.0-unknown-1d22fa")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
