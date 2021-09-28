organization := "org.scalablytyped"
name := "react-select"
version := "0.0-unknown-c18962"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "16.9.2-dc12ae",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5f2ac8",
  ("me.shadaj" %%% "slinky-web" % "0.6.7").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
