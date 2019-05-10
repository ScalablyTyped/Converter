organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-105b16"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-5265c0",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-2fa2fa",
  "org.scalablytyped" %%% "std" % "0.0-unknown-0f8ba7")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        