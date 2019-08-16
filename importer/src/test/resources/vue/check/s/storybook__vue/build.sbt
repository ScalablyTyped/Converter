organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-a4ae05"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-c0ce86",
  "org.scalablytyped" %%% "vue" % "2.5.13-9c54ec",
  "org.scalablytyped" %%% "webpack-env" % "1.13-d7f579")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        