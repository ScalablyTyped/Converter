organization := "com.scalablytyped"
name := "storybook__vue"
version := "3.3-dd56f3"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "node" % "0.0-unknown-13d322",
  "com.scalablytyped" %%% "std" % "0.0-unknown-9c6284",
  "com.scalablytyped" %%% "vue" % "2.5.13-0436e0",
  "com.scalablytyped" %%% "webpack-env" % "1.13-802ab3",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        