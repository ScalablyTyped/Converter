package org.scalablytyped.converter.internal.scalajs

import io.circe013.{Decoder, Encoder}

sealed trait ProtectionLevel

object ProtectionLevel {
  case object Private extends ProtectionLevel
  case object Protected extends ProtectionLevel
  case object Public extends ProtectionLevel

  implicit val encodes: Encoder[ProtectionLevel] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[ProtectionLevel] = io.circe013.generic.semiauto.deriveDecoder
}
