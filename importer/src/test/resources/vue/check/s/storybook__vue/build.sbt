organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-e7313f"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "node" % "0.0-unknown-1dbf0a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-470dfe",
  "org.scalablytyped" %%% "vue" % "2.5.13-8a870a",
  "org.scalablytyped" %%% "webpack-env" % "1.13-8db096")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        