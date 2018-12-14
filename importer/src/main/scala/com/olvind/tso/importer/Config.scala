package com.olvind.tso
package importer

import ammonite.ops.home
import com.olvind.tso.importer.build.Versions
import com.olvind.tso.scalajs.Name

case class Config(publish:        Boolean,
                  offline:        Boolean,
                  cleanRepo:      Boolean,
                  pedantic:       Boolean,
                  wantedLibNames: Set[String]) {

  def debugMode = wantedLibNames.nonEmpty

  // change in source code for now, lazy...
  val outputPkg               = Name("typings")
  val projectName             = "ScalablyTyped"
  val organization            = "org.scalablytyped"
  val versions                = Versions.`scala 2.12 with scala.js 0.6.25`
  val cacheFolder             = home / 'tmp / "tso-cache"
  val publishFolder           = home / ".ivy2" / "local"
  val ScalablyTypedRepo       = "git@github.com:oyvindberg/ScalablyTyped.git"
  val ScalablyTypedRepoPublic = "https://github.com/oyvindberg/ScalablyTyped.git"
  val parallelScalas          = Runtime.getRuntime.availableProcessors / 2
  val parallelLibraries       = 100
}

object Config {
  def unapply(args: Array[String]): Some[Config] =
    args partition (_ startsWith "-") match {
      case (flags, rest) =>
        Some(
          Config(
            publish        = flags contains "-publish",
            offline        = flags contains "-offline",
            cleanRepo      = flags contains "-cleanRepo",
            pedantic       = flags contains "-pedantic",
            wantedLibNames = rest.to[Set]
          )
        )
    }
}
