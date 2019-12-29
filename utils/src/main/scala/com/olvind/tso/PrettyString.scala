package com.olvind.tso

trait PrettyString {
  def apply(value: String, suffix: String, forceCamelCase: Boolean): String
}

object PrettyString {

  /**
    * This PrettyString class tries to do a maximum simplification, removing src, dist, bin as well as extra "Dash"
    */
  val Simplifying: PrettyString = {
    val shouldIgnore = Set("src", "dist", "bin")
    (value, suffix, forceCamelCase) =>
      value
        .flatMap {
          case '.'   => "#dot#"
          case '_'   => "#"
          case '@'   => "#at#"
          case '-'   => "#"
          case other => other.toString()
        }
        .split("[#/]")
        .filterNot(shouldIgnore)
        .filterNot(_.isEmpty)
        .zipWithIndex
        .map {
          case (x, 0) => if (forceCamelCase) stringUtils.unCapitalize(x) else x
          case (x, _) => x.capitalize
        }
        .mkString("", "", suffix)
  }

  val Regular: PrettyString = (value, suffix, forceCamelCase) =>
    value
      .flatMap {
        case '.'   => "#dot#" // doesn't work in sbt/maven/ivy somewhere
        case '_'   => "#underscore#" // will be erased otherwise
        case '@'   => "#at#"
        case '-'   => "#dash#" //causes `` in scala code
        case other => other.toString()
      }
      .split("[#/]")
      .filterNot(_.isEmpty)
      .zipWithIndex
      .map {
        case (x, 0) => if (forceCamelCase) stringUtils.unCapitalize(x) else x
        case (x, _) => x.capitalize
      }
      .mkString("", "", suffix)

}
