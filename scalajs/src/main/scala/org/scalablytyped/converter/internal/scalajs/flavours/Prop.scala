package org.scalablytyped.converter.internal
package scalajs
package flavours

final case class Prop(
    parameter: ParamTree,
    asString:  Either[String, String => String],
    original:  Either[TypeRef, MemberTree],
) {
  def isOptional = parameter.default.isDefined
}

object Prop {
  implicit val PropOrdering: Ordering[Prop] =
    Ordering.by((p: Prop) => (p.isOptional, p.parameter.name))
}
