package com.olvind.tso
package scalajs

object Annotations {
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
}
