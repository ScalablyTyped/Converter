organization := "org.scalablytyped"
name := "react-contextmenu"
version := "2.13.0-365ba1"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.4.2",
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "16.9.2-aa5bd9",
  "org.scalablytyped" %%% "std" % "0.0-unknown-5ead3b")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        