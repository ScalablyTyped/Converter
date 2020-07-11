package org.scalablytyped.converter.internal
package ts
package transforms

object InferTypeFromExpr extends TreeTransformationScopedChanges {

  override def enterTsMemberProperty(t: TsTreeScope)(x: TsMemberProperty): TsMemberProperty =
    x match {
      case TsMemberProperty(_, _, _, None, Some(expr), _, _) => x.copy(tpe = Some(toType(expr)), expr = None)
      case other                                             => other
    }

  override def enterTsDeclVar(t: TsTreeScope)(x: TsDeclVar): TsDeclVar =
    x match {
      case TsDeclVar(_, _, _, _, None, Some(expr), _, _) => x.copy(tpe = Some(toType(expr)), expr = None)
      case other                                         => other
    }

  private def toType(expr: TsExpr) =
    TsExpr.widen(TsExpr.typeOf(expr)) match {
      case tr: TsTypeRef => tr.copy(comments = tr.comments + Comment(s"/* ${TsExpr.format(expr)} */ "))
      case other => other
    }
}
