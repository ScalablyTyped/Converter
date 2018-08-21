package com.olvind.tso

object stringUtils {
  val Quote = '"'

  def quote(s: String): String =
    s"$Quote$s$Quote"

  def unquote(s: String): String =
    s.replaceAllLiterally(Quote.toString, "")

  /**
    * pff, scala apparently cares about nested comments, especially when theyre not balanced
    */
  def escapeNestedComments(s: String): String =
    (s.indexOf("/*"), s.lastIndexOf("*/")) match {
      case (-1, _) => s
      case (_, -1) => s
      case (start, end) =>
        val `/*` = s.substring(0, start + 2)
        val `*/` = s.substring(end)
        val escaped =
          s.substring(start + 2, end).replaceAll("/\\*", "/ *").replaceAll("\\*/", "* /")
        `/*` + escaped + `*/`
    }

  /**
    * Apparently scala cares and typescript doesn't
    */
  def escapeUnicodeEscapes(s: String): String =
    s.replaceAll("\\\\u", "\\\\\\\\u")
}
