organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-547bdf"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "node" % "0.0-unknown-835fcd",
  "org.scalablytyped" %%% "std" % "0.0-unknown-93ac75",
  "org.scalablytyped" %%% "vue" % "2.5.13-9e571e",
  "org.scalablytyped" %%% "webpack-env" % "1.13-aee59d")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        