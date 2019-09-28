package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts.{JsLocation, ModuleSpec}

object ImportJsLocation {
  def apply(location: JsLocation): Seq[AnnotationTree] =
    location match {
      case JsLocation.Zero => Seq(AnnotationTree.JsNative.get, AnnotationTree.JsGlobalScope.get)
      case JsLocation.Global(jsPath) =>
        Seq(AnnotationTree.JsGlobal(ImportName.skipConversion(jsPath)), AnnotationTree.JsNative.get)
      case JsLocation.Module(lit, spec) =>
        spec match {
          case ModuleSpec.Defaulted =>
            Seq(AnnotationTree.JsImport.Default(lit.value), AnnotationTree.JsNative.get)
          case ModuleSpec.Namespaced =>
            Seq(
              AnnotationTree.JsImport.Namespace(lit.value),
              AnnotationTree.JsNative.get,
            )
          case ModuleSpec.Specified(idents) =>
            Seq(
              AnnotationTree.JsImport.Named(lit.value, idents.map(ImportName.skipConversion)),
              AnnotationTree.JsNative.get,
            )
        }
    }
}
