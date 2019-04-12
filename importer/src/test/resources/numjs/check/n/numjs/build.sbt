organization := "org.scalablytyped"
name := "numjs"
version := "0.0-unknown-53b9d0"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "ndarray" % "0.0-unknown-b20ee7",
  "org.scalablytyped" %%% "std" % "0.0-unknown-20bbb4")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
        