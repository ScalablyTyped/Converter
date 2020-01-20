package org.scalablytyped.converter.internal
package importer

import java.time.LocalDateTime

import org.scalablytyped.converter.internal.importer.build.Versions
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
    enableScalaJsDefined: Boolean,
    /* only overwrite changed files to play better with tooling like intellij */
    softWrites:     Boolean,
    debugMode:      Boolean,
    wantedLibNames: Set[TsIdentLibrary],
    versions:       Versions,
    flavours:       List[Flavour],
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
        val flavours = List(
          if (flags.contains("-flavourPlain")) Some(new Flavour.Plain) else None,
          if (flags.contains("-flavourSlinky") || flags.contains("-reactSlinky")) Some(new Flavour.Slinky(companions))
          else None,
          if (flags.contains("-flavourJapgolly") || flags.contains("-reactJapgolly"))
            Some(new Flavour.Japgolly(companions))
          else None,
          if (flags.contains("-flavourNormal") || flags.contains("-reactFacade")) Some(new Flavour.Normal(companions))
          else None,
        ).flatten match {
          case Nil   => List(new Flavour.Normal(companions))
          case other => other
        }

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
            enableScalaJsDefined = flags contains "-enableScalaJsDefined",
            softWrites           = flags contains "-softWrites",
            debugMode            = wantedLibNames.nonEmpty || (flags contains "-debugMode"),
            wantedLibNames       = wantedLibNames,
            versions =
              if (flags contains "-nextVersions") Versions.next
              else Versions.current,
            flavours = flavours,
          ),
        )
    }
}
