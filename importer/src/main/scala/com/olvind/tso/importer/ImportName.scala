package com.olvind.tso
package importer

import com.olvind.tso.scalajs.{Name, QualifiedName}
import com.olvind.tso.ts._

object ImportName {
  def unapply(qident: TsQIdent): Option[QualifiedName] =
    Some(apply(qident))

  def unapply(x: TsIdent): Option[Name] =
    Some(apply(x))

  def rewrite(value: String, suffix: String): String =
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
        case (x, 0) => x
        case (x, _) => x.capitalize
      }
      .mkString("", "", suffix)

  def apply(i: TsIdent): Name =
    i match {
      case TsIdent.Apply           => Name.APPLY
      case TsIdentSimple(value)    => Name(value)
      case TsIdentNamespace(value) => Name(rewrite(value, "Ns"))
      case x: TsIdentLibrary =>
        Name(rewrite(x.value, "Lib"))
      case x: TsIdentModule =>
        def maybeDropFirst(ts: List[String]): List[String] =
          ts match {
            case one :: (tail @ (two :: _)) if one =/= two => tail
            case other                                     => other
          }
        Name(rewrite(maybeDropFirst(x.fragments).mkString("#"), "Mod"))
    }

  def apply(ident: TsQIdent): QualifiedName =
    QualifiedName(ident.parts map apply)

  def skipConversion(i: TsIdent): Name =
    Name(i.value)

  def skipConversion(ident: TsQIdent): QualifiedName =
    QualifiedName(ident.parts map skipConversion)
}
