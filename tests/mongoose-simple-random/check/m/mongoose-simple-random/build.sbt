organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-df7db5"
scalaVersion := "3.0.1-RC2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-f7a64b",
  "org.scalablytyped" %%% "node" % "0.0-unknown-62c300",
  "org.scalablytyped" %%% "std" % "0.0-unknown-eb24fe")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
