package com.olvind.tso
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

  @inline final implicit class MapOps[M[k, v] <: scala.Traversable[(k, v)], K, V](private val m: M[K, V])
      extends AnyVal {
    @inline def sorted(implicit O: Ordering[K]): SortedMap[K, V] =
      TreeMap.empty[K, V] ++ m
  }
}
