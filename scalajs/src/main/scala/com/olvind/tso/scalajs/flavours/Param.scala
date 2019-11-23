package com.olvind.tso
package scalajs
package flavours

final case class Param(parameter: ParamTree, asString: Either[String, String => String]) {
  def isOptional = parameter.default.isDefined
}

object Param {
  implicit val ParamOrdering: Ordering[Param] =
    Ordering.by((p: Param) => (p.isOptional, p.parameter.name))
}

