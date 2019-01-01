organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-f52a09"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "node" % "0.0-unknown-749f3c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-116b90",
  "org.scalablytyped" %%% "vue" % "2.5.13-fcd350",
  "org.scalablytyped" %%% "webpack-env" % "1.13-365dff")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        