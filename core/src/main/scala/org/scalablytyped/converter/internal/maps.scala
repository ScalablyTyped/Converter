package org.scalablytyped.converter.internal

import scala.collection.generic.CanBuildFrom
import scala.collection.immutable.{SortedMap, TreeMap}
import scala.collection.mutable

object maps {
  object EmptyMap {
    def unapply[K, V](map: Map[K, V]): Boolean =
      map.isEmpty
  }

  def sum[K, V <: AnyRef](ms: IArray[Map[K, V]]): Map[K, IArray[V]] = {
    val ret = mutable.Map.empty[K, IArray[V]]
    ms.foreach(_.foreach { case (k, v) => ret.update(k, ret.get(k).fold(IArray(v))(v +: _)) })
    ret.toMap
  }

  def smash[K, V](ms: IArray[Map[K, V]]): Map[K, V] =
    ms.foldLeft(Map.empty[K, V]) {
      case (acc, current) => acc ++ current
    }

  def combine[K, V <: AnyRef](ms: IArray[Map[K, IArray[V]]]): Map[K, IArray[V]] = {
    val ret = mutable.Map.empty[K, IArray[V]]
    ms.foreach(_.foreach { case (k, v) => ret.update(k, ret.get(k).fold(v)(v ++ _)) })
    ret.toMap
  }

  @inline final implicit class FromMapValuesOps[K, V <: AnyRef](private val map: scala.collection.Map[K, V])
      extends AnyVal {

    @inline def toIArrayValues: IArray[V] =
      toIArrayValues(null)

    @inline def toIArrayValues(keep: V => Boolean): IArray[V] = {
      val b    = IArray.Builder.empty[V](map.size)
      val iter = map.values.iterator
      while (iter.hasNext) {
        val current = iter.next()
        if (keep == null || keep(current)) b += current
      }
      b.result()
    }
  }

  @inline final implicit class FromMapOps[K, V](private val map: scala.collection.Map[K, V]) extends AnyVal {}

  @inline final implicit class MapOps[M[k, v] <: scala.Iterable[(k, v)], K, V](private val m: M[K, V]) extends AnyVal {

    @inline def toIArray: IArray[(K, V)] =
      toIArray(null)

    @inline def toIArray(keep: ((K, V)) => Boolean): IArray[(K, V)] = {
      val b    = IArray.Builder.empty[(K, V)](m.size)
      val iter = m.iterator
      while (iter.hasNext) {
        val current = iter.next()
        if (keep == null || keep(current)) b += current
      }
      b.result()
    }

    @inline def mapToIArray[A <: AnyRef](f: ((K, V)) => A, keep: ((K, V)) => Boolean = null): IArray[A] = {
      val b    = IArray.Builder.empty[A](m.size)
      val iter = m.iterator
      while (iter.hasNext) {
        val current = iter.next()
        if (keep == null || keep(current)) b += f(current)
      }
      b.result()
    }

    @inline def flatMapToIArray[A <: AnyRef](f: ((K, V)) => IArray[A], keep: ((K, V)) => Boolean = null): IArray[A] = {
      val b    = IArray.Builder.empty[A](m.size * 2)
      val iter = m.iterator
      while (iter.hasNext) {
        val current = iter.next()
        if (keep == null || keep(current)) b ++= f(current)
      }
      b.result()
    }

    @inline def mapNotNone[VV](
        f:          (K, V) => Option[VV],
    )(implicit cbf: CanBuildFrom[M[K, V], (K, VV), M[K, VV]]): M[K, VV] = {
      val b  = cbf()
      val it = m.toIterator

      while (it.hasNext) {
        it.next() match {
          case (k, v) =>
            f(k, v) match {
              case Some(vv) => b += ((k, vv))
              case None     => ()
            }
        }
      }
      b.result()
    }

    @inline def toSorted(implicit O: Ordering[K]): SortedMap[K, V] = TreeMap() ++ m

    @inline def firstDefined[U](f: (K, V) => Option[U]): Option[U] = {
      val it = m.toIterator

      while (it.hasNext) {
        it.next() match {
          case (k, v) =>
            f(k, v) match {
              case some @ Some(_) => return some
              case None           => ()
            }
        }
      }
      None
    }
  }
}
