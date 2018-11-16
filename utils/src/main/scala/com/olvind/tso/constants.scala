package com.olvind.tso

import java.net.URI
import java.time.ZoneId

import scala.io.Codec

/**
  * Todo: this is mostly config, and it's only laziness that it's all here static
  */
object constants {
  val DefinitelyTypedRepo = new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")

  val TimeZone = ZoneId.of("GMT")
  val Utf8     = Codec.UTF8.charSet

  // yeah, sorry - we'll do this more properly one day
  object MagicComments {
    val TrivialTypeAlias = new Comment("/* tso:trivial-typeparam */ ")
  }
}
