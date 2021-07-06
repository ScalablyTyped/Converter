organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-1fe16c"
scalaVersion := "3.0.1-RC2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-cf0aae",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-3dec8c",
  "org.scalablytyped" %%% "std" % "0.0-unknown-b7868b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
