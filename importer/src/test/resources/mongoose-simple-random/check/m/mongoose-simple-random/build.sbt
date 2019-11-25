organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-2e4e20"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-5e823a",
  "org.scalablytyped" %%% "node" % "0.0-unknown-06c9c9",
  "org.scalablytyped" %%% "std" % "0.0-unknown-061025")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        