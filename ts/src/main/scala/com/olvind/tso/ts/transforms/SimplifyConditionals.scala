package com.olvind.tso
package ts
package transforms

/**
  * Rudimentary support for conditional types
  */
object SimplifyConditionals extends TreeTransformationScopedChanges {
  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case x: TsTypeConditional => simplify(x)
      case other => other
    }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  /**
    * TsTypeUnion.simplified simplifies a set of types into a union types, a normal type, or `never`.
    *    The latter is the least useful, so let's rewrite it to any
    */
  def unify(types: Seq[TsType]): TsType =
    TsTypeUnion.simplified(types filterNot toIgnore) match {
      case TsTypeRef.never => TsTypeRef.any
      case other           => other
    }

  def simplify(x: TsTypeConditional): TsType = {
    /* It's common to nest these things, so handle that */
    def go(x: TsType): List[TsType] =
      x match {
        case xx: TsTypeConditional =>
          val types: List[TsType] =
            go(xx.ifFalse) ::: go(xx.ifTrue)

          lazy val inferredNames: Seq[TsIdent] =
            TreeTraverse.collect(xx.pred) { case TsTypeInfer(tp) => tp.name }

          lazy val inferAny: TsType => TsType = {
            val rewrites: Map[TsType, TsType] =
              Map(inferredNames.map(ident => TsTypeRef.of(ident) -> TsTypeRef.any): _*)

            new ts.transforms.TypeRewriter(x).visitTsType(rewrites)
          }

          types map inferAny

        case other => other :: Nil
      }

    unify(go(x))
  }
}
