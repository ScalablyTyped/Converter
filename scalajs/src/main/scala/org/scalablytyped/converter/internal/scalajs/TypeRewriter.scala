package org.scalablytyped.converter.internal.scalajs

import org.scalablytyped.converter.internal.Marker

case class TypeRewriter(replacements: Map[TypeRef, TypeRef]) extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(x: TypeRef): TypeRef =
    replacements.get(x) match {
      case Some(replaced) => replaced
      case None           => TypeRewriter.rewriteIndexedAccess(x)(visitTypeRef(scope))
    }

  override def leaveMethodTree(scope: TreeScope)(x: MethodTree): MethodTree =
    TypeRewriter.rewriteAlternativeProps(x)(visitTypeRef(scope))
}

object TypeRewriter {

  /* `Marker.IndexedAccess` refers to types (typically type parameters) from within comments, which the tree
   * transformation doesn't reach */
  def rewriteIndexedAccess(x: TypeRef)(f: TypeRef => TypeRef): TypeRef =
    x.comments.extract { case Marker.IndexedAccess(from, key) => (from, key) } match {
      case Some(((from, key), rest)) => x.copy(comments = rest + Marker.IndexedAccess(f(from), key))
      case None                      => x
    }

  /* same for `Marker.AlternativeProps` */
  def rewriteAlternativeProps(x: MethodTree)(f: TypeRef => TypeRef): MethodTree =
    x.comments.extract { case Marker.AlternativeProps(types) => types } match {
      case Some((types, rest)) => x.copy(comments = rest + Marker.AlternativeProps(types.map(f)))
      case None                => x
    }
}

case class TypeRewriterFn(replacements: TypeRef => TypeRef) extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(x: TypeRef): TypeRef =
    replacements(x)
}
