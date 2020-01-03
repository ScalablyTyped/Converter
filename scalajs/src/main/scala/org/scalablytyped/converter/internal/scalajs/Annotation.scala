package org.scalablytyped.converter.internal
package scalajs

sealed trait Annotation extends Product with Serializable
sealed trait MemberAnnotation extends Annotation
sealed trait ClassAnnotation extends Annotation
sealed trait LocationAnnotation extends ClassAnnotation

sealed trait Imported
object Imported {
  case object Namespace extends Imported
  case object Default extends Imported
  case class Named(name: Seq[Name]) extends Imported
}

object Annotation {
  case object JsBracketAccess extends MemberAnnotation
  case object JsBracketCall extends MemberAnnotation
  case object JsNative extends ClassAnnotation
  case object ScalaJSDefined extends ClassAnnotation
  case object JsGlobalScope extends LocationAnnotation
  case object Inline extends MemberAnnotation

  case class JsName(name:       Name) extends MemberAnnotation with ClassAnnotation
  case class JsNameSymbol(name: QualifiedName) extends MemberAnnotation
  case class JsImport(module:   String, imported: Imported) extends LocationAnnotation
  case class JsGlobal(name:     QualifiedName) extends LocationAnnotation

  def renamedFrom(newName: Name)(oldAnnotations: Seq[MemberAnnotation]): Seq[MemberAnnotation] = {
    val (names, others) =
      oldAnnotations partition {
        case _: JsName | _: JsNameSymbol | JsBracketCall => true
        case _ => false
      }

    val updatedNames: Seq[MemberAnnotation] =
      (names, newName) match {
        case (Nil, n @ (Name.APPLY | Name.namespaced)) => sys.error(s"Cannot rename `$n`")
        case (Nil, old)                                => Seq(JsName(old))
        case (existing, _)                             => existing
      }

    others ++ updatedNames
  }

  def classRenamedFrom(oldName: Name)(oldAnnotations: Seq[ClassAnnotation]): Seq[ClassAnnotation] = {
    val (names, others) =
      oldAnnotations partition {
        case _: JsName   => true
        case _: JsImport => true
        case _: JsGlobal => true
        case _ => false
      }

    val updatedNames: Seq[ClassAnnotation] =
      (names, oldName) match {
        case (Nil, old)    => Seq(JsName(old))
        case (existing, _) => existing
      }

    others ++ updatedNames
  }
}
