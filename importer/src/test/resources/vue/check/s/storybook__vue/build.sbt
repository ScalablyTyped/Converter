organization := "com.olvind.scalablytyped"
name := "storybook__vue"
version := "3.3-1a53d8"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-3f599b",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-1ff8aa",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-737aa4",
  "com.olvind.scalablytyped" %%% "webpack-env" % "1.13-6ecb96",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        