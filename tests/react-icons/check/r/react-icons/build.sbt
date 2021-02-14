organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-88f324"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.3.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-191d0f",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-b6667a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-225870")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
