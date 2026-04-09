organization := "org.scalablytyped"
name := "stardust-ui__react-component-event-listener"
version := "0.38.0-b42f36"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.7.5",
  "org.scalablytyped" %%% "react" % "16.9.2-534a16",
  "org.scalablytyped" %%% "std" % "0.0-unknown-12b071")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
