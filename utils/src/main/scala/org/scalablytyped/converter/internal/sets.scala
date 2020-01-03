package org.scalablytyped.converter.internal
import scala.collection.immutable.SortedSet

object sets {
  object EmptySet {
    def unapply[T](ts: Set[T]): Boolean = ts.isEmpty
  }

  object NonEmptySet {
    def unapply[T](ts: Set[T]): Option[Set[T]] = if (ts.nonEmpty) Some(ts) else None
  }

  @inline final implicit class SetOps[T](private val ts: Set[T]) extends AnyVal {
    @inline def sorted(implicit O: Ordering[T]): SortedSet[T] =
      SortedSet.empty[T] ++ ts
  }
}
