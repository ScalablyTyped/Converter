organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-68e97e"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.2.0-M1",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-0820b1",
  "org.scalablytyped" %%% "mime" % "2.0-a1ac82",
  "org.scalablytyped" %%% "std" % "0.0-unknown-1256bf")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        