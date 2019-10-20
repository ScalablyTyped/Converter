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
        case '-'   => "#" //causes `` in scala code
        case other => other.toString()
      }
      .split("[#/]")
      //Some paths names that are probably superfluous and just cause noise.
      .filter(!Set("src", "dist", "bin").contains(_))
      .filterNot(_.isEmpty)
      //Remove dupes, so that we don't have ugly things like ButtonButton
      //      .foldLeft(Array.empty[String])((acc, str) => if (acc.lastOption.fold(false)(_ == str)) acc else acc :+ str)
      .zipWithIndex
      .map[String, Array[String]] {
        case (x, 0) => if (forceCamelCase) stringUtils.unCapitalize(x) else x
        case (x, _) => x.capitalize
      }
      .mkString("", "", suffix)
}
