package com.olvind.tso

import java.net.URI
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

import scala.io.Codec

/**
  * Todo: this is mostly config, and it's only laziness that it's all here static
  */
object constants {
  val DefinitelyTypedRepo = new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")
  val isCi                = sys.env.get("CIRCLECI").isDefined
  val TimeZone            = ZoneId.of("UTC")
  val Utf8                = Codec.UTF8.charSet
  val DateTimePattern     = DateTimeFormatter ofPattern "yyyyMMddhhmm" withLocale Locale.ENGLISH withZone TimeZone

  val RuntimeOrg     = "com.olvind"
  val RuntimeName    = "scalablytyped-runtime"
  val RuntimeVersion = "2.1.0"
}
