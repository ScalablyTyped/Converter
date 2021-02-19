package org.scalablytyped.converter.internal
package scalajs

object ScalaNameEscape {
  def apply(ident: String): String =
    if (needsEscaping(ident)) "`" + ident + "`"
    else ident

  def isValidIdentifier(name: String): Boolean = {
    val c = name.head
    (c === '$' || c === '_' || c.isUnicodeIdentifierStart) &&
    name.tail.forall(c => c === '$' || c.isUnicodeIdentifierPart)
  }

  private def needsEscaping(ident: String): Boolean =
    ident match {
      case "^"                                             => false
      case str if str.isEmpty                              => true
      case str if str.endsWith("_=") && !str.contains("-") => false //lets say this is good enough
      case str if isScalaKeyword(str)                      => true
      case str                                             => !isValidIdentifier(str)
    }

  val isScalaKeyword: Set[String] =
    Set(
      "abstract",
      "case",
      "class",
      "catch",
      "def",
      "do",
      "else",
      "enum",
      "extends",
      "export",
      "extension",
      "false",
      "final",
      "finally",
      "for",
      "forSome",
      "given",
      "if",
      "implicit",
      "import",
      "inline",
      "lazy",
      "macro",
      "match",
      "new",
      "null",
      "object",
      "override",
      "package",
      "private",
      "protected",
      "return",
      "sealed",
      "super",
      "then", //not keyword but gives warning
      "this",
      "throw",
      "trait",
      "true",
      "try",
      "type",
      "using",
      "val",
      "var",
      "with",
      "while",
      "yield",
      ".",
      "_",
      ":",
      "=",
      "=>",
      "<-",
      "<:",
      "<%",
      ">:",
      "#",
      "@",
    )
}
