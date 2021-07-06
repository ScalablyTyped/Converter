organization := "org.scalablytyped"
name := "electron"
version := "2.0.0-ca7ead"
scalaVersion := "3.0.1-RC2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "node" % "0.0-unknown-410ba2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-4b4c49")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
