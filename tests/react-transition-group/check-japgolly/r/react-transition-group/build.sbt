organization := "org.scalablytyped"
name := "react-transition-group"
version := "2.0-50293a"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-5070d5",
  "org.scalablytyped" %%% "std" % "0.0-unknown-7647d3",
  ("com.github.japgolly.scalajs-react" %%% "core" % "1.7.5").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
