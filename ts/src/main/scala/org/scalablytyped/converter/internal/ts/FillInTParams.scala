package org.scalablytyped.converter.internal
package ts

import org.scalablytyped.converter.internal.ts.transforms.TypeRewriter

/**
  * For instance: `x: class Foo&lt;T&gt;` and `providedTParams: T = number` => `Foo&lt;number&gt;`
  * Includes all members
  */
object FillInTParams {
  def apply(x: TsDeclInterface, providedTParams: IArray[TsType]): TsDeclInterface =
    rewriter(x.tparams, providedTParams)
      .fold(x)(rws => new TypeRewriter(x).visitTsDeclInterface(rws)(x).copy(tparams = Empty))

  def apply(x: TsDeclClass, providedTParams: IArray[TsType]): TsDeclClass =
    rewriter(x.tparams, providedTParams)
      .fold(x)(rws => new TypeRewriter(x).visitTsDeclClass(rws)(x).copy(tparams = Empty))

  def apply(x: TsDeclTypeAlias, providedTParams: IArray[TsType]): TsDeclTypeAlias =
    rewriter(x.tparams, providedTParams)
      .fold(x)(rws => new TypeRewriter(x).visitTsDeclTypeAlias(rws)(x).copy(tparams = Empty))

  def apply(x: TsFunSig, providedTParams: IArray[TsType]): TsFunSig =
    rewriter(x.tparams, providedTParams).fold(x)(rws => new TypeRewriter(x).visitTsFunSig(rws)(x).copy(tparams = Empty))

  /* A function in scala cannot have type parameters, so we inline them with their defaults or upper bounds */
  def inlineTParams(sig: TsFunSig): TsFunSig = {
    def recursiveBound(name: TsIdent, b: TsType): Boolean =
      TsTreeTraverse.collect(b) { case `name` => name }.nonEmpty

    val defaulted = sig.tparams.map { tp =>
      tp.default.orElse(tp.upperBound) match {
        case Some(b) if !recursiveBound(tp.name, b) => b
        case _                                      => TsTypeRef.any
      }
    }

    /* Handle when type parameters reference each other */
    val replacements: Map[TsType, TsType] =
      sig.tparams
        .zip(defaulted)
        .map {
          case (TsTypeParam(_, name, _, _), tpe) => TsTypeRef(name) -> tpe
        }
        .toMap

    val rewritten = defaulted.map(tpe => new ts.transforms.TypeRewriter(sig).visitTsType(replacements)(tpe))

    FillInTParams(sig, rewritten)
  }

  private def rewriter(
      expectedTParams: IArray[TsTypeParam],
      providedTParams: IArray[TsType],
  ): Option[Map[TsType, TsType]] =
    if (expectedTParams.isEmpty) None
    else {
      val rewrites: Map[TsType, TsType] =
        expectedTParams.zipWithIndex.map {
          case (TsTypeParam(_, expected, _, default), idx) =>
            val provided =
              if (providedTParams.lengthCompare(idx) > 0) providedTParams(idx)
              else
                default.getOrElse(
                  TsTypeRef.any.copy(comments = Comments(Comment.warning(s"${expected.value} not provided"))),
                )

            TsTypeRef(expected) -> provided
        }.toMap

      Some(rewrites)
    }
}
