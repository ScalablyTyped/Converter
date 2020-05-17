package org.scalablytyped.converter.internal
package scalajs

object FillInTParams {
  def apply(
      cls:             ClassTree,
      scope:           TreeScope,
      providedTParams: IArray[TypeRef],
      newTParams:      IArray[TypeParamTree],
  ): ClassTree =
    if (providedTParams.isEmpty) cls
    else {
      val rewriter = TypeRewriter(rewrites(cls.tparams, providedTParams))
      rewriter.visitClassTree(scope)(cls)
    }.copy(tparams = newTParams)

  def apply(
      x:               TypeAliasTree,
      scope:           TreeScope,
      providedTParams: IArray[TypeRef],
      newTParams:      IArray[TypeParamTree],
  ): TypeAliasTree =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitTypeAliasTree(scope)(x)
    }.copy(tparams = newTParams)

  def apply(
      x:               MethodTree,
      scope:           TreeScope,
      providedTParams: IArray[TypeRef],
      newTParams:      IArray[TypeParamTree],
  ): MethodTree =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitMethodTree(scope)(x).copy(tparams = Empty)
    }.copy(tparams = newTParams)

  private def rewrites(
      expectedTParams: IArray[TypeParamTree],
      providedTParams: IArray[TypeRef],
  ): Map[TypeRef, TypeRef] =
    (expectedTParams zip providedTParams).map {
      case (TypeParamTree(expected, _, _, _), provided) if provided.targs.nonEmpty =>
        TypeRef(QualifiedName(IArray(expected)), Empty, NoComments) -> provided
      case (TypeParamTree(expected, _, _, _), provided) =>
        TypeRef(QualifiedName(IArray(expected)), Empty, NoComments) -> provided
    }.toMap
}
