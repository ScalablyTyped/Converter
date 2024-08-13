organization := "org.scalablytyped"
name := "stardust-ui__react-component-ref"
version := "0.38.0-c67f7b"
scalaVersion := "3.3.1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "2.1.1",
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "16.9.2-d4e96d",
  "org.scalablytyped" %%% "react-bootstrap" % "0.32-edeae4",
  "org.scalablytyped" %%% "std" % "0.0-unknown-4752d4")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
