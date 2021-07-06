organization := "org.scalablytyped"
name := "react-dropzone"
version := "10.1.10-13a1c2"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "16.9.2-7784a5",
  "org.scalablytyped" %%% "std" % "0.0-unknown-66db32",
  ("me.shadaj" %%% "slinky-web" % "0.6.7").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
