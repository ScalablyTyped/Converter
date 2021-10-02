organization := "org.scalablytyped"
name := "react-markdown"
version := "0.0-unknown-e7e6e4"
scalaVersion := "3.0.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "16.9.2-48c84e",
  "org.scalablytyped" %%% "std" % "0.0-unknown-70e0fa",
  ("com.github.japgolly.scalajs-react" %%% "core" % "1.7.5").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
