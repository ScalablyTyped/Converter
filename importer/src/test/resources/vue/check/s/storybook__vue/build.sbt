organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-3daa7a"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "node" % "0.0-unknown-0d2e2c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-f91e6a",
  "org.scalablytyped" %%% "vue" % "2.5.13-e557d0",
  "org.scalablytyped" %%% "webpack-env" % "1.13-232ae8")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        