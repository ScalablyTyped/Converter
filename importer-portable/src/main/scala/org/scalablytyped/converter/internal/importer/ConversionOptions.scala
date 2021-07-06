package org.scalablytyped.converter
package internal
package importer

import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.scalajs.flavours._
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
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
    privateWithin:          Option[Name],
) {
  val ignoredLibs: Set[TsIdentLibrary] =
    ignored.map(TsIdentLibrary.apply)

  val ignoredModulePrefixes: Set[List[String]] =
    ignored.map(_.split("/").toList)

  val flavourImpl: FlavourImpl =
    flavour match {
      case Flavour.Normal =>
        NormalFlavour(useScalaJsDomTypes, enableLongApplyMethod, outputPackage, versions)
      case Flavour.Slinky =>
        SlinkyFlavour(outputPackage, enableLongApplyMethod, versions, enableReactTreeShaking)
      case Flavour.SlinkyNative =>
        SlinkyNativeFlavour(outputPackage, enableLongApplyMethod, versions, enableReactTreeShaking)
      case Flavour.ScalajsReact =>
        JapgollyFlavour(outputPackage, enableLongApplyMethod, versions, enableReactTreeShaking)
    }

}

object ConversionOptions {
  implicit val encodes: Encoder[ConversionOptions] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[ConversionOptions] = io.circe013.generic.semiauto.deriveDecoder
}
