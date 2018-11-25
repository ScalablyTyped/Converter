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

  val TimeZone        = ZoneId.of("UTC")
  val Utf8            = Codec.UTF8.charSet
  val DateTimePattern = DateTimeFormatter ofPattern "ddMMyyyyhhmm" withLocale Locale.ENGLISH withZone TimeZone

  // yeah, sorry - we'll do this more properly one day
  object MagicComments {
    val TrivialTypeAlias = new Comment("/* tso:trivial-typeparam */ ")
  }
}
