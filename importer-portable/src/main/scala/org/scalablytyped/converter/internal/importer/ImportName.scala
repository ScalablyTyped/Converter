package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.{Annotation, Name, QualifiedName}
import org.scalablytyped.converter.internal.ts._

object ImportName {
  def skipConversion(i:     TsIdent):  Name          = Name(i.value)
  def skipConversion(ident: TsQIdent): QualifiedName = QualifiedName(ident.parts.map(skipConversion))

  def unapply(x: TsIdentSimple): Some[Name] =
    Some(apply(x))

  def apply(i: TsIdentSimple): Name =
    Name.necessaryRewrite(Name(i.value))

  def apply(i: TsIdentLibrary): Name =
    Name.necessaryRewrite(Name(AdaptiveNamingImport.variantsForLibName(i).head))

  object withJsNameAnnotation {
    def apply(original: TsIdentSimple): (Name, Option[Annotation.JsName]) = {
      val originalName = Name(original.value)

      Name.necessaryRewrite(original.value) match {
        case Some(rewritten)                      => (Name(rewritten), Some(Annotation.JsName(originalName)))
        case None if original.value.contains("$") => (originalName, Some(Annotation.JsName(originalName)))
        case None if original.value === "apply"   => (originalName, Some(Annotation.JsName(originalName)))
        case None                                 => (originalName, None)
      }
    }

    def unapply(original: TsIdentSimple): Some[(Name, Option[Annotation.JsName])] =
      Some(apply(original))
  }
}
