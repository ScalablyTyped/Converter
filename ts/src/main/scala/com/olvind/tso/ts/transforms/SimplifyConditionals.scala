package com.olvind.tso
package ts
package transforms

/**
  * Rudimentary support for conditional types
  */
object SimplifyConditionals extends TreeTransformationScopedChanges {
  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case x: TsTypeConditional => inferAny(x)
      case other => other
    }

  def inferAny(x: TsTypeConditional): TsType = {
    /* It's common to nest these things, so handle that */
    def go(x: TsType): TsType =
      x match {
        case xx: TsTypeConditional =>
          lazy val inferredNames: Seq[TsIdent] =
            TsTreeTraverse.collect(xx.pred) { case TsTypeInfer(tp) => tp.name }

          lazy val inferAny: TsType => TsType = {
            val rewrites: Map[TsType, TsType] =
              Map(inferredNames.map(ident => TsTypeRef.of(ident) -> TsTypeRef.any): _*)

            new ts.transforms.TypeRewriter(x).visitTsType(rewrites)
          }
          TsTypeConditional(xx.pred, go(inferAny(xx.ifTrue)), go(inferAny(xx.ifFalse)))

        case other => other
      }

    go(x)
  }
}
