package com.olvind.tso
package scalajs

sealed trait Annotation       extends Product with Serializable
sealed trait MemberAnnotation extends Annotation
sealed trait ClassAnnotation  extends Annotation

case object JsBracketAccess extends MemberAnnotation
case object JsBracketCall   extends MemberAnnotation
case object JsNative        extends ClassAnnotation
case object ScalaJSDefined  extends ClassAnnotation
case object JsGlobalScope   extends ClassAnnotation
case class JsName(name:       Name) extends MemberAnnotation with ClassAnnotation
case class JsNameSymbol(name: QualifiedName) extends MemberAnnotation
case class JsImport(module:   String, imported: Imported) extends ClassAnnotation
case class JsGlobal(name:     QualifiedName) extends ClassAnnotation

sealed trait Imported
object Imported {
  case object Namespace extends Imported
  case object Default   extends Imported
  case class Named(name: Name) extends Imported
}
