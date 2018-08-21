package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts.{JsLocation, ModuleSpec}

object JsLocationAnnotation {
  def apply(location: JsLocation, isWithinScalaModule: Boolean): Seq[ClassAnnotation] =
    if (isWithinScalaModule) Seq(JsNative)
    else
      location match {
        case JsLocation.Zero           => Seq(JsNative, JsGlobalScope)
        case JsLocation.Global(jsPath) => Seq(JsGlobal(AsName.skipConversion(jsPath)), JsNative)
        case JsLocation.Module(lit, spec) =>
          spec match {
            case ModuleSpec.Defaulted  => Seq(JsImport(lit.value, Imported.Default), JsNative)
            case ModuleSpec.Namespaced => Seq(JsImport(lit.value, Imported.Namespace), JsNative)
            case ModuleSpec.Specified(idents) =>
              val parts = lit.value.split("/").filter(_.nonEmpty) ++ idents.dropRight(1).map(_.value)
              Seq(JsImport(parts.mkString("/"), Imported.Named(AsName.skipConversion(idents.last))), JsNative)
          }
      }
}
