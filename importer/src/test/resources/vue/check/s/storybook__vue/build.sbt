organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-b0b276"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-c0ce86",
  "org.scalablytyped" %%% "vue" % "2.5.13-6e4567",
  "org.scalablytyped" %%% "webpack-env" % "1.13-a19be9")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        