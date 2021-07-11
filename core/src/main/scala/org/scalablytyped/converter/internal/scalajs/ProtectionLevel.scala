package org.scalablytyped.converter.internal.scalajs

import io.circe013.{Decoder, Encoder}

sealed trait ProtectionLevel

object ProtectionLevel {
  def stricter(one: ProtectionLevel, two: ProtectionLevel): ProtectionLevel =
    (one, two) match {
      case (p @ Private, _) => p
      case (_, p @ Private) => p
      case (Protected, _)   => Protected
      case (_, Protected)   => Protected
      case _                => Public
    }

  case object Private extends ProtectionLevel
  case object Protected extends ProtectionLevel
  case object Public extends ProtectionLevel

  implicit val encodes: Encoder[ProtectionLevel] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[ProtectionLevel] = io.circe013.generic.semiauto.deriveDecoder
}
