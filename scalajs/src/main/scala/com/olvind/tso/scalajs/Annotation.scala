package com.olvind.tso
package scalajs

sealed trait Annotation extends Product with Serializable
sealed trait MemberAnnotation extends Annotation
sealed trait ClassAnnotation extends Annotation

sealed trait Imported
object Imported {
  case object Namespace extends Imported
  case object Default extends Imported
  case class Named(name: Name) extends Imported
}

object Annotation {
  case object JsBracketAccess extends MemberAnnotation
  case object JsBracketCall extends MemberAnnotation
  case object JsNative extends ClassAnnotation
  case object ScalaJSDefined extends ClassAnnotation
  case object JsGlobalScope extends ClassAnnotation
  case object Inline extends MemberAnnotation

  case class JsName(name:       Name) extends MemberAnnotation with ClassAnnotation
  case class JsNameSymbol(name: QualifiedName) extends MemberAnnotation
  case class JsImport(module:   String, imported: Imported) extends ClassAnnotation
  case class JsGlobal(name:     QualifiedName) extends ClassAnnotation

  def jsName(name: Name): Seq[JsName] =
    if (name.unescaped.contains("$")) Seq(JsName(name))
    else if (name.unescaped === "apply") Seq(JsName(name))
    else Nil

  def jsNameSymbol(qname: QualifiedName): JsNameSymbol =
    JsNameSymbol(qname)

  def method(name: Name, isBracketAccess: Boolean): Seq[MemberAnnotation] =
    if (isBracketAccess) jsName(name) :+ JsBracketAccess
    else jsName(name)

  def renamedFrom(oldName: Name)(oldAnnotations: Seq[MemberAnnotation]): Seq[MemberAnnotation] = {
    val (names, others) =
      oldAnnotations partition {
        case _: JsName | _: JsNameSymbol | JsBracketCall => true
        case _ => false
      }

    val updatedNames: Seq[MemberAnnotation] =
      (names, oldName) match {
        case (Nil, n @ (Name.APPLY | Name.namespaced)) => sys.error(s"Cannot rename `$n`")
        case (Nil, old)                                => Seq(JsName(old))
        case (existing, _)                             => existing
      }

    others ++ updatedNames
  }

  def realName(anns: Seq[Annotation], fallback: Name): Name =
    anns collectFirst {
      case JsName(name)                      => name
      case JsImport(_, Imported.Named(name)) => name
      case JsGlobal(qname)                   => qname.parts.last
    } getOrElse fallback
}
