organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-87dd5f"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-776d54",
  "org.scalablytyped" %%% "vue" % "2.5.13-ed255e",
  "org.scalablytyped" %%% "webpack-env" % "1.13-dc8edb")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
