package com.olvind.tso
package scalajs

object ScalaNameEscape {
  def apply(ident: String): String =
    ident match {
      case i if i.isEmpty        => "Empty"
      case i if needsEscaping(i) =>
        /* can't just escape these with backticks */
        val patched = i
          .replaceAllLiterally("`", "_backtick")
          .replaceAllLiterally("'", "_quote")
          .replaceAllLiterally("\\n", "_newline")
          .replaceAllLiterally("\\b", "_backslash_b")

        if (needsEscaping(patched)) "`" + patched + "`" else patched
      case i => i
    }

  def isValidIdentifier(name: String): Boolean = {
    val c = name.head
    (c === '$' || c === '_' || c.isUnicodeIdentifierStart) &&
    name.tail.forall(c => c === '$' || c.isUnicodeIdentifierPart)
  }

  def requireValidIdent(name: String): Unit =
    require(isValidIdentifier(name), s"$name is not a valid identifier")

  def needsEscaping(ident: String): Boolean =
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
      "extends",
      "false",
      "final",
      "finally",
      "for",
      "forSome",
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
      "@"
    )

}
