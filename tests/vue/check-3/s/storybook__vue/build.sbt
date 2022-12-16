organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-bec0f1"
scalaVersion := "3.2.2-RC1"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "std" % "0.0-unknown-c173ae",
  "org.scalablytyped" %%% "vue" % "2.5.13-fe44a6",
  "org.scalablytyped" %%% "webpack-env" % "1.13-ca4503")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
