package com.olvind.tso

import ammonite.ops.Path
import org.scalatest.Assertion
import org.scalatest.Matchers._

import scala.util.parsing.combinator.Parsers

object ParserHarness {
  implicit final class Forcer[T](res: Parsers#ParseResult[T]) {
    def force: T =
      res getOrElse sys.error(
        "Parse error at %s\n".format(res.next.pos.toString) +
          res.asInstanceOf[Parsers#NoSuccess].msg + "\n" +
          res.next.pos.longString
      )
  }

  def withTsFile[T](resourceName: String)(f: String => T): T =
    f(files content InFile(Path(getClass.getResource(s"/$resourceName").getFile)))

  def parseAs[T](input: String, parser: String => Parsers#ParseResult[T]): T =
    parser(input).force

  def notParse[T](input: String, parser: String => Parsers#ParseResult[T]): Unit = {
    val res = parser(input)
    if (res.isEmpty) () else sys.error(s"$input should not have parsed")
  }

  def shouldParseAs[T](input: String, parser: String => Parsers#ParseResult[T])(expected: T): Assertion =
    parseAs(input, parser) should equal(expected)
}
