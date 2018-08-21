package com.olvind.tso

case class Suffix(unescaped: String) extends AnyVal {
  def +(other: Suffix): Suffix =
    Suffix(unescaped + other.unescaped)

  def ++(suffixes: Seq[Suffix]): Suffix =
    Suffix(suffixes.foldLeft(unescaped)(_ + _.unescaped))

  def +?(other: Option[Suffix]): Suffix =
    other.foldLeft(this)(_ + _)
}

trait ToSuffix[T] {
  def to(t: T): Suffix
}

object ToSuffix {
  def apply[T: ToSuffix](t: T): Suffix =
    implicitly[ToSuffix[T]].to(t)

  implicit object IsSuffix extends ToSuffix[Suffix] {
    override def to(t: Suffix): Suffix = t
  }

  implicit object StringSuffix extends ToSuffix[String] {
    override def to(t: String): Suffix = Suffix(t)
  }
}
