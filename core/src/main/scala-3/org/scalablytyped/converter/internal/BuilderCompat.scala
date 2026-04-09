package org.scalablytyped.converter.internal

import scala.collection.mutable

trait BuilderCompat[A <: AnyRef] { self: mutable.Builder[A, IArray[A]] =>
  // In Scala 3, += is provided by Growable and cannot be overridden
  // We only need to define addOne
}
