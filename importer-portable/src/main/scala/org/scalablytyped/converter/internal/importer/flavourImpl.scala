package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.Flavour
import org.scalablytyped.converter.internal.scalajs.Name
import org.scalablytyped.converter.internal.scalajs.flavours.{FlavourImpl, SlinkyFlavour}

object flavourImpl {
  def apply(
      flavour:                  Flavour,
      shouldUseScalaJsDomTypes: Boolean,
      outputPkg:                Name,
      enableImplicitOps:        Boolean,
  ): FlavourImpl =
    flavour match {
      case Flavour.Normal =>
        FlavourImpl.Normal(
          shouldGenerateComponents = true,
          shouldUseScalaJsDomTypes,
          enableImplicitOps,
          outputPkg,
        )
      case Flavour.Slinky =>
        SlinkyFlavour(outputPkg, enableImplicitOps)
      case Flavour.SlinkyNative =>
        FlavourImpl.SlinkyNative(outputPkg, enableImplicitOps)
      case Flavour.Japgolly =>
        FlavourImpl.Japgolly(outputPkg, enableImplicitOps)
    }

  def forConversion(co: ConversionOptions): FlavourImpl =
    apply(co.flavour, co.useScalaJsDomTypes, co.outputPackage, co.enableImplicitOps)
}
