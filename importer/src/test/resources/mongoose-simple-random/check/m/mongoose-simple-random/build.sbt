organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-db23cd"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-375e0a",
  "org.scalablytyped" %%% "node" % "0.0-unknown-f13736",
  "org.scalablytyped" %%% "std" % "0.0-unknown-f6c940")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        