organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-68450c"
scalaVersion := "2.12.7"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "1.0.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "org.scalablytyped" %%% "react" % "0.0-unknown-727aad",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-ef4088",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a8de11")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        