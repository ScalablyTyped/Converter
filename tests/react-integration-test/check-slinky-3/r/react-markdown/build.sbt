organization := "org.scalablytyped"
name := "react-markdown"
version := "0.0-unknown-a201a7"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "16.9.2-7a1e0b",
  "org.scalablytyped" %%% "std" % "0.0-unknown-d411c4",
  ("me.shadaj" %%% "slinky-web" % "0.6.8+1-b1dd3f4c").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
