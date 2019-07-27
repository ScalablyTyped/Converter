organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-eb162b"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-d2ed59",
  "org.scalablytyped" %%% "node" % "0.0-unknown-b68a96",
  "org.scalablytyped" %%% "std" % "0.0-unknown-dddb2f")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        