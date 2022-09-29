package org.scalablytyped.converter.internal
package ts.parser

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class LexerTests extends AnyFunSuite with Matchers {
  import ParserHarness._

  test("numbers") {
    Set(
      "-1",
      "0",
      "1",
      "10",
      "999",
      "9",
      "0x42",
      "042",
      "-1.1",
      "0.1",
      "999.999",
      "0.000000",
      "0xAC",
      "0b0000000000000000000000000000001",
    ).foreach(str => shouldParseAs(str, TsLexer.numericLiteral)(TsLexer.NumericLit(str)))
  }

  test("comment") {
    shouldParseAs("//A", TsLexer.comment)(
      TsLexer.CommentLineToken("//A\n"),
    )
  }

  test("-readonly") {
    shouldParseAs("-readonly", TsLexer.token)(
      TsLexer.Keyword("-readonly"),
    )
  }

  test("...") {
    shouldParseAs("...", TsLexer.token)(
      TsLexer.Keyword("..."),
    )
  }

  test("#!/bin/bash") {
    shouldParseAs("#!/bin/bash", TsLexer.token)(
      TsLexer.Shebang("#!/bin/bash"),
    )
  }

  test("template") {
    shouldParseAs("`a`", TsLexer.stringTemplateLiteral)(
      TsLexer.StringTemplateLiteral(List(Left('a'))),
    )
    shouldParseAs("`a${'b'}c${d}`", TsLexer.stringTemplateLiteral)(
      TsLexer.StringTemplateLiteral(
        List(Left('a'), Right(List(TsLexer.StringLit("b"))), Left('c'), Right(List(TsLexer.Identifier("d")))),
      ),
    )
  }

  test("nested template strings") {
    val nested = TsLexer.StringTemplateLiteral(
      List(
        Left('b'),
        Right(List(TsLexer.Identifier("c"))),
      ),
    )
    shouldParseAs("`a${`b${c}`}`", TsLexer.stringTemplateLiteral)(
      TsLexer.StringTemplateLiteral(List(Left('a'), Right(List(nested)))),
    )
  }

  test("nested template strings (sample)") {
    val nested = TsLexer.StringTemplateLiteral(
      List(
        Left('['),
        Right(List(TsLexer.Identifier("Middle"))),
        Left(']'),
        Right(List(TsLexer.Identifier("Tail"))),
      ),
    )

    shouldParseAs("`${Head}.${FixPathSquareBrackets<`[${Middle}]${Tail}`>}`", TsLexer.stringTemplateLiteral)(
      TsLexer.StringTemplateLiteral(
        List(
          Right(List(TsLexer.Identifier("Head"))),
          Left('.'),
          Right(List(TsLexer.Identifier("FixPathSquareBrackets"), TsLexer.Keyword("<"), nested, TsLexer.Keyword(">"))),
        ),
      ),
    )
  }
}
