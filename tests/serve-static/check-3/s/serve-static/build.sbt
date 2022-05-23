organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-e76ac1"
scalaVersion := "3.1.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-22b05f",
  "org.scalablytyped" %%% "mime" % "2.0-faf337",
  "org.scalablytyped" %%% "std" % "0.0-unknown-cba7ff")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
