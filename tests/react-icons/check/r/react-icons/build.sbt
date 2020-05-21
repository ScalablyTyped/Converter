organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-62e047"
scalaVersion := "2.13.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-f154a9",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-eb9f49",
  "org.scalablytyped" %%% "std" % "0.0-unknown-fea05b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
