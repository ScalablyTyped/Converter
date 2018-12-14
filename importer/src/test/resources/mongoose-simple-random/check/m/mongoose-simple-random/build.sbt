organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-34e116"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-a2e620",
  "org.scalablytyped" %%% "node" % "0.0-unknown-0deac5",
  "org.scalablytyped" %%% "std" % "0.0-unknown-032a31")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        