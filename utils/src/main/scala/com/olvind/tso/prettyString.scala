package com.olvind.tso

/* I'm sure we can discuss how pretty it is, but at least try to do it consistently */
object prettyString {
  def apply(value: String, suffix: String, forceCamelCase: Boolean): String =
    value
      .flatMap {
        case '\\'  => "#backslash#" //be safe
        case '.'   => "#dot#" // doesn't work in sbt/maven/ivy somewhere
        case '_'   => "#underscore#" // will be erased otherwise
        case '@'   => "#at#"
        case '-'   => "#dash#" //causes `` in scala code
        case other => other.toString()
      }
      .split("[#/]")
      .filterNot(_.isEmpty)
      .zipWithIndex
      .map[String, Array[String]] {
        case (x, 0) => if (forceCamelCase) stringUtils.unCapitalize(x) else x
        case (x, _) => x.capitalize
      }
      .mkString("", "", suffix)
}
