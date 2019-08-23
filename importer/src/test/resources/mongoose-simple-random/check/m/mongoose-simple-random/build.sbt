organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-d438f0"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-ec21a2",
  "org.scalablytyped" %%% "node" % "0.0-unknown-86ce94",
  "org.scalablytyped" %%% "std" % "0.0-unknown-0c88c3")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        