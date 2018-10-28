organization := "com.olvind.scalablytyped"
name := "react-icons"
version := "2.2-d1be22"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "react" % "0.0-unknown-499b3d",
  "com.olvind.scalablytyped" %%% "react-icon-base" % "2.1-fbecf9",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-98c990",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        