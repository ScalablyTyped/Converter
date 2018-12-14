package com.olvind.tso
package importer

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class ContribJson(typings: Set[String], dependencies: Set[ContribJson.Dep])

object ContribJson {
  final case class Dep(org: String, artifact: String, version: String)

  implicit val DecoderDep: Decoder[Dep]         = deriveDecoder[Dep]
  implicit val Decoder:    Decoder[ContribJson] = deriveDecoder[ContribJson]
}
