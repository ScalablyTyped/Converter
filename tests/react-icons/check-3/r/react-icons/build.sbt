organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-2042a1"
scalaVersion := "3.2.2-RC1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-96a7aa",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-9cf065",
  "org.scalablytyped" %%% "std" % "0.0-unknown-55448b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
