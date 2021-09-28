organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-a10ece"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-ab72fd",
  "org.scalablytyped" %%% "node" % "0.0-unknown-a8a145",
  "org.scalablytyped" %%% "std" % "0.0-unknown-be260d")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
