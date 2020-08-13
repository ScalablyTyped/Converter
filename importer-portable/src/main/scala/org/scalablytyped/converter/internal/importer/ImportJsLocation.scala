package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.ts.{JsLocation, ModuleSpec}

object ImportJsLocation {

  def apply(location: JsLocation): IArray[Annotation] =
    location match {
      case JsLocation.Zero =>
        IArray(Annotation.JsNative, Annotation.JsGlobalScope)
      case x: JsLocation.Global =>
        IArray(jsGlobal(x), Annotation.JsNative)
      case JsLocation.Both(mod, global) =>
        IArray(jsMod(mod, Some(jsGlobal(global))), Annotation.JsNative)
      case mod: JsLocation.Module =>
        IArray(jsMod(mod, None), Annotation.JsNative)
    }

  def jsGlobal(x: JsLocation.Global): Annotation.JsGlobal =
    Annotation.JsGlobal(ImportName.skipConversion(x.jsPath))

  def jsMod(x: JsLocation.Module, globalOpt: Option[Annotation.JsGlobal]): Annotation.JsImport = x match {
    case JsLocation.Module(modName, spec) =>
      spec match {
        case ModuleSpec.Defaulted  => Annotation.JsImport(modName.value, Imported.Default, globalOpt)
        case ModuleSpec.Namespaced => Annotation.JsImport(modName.value, Imported.Namespace, globalOpt)
        case ModuleSpec.Specified(idents) =>
          Annotation.JsImport(
            module   = modName.value,
            imported = Imported.Named(idents.map(ImportName.skipConversion)),
            global   = globalOpt,
          )
      }
  }
}
