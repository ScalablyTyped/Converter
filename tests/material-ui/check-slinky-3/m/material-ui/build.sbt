organization := "org.scalablytyped"
name := "material-ui"
version := "0.0-unknown-7ff96b"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.7.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-999cf3",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5d0c3e")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
