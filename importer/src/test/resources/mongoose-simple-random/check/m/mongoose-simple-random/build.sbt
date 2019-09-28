organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-70c0fa"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-434975",
  "org.scalablytyped" %%% "node" % "0.0-unknown-971714",
  "org.scalablytyped" %%% "std" % "0.0-unknown-e8fc1f")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        