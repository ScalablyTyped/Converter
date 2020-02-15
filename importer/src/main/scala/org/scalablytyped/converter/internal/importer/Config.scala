package org.scalablytyped.converter.internal
package importer

import java.time.LocalDateTime

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.importer.build.Versions
import org.scalablytyped.converter.internal.scalajs.Name
import org.scalablytyped.converter.internal.scalajs.flavours.Flavour
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

case class PublishConfig(
    username: String,
    password: String,
)
case class Config(
    runId:                String,
    publish:              Option[PublishConfig],
    offline:              Boolean,
    pedantic:             Boolean,
    sequential:           Boolean,
    forceCommit:          Boolean,
    conserveSpace:        Boolean,
    enableParseCache:     Boolean,
    dontCleanProject:     Boolean,
    enableScalaJsDefined: Selection[TsIdentLibrary],
    /* only overwrite changed files to play better with tooling like intellij */
    softWrites:     Boolean,
    debugMode:      Boolean,
    wantedLibNames: Set[TsIdentLibrary],
    versions:       Versions,
    flavour:        Flavour,
    projectName:    String,
    repo:           String,
    organization:   String,
) {
  // change in source code for now, lazy...
  val parallelLibraries = 100
  val parallelScalas    = 4
}

object Config {
  val cacheFolder: os.Path = os.home / 'tmp / "tso-cache"

  def unapply(args: Array[String]): Some[Config] =
    args partition (_ startsWith "-") match {
      case (flags, rest) =>
        val publish: Option[PublishConfig] = if (flags contains "-publish") {
          val values: Map[String, String] =
            files
              .content(InFile(os.home / ".bintray" / ".credentials"))
              .split("\n")
              .map(_.split("=").map(_.trim).filter(_.nonEmpty).toList)
              .collect { case List(k, v) => (k, v) }
              .toMap

          Some(PublishConfig(values("user"), values("password")))
        } else None

        val wantedLibNames: Set[TsIdentLibrary] = (if (flags contains "-demoSet") Libraries.DemoSet else Set()) ++ rest
          .map(TsIdentLibrary.apply)

        val companions = !(flags contains "-skipCompanions")

        val (flavour: Flavour, projectName: String, repo: String, organization: String) =
          if (flags.contains("-flavourSlinky"))
            (
              Flavour.Slinky(companions, Name("typingsSlinky")),
              "SlinkyTyped",
              "https://github.com/ScalablyTyped/SlinkyTypes.git",
              "org.scalablytyped.slinky",
            )
          else if (flags.contains("-flavourSlinkyNative"))
            (
              Flavour.SlinkyNative(companions, Name("typingsSlinky")),
              "SlinkyNativeTyped",
              "https://github.com/ScalablyTyped/SlinkyNativeTypes.git",
              "org.scalablytyped.slinkynative",
            )
          else if (flags.contains("-flavourJapgolly"))
            (
              Flavour.Japgolly(companions, Name("typingsJapgolly")),
              "ScalajsReactTyped",
              "https://github.com/ScalablyTyped/ScalajsReactTyped.git",
              "org.scalablytyped.japgolly",
            )
          else
            (
              Flavour.Normal(
                shouldGenerateCompanions = companions,
                shouldGenerateComponents = true,
                shouldUseScalaJsDomTypes = flags contains "-useScalaJsDomTypes",
                outputPkg                = Name.typings,
              ),
              "ScalablyTyped",
              "https://github.com/oyvindberg/ScalablyTyped.git",
              "org.scalablytyped",
            )

        val enableScalaJsDefined: Selection[TsIdentLibrary] =
          if (flags contains "-enableScalaJsDefined")
            Selection.AllExcept(Libraries.Slow.to[Seq]: _*)
          else Selection.None

        Some(
          Config(
            runId                = constants.DateTimePattern format LocalDateTime.now,
            publish              = publish,
            offline              = flags contains "-offline",
            pedantic             = flags contains "-pedantic",
            sequential           = flags contains "-sequential",
            forceCommit          = flags contains "-forceCommit",
            conserveSpace        = flags contains "-conserveSpace",
            enableParseCache     = flags contains "-enableParseCache",
            dontCleanProject     = flags contains "-dontCleanProject",
            enableScalaJsDefined = enableScalaJsDefined,
            softWrites           = flags contains "-softWrites",
            debugMode            = wantedLibNames.nonEmpty || (flags contains "-debugMode"),
            wantedLibNames       = wantedLibNames,
            versions             = if (flags contains "-nextVersions") Versions.next else Versions.current,
            flavour              = flavour,
            projectName          = projectName,
            repo                 = repo,
            organization         = organization,
          ),
        )
    }
}
