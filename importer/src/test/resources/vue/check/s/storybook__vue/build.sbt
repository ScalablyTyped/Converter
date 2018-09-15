organization := "com.olvind.scalablytyped"
name := "storybook__vue"
version := "3.3-3bce93"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-c28e3f",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-3632e0",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-d4c0e1",
  "com.olvind.scalablytyped" %%% "webpack-env" % "1.13-382882",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        