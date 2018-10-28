organization := "com.olvind.scalablytyped"
name := "storybook__vue"
version := "3.3-35a70a"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "node" % "0.0-unknown-6e1964",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-cd38ff",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-14fa1d",
  "com.olvind.scalablytyped" %%% "webpack-env" % "1.13-932454",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        