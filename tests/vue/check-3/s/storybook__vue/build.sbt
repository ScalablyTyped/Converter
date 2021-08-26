organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-323aea"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-f2e76f",
  "org.scalablytyped" %%% "vue" % "2.5.13-442a0f",
  "org.scalablytyped" %%% "webpack-env" % "1.13-143818")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
