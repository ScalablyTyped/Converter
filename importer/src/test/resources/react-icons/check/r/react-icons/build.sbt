organization := "org.scalablytyped"
name := "react-icons"
version := "2.2-de1621"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.1.0",
  "org.scalablytyped" %%% "react" % "0.0-unknown-be709e",
  "org.scalablytyped" %%% "react-icon-base" % "2.1-fe2570",
  "org.scalablytyped" %%% "std" % "0.0-unknown-ccf809")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        