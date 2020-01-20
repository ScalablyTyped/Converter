organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-fdf7bd"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-84b8ea",
  "org.scalablytyped" %%% "mime" % "2.0-fc44b8",
  "org.scalablytyped" %%% "std" % "0.0-unknown-c0154d")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        