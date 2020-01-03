package org.scalablytyped.converter.internal.scalajs

case class TypeRewriter(replacements: Map[TypeRef, TypeRef]) extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(x: TypeRef): TypeRef =
    replacements.getOrElse(x, x)
}

case class TypeRewriterFn(replacements: TypeRef => TypeRef) extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(x: TypeRef): TypeRef =
    replacements(x)
}
