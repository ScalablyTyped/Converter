package org.scalablytyped.converter.internal

import io.circe013.{Decoder, Encoder}

sealed trait ProtectionLevel

object ProtectionLevel {
  case object Default extends ProtectionLevel
  case object Private extends ProtectionLevel
  case object Protected extends ProtectionLevel

  implicit val encodes: Encoder[ProtectionLevel] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[ProtectionLevel] = io.circe013.generic.semiauto.deriveDecoder
}
