organization := "com.olvind.scalablytyped"
name := "storybook__vue"
version := "3.3-ef4959"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-da3634",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-fedb3f",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-7fc6e5",
  "com.olvind.scalablytyped" %%% "webpack-env" % "1.13-9fcf87",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        