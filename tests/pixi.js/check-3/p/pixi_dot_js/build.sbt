organization := "org.scalablytyped"
name := "pixi_dot_js"
version := "0.0-unknown-9a9a52"
scalaVersion := "3.2.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "eventemitter3" % "0.0-unknown-9cb2e3",
  "org.scalablytyped" %%% "pixi__utils" % "0.0-unknown-29f9ac")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
