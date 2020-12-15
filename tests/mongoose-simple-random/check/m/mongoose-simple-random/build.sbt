organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-d539a8"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.3.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-077762",
  "org.scalablytyped" %%% "node" % "0.0-unknown-b68820",
  "org.scalablytyped" %%% "std" % "0.0-unknown-0c4784")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
