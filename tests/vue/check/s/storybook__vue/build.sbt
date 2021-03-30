organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-a669fa"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-8f6601",
  "org.scalablytyped" %%% "vue" % "2.5.13-eefff1",
  "org.scalablytyped" %%% "webpack-env" % "1.13-555510")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
