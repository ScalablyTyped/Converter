organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-7fa924"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-5546e3",
  "org.scalablytyped" %%% "node" % "0.0-unknown-6bddef",
  "org.scalablytyped" %%% "std" % "0.0-unknown-ae2b72")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        