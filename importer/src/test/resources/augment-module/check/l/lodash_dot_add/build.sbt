organization := "com.olvind.scalablytyped"
name := "lodash_dot_add"
version := "3.7-0f8732"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "lodash" % "4.14-6669e5",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-5ac66d",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        