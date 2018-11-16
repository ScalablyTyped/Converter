organization := "com.scalablytyped"
name := "react-icons"
version := "2.2-827283"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.scalablytyped" %%% "react" % "0.0-unknown-2b178b",
  "com.scalablytyped" %%% "react-icon-base" % "2.1-65cee7",
  "com.scalablytyped" %%% "std" % "0.0-unknown-ad6ddd",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        