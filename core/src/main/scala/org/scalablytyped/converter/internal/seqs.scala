package org.scalablytyped.converter.internal

import scala.collection.GenIterableLike
import scala.collection.generic.CanBuildFrom

object seqs {
  @inline final implicit class TraversableOps[C[t] <: GenIterableLike[t, C[t]], T](private val ts: C[T])
      extends AnyVal {

    def firstDefined[U](f: T => Option[U]): Option[U] = {
      val it = ts.toIterator

      while (it.hasNext) {
        val res = f(it.next())
        if (res.isDefined) return res
      }
      None
    }

    def partitionCollect[T1](t1: PartialFunction[T, T1])(
        implicit cbfT:           CanBuildFrom[C[T], T, C[T]],
        cbfT1:                   CanBuildFrom[C[T], T1, C[T1]],
    ): (C[T1], C[T]) = {

      val t1s  = cbfT1()
      val rest = cbfT()

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t                      => rest += t
      }

      (t1s.result(), rest.result())
    }

    def partitionCollect2[T1, T2](t1: PartialFunction[T, T1], t2: PartialFunction[T, T2])(
        implicit cbfT:                CanBuildFrom[C[T], T, C[T]],
        cbfT1:                        CanBuildFrom[C[T], T1, C[T1]],
        cbfT2:                        CanBuildFrom[C[T], T2, C[T2]],
    ): (C[T1], C[T2], C[T]) = {
      val t1s  = cbfT1()
      val t2s  = cbfT2()
      val rest = cbfT()

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), rest.result())
    }

    def partitionCollect3[T1, T2, T3](
        t1: PartialFunction[T, T1],
        t2: PartialFunction[T, T2],
        t3: PartialFunction[T, T3],
    )(
        implicit cbfT: CanBuildFrom[C[T], T, C[T]],
        cbfT1:         CanBuildFrom[C[T], T1, C[T1]],
        cbfT2:         CanBuildFrom[C[T], T2, C[T2]],
        cbfT3:         CanBuildFrom[C[T], T3, C[T3]],
    ): (C[T1], C[T2], C[T3], C[T]) = {

      val t1s  = cbfT1()
      val t2s  = cbfT2()
      val t3s  = cbfT3()
      val rest = cbfT()

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t if t3.isDefinedAt(t) => t3s += t3(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), t3s.result(), rest.result())
    }

    def partitionCollect4[T1, T2, T3, T4](
        t1: PartialFunction[T, T1],
        t2: PartialFunction[T, T2],
        t3: PartialFunction[T, T3],
        t4: PartialFunction[T, T4],
    )(
        implicit cbfT: CanBuildFrom[C[T], T, C[T]],
        cbfT1:         CanBuildFrom[C[T], T1, C[T1]],
        cbfT2:         CanBuildFrom[C[T], T2, C[T2]],
        cbfT3:         CanBuildFrom[C[T], T3, C[T3]],
        cbfT4:         CanBuildFrom[C[T], T4, C[T4]],
    ): (C[T1], C[T2], C[T3], C[T4], C[T]) = {

      val t1s  = cbfT1()
      val t2s  = cbfT2()
      val t3s  = cbfT3()
      val t4s  = cbfT4()
      val rest = cbfT()

      ts.foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t if t3.isDefinedAt(t) => t3s += t3(t)
        case t if t4.isDefinedAt(t) => t4s += t4(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), t3s.result(), t4s.result(), rest.result())
    }

    def partitionCollect5[T1, T2, T3, T4, T5](
        t1: PartialFunction[T, T1],
        t2: PartialFunction[T, T2],
        t3: PartialFunction[T, T3],
        t4: PartialFunction[T, T4],
        t5: PartialFunction[T, T5],
    )(
        implicit cbfT: CanBuildFrom[C[T], T, C[T]],
        cbfT1:         CanBuildFrom[C[T], T1, C[T1]],
        cbfT2:         CanBuildFrom[C[T], T2, C[T2]],
        cbfT3:         CanBuildFrom[C[T], T3, C[T3]],
        cbfT4:         CanBuildFrom[C[T], T4, C[T4]],
        cbfT5:         CanBuildFrom[C[T], T5, C[T5]],
    ): (C[T1], C[T2], C[T3], C[T4], C[T5], C[T]) = {

      val t1s  = cbfT1()
      val t2s  = cbfT2()
      val t3s  = cbfT3()
      val t4s  = cbfT4()
      val t5s  = cbfT5()
      val rest = cbfT()

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
