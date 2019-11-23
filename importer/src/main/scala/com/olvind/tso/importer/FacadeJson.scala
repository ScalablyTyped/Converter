package com.olvind.tso
package importer

import com.olvind.tso.scalajs.Dep
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class FacadeJson(typings: Set[String], dependencies: Set[Dep])

object FacadeJson {
  implicit val DecoderDep: Decoder[Dep]        = deriveDecoder[Dep]
  implicit val Decoder:    Decoder[FacadeJson] = deriveDecoder[FacadeJson]
}
