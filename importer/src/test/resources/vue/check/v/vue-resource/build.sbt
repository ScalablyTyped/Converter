organization := "com.olvind.scalablytyped"
name := "vue-resource"
version := "0.9.3-633474"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-1ff8aa",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-737aa4",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        