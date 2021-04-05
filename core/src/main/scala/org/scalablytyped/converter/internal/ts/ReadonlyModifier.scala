package org.scalablytyped.converter.internal.ts

sealed trait ReadonlyModifier {
  def apply(wasReadonly: Boolean): Boolean =
    this match {
      case ReadonlyModifier.Noop => wasReadonly
      case ReadonlyModifier.Yes  => true
      case ReadonlyModifier.No   => false
    }
}

object ReadonlyModifier {
  case object Noop extends ReadonlyModifier
  case object Yes extends ReadonlyModifier
  case object No extends ReadonlyModifier
}
