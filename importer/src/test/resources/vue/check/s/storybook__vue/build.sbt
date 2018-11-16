organization := "com.scalablytyped"
name := "storybook__vue"
version := "3.3-d86c30"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "node" % "0.0-unknown-62c8e8",
  "com.scalablytyped" %%% "std" % "0.0-unknown-f30401",
  "com.scalablytyped" %%% "vue" % "2.5.13-4439c8",
  "com.scalablytyped" %%% "webpack-env" % "1.13-5d8e1c",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        