package com.olvind.tso
package importer

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class FacadeJson(typings: Set[String], dependencies: Set[FacadeJson.Dep])

object FacadeJson {
  final case class Dep(org: String, artifact: String, version: String)

  implicit val DecoderDep: Decoder[Dep]        = deriveDecoder[Dep]
  implicit val Decoder:    Decoder[FacadeJson] = deriveDecoder[FacadeJson]
}
