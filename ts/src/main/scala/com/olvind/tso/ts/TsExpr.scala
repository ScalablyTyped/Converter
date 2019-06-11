package com.olvind.tso
package ts

sealed trait TsExpr

object TsExpr {
  val Default = TsTypeUnion.simplified(List(TsTypeRef.string, TsTypeRef.number))

  case class Ref(value:     TsTypeRef) extends TsExpr
  case class Literal(value: TsLiteral) extends TsExpr
  case class Call(function: TsExpr, params: List[TsExpr]) extends TsExpr
  case class Unary(op:      String, expr: TsExpr) extends TsExpr
  case class BinaryOp(one:  TsExpr, op: String, two: TsExpr) extends TsExpr

  def format(expr: TsExpr): String =
    expr match {
      case Ref(value)                       => TsTypeFormatter(value)
      case Literal(TsLiteralString(value))  => stringUtils.quote(value)
      case Literal(TsLiteralNumber(value))  => value
      case Literal(TsLiteralBoolean(value)) => value.toString
      case Call(function, params)           => s"${format(function)}(${params map format mkString ", "})"
      case Unary(op, expr)                  => s"$op${format(expr)}"
      case BinaryOp(one, op, two)           => s"${format(one)} $op ${format(two)}"
    }

  def typeOf(expr: TsExpr): TsType =
    expr match {
      case Ref(value)        => value
      case Literal(lit)      => TsTypeLiteral(lit)
      case Call(_, _)        => TsTypeRef.any
      case Unary(_, e)       => widen(typeOf(e))
      case BinaryOp(e, _, _) => widen(typeOf(e))
    }

  def typeOfOpt(exprOpt: Option[TsExpr]): TsType =
    exprOpt match {
      case Some(expr) => typeOf(expr)
      case None       => Default
    }

  def widen(tpe: TsType): TsType =
    tpe match {
      case TsTypeLiteral(TsLiteralString(_))  => TsTypeRef.string
      case TsTypeLiteral(TsLiteralNumber(_))  => TsTypeRef.number
      case TsTypeLiteral(TsLiteralBoolean(_)) => TsTypeRef.boolean
      case _                                  => Default
    }
}
