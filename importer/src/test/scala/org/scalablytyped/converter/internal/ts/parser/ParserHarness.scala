package org.scalablytyped.converter.internal.ts.parser

import org.scalablytyped.converter.internal.{files, InFile}
import org.scalatest.Assertion
import org.scalatest.matchers.should.Matchers._

import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.CharSequenceReader

object ParserHarness {
  implicit final class Forcer[T](res: Parsers#ParseResult[T]) {
    def force: T =
      res.getOrElse(
        sys.error(
          "Parse error at %s\n".format(res.next.pos.toString) +
            res.asInstanceOf[Parsers#NoSuccess].msg + "\n" +
            res.next.pos.longString,
        ),
      )
  }

  implicit def UseLexerParser[T](p: TsLexer.Parser[T]): String => Parsers#ParseResult[T] =
    (str: String) => {
      val str1 = cleanedString(str)
      p(new CharSequenceReader(str1))
    }

  /** enable direct use of parsers with strings * */
  implicit def UseParserParser[T](p: TsParser.Parser[T]): String => Parsers#ParseResult[T] =
    (str: String) => {
      val str1 = cleanedString(str)
      TsParser.phrase(p)(new TsParser.lexical.Scanner(str1))
    }

  def withTsFile[T](resourceName: String)(f: String => T): T =
    f(files.content(InFile(os.Path(getClass.getResource(s"/$resourceName").getFile))))

  def parseAs[T](input: String, parser: String => Parsers#ParseResult[T]): T =
    parser(input).force

  def notParse[T](input: String, parser: String => Parsers#ParseResult[T]): Unit = {
    val res = parser(input)
    if (res.isEmpty) () else sys.error(s"$input should not have parsed")
  }

  def shouldParseAs[T](input: String, parser: String => Parsers#ParseResult[T])(expected: T): Assertion =
    parseAs(input, parser) should equal(expected)
}
