organization := "org.scalablytyped"
name := "material-ui"
version := "0.0-unknown-fbcc25"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.0",
  "me.shadaj" %%% "slinky-web" % "0.6.6",
  "org.scalablytyped" %%% "react" % "0.0-unknown-cb1176",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a34285")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
