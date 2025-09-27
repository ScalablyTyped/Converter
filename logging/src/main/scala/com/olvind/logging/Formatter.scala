package com.olvind.logging

import java.io.File
import java.net.URI

import fansi.Str
import scala.Iterable

trait Formatter[T] {
  def apply(t: T): Str
}

object Formatter {
  @inline def apply[T: Formatter](t: T): Str = implicitly[Formatter[T]].apply(t)

  implicit def Tuple2Formatter[T1: Formatter, T2: Formatter]: Formatter[(T1, T2)] = {
    case (t1, t2) => Str.join(List(Formatter(t1), ", ", Formatter(t2)))
  }

  implicit def Tuple3Formatter[T1: Formatter, T2: Formatter, T3: Formatter]: Formatter[(T1, T2, T3)] = {
    case (t1, t2, t3) => Str.join(List(Formatter(t1), ", ", Formatter(t2), ", ", Formatter(t3)))
  }

  implicit def Tuple4Formatter[T1: Formatter, T2: Formatter, T3: Formatter, T4: Formatter]
      : Formatter[(T1, T2, T3, T4)] = {
    case (t1, t2, t3, t4) =>
      Str.join(List(Formatter(t1), ", ", Formatter(t2), ", ", Formatter(t3), ", ", Formatter(t4)))
  }

  implicit def EitherFormatter[L: Formatter, R: Formatter]: Formatter[Either[L, R]] =
    _.fold(Formatter[L], Formatter[R])

  implicit def TraversableFormatter[C[t] <: Iterable[t], T: Formatter]: Formatter[C[T]] =
    ts =>
      if (ts.isEmpty) ""
      else {
        val arr = Array.ofDim[Str]((ts.size * /* t, comma */ 2) - /* comma */ 1 + /* brackets */ 2)
        var idx = 0
        arr(idx) = "["
        idx += 1
        ts.foreach { t =>
          arr(idx)     = Formatter(t)
          arr(idx + 1) = ", "
          idx += 2
        }

        arr(idx - 1) = "]"
        Str.join(arr)
      }

  implicit def ArrayFormatter[T: Formatter]: Formatter[Array[T]] =
    ts =>
      if (ts.isEmpty) ""
      else {
        val arr = Array.ofDim[Str]((ts.length * /* t, comma */ 2) - /* comma */ 1 + /* brackets */ 2)
        var idx = 0
        arr(idx) = "["
        idx += 1
        ts.foreach { t =>
          arr(idx)     = Formatter(t)
          arr(idx + 1) = ", "
          idx += 2
        }

        arr(idx - 1) = "]"
        Str.join(arr)
      }

  implicit def MapFormatter[K: Formatter, V: Formatter]: Formatter[Map[K, V]] =
    kvs =>
      if (kvs.isEmpty) ""
      else {
        val arr = Array.ofDim[Str]((kvs.size * /* key, arrow, value, comma */ 4) - /* comma */ 1 + /* brackets */ 2)
        var idx = 0
        arr(idx) = "["
        idx += 1
        kvs.foreach {
          case (k, v) =>
            arr(idx + 0) = Formatter(k)
            arr(idx + 1) = " => "
            arr(idx + 2) = Formatter(v)
            arr(idx + 3) = ", "
            idx += 4
        }

        arr(idx - 1) = "]"
        Str.join(arr)
      }

  implicit val StrFormatter:    Formatter[Str]    = x => x
  implicit val StringFormatter: Formatter[String] = x => x
  implicit val IntFormatter:    Formatter[Int]    = _.toString
  implicit val LongFormatter:   Formatter[Long]   = _.toString
  implicit val UnitFormatter:   Formatter[Unit]   = _ => ""
  implicit val FileFormatter:   Formatter[File]   = _.getName
  implicit val URIFormatter:    Formatter[URI]    = _.toString

  implicit def ThrowableFormatter[Th <: Throwable]: Formatter[Th] = {
    case th: Throwable if th.getMessage != null => Str.join(List(th.getClass.getName, ": ", th.getMessage))
    case th: Throwable                          => th.getClass.getName
  }
}
