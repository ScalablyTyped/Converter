organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-1ab64d"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-98bacf",
  "org.scalablytyped" %%% "node" % "0.0-unknown-e2d417",
  "org.scalablytyped" %%% "std" % "0.0-unknown-2374ff")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        