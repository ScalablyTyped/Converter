organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-251bf1"
scalaVersion := "2.13.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-7d9c4f",
  "org.scalablytyped" %%% "mime" % "2.0-daaca0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a0c14e")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
