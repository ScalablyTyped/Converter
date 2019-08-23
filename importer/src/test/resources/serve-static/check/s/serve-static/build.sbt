organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-e3afd6"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-30e65e",
  "org.scalablytyped" %%% "mime" % "2.0-a0c94e",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5fe3f3")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        