package org.scalablytyped.converter
package internal
package importer

import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.scalajs.{flavours, Name, Versions}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

import scala.collection.immutable.SortedSet

case class ConversionOptions(
    useScalaJsDomTypes:     Boolean,
    flavour:                Flavour,
    outputPackage:          Name,
    enableScalaJsDefined:   Selection[TsIdentLibrary],
    stdLibs:                SortedSet[String],
    expandTypeMappings:     Selection[TsIdentLibrary],
    ignored:                SortedSet[String],
    versions:               Versions,
    organization:           String,
    enableReactTreeShaking: Selection[Name],
    enableLongApplyMethod:  Boolean,
) {
  val ignoredLibs: Set[TsIdentLibrary] =
    ignored.map(TsIdentLibrary.apply)

  val ignoredModulePrefixes: Set[List[String]] =
    ignored.map(_.split("/").toList)

  val flavourImpl: flavours.FlavourImpl =
    flavour match {
      case Flavour.Normal =>
        flavours.NormalFlavour(useScalaJsDomTypes, enableLongApplyMethod, outputPackage)
      case Flavour.Slinky =>
        flavours.SlinkyFlavour(outputPackage, enableLongApplyMethod, versions.scala, enableReactTreeShaking)
      case Flavour.SlinkyNative =>
        flavours.SlinkyNativeFlavour(outputPackage, enableLongApplyMethod, versions.scala, enableReactTreeShaking)
      case Flavour.Japgolly =>
        flavours.JapgollyFlavour(outputPackage, enableLongApplyMethod, versions.scala, enableReactTreeShaking)
    }

}

object ConversionOptions {
  import io.circe.generic.auto._
  import jsonCodecs._

  implicit val encodes: Encoder[ConversionOptions] = exportEncoder[ConversionOptions].instance
  implicit val decodes: Decoder[ConversionOptions] = exportDecoder[ConversionOptions].instance
}
