organization := "org.scalablytyped"
name := "react-transition-group"
version := "2.0-ba4be7"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-d58e8d",
  "org.scalablytyped" %%% "std" % "0.0-unknown-dd3122",
  ("me.shadaj" %%% "slinky-web" % "0.6.8+1-b1dd3f4c").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
