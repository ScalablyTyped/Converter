organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-5d0a84"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-50f894",
  "org.scalablytyped" %%% "vue" % "2.5.13-572b22",
  "org.scalablytyped" %%% "webpack-env" % "1.13-9b5965")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
