package com.olvind.tso
import scala.collection.mutable

object maps {
  object EmptyMap {
    def unapply[K, V](map: Map[K, V]): Boolean =
      map.isEmpty
  }

  def unzip[K, V1, V2](m: Map[K, Either[V1, V2]]): (Map[K, V1], Map[K, V2]) =
    (
      m.collect({ case (k, Left(v1))  => k -> v1 }),
      m.collect({ case (k, Right(v2)) => k -> v2 })
    )

  def assertLeftOnly[K, V1, V2](m: Map[K, Either[V1, V2]]): Map[K, V1] =
    unzip(m) match {
      case (l, EmptyMap()) => l
      case (_, r)          => sys.error(s"Unexpected rights: $r")
    }

  def sum[K, V](ms: Iterable[Map[K, V]]): Map[K, List[V]] = {
    val ret = mutable.Map.empty[K, List[V]]
    ms.foreach(_.foreach { case (k, v) => ret.update(k, ret.get(k).fold(v :: Nil)(v :: _)) })
    ret.toMap
  }
}
