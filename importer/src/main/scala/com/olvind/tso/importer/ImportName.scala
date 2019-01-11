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
      case TsIdentNamespace(value) => Name(rewrite(value, "Ns", forceCamelCase = false))
      case x: TsIdentLibrary => Name(rewrite(x.value, "Lib", forceCamelCase = true))
      case x: TsIdentModule  => rewriteModuleName(x)
      case x: TsIdentImport  => sys.error(s"Unexpected: $x")
    }

  private def rewrite(value: String, suffix: String, forceCamelCase: Boolean): String =
    value
      .flatMap {
        case '\\'  => "#backslash#" //be safe
        case '.'   => "#dot#" // doesn't work in sbt/maven/ivy somewhere
        case '@'   => "#at#"
        case '_'   => "#underscore#" // will be erased otherwise
        case '-'   => "#dash#" //causes `` in scala code
        case other => other.toString
      }
      .split("[#/]")
      .filterNot(_.isEmpty)
      .zipWithIndex
      .map {
        case (x, 0) => if (forceCamelCase && x.head.isUpper) x.toLowerCase else x
        case (x, _) => x.capitalize
      }
      .mkString("", "", suffix)

  /**
    * We shorten a module name if it starts with the name of a known library.
    */
  private def rewriteModuleName(x: TsIdentModule): Name = {
    val shortenedOpt: Option[String] =
      x match {
        case TsIdentModule(Some(scope), head :: tail) =>
          knownLibraries.collectFirst {
            case TsIdentLibraryScoped(`scope`, Some(`head`)) => tail.mkString("/")
          }
        case TsIdentModule(None, head :: tail) =>
          knownLibraries.collectFirst {
            case TsIdentLibrarySimple(`head`) => tail.mkString("/")
          }
        case _ => None
      }

    Name(rewrite(shortenedOpt.filter(_.nonEmpty).getOrElse(x.value), "Mod", forceCamelCase = true))
  }
}

object ImportName {
  def skipConversion(i:     TsIdent):  Name          = Name(i.value)
  def skipConversion(ident: TsQIdent): QualifiedName = QualifiedName(ident.parts map skipConversion)
}
