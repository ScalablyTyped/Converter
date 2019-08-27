organization := "org.scalablytyped"
name := "numjs"
version := "0.0-unknown-5d655d"
scalaVersion := "2.12.10"
enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "com.olvind" %%% "scalablytyped-runtime" % "2.2.0-M1",
  "org.scalablytyped" %%% "ndarray" % "0.0-unknown-cb856d",
  "org.scalablytyped" %%% "std" % "0.0-unknown-1256bf")
publishArtifact in packageDoc := false
scalacOptions ++= List("-P:scalajs:sjsDefinedByDefault", "-g:notailcalls")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "ScalablyTyped"
resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
        