package com.olvind.tso.scalajs

case class TypeRewriter(replacements: Map[TypeRef, TypeRef]) extends SymbolVisitor {
  override def leaveTypeRef(scope: SymbolScope)(x: TypeRef): TypeRef =
    replacements.getOrElse(x, x)
}
