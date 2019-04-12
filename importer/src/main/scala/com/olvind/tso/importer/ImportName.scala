package com.olvind.tso
package importer

import com.olvind.tso.scalajs.{Name, QualifiedName}
import com.olvind.tso.ts._

/**
  * @param knownLibraries A known library in this context is the one we
  *                       are converting, or any of it's dependencies
  */
class ImportName(knownLibraries: Set[TsIdentLibrary]) {
  def unapply(qident: TsQIdent): Some[QualifiedName] =
    Some(apply(qident))

  def unapply(x: TsIdent): Some[Name] =
    Some(apply(x))

  def apply(ident: TsQIdent): QualifiedName =
    QualifiedName(ident.parts map apply)

  def apply(i: TsIdent): Name =
    i match {
      case TsIdent.Apply           => Name.APPLY
      case TsIdentSimple(value)    => Name(value)
      case TsIdentNamespace(value) => Name(prettyString(value, "Ns", forceCamelCase = false))
      case x: TsIdentLibrary => Name(prettyString(x.value, "Lib", forceCamelCase = true))
      case x: TsIdentModule  => rewriteModuleName(x)
      case x: TsIdentImport  => sys.error(s"Unexpected: $x")
    }

  /**
    * We shorten a module name if it starts with the name of a known library.
    */
  private def rewriteModuleName(x: TsIdentModule): Name = {
    val shortenedOpt: Option[String] =
      x match {
        case TsIdentModule(Some(scope), head :: tail) if !(tail.size === 1 && tail.head === head) =>
          knownLibraries.collectFirst {
            case TsIdentLibraryScoped(`scope`, Some(`head`)) => tail.mkString("/")
          }
        case TsIdentModule(None, head :: tail) if !(tail.size === 1 && tail.head === head) =>
          knownLibraries.collectFirst {
            case TsIdentLibrarySimple(`head`) => tail.mkString("/")
          }
        case _ => None
      }

    Name(prettyString(shortenedOpt.filter(_.nonEmpty).getOrElse(x.value), "Mod", forceCamelCase = true))
  }
}

object ImportName {
  def skipConversion(i:     TsIdent):  Name          = Name(i.value)
  def skipConversion(ident: TsQIdent): QualifiedName = QualifiedName(ident.parts map skipConversion)
}
