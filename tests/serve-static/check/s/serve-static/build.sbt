organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-7644ac"
scalaVersion := "3.0.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-53bf90",
  "org.scalablytyped" %%% "mime" % "2.0-22281a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-7c1e2a")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
