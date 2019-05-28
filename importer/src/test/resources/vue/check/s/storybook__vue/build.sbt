organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-e25809"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-862a66",
  "org.scalablytyped" %%% "vue" % "2.5.13-7aa211",
  "org.scalablytyped" %%% "webpack-env" % "1.13-5de669")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        