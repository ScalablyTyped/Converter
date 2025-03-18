organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-b74b64"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-8e69b2",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-44dd0d",
  "org.scalablytyped" %%% "std" % "0.0-unknown-351a30")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
