organization := "org.scalablytyped"
name := "util-dynamodb"
version := "0.0-unknown-c40047"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "aws-sdk__client-dynamodb" % "0.0-unknown-0dad99",
  "org.scalablytyped" %%% "std" % "0.0-unknown-6fc558")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
