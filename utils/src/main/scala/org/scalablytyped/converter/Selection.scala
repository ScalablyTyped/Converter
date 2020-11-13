package org.scalablytyped.converter

import scala.collection.immutable.{SortedSet, TreeSet}

sealed trait Selection[T] {
  def &&(other: Selection[T]): Selection[T] =
    Selection.And(this, other)

  def ||(other: Selection[T]): Selection[T] =
    Selection.Or(this, other)

  def map[U: Ordering](f: T => U): Selection[U] =
    this match {
      case Selection.NoneExcept(values) => Selection.NoneExcept(values.map(f))
      case Selection.AllExcept(values)  => Selection.AllExcept(values.map(f))
      case Selection.And(_1, _2)        => Selection.And(_1.map(f), _2.map(f))
      case Selection.Or(_1, _2)         => Selection.Or(_1.map(f), _2.map(f))
    }

  def apply(value: T): Boolean =
    this match {
      case Selection.NoneExcept(values) => values.contains(value)
      case Selection.AllExcept(values)  => !values.contains(value)
      case Selection.And(_1, _2)        => _1(value) && _2(value)
      case Selection.Or(_1, _2)         => _1(value) || _2(value)
    }
}

object Selection {
  def All[T: Ordering]: Selection[T] = AllExcept(TreeSet.empty[T])

  def None[T: Ordering]: Selection[T] = NoneExcept(TreeSet.empty[T])

  final case class AllExcept[T: Ordering](values: SortedSet[T]) extends Selection[T]

  object AllExcept {
    def apply[T: Ordering](values: T*): AllExcept[T] = AllExcept(TreeSet.empty[T] ++ values)
  }

  final case class NoneExcept[T](values: SortedSet[T]) extends Selection[T]

  object NoneExcept {
    def apply[T: Ordering](values: T*): NoneExcept[T] = NoneExcept(TreeSet.empty ++ values)
  }

  final case class And[T](_1: Selection[T], _2: Selection[T]) extends Selection[T]

  final case class Or[T](_1: Selection[T], _2: Selection[T]) extends Selection[T]

}
