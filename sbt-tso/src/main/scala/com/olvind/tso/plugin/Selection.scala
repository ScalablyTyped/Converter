package com.olvind.tso.plugin

sealed trait Selection[T] {
  def map[U](f: T => U): Selection[U] =
    this match {
      case Selection.Yes(values @ _*) => Selection.Yes(values map f: _*)
      case Selection.No(values @ _*)  => Selection.No(values map f: _*)
      case Selection.All()            => Selection.All()
      case Selection.None()           => Selection.None()
    }

  def apply(value: T) = this match {
    case Selection.Yes(values @ _*) => values.contains(value)
    case Selection.No(values @ _*)  => !values.contains(value)
    case Selection.All()            => true
    case Selection.None()           => false
  }
}

object Selection {
  case class Yes[T](values: T*) extends Selection[T]
  case class No[T](values:  T*) extends Selection[T]
  case class All[T]() extends Selection[T]
  case class None[T]() extends Selection[T]
}
