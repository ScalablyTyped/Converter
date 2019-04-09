organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-3a97ce"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-4565d2",
  "org.scalablytyped" %%% "node" % "0.0-unknown-eab046",
  "org.scalablytyped" %%% "std" % "0.0-unknown-bd683c")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        