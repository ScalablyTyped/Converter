package com.olvind.tso

import scala.collection.generic.CanBuildFrom
import scala.collection.immutable.{SortedMap, TreeMap}
import scala.collection.mutable

object maps {
  object EmptyMap {
    def unapply[K, V](map: Map[K, V]): Boolean =
      map.isEmpty
  }

  def sum[K, V](ms: Iterable[Map[K, V]]): Map[K, List[V]] = {
    val ret = mutable.Map.empty[K, List[V]]
    ms.foreach(_.foreach { case (k, v) => ret.update(k, ret.get(k).fold(v :: Nil)(v :: _)) })
    ret.toMap
  }

  def smash[K, V](ms: scala.Iterable[Map[K, V]]): Map[K, V] =
    ms.foldLeft(Map.empty[K, V]) {
      case (acc, current) => acc ++ current
    }

  def combine[K, V](ms: Iterable[Map[K, Seq[V]]]): Map[K, Seq[V]] = {
    val ret = mutable.Map.empty[K, Seq[V]]
    ms.foreach(_.foreach { case (k, v) => ret.update(k, ret.get(k).fold(v)(v ++ _)) })
    ret.toMap
  }

  @inline final implicit class MapOps[M[k, v] <: scala.Traversable[(k, v)], K, V](private val m: M[K, V])
      extends AnyVal {

    def mapNotNone[VV](f: V => Option[VV])(implicit cbf: CanBuildFrom[M[K, V], (K, VV), M[K, VV]]): M[K, VV] = {
      val b  = cbf()
      val it = m.toIterator

      while (it.hasNext) {
        it.next() match {
          case (k, v) =>
            f(v) match {
              case Some(vv) => b += ((k, vv))
              case None     => ()
            }
        }
      }
      b.result()
    }

    @inline def toSorted(implicit O: Ordering[K]): SortedMap[K, V] = TreeMap() ++ m
  }
}
