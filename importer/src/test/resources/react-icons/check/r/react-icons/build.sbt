organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-db1a71"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-ac6e8f",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-80d5ee",
  "org.scalablytyped" %%% "std" % "0.0-unknown-eedb09")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
