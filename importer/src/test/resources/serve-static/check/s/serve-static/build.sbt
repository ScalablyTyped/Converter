organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-c94426"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-1ba00b",
  "org.scalablytyped" %%% "mime" % "2.0-cfe2bb",
  "org.scalablytyped" %%% "std" % "0.0-unknown-60d4be")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        