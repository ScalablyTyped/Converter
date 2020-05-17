package org.scalablytyped.converter.internal.scalajs

import org.scalablytyped.converter.internal.scalajs.transforms.UnionToInheritance
import org.scalablytyped.converter.internal.{CommentData, Comments}

case class TypeRewriter(replacements: Map[TypeRef, TypeRef]) extends TreeTransformation {
  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree =
    cls.copy(comments = rewriteComments(cls.comments, scope))

  override def leaveTypeAliasTree(scope: TreeScope)(ta: TypeAliasTree): TypeAliasTree =
    ta.copy(comments = rewriteComments(ta.comments, scope))

  override def leaveTypeRef(scope: TreeScope)(x: TypeRef): TypeRef =
    replacements.getOrElse(x, x)

  // https://en.wikipedia.org/wiki/Leaky_abstraction
  private def rewriteComments(cs: Comments, scope: TreeScope): Comments =
    cs.extract { case x: UnionToInheritance.WasUnion => x } match {
      case None => cs
      case Some((UnionToInheritance.WasUnion(asInheritance, noRewrites), rest)) =>
        rest + CommentData(
          UnionToInheritance.WasUnion(
            asInheritance = asInheritance map visitTypeRef(scope),
            noRewrites    = noRewrites map visitTypeRef(scope),
          ),
        )
    }

}
