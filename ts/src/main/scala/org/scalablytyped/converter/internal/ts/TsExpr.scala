package org.scalablytyped.converter.internal
package ts

sealed trait TsExpr

object TsExpr {
  val Default = TsTypeUnion.simplified(IArray(TsTypeRef.string, TsTypeRef.number))

  case class Ref(value:     TsQIdent) extends TsExpr
  case class Literal(value: TsLiteral) extends TsExpr
  case class Call(function: TsExpr, params: IArray[TsExpr]) extends TsExpr
  case class Unary(op:      String, expr: TsExpr) extends TsExpr
  case class BinaryOp(one:  TsExpr, op: String, two: TsExpr) extends TsExpr
  case class Cast(expr:     TsExpr, tpe: TsType) extends TsExpr

  def format(expr: TsExpr): String =
    expr match {
      case Ref(value)                      => TsTypeFormatter.qident(value)
      case Literal(TsLiteralString(value)) => stringUtils.quote(value)
      case Literal(Num.Long(long)) =>
        if (long > Int.MaxValue) long + ".0" // long's wont work in scala.js, so we'll just YOLO this
        else long.toString
      case Literal(TsLiteralNumber(value))  => value
      case Literal(TsLiteralBoolean(value)) => value.toString
      case Call(function, params)           => s"${format(function)}(${params.map(format).mkString(", ")})"
      case Unary(op, expr)                  => s"$op${format(expr)}"
      case BinaryOp(one, op, two)           => s"${format(one)} $op ${format(two)}"
      case Cast(expr, tpe)                  => s"${format(expr)} as ${TsTypeFormatter(tpe)}"
    }

  object Num {
    def unapply(x: TsType): Option[BigDecimal] =
      x match {
        case TsTypeLiteral(Num(num)) => Some(num)
        case _                       => None
      }

    def unapply(x: TsLiteral): Option[BigDecimal] =
      x match {
        case TsLiteralNumber(value) if value.forall(c => c.isDigit || c === '.') => Some(BigDecimal(value))
        case _ => None
      }

    object Long {
      def unapply(x: TsType): Option[Long] =
        x match {
          case TsTypeLiteral(Long(long)) => Some(long)
          case _                         => None
        }
      def unapply(x: TsLiteral): Option[Long] =
        x match {
          case TsLiteralNumber(value) if value.forall(c => c.isDigit) => Some(value.toLong)
          case _ => None
        }
    }
  }

  def typeOf(expr: TsExpr): TsType =
    expr match {
      case Ref(_)       => Default
      case Literal(lit) => TsTypeLiteral(lit)
      case Call(_, _)   => TsTypeRef.any
      case Unary(_, e)  => widen(typeOf(e))
      case Cast(_, tpe) => tpe
      case BinaryOp(e1, op, e2) =>
        (typeOf(e1), op, typeOf(e2)) match {
          case (Num(n1), "+", Num(n2)) =>
            TsTypeLiteral(TsLiteralNumber((n1 + n2).toString))
          case (Num(n1), "*", Num(n2)) =>
            TsTypeLiteral(TsLiteralNumber((n1 * n2).toString))
          case (Num.Long(n1), "<<", Num.Long(n2)) =>
            TsTypeLiteral(TsLiteralNumber((n1 << n2).toString))
          case (Num.Long(n1), ">>", Num.Long(n2)) =>
            TsTypeLiteral(TsLiteralNumber((n1 >> n2).toString))
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
      case Cast(expr, tpe)        => Cast(visit(expr)(f), tpe)
      case Call(function, params) => Call(visit(function)(f), params.map(p => visit(p)(f)))
      case Unary(op, expr)        => Unary(op, visit(expr)(f))
      case BinaryOp(one, op, two) => BinaryOp(visit(one)(f), op, visit(two)(f))
    })
}
