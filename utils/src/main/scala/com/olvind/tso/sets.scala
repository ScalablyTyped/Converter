package com.olvind.tso

object sets {
  object EmptySet {
    def unapply[T](ts: Set[T]): Boolean = ts.isEmpty
  }

  object NonEmptySet {
    def unapply[T](ts: Set[T]): Option[Set[T]] = if (ts.nonEmpty) Some(ts) else None
  }
}
