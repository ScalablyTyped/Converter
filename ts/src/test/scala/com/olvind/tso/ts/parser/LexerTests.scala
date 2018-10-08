package com.olvind.tso
package ts.parser

import org.scalatest._

final class LexerTests extends FunSuite with Matchers {
  import ParserHarness._

  test("numbers") {
    Set("-1", "0", "1", "10", "999", "9", "0x42", "042", "-1.1", "0.1", "999.999", "0.000000", "0xAC") foreach (
        str => shouldParseAs(str, TsLexer.numericLiteral)(TsLexer.NumericLit(str))
    )
  }

  test("comment") {
    shouldParseAs("//A", TsLexer.comment)(
      TsLexer.CommentLineToken("//A\n")
    )
  }
}
