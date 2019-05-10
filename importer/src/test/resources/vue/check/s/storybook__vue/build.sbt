organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-ef828d"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-b6b5ea",
  "org.scalablytyped" %%% "vue" % "2.5.13-9ddd50",
  "org.scalablytyped" %%% "webpack-env" % "1.13-0a06e8")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        