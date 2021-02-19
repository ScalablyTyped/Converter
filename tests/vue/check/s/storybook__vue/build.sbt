organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-a94f8f"
scalaVersion := "3.0.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-321261",
  "org.scalablytyped" %%% "vue" % "2.5.13-5d0336",
  "org.scalablytyped" %%% "webpack-env" % "1.13-7e0829")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
