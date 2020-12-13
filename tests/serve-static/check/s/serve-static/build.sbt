organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-28813e"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.3.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-1ff77a",
  "org.scalablytyped" %%% "mime" % "2.0-85b43c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-de1384")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
