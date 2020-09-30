organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-4e14f4"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-4126ed",
  "org.scalablytyped" %%% "node" % "0.0-unknown-49716a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-4fbd5f")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
