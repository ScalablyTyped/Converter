package org.scalablytyped.converter.internal
package ts.parser

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class LexerTests extends AnyFunSuite with Matchers {
  import ParserHarness._

  test("numbers") {
    Set("-1", "0", "1", "10", "999", "9", "0x42", "042", "-1.1", "0.1", "999.999", "0.000000", "0xAC") foreach (
        str =>
          shouldParseAs(str, TsLexer.numericLiteral)(TsLexer.NumericLit(str)),
      )
  }

  test("comment") {
    shouldParseAs("//A", TsLexer.comment)(
      TsLexer.CommentLineToken("//A\n"),
    )
  }

  test("string literal") {
    shouldParseAs("`a`", TsLexer.stringLiteral)(
      TsLexer.StringLit("a"),
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
}
