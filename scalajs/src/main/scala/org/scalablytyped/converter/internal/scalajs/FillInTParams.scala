package org.scalablytyped.converter.internal
package scalajs

import org.scalablytyped.converter.internal.scalajs.transforms.UnionToInheritance

object FillInTParams {
  def apply(
      cls:             ClassTree,
      scope:           TreeScope,
      providedTParams: Seq[TypeRef],
      newTParams:      Seq[TypeParamTree],
  ): ClassTree =
    if (providedTParams.isEmpty) cls
    else {
      val rewriter = TypeRewriter(rewrites(cls.tparams, providedTParams))
      val newCls   = rewriter.visitClassTree(scope)(cls)

      newCls.comments.extract { case UnionToInheritance.WasUnion(related) => related } match {
        case None                  => newCls
        case Some((related, rest)) =>
          // https://en.wikipedia.org/wiki/Leaky_abstraction
          val newRelated = CommentData(UnionToInheritance.WasUnion(related map rewriter.visitTypeRef(scope)))
          newCls.copy(comments = rest + newRelated)
      }
    }.copy(tparams = newTParams)

  def apply(
      x:               TypeAliasTree,
      scope:           TreeScope,
      providedTParams: Seq[TypeRef],
      newTParams:      Seq[TypeParamTree],
  ): TypeAliasTree =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitTypeAliasTree(scope)(x)
    }.copy(tparams = newTParams)

  def apply(
      x:               MethodTree,
      scope:           TreeScope,
      providedTParams: Seq[TypeRef],
      newTParams:      Seq[TypeParamTree],
  ): MethodTree =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitMethodTree(scope)(x).copy(tparams = Nil)
    }.copy(tparams = newTParams)

  private def rewrites(expectedTParams: Seq[TypeParamTree], providedTParams: Seq[TypeRef]): Map[TypeRef, TypeRef] =
    (expectedTParams zip providedTParams).map {
      case (TypeParamTree(expected, _, _), provided) if provided.targs.nonEmpty =>
        TypeRef(QualifiedName(expected :: Nil), Nil, NoComments) -> provided
      case (TypeParamTree(expected, _, _), provided) =>
        TypeRef(QualifiedName(expected :: Nil), Nil, NoComments) -> provided
    }.toMap
}
