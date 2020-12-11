package org.scalablytyped.converter.internal
package ts
package parser

import scala.collection.immutable.HashSet
import scala.util.parsing.combinator._
import scala.util.parsing.combinator.lexical._
import scala.util.parsing.combinator.token._
import scala.util.parsing.input.CharArrayReader.EofCh
import scala.util.parsing.input.CharSequenceReader

object TsLexer extends Lexical with StdTokens with ParserHelpers with ImplicitConversions {

  sealed trait CommentToken extends Token {
    def chars: String
  }
  final case class CommentLineToken(chars:  String) extends CommentToken
  final case class CommentBlockToken(chars: String) extends CommentToken

  final case class DirectiveToken(name: String, key: String, value: String) extends Token {
    override def chars: String = s"$name $key=$value"
  }
  final case class Shebang(chars: String) extends Token

  implicit def FromString[T](p: Parser[T]): String => ParseResult[T] =
    (str: String) => p.apply(new CharSequenceReader(str))

  // format: off

  /** The set of reserved identifiers: these will be returned as `Keyword`s */
  val keywords = HashSet(
    "abstract", "as", "asserts", "break", "case", "catch", "class", "const", "continue", "debugger",
    "declare", "default", "delete", "do", "else", "enum", "export", "extends", "false",
    "finally", "for", "from", "function", "global", "if", "implements", "import", "in",
    "instanceof", "infer", "interface", "is", "keyof", "let", "module", "namespace", "never",
    "new", "null", "package", "private", "protected", "public", "readonly", "require", "return",
    "static", "super", "symbol", "switch", "this", "throw", "true", "try", "type", "typeof", "undefined",
    "unique", "var", "void", "while", "with", "yield",
  )

  val shebang = '#' ~ '!' ~ chrExcept('\n', EofCh).+ ^^ {
    case hash ~ exclamation ~ rest => Shebang(hash.toString + exclamation.toString + chars2string(rest))
  }

  val hexDigit: Parser[Int] =
    accept("hex digit", {
      case c @ ('0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9') => c - '0'
      case c @ ('A' | 'B' | 'C' | 'D' | 'E' | 'F')                         => c - 'A' + 10
      case c @ ('a' | 'b' | 'c' | 'd' | 'e' | 'f')                         => c - 'a' + 10
    })

  // format: on

  val pseudoChar: Parser[Char] = {
    '\\' ~> (
      'x' ~> hexDigit ~ hexDigit ^^ { case d1 ~ d0 => (16 * d1 + d0).toChar } |
        'u' ~> hexDigit ~ hexDigit ~ hexDigit ~ hexDigit ^^ {
          case d3 ~ d2 ~ d1 ~ d0 =>
            (4096 * d3 + 256 * d2 + 16 * d1 + d0).toChar
        } |
        elem("", _ => true) ^^ {
          case '0' => '\u0000'
          case 'b' => '\u0008'
          case 't' => '\u0009'
          case 'n' => '\u000A'
          case 'v' => '\u000B'
          case 'f' => '\u000C'
          case 'r' => '\u000D'
          case c   => c // including ' " \
        }
    )
  }

  val identifier: Parser[Token] = {
    // legal identifier chars
    def isIdentifierStart(c: Char): Boolean =
      c === '$' || c === '_' || c === '#' || c.isUnicodeIdentifierStart

    def isIdentifierPart(c: Char): Boolean =
      c === '$' || c.isUnicodeIdentifierPart

    val identifierStart: Parser[Char] =
      elem("", isIdentifierStart) | (pseudoChar.filter(isIdentifierStart))

    val identifierPart: Parser[Char] =
      elem("", isIdentifierPart) | (pseudoChar.filter(isIdentifierPart))

    stringOf1(identifierStart, identifierPart).filter(_ != "#") ^^ { x =>
      if (keywords contains x) Keyword(x) else Identifier(x)
    }
  }

  val numericLiteral: Parser[NumericLit] = {
    val hexNumericLiteral: Parser[NumericLit] =
      '0' ~> (Parser('x') | 'X') ~> stringOf1(
        digit | 'a' | 'A' | 'b' | 'B' | 'c' | 'C' | 'd' | 'D' | 'e' | 'E' | 'f' | 'F',
      ) ^^ (s => NumericLit("0x" + s))

    val decimal = stringOf1(digit | '.' | '-' | 'e') <~ 'n'.? ^^ NumericLit // yeah yeah, good enough for us

    hexNumericLiteral | decimal.filter(_.chars.exists(_.isDigit))
  }

