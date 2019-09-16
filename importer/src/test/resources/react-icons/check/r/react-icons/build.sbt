organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-d76c75"
scalaVersion := "2.12.9"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "me.shadaj" %%% "slinky-web" % "0.6.2",
  "org.scalablytyped" %%% "react" % "0.0-unknown-57a471",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-9a4cd7",
  "org.scalablytyped" %%% "std" % "0.0-unknown-0d17d2")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        