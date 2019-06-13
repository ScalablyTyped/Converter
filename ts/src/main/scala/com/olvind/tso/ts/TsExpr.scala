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
      case Ref(value)                      => TsTypeFormatter(value)
      case Literal(TsLiteralString(value)) => stringUtils.quote(value)
      case Literal(TsLiteralNumber(value)) =>
        if (value.toLong > Int.MaxValue) value + ".0" // long's wont work in scala.js, so we'll just YOLO this
        else value
      case Literal(TsLiteralBoolean(value)) => value.toString
      case Call(function, params)           => s"${format(function)}(${params map format mkString ", "})"
      case Unary(op, expr)                  => s"$op${format(expr)}"
      case BinaryOp(one, op, two)           => s"${format(one)} $op ${format(two)}"
    }

  def typeOf(expr: TsExpr): TsType =
    expr match {
      case Ref(value)   => Default
      case Literal(lit) => TsTypeLiteral(lit)
      case Call(_, _)   => TsTypeRef.any
      case Unary(_, e)  => widen(typeOf(e))
      case BinaryOp(e1, op, e2) =>
        (typeOf(e1), op, typeOf(e2)) match {
          case (TsTypeLiteral(TsLiteralNumber(n1)), "+", TsTypeLiteral(TsLiteralNumber(n2))) =>
            TsTypeLiteral(TsLiteralNumber((n1.toLong + n2.toLong).toString))
          case (TsTypeLiteral(TsLiteralNumber(n1)), "*", TsTypeLiteral(TsLiteralNumber(n2))) =>
            TsTypeLiteral(TsLiteralNumber((n1.toLong * n2.toLong).toString))
          case (TsTypeLiteral(TsLiteralNumber(n1)), "<<", TsTypeLiteral(TsLiteralNumber(n2))) =>
            TsTypeLiteral(TsLiteralNumber((n1.toInt << n2.toInt).toString))
          case (TsTypeLiteral(TsLiteralNumber(n1)), ">>", TsTypeLiteral(TsLiteralNumber(n2))) =>
            TsTypeLiteral(TsLiteralNumber((n1.toInt >> n2.toInt).toString))
          case (t, _, _) => widen(t)
        }
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
      case TsTypeRef.string                   => TsTypeRef.string
      case TsTypeRef.number                   => TsTypeRef.number
      case _                                  => Default
    }

  def visit(e: TsExpr)(f: TsExpr => TsExpr): TsExpr =
    f(e match {
      case x: Ref     => x
      case x: Literal => x
      case Call(function, params) => Call(visit(function)(f), params.map(p => visit(p)(f)))
      case Unary(op, expr)        => Unary(op, visit(expr)(f))
      case BinaryOp(one, op, two) => BinaryOp(visit(one)(f), op, visit(two)(f))
    })
}
