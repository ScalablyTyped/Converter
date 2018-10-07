package com.olvind.tso.importer

import com.olvind.tso.scalajs.{Name, QualifiedName}
import com.olvind.tso.ts._

object ImportName {
  def unapply(qident: TsQIdent): Option[QualifiedName] =
    Some(apply(qident))

  def unapply(x: TsIdent): Option[Name] =
    Some(apply(x))

  def rewrite(value: String, suffix: String, capitalize: Boolean): String =
    value
      .flatMap {
        case '\\'  => "Backslash_"
        case '.'   => "Dot_"
        case '@'   => "At_"
        case '_'   => "Underscore_"
        case '-'   => "Dash_"
        case other => other.toString
      }
      .split("[/_]")
      .filterNot(_.isEmpty)
      .map(x => if (capitalize) x.capitalize else x)
      .mkString("", "", suffix)

  def apply(i: TsIdent): Name =
    i match {
      case TsIdent.Apply        => Name.APPLY
      case TsIdentSimple(value) => Name(value)
      case x: TsIdentLibrary => Name(rewrite(x.value, "Lib", capitalize    = true))
      case x: TsIdentModule  => Name(rewrite(x.value, "Module", capitalize = true))
      case TsIdentNamespace(value) => Name(rewrite(value, "Namespace", capitalize = false))
    }

  def apply(ident: TsQIdent): QualifiedName =
    QualifiedName(ident.parts map apply)

  def skipConversion(i: TsIdent): Name =
    Name(i.value)

  def skipConversion(ident: TsQIdent): QualifiedName =
    QualifiedName(ident.parts map skipConversion)
}
