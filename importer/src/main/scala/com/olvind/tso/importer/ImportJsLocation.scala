package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts.{JsLocation, ModuleSpec}

object ImportJsLocation {
  def apply(location: JsLocation): Seq[ClassAnnotation] =
    location match {
      case JsLocation.Zero => Seq(Annotation.JsNative, Annotation.JsGlobalScope)
      case JsLocation.Global(jsPath) =>
        Seq(Annotation.JsGlobal(ImportName.skipConversion(jsPath)), Annotation.JsNative)
      case JsLocation.Module(lit, spec) =>
        spec match {
          case ModuleSpec.Defaulted  => Seq(Annotation.JsImport(lit.value, Imported.Default), Annotation.JsNative)
          case ModuleSpec.Namespaced => Seq(Annotation.JsImport(lit.value, Imported.Namespace), Annotation.JsNative)
          case ModuleSpec.Specified(idents) =>
            Seq(
              Annotation.JsImport(
                module   = lit.value,
                imported = Imported.Named(idents map ImportName.skipConversion),
              ),
              Annotation.JsNative,
            )
        }
    }
}
