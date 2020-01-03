package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.ts.{JsLocation, ModuleSpec}

object ImportJsLocation {
  def apply(location: JsLocation): IArray[ClassAnnotation] =
    location match {
      case JsLocation.Zero => IArray(Annotation.JsNative, Annotation.JsGlobalScope)
      case JsLocation.Global(jsPath) =>
        IArray(Annotation.JsGlobal(ImportName.skipConversion(jsPath)), Annotation.JsNative)
      case JsLocation.Module(lit, spec) =>
        spec match {
          case ModuleSpec.Defaulted  => IArray(Annotation.JsImport(lit.value, Imported.Default), Annotation.JsNative)
          case ModuleSpec.Namespaced => IArray(Annotation.JsImport(lit.value, Imported.Namespace), Annotation.JsNative)
          case ModuleSpec.Specified(idents) =>
            IArray(
              Annotation.JsImport(
                module   = lit.value,
                imported = Imported.Named(idents map ImportName.skipConversion),
              ),
              Annotation.JsNative,
            )
        }
    }
}
