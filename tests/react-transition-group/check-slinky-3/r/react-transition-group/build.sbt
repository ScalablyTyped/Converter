organization := "org.scalablytyped"
name := "react-transition-group"
version := "2.0-3da1e3"
scalaVersion := "3.3.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.7.5",
  "org.scalablytyped" %%% "react" % "0.0-unknown-4da789",
  "org.scalablytyped" %%% "std" % "0.0-unknown-081e09")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
