organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-6ce0d8"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-bf1a14",
  "org.scalablytyped" %%% "mime" % "2.0-ff6baa",
  "org.scalablytyped" %%% "std" % "0.0-unknown-43cef5")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
