package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts.{JsLocation, ModuleSpec}

object ImportJsLocation {
  def apply(location: JsLocation, isWithinScalaModule: Boolean): Seq[ClassAnnotation] =
    if (isWithinScalaModule) Seq(Annotation.JsNative)
    else
      location match {
        case JsLocation.Zero => Seq(Annotation.JsNative, Annotation.JsGlobalScope)
        case JsLocation.Global(jsPath) =>
          Seq(Annotation.JsGlobal(ImportName.skipConversion(jsPath)), Annotation.JsNative)
        case JsLocation.Module(lit, spec) =>
          spec match {
            case ModuleSpec.Defaulted  => Seq(Annotation.JsImport(lit.value, Imported.Default), Annotation.JsNative)
            case ModuleSpec.Namespaced => Seq(Annotation.JsImport(lit.value, Imported.Namespace), Annotation.JsNative)
            case ModuleSpec.Specified(idents) =>
              val parts = lit.value.split("/").filter(_.nonEmpty) ++ idents.dropRight(1).map(_.value)
              Seq(
                Annotation.JsImport(parts.mkString("/"), Imported.Named(ImportName.skipConversion(idents.last))),
                Annotation.JsNative,
              )
          }
      }
}
