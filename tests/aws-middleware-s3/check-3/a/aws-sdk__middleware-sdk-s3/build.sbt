organization := "org.scalablytyped"
name := "aws-sdk__middleware-sdk-s3"
version := "0.0-unknown-737b86"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "aws-sdk__core" % "0.0-unknown-f5f3a5",
  "org.scalablytyped" %%% "smithy__core" % "0.0-unknown-4fb756",
  "org.scalablytyped" %%% "smithy__types" % "0.0-unknown-357e54",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a9a9f5")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
