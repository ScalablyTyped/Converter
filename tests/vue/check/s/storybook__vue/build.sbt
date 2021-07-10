organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-b2f832"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-b9c231",
  "org.scalablytyped" %%% "vue" % "2.5.13-c2fcf3",
  "org.scalablytyped" %%% "webpack-env" % "1.13-b65c7d")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
