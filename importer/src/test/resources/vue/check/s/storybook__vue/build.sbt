organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-80e11e"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-b6b5ea",
  "org.scalablytyped" %%% "vue" % "2.5.13-87b82e",
  "org.scalablytyped" %%% "webpack-env" % "1.13-fafb5f")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        