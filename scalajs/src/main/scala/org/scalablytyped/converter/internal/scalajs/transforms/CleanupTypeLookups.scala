package org.scalablytyped.converter.internal
package scalajs
package transforms

object CleanupTypeLookups extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef = s match {
    case TypeRef.TypeLookup(_, _) =>
      TypeRef(QualifiedName.Any, Empty, Comments(Comment.warning("Type Lookup not supported")))
    case other => other
  }




}
