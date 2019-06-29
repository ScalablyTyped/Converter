organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-5d1b0c"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-d3b607",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-a9efad",
  "org.scalablytyped" %%% "std" % "0.0-unknown-bdb993")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        