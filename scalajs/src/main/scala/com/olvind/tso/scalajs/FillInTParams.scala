package com.olvind.tso
package scalajs

object FillInTParams {
  def apply(x: ClassTree, scope: TreeScope, providedTParams: Seq[TypeRef]): ClassTree =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitClassTree(scope)(x).copy(tparams = Nil)
    }

  def apply(x: TypeAliasTree, scope: TreeScope, providedTParams: Seq[TypeRef]): TypeAliasTree =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitTypeAliasTree(scope)(x).copy(tparams = Nil)
    }

  private def rewrites(expectedTParams: Seq[TypeParamTree], providedTParams: Seq[TypeRef]): Map[TypeRef, TypeRef] =
    (expectedTParams zip providedTParams).map {
      case (TypeParamTree(expected, _, _), provided) if provided.targs.nonEmpty =>
        TypeRef(QualifiedName(expected :: Nil), Nil, NoComments) -> provided
      case (TypeParamTree(expected, _, _), provided) =>
        TypeRef(QualifiedName(expected :: Nil), Nil, NoComments) -> provided
    }.toMap
}
