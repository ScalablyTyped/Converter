organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-11a5d1"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-2a1da2",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-b34b2a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-f2d036")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
