organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-ea9971"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-c314ca",
  "org.scalablytyped" %%% "node" % "0.0-unknown-2bbf7c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-dd99ed")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
