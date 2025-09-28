package org.scalablytyped.converter.internal

import scala.collection.mutable

trait BuilderCompat[A <: AnyRef] { self: mutable.Builder[A, IArray[A]] =>
  def addOne(elem: A): this.type

  // Scala 2.12 needs explicit += definition
  def +=(elem: A): this.type = addOne(elem)
}
