package com.olvind.tso.plugin

sealed trait Selection[T] {
  def map[U](f: T => U): Selection[U] =
    this match {
      case Selection.AllOf(values @ _*)     => Selection.AllOf(values map f: _*)
      case Selection.AllExcept(values @ _*) => Selection.AllExcept(values map f: _*)
      case Selection.All()            => Selection.All()
      case Selection.None()           => Selection.None()
    }

  def apply(value: T) = this match {
    case Selection.AllOf(values @ _*)     => values.contains(value)
    case Selection.AllExcept(values @ _*) => !values.contains(value)
    case Selection.All()            => true
    case Selection.None()           => false
  }
}

object Selection {
  case class AllOf[T](values:     T*) extends Selection[T]
  case class AllExcept[T](values: T*) extends Selection[T]
  case class All[T]() extends Selection[T]
  case class None[T]() extends Selection[T]
}
