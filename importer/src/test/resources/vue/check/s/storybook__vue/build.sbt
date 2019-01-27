organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-e2e982"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "node" % "0.0-unknown-59d174",
  "org.scalablytyped" %%% "std" % "0.0-unknown-3a694c",
  "org.scalablytyped" %%% "vue" % "2.5.13-1a53a8",
  "org.scalablytyped" %%% "webpack-env" % "1.13-f394c7")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        