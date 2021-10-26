organization := "org.scalablytyped"
name := "stardust-ui__react-component-event-listener"
version := "0.38.0-28d87a"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "16.9.2-9b76f4",
  "org.scalablytyped" %%% "std" % "0.0-unknown-7f8a22",
  ("me.shadaj" %%% "slinky-web" % "0.6.8+1-b1dd3f4c").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
