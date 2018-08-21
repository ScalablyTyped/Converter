package ScalablyTyped.runtime

import scala.scalajs.js

trait NumberDictionary[V] extends js.Object

object NumberDictionary {
  @inline implicit def wrapNumberDictionary[V](dict: NumberDictionary[V]): WrappedNumberDictionary[V] =
    new WrappedNumberDictionary(dict)

  /** Returns a new empty dictionary */
  @inline def empty[A]: NumberDictionary[A] =
    (new js.Object).asInstanceOf[NumberDictionary[A]]

  @inline
  def apply[A](properties: (Double, A)*): NumberDictionary[A] = {
//    js.special.objectLiteral(properties: _*).asInstanceOf[NumberDictionary[A]]

    val result = empty[A]
    for ((key, value) <- properties)
      result(key) = value
    result
  }
}
