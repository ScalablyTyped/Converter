package ScalablyTyped.runtime

import scala.collection.generic.CanBuildFrom
import scala.collection.mutable
import scala.collection.mutable.Builder
import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess

/**
  * Lifted scala.scalajs.js.WrappedDictionary and adapted it to `NumberDictionary`
  */
@inline
class WrappedNumberDictionary[A](val dict: NumberDictionary[A])
    extends mutable.AbstractMap[Double, A]
    with mutable.Map[Double, A]
    with mutable.MapLike[Double, A, WrappedNumberDictionary[A]] {

  import WrappedNumberDictionary._

  def get(key: Double): Option[A] =
    if (contains(key))
      Some(rawApply(key))
    else
      None

  override def apply(key: Double): A =
    if (contains(key))
      rawApply(key)
    else
      throw new NoSuchElementException("key not found: " + key)

  @inline
  private def rawApply(key: Double): A =
    dict.asInstanceOf[DictionaryRawApply[A]].rawApply(key)

  override def contains(key: Double): Boolean =
    /* We have to use a safe version of hasOwnProperty, because
     * "hasOwnProperty" could be a key of this dictionary.
     */
    safeHasOwnProperty(dict, key)

  def -=(key: Double): this.type = {
    if (contains(key))
      js.special.delete(dict, key)
    this
  }

  override def update(key: Double, value: A): Unit =
    dict.asInstanceOf[DictionaryRawApply[A]].rawUpdate(key, value)

  def +=(kv: (Double, A)): this.type = {
    dict(kv._1) = kv._2
    this
  }

  def iterator: scala.collection.Iterator[(Double, A)] =
    new DictionaryIterator(dict)

  @inline
  override def keys: scala.collection.Iterable[Double] =
    js.Object.keys(dict.asInstanceOf[js.Object]).asInstanceOf[scala.collection.Iterable[Double]]

  override def empty: WrappedNumberDictionary[A] =
    WrappedNumberDictionary.empty[A]

}

object WrappedNumberDictionary {
  // Note: We can't extend MutableMapFactory[WrappedDictionary] since
  // it requires support for any type of key

  private object Cache {
    val safeHasOwnProperty =
      js.Dynamic.global.Object.prototype.hasOwnProperty
        .asInstanceOf[js.ThisFunction1[WrappedNumberDictionary[_], Double, Boolean]]
  }

  @inline
  private def safeHasOwnProperty(dict: WrappedNumberDictionary[_], key: Double): Boolean =
    Cache.safeHasOwnProperty(dict, key)

  @js.native
  private trait DictionaryRawApply[A] extends js.Object {

    /** Reads a field of this object by its name.
      *
      *  This must not be called if the dictionary does not contain the key.
      */
    @JSBracketAccess
    def rawApply(key: Double): A = js.native

    /** Writes a field of this object. */
    @JSBracketAccess
    def rawUpdate(key: Double, value: A): Unit = js.native
  }

  private final class DictionaryIterator[+A](dict: WrappedNumberDictionary[A])
      extends scala.collection.Iterator[(Double, A)] {

    private[this] val keys = js.Object.keys(dict.asInstanceOf[js.Object]).asInstanceOf[js.Array[Double]]
    private[this] var index: Int = 0

    def hasNext: Boolean = index < keys.length

    def next(): (Double, A) = {
      val key = keys(index)
      index += 1
      (key, dict(key))
    }
  }

  def empty[A]: WrappedNumberDictionary[A] =
    new WrappedNumberDictionary(NumberDictionary.empty[A])

  implicit def canBuildFrom[A]: CanBuildFrom[WrappedNumberDictionary[_], (Double, A), WrappedNumberDictionary[A]] =
    new CanBuildFrom[WrappedNumberDictionary[_], (Double, A), WrappedNumberDictionary[A]] {
      def apply(from: WrappedNumberDictionary[_]): Builder[(Double, A), WrappedNumberDictionary[A]] =
        new WrappedDictionaryBuilder[A]
      def apply(): Builder[(Double, A), WrappedNumberDictionary[A]] =
        new WrappedDictionaryBuilder[A]
    }

  private final class WrappedDictionaryBuilder[A] extends Builder[(Double, A), WrappedNumberDictionary[A]] {

    private[this] var dict: NumberDictionary[A] = NumberDictionary.empty[A]

    def +=(elem: (Double, A)): this.type = {
      dict(elem._1) = elem._2
      this
    }

    def clear(): Unit =
      dict = NumberDictionary.empty[A]

    def result(): WrappedNumberDictionary[A] =
      new WrappedNumberDictionary(dict)
  }
}
