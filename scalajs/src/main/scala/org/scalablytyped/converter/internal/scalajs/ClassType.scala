package org.scalablytyped.converter.internal
package scalajs

sealed trait ClassType {
  import ClassType._

  final def combine(that: ClassType): ClassType =
    (this, that) match {
      case (Class, _)         => Class
      case (_, Class)         => Class
      case (AbstractClass, _) => AbstractClass
      case (_, AbstractClass) => AbstractClass
      case (_, _)             => Trait
    }

  final def asString: String =
    this match {
      case Trait         => "trait"
      case AbstractClass => "abstract class"
      case Class         => "class"
    }
}

object ClassType {
  case object Class extends ClassType
  case object AbstractClass extends ClassType
  case object Trait extends ClassType
}
