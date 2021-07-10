organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-12ae6e"
scalaVersion := "3.0.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-8750b0",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-729a23",
  "org.scalablytyped" %%% "std" % "0.0-unknown-6a8809")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
