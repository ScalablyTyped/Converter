organization := "org.scalablytyped"
name := "stardust-ui__react-component-ref"
version := "0.38.0-e9d92e"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "me.shadaj" %%% "slinky-web" % "0.6.8+10-ca6379d6",
  "org.scalablytyped" %%% "react" % "16.9.2-81d922",
  "org.scalablytyped" %%% "std" % "0.0-unknown-566357")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
