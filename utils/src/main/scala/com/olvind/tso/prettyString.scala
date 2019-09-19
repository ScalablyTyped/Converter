package com.olvind.tso

trait PrettyString {
  def prettifyName(value: String, suffix: String, forceCamelCase: Boolean): String

  def nameFor(underlying: String): String
}

/**
  * This PrettyString class tries to do a maximum simplification, removing src, dist, bin as well as extra "Dash"
  */
object SimplifyingPrettyString extends PrettyString {
  def prettifyName(value: String, suffix: String, forceCamelCase: Boolean): String =
    value
      .flatMap {
        case '\\'  => "#backslash#" //be safe
        case '.'   => "#dot#" // doesn't work in sbt/maven/ivy somewhere
        case '_'   => "#underscore#" // will be erased otherwise
        case '@'   => "#at#"
        case '$'   => "#dollar#"
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

  /* This is used for translating what was originally strings, so much more free form.
   *  We rely more on escaping with ` here
   */
  def nameFor(underlying: String): String = {
    val base =
      stringUtils unquote underlying flatMap {
        case '.'   => "DOT"
        case '`'   => "BACKTICK"
        case '\\'  => "BACKSLASH"
        case '$'   => "DOLLAR"
        case other => other.toString
      }

    base match {
      case "_"       => "Underscore"
      case "^"       => "`^`" // todo: think this might be solved in the printer
      case ""        => "Empty"
      case "Empty"   => "Empty_"
      case "package" => "PACKAGE"
      case "js"      => "JS"
      case "scala"   => "SCALA"
      case other     => other
    }
  }
}

object RegularPrettyString extends PrettyString {
  def prettifyName(value: String, suffix: String, forceCamelCase: Boolean): String =
    value
      .flatMap {
        case '\\'  => "#backslash#" //be safe
        case '.'   => "#dot#" // doesn't work in sbt/maven/ivy somewhere
        case '_'   => "#underscore#" // will be erased otherwise
        case '@'   => "#at#"
        case '$'   => "#dollar#"
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

  /* This is used for translating what was originally strings, so much more free form.
   *  We rely more on escaping with ` here
   */
  def nameFor(underlying: String): String = {
    val base =
      stringUtils unquote underlying flatMap {
        case '.'   => "DOT"
        case '`'   => "BACKTICK"
        case '\\'  => "BACKSLASH"
        case '$'   => "DOLLAR"
        case other => other.toString
      }

    base match {
      case "_"       => "Underscore"
      case "^"       => "`^`" // todo: think this might be solved in the printer
      case ""        => "Empty"
      case "package" => "PACKAGE"
      case "js"      => "JS"
      case "scala"   => "SCALA"
      case other     => other
    }
  }
}
