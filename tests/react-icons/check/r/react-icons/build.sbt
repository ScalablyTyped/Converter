organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-2b7f02"
scalaVersion := "2.13.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-54da8a",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-1116ce",
  "org.scalablytyped" %%% "std" % "0.0-unknown-ee18dc")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
