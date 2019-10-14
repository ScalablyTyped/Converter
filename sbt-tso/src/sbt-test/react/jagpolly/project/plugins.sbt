{
  val pluginVersion = System.getProperty("plugin.version")
  if (pluginVersion == null) {
    addSbtPlugin("com.olvind" % """sbt-tso""" % "0.1-snapshot")
  } else {
    addSbtPlugin("com.olvind" % """sbt-tso""" % pluginVersion)
  }
}
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.28")
addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.15.0-0.6")
//
//def removeSbtPlugin(dependency: ModuleID) =
//  libraryDependencies -= {
//    val sbtV = (sbtBinaryVersion in pluginCrossBuild).value
//    val scalaV = (scalaBinaryVersion in update).value
//    Defaults.sbtPluginExtra(dependency, sbtV, scalaV)
//  }
//
//
//removeSbtPlugin("com.eed3si9n" % "sbt-dirty-money" % "0.2.0")
//removeSbtPlugin("org.jetbrains" % "sbt-structure-extractor" % "2018.2")
//removeSbtPlugin("org.jetbrains" % "sbt-idea-shell" % "2018.3")
//removeSbtPlugin("io.get-coursier" % "sbt-coursier" % "2.0.0-RC3-2")
//removeSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.3")
//removeSbtPlugin("de.heikoseeberger" % "sbt-fresh" % "5.2.0")
//removeSbtPlugin("com.scalapenos" % "sbt-prompt" % "1.0.2")
//removeSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")
//removeSbtPlugin("com.oradian.sbt" % "sbt-sh" % "0.3.0")
//removeSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.4.2")
//removeSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
//removeSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.15")
//removeSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.5.1")
//removeSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.0.4")
//
////def dep(
////         dependency: ModuleID
////       ) = {
////  val sbtV = (sbtBinaryVersion in pluginCrossBuild).value
////  val scalaV = (scalaBinaryVersion in update).value
////  Defaults.sbtPluginExtra(dependency, sbtV, scalaV)
////}
////
////
////def removeSbtPlugin(dependency: ModuleID) =
////  excludeDependencies += dep(dependency)
////
////libraryDependencies --= Seq(
////  dep("com.eed3si9n" % "sbt-dirty-money" % "0.2.0"),
////  dep("org.jetbrains" % "sbt-structure-extractor" % "2018.2"),
////  dep("org.jetbrains" % "sbt-idea-shell" % "2018.3"),
////  dep("io.get-coursier" % "sbt-coursier" % "2.0.0-RC3-2"),
////  dep("org.duhemm" % "sbt-errors-summary" % "0.6.3"),
////  dep("de.heikoseeberger" % "sbt-fresh" % "5.2.0"),
////  dep("com.scalapenos" % "sbt-prompt" % "1.0.2"),
////  dep("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0"),
////  dep("com.oradian.sbt" % "sbt-sh" % "0.3.0"),
////  dep("com.timushev.sbt" % "sbt-updates" % "0.4.2"),
////  dep("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4"),
////  dep("com.lucidchart" % "sbt-scalafmt" % "1.15"),
////  dep("com.geirsson" % "sbt-scalafmt" % "1.5.1"),
////  dep("org.scalameta" % "sbt-scalafmt" % "2.0.4"))
