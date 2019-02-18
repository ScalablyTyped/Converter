organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-b68c6f"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "react" % "0.0-unknown-d30693",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-70a9f9",
  "org.scalablytyped" %%% "std" % "0.0-unknown-f5ca6c")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        