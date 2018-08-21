package com.olvind.tso
package scalajs

object FillInTParams {
  def apply(x: ClassSymbol, scope: SymbolScope, providedTParams: Seq[TypeRef]): ClassSymbol =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitClassSymbol(scope)(x).copy(tparams = Nil)
    }

  def apply(x: TypeAliasSymbol, scope: SymbolScope, providedTParams: Seq[TypeRef]): TypeAliasSymbol =
    if (providedTParams.isEmpty) x
    else {
      val refToRef = rewrites(x.tparams, providedTParams)
      TypeRewriter(refToRef).visitTypeAliasSymbol(scope)(x).copy(tparams = Nil)
    }

  private def rewrites(expectedTParams: Seq[TypeParamSymbol], providedTParams: Seq[TypeRef]): Map[TypeRef, TypeRef] =
    (expectedTParams zip providedTParams).map {
      case (TypeParamSymbol(expected, _, _), provided) if provided.targs.nonEmpty =>
        TypeRef(QualifiedName(expected :: Nil), Nil, NoComments) -> provided
      case (TypeParamSymbol(expected, _, _), provided) =>
        TypeRef(QualifiedName(expected :: Nil), Nil, NoComments) -> provided
    }.toMap
}
