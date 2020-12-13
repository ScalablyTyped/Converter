organization := "org.scalablytyped"
name := "storybook__vue"
version := "3.3-45d7f2"
scalaVersion := "2.13.3"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.3.0",
  "org.scalablytyped" %%% "std" % "0.0-unknown-9327fa",
  "org.scalablytyped" %%% "vue" % "2.5.13-15050d",
  "org.scalablytyped" %%% "webpack-env" % "1.13-b555e7")
publishArtifact in packageDoc := false
scalacOptions ++= List("-encoding", "utf-8", "-feature", "-g:notailcalls", "-language:implicitConversions", "-language:higherKinds", "-language:existentials")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
