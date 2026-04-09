package org.scalablytyped.converter.internal
package scalajs

import io.circe.{Decoder, Encoder}

sealed trait ClassType {
  import ClassType._

  final def combine(that: ClassType): ClassType =
    (this, that) match {
      case (Class, _) => Class
      case (_, Class) => Class
      case (_, _)     => Trait
    }

  final def asString: String =
    this match {
      case Trait => "trait"
      case Class => "class"
    }
}

object ClassType {
  case object Class extends ClassType
  case object Trait extends ClassType

  implicit val encodes: Encoder[ClassType] = io.circe.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[ClassType] = io.circe.generic.semiauto.deriveDecoder
}
