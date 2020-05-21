organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-df214b"
scalaVersion := "2.13.2"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-748ce9",
  "org.scalablytyped" %%% "vue" % "2.5.13-6f30a5",
  "org.scalablytyped" %%% "webpack-env" % "1.13-458496")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
