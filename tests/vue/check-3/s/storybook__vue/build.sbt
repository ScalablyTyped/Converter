organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-58d558"
scalaVersion := "3.2.2-RC1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-623d12",
  "org.scalablytyped" %%% "vue" % "2.5.13-007c16",
  "org.scalablytyped" %%% "webpack-env" % "1.13-fc7ca1")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
