organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-74f779"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.2.0-M1",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-93f2ba",
  "org.scalablytyped" %%% "node" % "0.0-unknown-57e05d",
  "org.scalablytyped" %%% "std" % "0.0-unknown-44c124")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        