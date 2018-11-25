organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-40d2a7"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "react" % "0.0-unknown-685aee",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-78519a",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5f5ff4")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        