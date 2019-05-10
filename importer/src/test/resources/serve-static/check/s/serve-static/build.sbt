organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-6bc53e"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-651458",
  "org.scalablytyped" %%% "mime" % "2.0-e4e722",
  "org.scalablytyped" %%% "std" % "0.0-unknown-e62f6e")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        