  val stringLiteral: Parser[StringLit] = {
    def inQuoteChar(quoteChar: Char): Parser[Char] =
      chrExcept('\\', quoteChar, EofCh) | pseudoChar

    def quoted(quoteChar: Char): Parser[String] =
      quoteChar ~> stringOf(inQuoteChar(quoteChar)) <~ quoteChar

    (quoted('\"') | quoted('\'') | quoted('`')) ^^ StringLit
  }

  val delim: Parser[Keyword] = {
    /* construct parser for delimiters by |'ing together the parsers for the
     * individual delimiters, starting with the longest one -- otherwise a
     * delimiter D will never be matched if there is another delimiter that is
     * a prefix of D
     */
    def parseDelim(s: String): Parser[Keyword] =
      accept(s.toList) ^^ (_ => Keyword(s))

    /** The set of delimiters (ordering does not matter) */
    // format: off
    val delimiters = List(
      "{", "}", "(", ")", "[", "]", "<", ">",
      ".", ";", ",", "?", ":", "=", "|", "&", "*", "+", "-", "^", "/", "%",
      // TypeScript-specific
      "...", "=>", "-?", "+?", "-readonly",
    )
    // format: on
    delimiters
      .sortBy(_.length)
      .map(parseDelim)
      .foldRight(failure("no matching delimiter"): Parser[Keyword])((x, y) => y | x)
  }

  private val newLine: Parser[Char] =
    ('\r'.? ~> '\n') | ('\r') ^^ (_ => '\n')

  /** A character-parser that matches a white-space character (and returns it).
    * We dont ignore newlines */
  override val whitespaceChar: Parser[Char] = {
    elem("space char", ch => ch <= ' ' && ch != EofCh && ch != '\n' && ch != '\r')
  }

  override val whitespace: Parser[Any] =
    (whitespaceChar | '\uFEFF' | '\uFFFE' | '\u00a0').*.named("whitespace")

  val directive: Parser[DirectiveToken] = {
    val quote: Parser[Char] =
      ('\'': Parser[Char]) | '"'

    val asd: Parser[List[Char] ~ List[Char] ~ List[Char]] =
      '/' ~> '/' ~> '/' ~> whitespace.? ~> '<' ~> chrExcept(' ').* ~ (' ' ~> chrExcept('=').* <~ '=' <~ quote) ~ chrExcept(
        '"',
        '\'',
      ).* <~ quote <~ ' '.? <~ '/' <~ '>'

    asd ^^ {
      case c1 ~ c2 ~ c3 =>
        DirectiveToken(chars2string(c1), chars2string(c2), chars2string(c3))
    }
  }

  val comment: Parser[CommentToken] = {
    val oneLine: Parser[CommentLineToken] =
      (whitespaceChar.* ~ '/' ~ '/' ~ rep(chrExcept(EofCh, '\n', '\r'))) ^^ {
        case cs1 ~ c1 ~ c2 ~ cs2 =>
          CommentLineToken(s"${chars2string(cs1)}$c1$c2${chars2string(cs2)}\n")
      }

    val block: Parser[CommentBlockToken] =
      (whitespaceChar.* ~ '/' ~ '*' ~ rep(not('*' ~ '/') ~> chrExcept(EofCh)) ~ '*' ~ '/' ~ whitespaceChar.* ~ newLine.*) ^^ {
        case cs1 ~ c1 ~ c2 ~ cs2 ~ c3 ~ c4 ~ cs3 ~ cs4 =>
          CommentBlockToken(
            s"${chars2string(cs1)}$c1$c2${chars2string(cs2)}$c3$c4${chars2string(cs3)}${chars2string(cs4)}"
              .replaceAll("\r", ""),
          )
      }

    not(directive) ~> oneLine | block
  }

  override val token: Parser[Token] = {
    val base = identifier | directive | comment | numericLiteral | stringLiteral | delim | shebang | EofCh ^^^ EOF

    val ignore = (newLine | whitespaceChar).*

    (ignore ~> base <~ ignore) | failure("illegal character").named("token")
  }
}
