package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.Flavour
import org.scalablytyped.converter.internal.scalajs.Name
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl

object flavourImpl {
  def apply(
      flavour:                  Flavour,
      shouldUseScalaJsDomTypes: Boolean,
      outputPackage:            Name,
  ): FlavourImpl =
    flavour match {
      case Flavour.Normal =>
        FlavourImpl.Normal(
          shouldGenerateComponents = true,
          shouldUseScalaJsDomTypes = shouldUseScalaJsDomTypes,
          outputPkg                = outputPackage,
        )
      case Flavour.Slinky =>
        FlavourImpl.Slinky(outputPkg = outputPackage)
      case Flavour.SlinkyNative =>
        FlavourImpl.SlinkyNative(outputPkg = outputPackage)
      case Flavour.Japgolly =>
        FlavourImpl.Japgolly(outputPkg = outputPackage)
    }

  def fromInput(i: SharedInput): FlavourImpl =
    apply(i.flavour, i.shouldUseScalaJsDomTypes, i.outputPackage)
}
