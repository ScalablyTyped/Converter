organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-d53862"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-5bcc51",
  "org.scalablytyped" %%% "mime" % "2.0-b145bb",
  "org.scalablytyped" %%% "std" % "0.0-unknown-42967d")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
