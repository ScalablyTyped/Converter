organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-eb42ca"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-6eb03b",
  "org.scalablytyped" %%% "vue" % "2.5.13-ee2f05",
  "org.scalablytyped" %%% "webpack-env" % "1.13-872fb4")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
