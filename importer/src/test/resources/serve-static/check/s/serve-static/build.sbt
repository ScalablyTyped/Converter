organization := "org.scalablytyped"
name := "serve-static"
version := "0.0-unknown-7113a8"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "express-serve-static-core" % "0.0-unknown-885a19",
  "org.scalablytyped" %%% "mime" % "2.0-a60329",
  "org.scalablytyped" %%% "std" % "0.0-unknown-78e68c")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        