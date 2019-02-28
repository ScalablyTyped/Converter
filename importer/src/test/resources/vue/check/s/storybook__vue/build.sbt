organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-92f717"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "node" % "0.0-unknown-339f8b",
  "org.scalablytyped" %%% "std" % "0.0-unknown-b3705b",
  "org.scalablytyped" %%% "vue" % "2.5.13-20c057",
  "org.scalablytyped" %%% "webpack-env" % "1.13-12e344")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        