organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-9f5c1a"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-39a5f5",
  "org.scalablytyped" %%% "vue" % "2.5.13-a5a3d4",
  "org.scalablytyped" %%% "webpack-env" % "1.13-5d8493")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        