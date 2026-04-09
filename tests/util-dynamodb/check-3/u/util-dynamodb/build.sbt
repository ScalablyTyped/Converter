organization := "org.scalablytyped"
name := "util-dynamodb"
version := "0.0-unknown-3b7729"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "aws-sdk__client-dynamodb" % "0.0-unknown-e2049e",
  "org.scalablytyped" %%% "std" % "0.0-unknown-ca137a")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
