organization := "com.olvind.scalablytyped"
name := "vue-scrollto"
version := "2.7-838dd1"
scalaVersion := "2.12.6"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "runtime" % "1.0.0-M1",
  "com.olvind.scalablytyped" %%% "std" % "0.0-unknown-b43f41",
  "com.olvind.scalablytyped" %%% "vue" % "2.5.13-71f452",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
        