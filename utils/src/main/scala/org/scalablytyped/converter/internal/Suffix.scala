package org.scalablytyped.converter
package internal

case class Suffix(unescaped: String) extends AnyVal {
  def +(other: Suffix): Suffix =
    (this, other) match {
      case (Suffix.Empty, Suffix.Empty) => Suffix.Empty
      case (Suffix.Empty, nonEmpty)     => nonEmpty
      case (nonEmpty, Suffix.Empty)     => nonEmpty
      case (Suffix(one), Suffix(two))   => Suffix(one + "_" + two)
    }

  def ++[T <: AnyRef: ToSuffix](suffixes: IArray[T]): Suffix =
    Suffix(suffixes.foldLeft(unescaped)(_ + ToSuffix(_).unescaped))

  def +?[T: ToSuffix](other: Option[T]): Suffix =
    other.foldLeft(this)(_ + ToSuffix(_))
}

object Suffix {
  val Empty = new Suffix("")
}

trait ToSuffix[T] {
  def to(t: T): Suffix
}

object ToSuffix {
  def apply[T: ToSuffix](t: T): Suffix =
    implicitly[ToSuffix[T]].to(t)

  implicit def IArray[T <: AnyRef: ToSuffix]: ToSuffix[IArray[T]] =
    ts => Suffix.Empty ++ ts

  implicit object IsSuffix extends ToSuffix[Suffix] {
    override def to(t: Suffix): Suffix = t
  }

  implicit object StringSuffix extends ToSuffix[String] {
    override def to(t: String): Suffix = Suffix(t)
  }
}
