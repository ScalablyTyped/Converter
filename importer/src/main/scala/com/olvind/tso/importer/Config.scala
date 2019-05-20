package com.olvind.tso
package importer

import java.time.LocalDateTime

import ammonite.ops.home
import com.olvind.tso.importer.build.Versions
import com.olvind.tso.scalajs.Name

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
    wantedLibNames:   Set[String],
) {

  def debugMode = wantedLibNames.nonEmpty

  // change in source code for now, lazy...
  val outputPkg         = Name("typings")
  val projectName       = "ScalablyTyped"
  val organization      = "org.scalablytyped"
  val versions          = Versions.`scala 2.12 with scala.js 0.6`
  val cacheFolder       = home / 'tmp / "tso-cache"
  val publishFolder     = home / ".ivy2" / "local"
  val ScalablyTypedRepo = "https://github.com/oyvindberg/ScalablyTyped.git"
  val parallelScalas    = Runtime.getRuntime.availableProcessors / 2
  val parallelLibraries = 100
}

object Config {
  def unapply(args: Array[String]): Some[Config] =
    args partition (_ startsWith "-") match {
      case (flags, rest) =>
        val publish: Option[PublishConfig] = if (flags contains "-publish") {
          val values: Map[String, String] =
            files
              .content(InFile(home / ".bintray" / ".credentials"))
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
            wantedLibNames   = rest.to[Set],
          ),
        )
    }
}
