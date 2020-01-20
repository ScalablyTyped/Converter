organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-7887bc"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5a7556",
  "org.scalablytyped" %%% "vue" % "2.5.13-e063f3",
  "org.scalablytyped" %%% "webpack-env" % "1.13-70f207")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        