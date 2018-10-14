organization := "com.olvind.scalablytyped"
name := "storybook__vue"
version := "3.3-2869ac"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-7748b7",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-0ccee1",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-d60248",
  "com.olvind.scalablytyped" %%% "webpack-env" % "1.13-cc4e64",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        