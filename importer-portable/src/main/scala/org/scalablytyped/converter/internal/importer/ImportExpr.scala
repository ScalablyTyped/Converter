package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.{ExprTree, QualifiedName}
import org.scalablytyped.converter.internal.ts._

class ImportExpr(importType: ImportType, importName: AdaptiveNamingImport) {
  def apply(tsExpr: TsExpr, scope: TsTreeScope): ExprTree =
    tsExpr match {
      case TsExpr.Ref(value) =>
        ExprTree.Ref(importName(value))

      case TsExpr.Literal(value) =>
        value match {
          case TsLiteral.Num(value)  => ImportType.numberToExpr(value)
          case TsLiteral.Str(value)  => ImportType.stringToExpr(value)
          case TsLiteral.Bool(value) => ExprTree.BooleanLit(value)
        }
      case TsExpr.Cast(expr, tpe) =>
        ExprTree.Cast(apply(expr, scope), importType(scope, importName)(tpe))
      case TsExpr.ArrayOf(expr) =>
        ExprTree.Call(ExprTree.Ref(QualifiedName.JsArray), IArray(IArray(apply(expr, scope))))
      case TsExpr.Call(function, params) =>
        ExprTree.Call(apply(function, scope), IArray(params.map(p => apply(p, scope))))
      case TsExpr.Unary(op, expr) =>
        ExprTree.Unary(op, apply(expr, scope))
      case TsExpr.BinaryOp(one, op, two) =>
        ExprTree.BinaryOp(apply(one, scope), op, apply(two, scope))
    }
}
