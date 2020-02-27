package org.scalablytyped.converter.internal
package importer

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder
import org.scalablytyped.converter.internal.scalajs.Dep

final case class FacadeJson(typings: Set[String], dependencies: Set[Dep.ScalaJs])

object FacadeJson {
  implicit val DecoderDep: Decoder[Dep.ScalaJs] = deriveDecoder[Dep.ScalaJs]
  implicit val Decoder:    Decoder[FacadeJson]  = deriveDecoder[FacadeJson]
}
