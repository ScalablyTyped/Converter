package org.scalablytyped.converter.internal

import java.io.{StringWriter, Writer}
import java.util.Locale

/* Borrowed from org/apache/commons/lang/StringEscapeUtils.java */
object EscapeStrings {
  def java(str: String): String = {
    val writer = new StringWriter(str.length * 2)
    go(writer, str, escapeSingleQuote = false, escapeForwardSlash = false)
    writer.toString
  }

  def javaScript(str: String): String = {
    val writer = new StringWriter(str.length * 2)
    go(writer, str, escapeSingleQuote = true, escapeForwardSlash = true)
    writer.toString
  }

  /**
    * @param out                write to receieve the escaped string
    * @param str                String to escape values in, may be null
    * @param escapeSingleQuote  escapes single quotes if <code>true</code>
    */
  private def go(out: Writer, str: String, escapeSingleQuote: Boolean, escapeForwardSlash: Boolean): Unit = {
    var i = 0
    while (i < str.length) {
      val ch = str.charAt(i)

      // handle unicode
      if (ch > 0xfff) out.write("\\u" + hex(ch))
      else if (ch > 0xff) out.write("\\u0" + hex(ch))
      else if (ch > 0x7f) out.write("\\u00" + hex(ch))
      else if (ch < 32) ch match {
        case '\b' =>
          out.write('\\')
          out.write('b')
        case '\n' =>
          out.write('\\')
          out.write('n')
        case '\t' =>
          out.write('\\')
          out.write('t')
        case '\f' =>
          out.write('\\')
          out.write('f')
        case '\r' =>
          out.write('\\')
          out.write('r')
        case _ =>
          if (ch > 0xf) out.write("\\u00" + hex(ch))
          else out.write("\\u000" + hex(ch))
      }
      else
        ch match {
          case '\'' =>
            if (escapeSingleQuote) out.write('\\')
            out.write('\'')
          case '"' =>
            out.write('\\')
            out.write('"')
          case '\\' =>
            out.write('\\')
            out.write('\\')
          case '/' =>
            if (escapeForwardSlash) out.write('\\')
            out.write('/')
          case _ =>
            out.write(ch.toInt)
        }

      i += 1
    }
  }

  /**
    * <p>Returns an upper case hexadecimal <code>String</code> for the given
    * character.</p>
    *
    * @param ch The character to convert.
    * @return An upper case hexadecimal <code>String</code>
    */
  def hex(ch: Char): String =
    Integer.toHexString(ch.toInt).toUpperCase(Locale.ENGLISH)
}
