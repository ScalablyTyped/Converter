package com.olvind.tso
package ts

import com.olvind.tso.ts.transforms.TypeRewriter

/**
  * For instance: `x: class Foo&lt;T&gt;` and `providedTParams: T = number` => `Foo&lt;number&gt;`
  * Includes all members
  */
object FillInTParams {
  def apply(x: TsDeclInterface, providedTParams: Seq[TsType]): TsDeclInterface =
    rewriter(x.tparams, providedTParams)
      .fold(x)(rws => new TypeRewriter(x).visitTsDeclInterface(rws)(x).copy(tparams = Nil))

  def apply(x: TsDeclClass, providedTParams: Seq[TsType]): TsDeclClass =
    rewriter(x.tparams, providedTParams)
      .fold(x)(rws => new TypeRewriter(x).visitTsDeclClass(rws)(x).copy(tparams = Nil))

  def apply(x: TsDeclTypeAlias, providedTParams: Seq[TsType]): TsDeclTypeAlias =
    rewriter(x.tparams, providedTParams)
      .fold(x)(rws => new TypeRewriter(x).visitTsDeclTypeAlias(rws)(x).copy(tparams = Nil))

  def apply(x: TsFunSig, providedTParams: Seq[TsType]): TsFunSig =
    rewriter(x.tparams, providedTParams).fold(x)(rws => new TypeRewriter(x).visitTsFunSig(rws)(x).copy(tparams = Nil))

  private def rewriter(expectedTParams: Seq[TsTypeParam], providedTParams: Seq[TsType]): Option[Map[TsType, TsType]] =
    if (expectedTParams.isEmpty) None
    else {
      val rewrites: Map[TsType, TsType] =
        expectedTParams.zipWithIndex.map {
          case (TsTypeParam(_, expected, _, default), idx) =>
            val provided =
              if (providedTParams.lengthCompare(idx) > 0) providedTParams(idx)
              else default getOrElse sys.error("Type parameter not provided")

            TsTypeRef(TsQIdent(List(expected)), Nil) -> provided
        }.toMap

      /* in case the type params refer to each other. This is probably not perfect, but it was quick to write */
      val rw2 = rewrites.map {
        case (k, v) => (k, new TypeRewriter(v).visitTsType(rewrites)(v))
      }

      Some(rw2)
    }
}
