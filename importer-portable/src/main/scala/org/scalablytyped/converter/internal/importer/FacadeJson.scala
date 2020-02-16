package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.Dep
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class FacadeJson(typings: Set[String], dependencies: Set[Dep])

object FacadeJson {
  implicit val DecoderDep: Decoder[Dep]        = deriveDecoder[Dep]
  implicit val Decoder:    Decoder[FacadeJson] = deriveDecoder[FacadeJson]
}
