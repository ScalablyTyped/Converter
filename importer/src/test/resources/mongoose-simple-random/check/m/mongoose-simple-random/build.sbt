organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-83e39e"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-68616d",
  "org.scalablytyped" %%% "node" % "0.0-unknown-ee3d7a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-650c54")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        