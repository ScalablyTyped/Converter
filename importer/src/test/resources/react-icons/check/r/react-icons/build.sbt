organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-f545ef"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-292d92",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-948e77",
  "org.scalablytyped" %%% "std" % "0.0-unknown-bdb993")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        