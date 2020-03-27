organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-060853"
scalaVersion := "2.13.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-f74982",
  "org.scalablytyped" %%% "node" % "0.0-unknown-b50342",
  "org.scalablytyped" %%% "std" % "0.0-unknown-9cad4f")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-g:notailcalls", "-P:scalajs:sjsDefinedByDefault")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
