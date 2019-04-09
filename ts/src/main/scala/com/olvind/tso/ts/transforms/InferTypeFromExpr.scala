package com.olvind.tso
package ts
package transforms

object InferTypeFromExpr extends TreeTransformationScopedChanges {
  def commentFor(expr: TsExpr): Option[Comment] =
    expr match {
      case TsExpr.Ref(_)     => None
      case TsExpr.Literal(_) => None
      case other             => Some(Comment(s"/* Type inferred from expression ${TsExpr.format(other)} */ "))
    }

  override def enterTsMemberProperty(t: TsTreeScope)(x: TsMemberProperty): TsMemberProperty =
    x match {
      case TsMemberProperty(comments, _, _, None, Some(expr), _, _, _) =>
        x.copy(tpe = Some(TsExpr.typeOf(expr)), expr = None, comments = comments +? commentFor(expr))
      case other => other
    }

  override def enterTsDeclVar(t: TsTreeScope)(x: TsDeclVar): TsDeclVar =
    x match {
      case TsDeclVar(comments, _, _, _, None, Some(expr), _, _, _) =>
        x.copy(tpe = Some(TsExpr.typeOf(expr)), expr = None, comments = comments +? commentFor(expr))
      case other => other
    }
}
