organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-fb6808"
scalaVersion := "3.0.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a27207",
  "org.scalablytyped" %%% "vue" % "2.5.13-504547",
  "org.scalablytyped" %%% "webpack-env" % "1.13-265de0")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
