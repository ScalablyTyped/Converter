organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-09c35e"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-dfe766",
  "org.scalablytyped" %%% "vue" % "2.5.13-f12957",
  "org.scalablytyped" %%% "webpack-env" % "1.13-07f0c0")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        