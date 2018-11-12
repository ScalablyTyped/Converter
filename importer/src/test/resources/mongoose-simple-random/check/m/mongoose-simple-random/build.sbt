organization := "com.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-cf721a"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "mongoose" % "0.0-unknown-9e1ce3",
  "com.scalablytyped" %%% "node" % "0.0-unknown-0d4baa",
  "com.scalablytyped" %%% "std" % "0.0-unknown-c63178",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        