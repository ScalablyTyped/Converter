package org.scalablytyped.converter.internal.ts.parser

import scala.util.parsing.combinator.Parsers

trait ParserHelpers { self: Parsers =>

  @inline protected final implicit class ToParserOps[P](private val p: P) {
    def isDefined[Q](implicit ev: P => Parser[Q]): Parser[Boolean] =
      p.? ^^ (_.isDefined)
  }

  def rep1sepTrail[T](t: Parser[T], sep: Parser[Any]): Parser[List[T]] =
    rep1sep(t, sep) <~ opt(sep)

  def chars2string(chars: Seq[Char]): String =
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
