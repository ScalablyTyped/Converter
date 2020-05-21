organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-247145"
scalaVersion := "2.13.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-cafa9d",
  "org.scalablytyped" %%% "mime" % "2.0-a4cc8d",
  "org.scalablytyped" %%% "std" % "0.0-unknown-3e814e")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
