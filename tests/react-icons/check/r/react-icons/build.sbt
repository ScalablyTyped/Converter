organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-449097"
scalaVersion := "3.0.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-0d6aaf",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-88234b",
  "org.scalablytyped" %%% "std" % "0.0-unknown-bf4aa2")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
