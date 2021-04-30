package org.scalablytyped.converter

package object internal {
  val Empty = IArray.Empty

  @inline private[internal] final implicit class AnyRefOps[T](private val t: T) extends AnyVal {
    @inline def ===(tt:  T): Boolean = t == tt
    @inline def =/=(tt:  T): Boolean = t != tt
    @inline def |>[U](f: T => U): U = f(t)
    @inline def <|(f:    T => Unit): T = { f(t); t }
  }

  @inline private[internal] final implicit class StrOps(private val str: String) extends AnyVal {
    @inline def |+|(other: String): String = str + other
  }
}
