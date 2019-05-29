organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-0590cd"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-b07440",
  "org.scalablytyped" %%% "mime" % "2.0-1b3762",
  "org.scalablytyped" %%% "std" % "0.0-unknown-b2dca5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        