organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-0e65b6"
scalaVersion := "3.1.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-2447ad",
  "org.scalablytyped" %%% "vue" % "2.5.13-41a2ed",
  "org.scalablytyped" %%% "webpack-env" % "1.13-e9cf3b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
