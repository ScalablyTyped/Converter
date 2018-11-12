organization := "com.scalablytyped"
name := "storybook__vue"
version := "3.3-467370"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "node" % "0.0-unknown-82274e",
  "com.scalablytyped" %%% "std" % "0.0-unknown-869aa7",
  "com.scalablytyped" %%% "vue" % "2.5.13-42db03",
  "com.scalablytyped" %%% "webpack-env" % "1.13-c1b869",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        