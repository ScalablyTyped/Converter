package org.scalablytyped.converter.internal

import java.net.URI
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

import org.scalablytyped.converter.internal.environment.OpSystem

import scala.io.Codec

object constants {
  val defaultCacheFolder: os.Path = environment.OS match {
    case OpSystem.MAC     => os.home / "Library" / "Caches" / "ScalablyTyped"
    case OpSystem.WINDOWS => os.home / "AppData" / "Local" / "ScalablyTyped"
    case OpSystem.LINUX   => os.home / ".cache" / "scalablytyped"
    case OpSystem.UNKNOWN => os.home / ".cache" / "scalablytyped" // By default, Linux cache folder
  }
  val defaultLocalPublishFolder: os.Path = os.home / ".ivy2" / "local"

  val DefinitelyTypedRepo = new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")
  val ConverterRepo       = new URI("https://github.com/ScalablyTyped/Converter.git")
  val isCi                = sys.env.get("CIRCLECI").isDefined
  val TimeZone            = ZoneId.of("UTC")
  val Utf8                = Codec.UTF8.charSet
  val DateTimePattern     = DateTimeFormatter.ofPattern("yyyyMMddhhmm").withLocale(Locale.ENGLISH).withZone(TimeZone)
}
