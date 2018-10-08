organization := "com.olvind.scalablytyped"
name := "material-ui"
version := "0.0-unknown-8b3bcd"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-2df001",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-5149f5",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        