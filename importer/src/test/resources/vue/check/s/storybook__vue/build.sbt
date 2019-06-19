organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-c5ddcb"
scalaVersion := "2.12.8"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.0.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-9467c5",
  "org.scalablytyped" %%% "vue" % "2.5.13-e71eb8",
  "org.scalablytyped" %%% "webpack-env" % "1.13-0df6ea")
publishArtifact in packageDoc := false
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        