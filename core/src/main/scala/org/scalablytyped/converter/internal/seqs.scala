package org.scalablytyped.converter.internal

import scala.collection.mutable
import scala.collection.compat._
import scala.collection.compat.Factory

object seqs {
  @inline final implicit class TraversableOps[T](private val ts: Iterable[T]) extends AnyVal {
    def firstDefined[U](f: T => Option[U]): Option[U] = {
      val it = ts.iterator
      while (it.hasNext) {
        val res = f(it.next())
        if (res.isDefined) return res
      }
      None
    }

    def partitionCollect[T1, C[_]](t1: PartialFunction[T, T1])(
        implicit factoryT:             Factory[T, C[T]],
        factoryT1:                     Factory[T1, C[T1]],
    ): (C[T1], C[T]) = {
      val t1s  = factoryT1.newBuilder
      val rest = factoryT.newBuilder

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t                      => rest += t
      }

      (t1s.result(), rest.result())
    }

    def partitionCollect2[T1, T2, C[_]](t1: PartialFunction[T, T1], t2: PartialFunction[T, T2])(
        implicit factoryT:                  Factory[T, C[T]],
        factoryT1:                          Factory[T1, C[T1]],
        factoryT2:                          Factory[T2, C[T2]],
    ): (C[T1], C[T2], C[T]) = {
      val t1s  = factoryT1.newBuilder
      val t2s  = factoryT2.newBuilder
      val rest = factoryT.newBuilder

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), rest.result())
    }

    def partitionCollect3[T1, T2, T3, C[_]](
        t1: PartialFunction[T, T1],
        t2: PartialFunction[T, T2],
        t3: PartialFunction[T, T3],
    )(
        implicit factoryT: Factory[T, C[T]],
        factoryT1:         Factory[T1, C[T1]],
        factoryT2:         Factory[T2, C[T2]],
        factoryT3:         Factory[T3, C[T3]],
    ): (C[T1], C[T2], C[T3], C[T]) = {
      val t1s  = factoryT1.newBuilder
      val t2s  = factoryT2.newBuilder
      val t3s  = factoryT3.newBuilder
      val rest = factoryT.newBuilder

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t if t3.isDefinedAt(t) => t3s += t3(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), t3s.result(), rest.result())
    }

    def partitionCollect4[T1, T2, T3, T4, C[_]](
        t1: PartialFunction[T, T1],
        t2: PartialFunction[T, T2],
        t3: PartialFunction[T, T3],
        t4: PartialFunction[T, T4],
    )(
        implicit factoryT: Factory[T, C[T]],
        factoryT1:         Factory[T1, C[T1]],
        factoryT2:         Factory[T2, C[T2]],
        factoryT3:         Factory[T3, C[T3]],
        factoryT4:         Factory[T4, C[T4]],
    ): (C[T1], C[T2], C[T3], C[T4], C[T]) = {
      val t1s  = factoryT1.newBuilder
      val t2s  = factoryT2.newBuilder
      val t3s  = factoryT3.newBuilder
      val t4s  = factoryT4.newBuilder
      val rest = factoryT.newBuilder

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t if t3.isDefinedAt(t) => t3s += t3(t)
        case t if t4.isDefinedAt(t) => t4s += t4(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), t3s.result(), t4s.result(), rest.result())
    }

    def partitionCollect5[T1, T2, T3, T4, T5, C[_]](
        t1: PartialFunction[T, T1],
        t2: PartialFunction[T, T2],
        t3: PartialFunction[T, T3],
        t4: PartialFunction[T, T4],
        t5: PartialFunction[T, T5],
    )(
        implicit factoryT: Factory[T, C[T]],
        factoryT1:         Factory[T1, C[T1]],
        factoryT2:         Factory[T2, C[T2]],
        factoryT3:         Factory[T3, C[T3]],
        factoryT4:         Factory[T4, C[T4]],
        factoryT5:         Factory[T5, C[T5]],
    ): (C[T1], C[T2], C[T3], C[T4], C[T5], C[T]) = {
      val t1s  = factoryT1.newBuilder
      val t2s  = factoryT2.newBuilder
      val t3s  = factoryT3.newBuilder
      val t4s  = factoryT4.newBuilder
      val t5s  = factoryT5.newBuilder
      val rest = factoryT.newBuilder

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t if t3.isDefinedAt(t) => t3s += t3(t)
        case t if t4.isDefinedAt(t) => t4s += t4(t)
        case t if t5.isDefinedAt(t) => t5s += t5(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), t3s.result(), t4s.result(), t5s.result(), rest.result())
    }
  }
}
