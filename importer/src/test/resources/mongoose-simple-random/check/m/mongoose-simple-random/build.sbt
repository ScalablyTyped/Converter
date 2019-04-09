organization := "org.scalablytyped"
name := "mongoose-simple-random"
version := "0.4-d24c43"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "mongoose" % "0.0-unknown-9ce28b",
  "org.scalablytyped" %%% "node" % "0.0-unknown-364d4e",
  "org.scalablytyped" %%% "std" % "0.0-unknown-65c30f")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        