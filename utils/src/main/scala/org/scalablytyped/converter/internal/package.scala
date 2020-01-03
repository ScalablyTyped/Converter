package org.scalablytyped.converter

package object internal {
  type Seq[+A] = scala.collection.immutable.Seq[A]
  val Seq = scala.collection.immutable.Seq
  type Set[A] = scala.collection.immutable.Set[A]
  val Set = scala.collection.immutable.Set
  type Iterable[+A] = scala.collection.immutable.Iterable[A]
  val Iterable = scala.collection.immutable.Iterable

  @inline private[internal] final implicit class AnyRefOps[T](private val t: T) extends AnyVal {
    @inline def ===(tt:  T): Boolean = t == tt
    @inline def =/=(tt:  T): Boolean = t != tt
    @inline def |>[U](f: T => U): U = f(t)
    @inline def <|(f:    T => Unit): T = { f(t); t }
  }

  @inline private[internal] final implicit class StrOps(private val str: String) extends AnyVal {
    @inline def |+|(other: String): String = str + other
  }
//  val logger = logging.stdout()
}
