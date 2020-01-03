package org.scalablytyped.converter.internal.scalajs

/**
  * Model that we do prefer to output `_` instead of `Any` in type parameters (because that's closer to how ts works),
  * Scala disallows this trick in inheritance and in method parameters
  */
sealed abstract class Wildcards(val allowed: Boolean) {
  def maybeAllow: Wildcards =
    this match {
      case Wildcards.Yes      => Wildcards.Yes
      case Wildcards.No       => Wildcards.Yes
      case Wildcards.Prohibit => Wildcards.Prohibit
    }
}

object Wildcards {
  val Remove = TypeRewriter(Map(TypeRef.Wildcard -> TypeRef.Any))

  case object Yes extends Wildcards(true)
  case object No extends Wildcards(false)
  case object Prohibit extends Wildcards(false)
}
