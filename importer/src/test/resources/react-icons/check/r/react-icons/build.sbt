organization := "com.scalablytyped"
name := "react-icons"
version := "2.2-05563d"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "react" % "0.0-unknown-e6eafe",
  "com.scalablytyped" %%% "react-icon-base" % "2.1-b1d18a",
  "com.scalablytyped" %%% "std" % "0.0-unknown-23502f",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        