organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-55bda3"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-89e5f5",
  "org.scalablytyped" %%% "node" % "0.0-unknown-654197",
  "org.scalablytyped" %%% "std" % "0.0-unknown-9918e1")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
