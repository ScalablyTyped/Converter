package org.scalablytyped.converter.internal.scalajs

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class Dep(org: String, artifact: String, version: String)

object Dep {
  implicit val DecoderDep: Decoder[Dep] = deriveDecoder[Dep]
}
