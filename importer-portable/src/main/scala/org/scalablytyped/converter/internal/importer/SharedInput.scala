package org.scalablytyped.converter
package internal
package importer

import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer.build.Versions

case class SharedInput(
    shouldUseScalaJsDomTypes: Boolean,
    wantedLibs:               Set[ts.TsIdentLibrary],
    flavour:                  Flavour,
    outputPackage:            scalajs.Name,
    enableScalaJsDefined:     Selection[ts.TsIdentLibrary],
    stdLibs:                  IArray[String],
    expandTypeMappings:       Selection[ts.TsIdentLibrary],
    ignoredLibs:              Set[ts.TsIdentLibrary],
    ignoredModulePrefixes:    Set[List[String]],
    versions:                 Versions,
)

object SharedInput {
  import io.circe.generic.auto._
  import jsonCodecs._

  implicit val ConfigEncoder: Encoder[SharedInput] = exportEncoder[SharedInput].instance
  implicit val ConfigDecoder: Decoder[SharedInput] = exportDecoder[SharedInput].instance
}
