organization := "com.olvind.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-ca9a6f"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "mongoose" % "0.0-unknown-f4a199",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-90a31f",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-221ae8",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        