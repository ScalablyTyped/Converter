organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-d0d94a"
scalaVersion := "3.0.1-RC2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-bf0d05",
  "org.scalablytyped" %%% "vue" % "2.5.13-eee392",
  "org.scalablytyped" %%% "webpack-env" % "1.13-45063b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
