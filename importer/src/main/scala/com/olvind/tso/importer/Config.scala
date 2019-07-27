package com.olvind.tso
package importer

import java.time.LocalDateTime

import com.olvind.tso.importer.build.Versions

case class PublishConfig(
    username: String,
    password: String,
)
case class Config(
    runId:            String,
    publish:          Option[PublishConfig],
    offline:          Boolean,
    pedantic:         Boolean,
    sequential:       Boolean,
    forceCommit:      Boolean,
    conserveSpace:    Boolean,
    enableParseCache: Boolean,
    dontCleanProject: Boolean,
    /* only overwrite changed files to play better with tooling like intellij */
    softWrites:     Boolean,
    wantedLibNames: Set[String],
    versions:       Versions,
) {

  def debugMode = wantedLibNames.nonEmpty

  // change in source code for now, lazy...
  val projectName       = "ScalablyTyped"
  val organization      = "org.scalablytyped"
  val cacheFolder       = os.home / 'tmp / "tso-cache"
  val publishFolder     = os.home / ".ivy2" / "local"
  val ScalablyTypedRepo = "https://github.com/oyvindberg/ScalablyTyped.git"
  val parallelLibraries = 100
  val parallelScalas    = 4
}

object Config {
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

        Some(
          Config(
            runId            = constants.DateTimePattern format LocalDateTime.now,
            publish          = publish,
            offline          = flags contains "-offline",
            pedantic         = flags contains "-pedantic",
            sequential       = flags contains "-sequential",
            forceCommit      = flags contains "-forceCommit",
            conserveSpace    = flags contains "-conserveSpace",
            enableParseCache = flags contains "-enableParseCache",
            dontCleanProject = flags contains "-dontCleanProject",
            softWrites       = flags contains "-softWrites",
            wantedLibNames   = rest.to[Set],
            versions =
              if (flags contains "-nextVersions") Versions.`scala 2.13 with scala.js 1`
              else Versions.`scala 2.12 with scala.js 0.6`,
          ),
        )
    }
}
