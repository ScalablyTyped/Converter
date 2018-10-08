organization := "com.olvind.scalablytyped"
name := "angular-agility"
version := "0.0-unknown-e9f851"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "angular" % "1.6-a840e4",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-4ebc26",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        