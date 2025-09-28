organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-5e6f7f"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-7d7dd0",
  "org.scalablytyped" %%% "vue" % "2.5.13-1e5148",
  "org.scalablytyped" %%% "webpack-env" % "1.13-3fafb9")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
