package com.olvind.tso

import scala.collection.generic.{CanBuildFrom, Growable}
import scala.collection.{mutable, GenIterableLike}

object seqs {
  private object NoBuild extends CanBuildFrom[Unit, Unit, Array[Unit]] with PartialFunction[Any, Unit] {

    object builder extends mutable.ArrayBuilder[Unit] {
      override def clear():  Unit        = {}
      override def result(): Array[Unit] = null
      override def +=(elem: Unit) = this
    }

    override def apply(from: Unit): mutable.Builder[Unit, Array[Unit]] = builder
    override def apply(): mutable.Builder[Unit, Array[Unit]] = builder
    override def isDefinedAt(x: Any): Boolean = false
    override def apply(v1:      Any): Nothing = ???
  }

  implicit def noBuild[C[_]]: CanBuildFrom[Any, Unit, C[Unit]] =
    NoBuild.asInstanceOf[CanBuildFrom[Any, Unit, C[Unit]]]

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

    @inline def partialForeach(pf: PartialFunction[T, Unit]): Unit =
      ts.foreach {
        case t if pf isDefinedAt t => pf(t)
        case _                     =>
      }

    def partitionCollect[T1](t1: PartialFunction[T, T1])(
        implicit cbfT:           CanBuildFrom[C[T], T, C[T]],
        cbfT1:                   CanBuildFrom[C[T], T1, C[T1]]
    ): (C[T1], C[T]) = {

      val (t1s, _, _, rest) =
        ts.partitionCollect3(t1, NoBuild, NoBuild)
      (t1s, rest)
    }

    def partitionCollect2[T1, T2](t1: PartialFunction[T, T1], t2: PartialFunction[T, T2])(
        implicit cbfT:                CanBuildFrom[C[T], T, C[T]],
        cbfT1:                        CanBuildFrom[C[T], T1, C[T1]],
        cbfT2:                        CanBuildFrom[C[T], T2, C[T2]]
    ): (C[T1], C[T2], C[T]) = {
      val (t1s, t2s, _, rest) = ts.partitionCollect3(t1, t2, NoBuild)
      (t1s, t2s, rest)
    }

    def partitionCollect3[T1, T2, T3](t1: PartialFunction[T, T1],
                                      t2: PartialFunction[T, T2],
                                      t3: PartialFunction[T, T3])(
        implicit cbfT:                    CanBuildFrom[C[T], T, C[T]],
        cbfT1:                            CanBuildFrom[C[T], T1, C[T1]],
        cbfT2:                            CanBuildFrom[C[T], T2, C[T2]],
        cbfT3:                            CanBuildFrom[C[T], T3, C[T3]]
    ): (C[T1], C[T2], C[T3], C[T]) = {

      val t1s  = cbfT1()
      val t2s  = cbfT2()
      val t3s  = cbfT3()
      val rest = cbfT()

      ts foreach {
        case t if t1.isDefinedAt(t) => t1s += t1(t)
        case t if t2.isDefinedAt(t) => t2s += t2(t)
        case t if t3.isDefinedAt(t) => t3s += t3(t)
        case t                      => rest += t
      }

      (t1s.result(), t2s.result(), t3s.result(), rest.result())
    }
  }

  @inline final implicit class BufferOps[T, C[t] <: Growable[t]](private val ts: mutable.Buffer[T]) extends AnyVal {
    def addOrUpdateMatching[U <: T](orElse: U)(ifNotMatch: U => U)(pf: PartialFunction[T, U]): Unit = {
      var i       = 0
      var updated = false
      while (i < ts.length && !updated) {
        val t = ts(i)
        if (pf isDefinedAt t) {
          ts(i) = pf(t)
          updated = true
        }
        i += 1
      }
      if (!updated)
        ts += ifNotMatch(orElse)
    }
  }

  object Head {
    def unapply[T](ts: Seq[T]): Option[T] = ts.headOption
  }
}
