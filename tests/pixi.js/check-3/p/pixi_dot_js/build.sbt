organization := "org.scalablytyped"
name := "pixi_dot_js"
version := "0.0-unknown-e874e6"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "eventemitter3" % "0.0-unknown-9c09cb",
  "org.scalablytyped" %%% "pixi__utils" % "0.0-unknown-74315b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
