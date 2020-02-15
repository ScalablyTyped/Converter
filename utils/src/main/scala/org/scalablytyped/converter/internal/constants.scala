package org.scalablytyped.converter.internal

import java.net.URI
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

import scala.io.Codec

object constants {
  val DefinitelyTypedRepo = new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")
  val ConverterRepo       = new URI("https://github.com/ScalablyTyped/Converter.git")
  val isCi                = sys.env.get("CIRCLECI").isDefined
  val TimeZone            = ZoneId.of("UTC")
  val Utf8                = Codec.UTF8.charSet
  val DateTimePattern     = DateTimeFormatter ofPattern "yyyyMMddhhmm" withLocale Locale.ENGLISH withZone TimeZone

  val RuntimeOrg     = "com.olvind"
  val RuntimeName    = "scalablytyped-runtime"
  val RuntimeVersion = "2.1.0"
}
