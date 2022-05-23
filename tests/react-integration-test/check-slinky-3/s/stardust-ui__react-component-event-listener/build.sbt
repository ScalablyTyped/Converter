organization := "org.scalablytyped"
name := "stardust-ui__react-component-event-listener"
version := "0.38.0-ca7599"
scalaVersion := "3.1.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.7.0",
  "org.scalablytyped" %%% "react" % "16.9.2-6958af",
  "org.scalablytyped" %%% "std" % "0.0-unknown-67e249")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
