package com.olvind.tso

import java.net.URI
import java.time.ZoneId

import scala.io.Codec

object constants {
  val ScalablyTypedRepo   = "git@github.com:oyvindberg/ScalablyTyped.git"
  val DefinitelyTypedRepo = new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")
  val Pedantic            = true
  val pkg                 = "ScalablyTyped"
  val offline             = false
  val freshRepo           = false

  val TimeZone = ZoneId.of("GMT")
  val Utf8     = Codec.UTF8.charSet
}
