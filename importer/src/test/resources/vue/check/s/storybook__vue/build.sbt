organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-87768c"
scalaVersion := "2.12.9"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-a1dd39",
  "org.scalablytyped" %%% "vue" % "2.5.13-963cf8",
  "org.scalablytyped" %%% "webpack-env" % "1.13-5c73ab")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        