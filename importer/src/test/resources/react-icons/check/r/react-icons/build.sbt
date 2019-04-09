organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-17b40b"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-f2005d",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-07c56b",
  "org.scalablytyped" %%% "std" % "0.0-unknown-e8f6a4")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        