package org.scalablytyped.converter.internal
package ts.parser

import scala.util.parsing.combinator.Parsers

trait ParserHelpers { self: Parsers =>
  def upgrade[P <: AnyRef](p: Parser[List[P]]): Parser[IArray[P]] = p ^^ (ps => IArray.fromTraversable[P](ps))

  @inline protected final implicit class ToParserOps[P](private val p: P) {
    def isDefined[Q](implicit ev: P => Parser[Q]): Parser[Boolean] =
      p.? ^^ (_.isDefined)
  }

  @inline protected final implicit class ParserSyntax[P <: AnyRef](private val p: Parser[P]) {
    def ** : Parser[IArray[P]] = upgrade(rep(p))
  }

  def rep_[T <: AnyRef](p: => Parser[T]): Parser[IArray[T]] =
    upgrade(rep(p))

  def rep1_[T <: AnyRef](p: => Parser[T]): Parser[IArray[T]] =
    upgrade(rep1(p))

  def rep1sep_[T <: AnyRef](p: => Parser[T], q: => Parser[Any]): Parser[IArray[T]] =
    upgrade(rep1sep(p, q))

  def repsep_[T <: AnyRef](p: => Parser[T], q: => Parser[Any]): Parser[IArray[T]] =
    upgrade(repsep(p, q))

  def rep1sepTrail[T <: AnyRef](t: Parser[T], sep: Parser[Any]): Parser[IArray[T]] =
    rep1sep_(t, sep) <~ opt(sep)

  def chars2string(chars: List[Char]): String =
    new String(chars.toArray)

  def char2Int(c: Char): Int =
    c - '0'

  def stringOf(p: Parser[Char]): Parser[String] =
    rep(p) ^^ chars2string

  def stringOf1(p: Parser[Char]): Parser[String] =
    rep1(p) ^^ chars2string

  def stringOf1(first: Parser[Char], p: => Parser[Char]): Parser[String] =
    rep1(first, p) ^^ chars2string

  def tuple2[A, B](t: (A ~ B)): (A, B) = t match {
    case a ~ b => (a, b)
  }

  def either[L, R](l: Parser[L], r: Parser[R]): Parser[Either[L, R]] =
    l ^^ Left.apply | r ^^ Right.apply
}
