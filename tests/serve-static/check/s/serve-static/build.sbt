organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-e3b2a6"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-8114c5",
  "org.scalablytyped" %%% "mime" % "2.0-eddee5",
  "org.scalablytyped" %%% "std" % "0.0-unknown-0406a0")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
