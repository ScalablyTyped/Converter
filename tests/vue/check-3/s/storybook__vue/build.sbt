organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-50d939"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-55ca38",
  "org.scalablytyped" %%% "vue" % "2.5.13-854b14",
  "org.scalablytyped" %%% "webpack-env" % "1.13-9507ff")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
