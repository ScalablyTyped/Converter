organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-5265bf"
scalaVersion := "2.13.0"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-08973b",
  "org.scalablytyped" %%% "vue" % "2.5.13-16d0cb",
  "org.scalablytyped" %%% "webpack-env" % "1.13-4c4776")
publishArtifact in packageDoc := false
scalacOptions ++= List("-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        