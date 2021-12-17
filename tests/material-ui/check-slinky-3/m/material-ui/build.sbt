organization := "org.scalablytyped"
name := "material-ui"
version := "0.0-unknown-997d99"
scalaVersion := "3.1.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.4.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-20a641",
  "org.scalablytyped" %%% "std" % "0.0-unknown-23ab28",
  ("me.shadaj" %%% "slinky-web" % "0.6.8+1-b1dd3f4c").cross(CrossVersion.for3Use2_13))
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-no-indent", "-source:future")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
