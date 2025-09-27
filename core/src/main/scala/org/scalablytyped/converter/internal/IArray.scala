package org.scalablytyped.converter.internal

import java.util

import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.IArray.fromArrayAndSize

import scala.collection.immutable.{Range, SortedSet}
import scala.collection.mutable.WrappedArray.ofRef
import scala.collection.{immutable, mutable, GenTraversableOnce, Iterator}
import scala.Iterable

object IArray {
  implicit def IArrayEncoder[T <: AnyRef: Encoder]: Encoder[IArray[T]] =
    Encoder[List[T]].contramap[IArray[T]](_.toList)

  implicit def IArrayDecoder[T <: AnyRef: Decoder]: Decoder[IArray[T]] =
    Decoder[List[T]].map[IArray[T]](IArray.fromTraversable)

  implicit def ordering[T <: AnyRef: Ordering]: Ordering[IArray[T]] =
    new Ordering[IArray[T]] {
      override def compare(x: IArray[T], y: IArray[T]): Int = {
        val xe = x.iterator
        val ye = y.iterator

        while (xe.hasNext && ye.hasNext) {
          val res = implicitly[Ordering[T]].compare(xe.next(), ye.next())
          if (res != 0) return res
        }

        Ordering.Boolean.compare(xe.hasNext, ye.hasNext)
      }
    }

  def apply[A <: AnyRef](as: A*): IArray[A] =
    as match {
      case x: ofRef[A]                => fromArray(x.array)
      case x: mutable.WrappedArray[A] => fromArray(x.array)
      case x: GenTraversableOnce[A]   => fromTraversable(x)
    }

  def fromOption[A <: AnyRef](oa: Option[A]): IArray[A] =
    oa match {
      case Some(a) => apply(a)
      case None    => Empty
    }

  def fromOptions[A <: AnyRef](as: Option[A]*): IArray[A] =
    apply(as.flatten: _*)

  def fromArray[A <: AnyRef](as: Array[A]): IArray[A] =
    fromArrayAndSize(as.asInstanceOf[Array[AnyRef]], as.length)

  def fromTraversable[A <: AnyRef](as: Iterable[A]): IArray[A] =
    fromArrayAndSize(as.asInstanceOf[Iterable[AnyRef]].toArray, as.size)

  @inline private def fromArrayAndSize[A <: AnyRef](as: Array[AnyRef], length: Int): IArray[A] =
    if (length == 0) Empty else new IArray[A](as, length)

  val Empty = new IArray(Array.ofDim(0), 0)

  object first {
    def unapply[A <: AnyRef](as: IArray[A]): Option[A] = as.headOption
  }
  object last {
    def unapply[A <: AnyRef](as: IArray[A]): Option[A] = as.lastOption
  }
  object exactlyOne {
    def unapply[A <: AnyRef](as: IArray[A]): Option[A] =
      if (as.length == 1) Some(as(0)) else None
  }
  object exactlyTwo {
    def unapply[A <: AnyRef](as: IArray[A]): Option[(A, A)] =
      if (as.length == 2) Some((as(0), as(1))) else None
  }
  object exactlyThree {
    def unapply[A <: AnyRef](as: IArray[A]): Option[(A, A, A)] =
      if (as.length == 3) Some((as(0), as(1), as(2))) else None
  }
  object exactlyFour {
    def unapply[A <: AnyRef](as: IArray[A]): Option[(A, A, A, A)] =
      if (as.length == 4) Some((as(0), as(1), as(2), as(3))) else None
  }
  object headTail {
    def unapply[A <: AnyRef](as: IArray[A]): Option[(A, IArray[A])] =
      if (as.length == 0) None else Some((as.head, as.tail))
  }
  object headHeadTail {
    def unapply[A <: AnyRef](as: IArray[A]): Option[(A, A, IArray[A])] =
      if (as.length < 2) None else Some((as(0), as(1), as.drop(2)))
  }
  object initLast {
    def unapply[A <: AnyRef](as: IArray[A]): Option[(IArray[A], A)] =
      if (as.length == 0) None else Some((as.init, as.last))
  }

  object Builder {
    def empty[A <: AnyRef]: Builder[A] = new Builder[A](32)
    def empty[A <: AnyRef](initialCapacity: Int): Builder[A] = new Builder[A](initialCapacity)

    def apply[A <: AnyRef](as: IArray[A], initialCapacity: Int): Builder[A] = {
      val ret = new Builder[A](initialCapacity)
      var idx = 0
      while (idx < as.length) {
        ret += as(idx)
        idx += 1
      }
      ret
    }
  }

  final class Builder[A <: AnyRef](initialCapacity: Int) extends mutable.Builder[A, IArray[A]] {
    private val buf = new util.ArrayList[A](initialCapacity)

    override def +=(elem: A): this.type = {
      buf.add(elem)
      this
    }
    override def clear(): Unit = buf.clear()

    override def result(): IArray[A] = new IArray[A](buf.toArray, buf.size())

    def ++=(as: IArray[A]): this.type = {
      var idx = 0
      while (idx < as.length) {
        this += as(idx)
        idx += 1
      }
      this
    }

    def isEmpty: Boolean =
      buf.size() == 0

    // extensions below

    @inline def forall(f: A => Boolean): Boolean = {
      var idx    = 0
      val length = buf.size()
      while (idx < length) {
        if (!f(buf.get(idx))) {
          return false
        }
        idx += 1
      }
      true
    }

    def addOrUpdateMatching[U <: A](orElse: U)(ifNotMatch: U => U)(pf: PartialFunction[A, U]): Unit = {
      var i       = 0
      var updated = false
      while (i < buf.size && !updated) {
        val t = buf.get(i)
        if (pf.isDefinedAt(t)) {
          buf.set(i, pf(t))
          updated = true
        }
        i += 1
      }
      if (!updated) {
        buf.add(ifNotMatch(orElse))
        ()
      }
    }
  }

  @inline implicit final class IArrayOps[A <: AnyRef](val as: IArray[A]) extends AnyRef {
    // invariant contains!
    def contains(a: A): Boolean = {
      var idx = 0
      while (idx < as.length) {
        if (as.array(idx) == a) {
          return true
        }
        idx += 1
      }
      false
    }

    // custom extensions below

    @inline def mapNotNone[B <: AnyRef](f: A => Option[B]): IArray[B] = {
      if (as.isEmpty) {
        return IArray.Empty
      }

      val newArray = Array.ofDim[AnyRef](as.length)
      var i        = 0
      var o        = 0
      while (i < as.length) {
        f(as(i)) match {
          case Some(b) =>
            newArray(o) = b
            o += 1
          case None => ()
        }
        i += 1
      }
      fromArrayAndSize[B](newArray, o)
    }

    def partitionCollect[A1 <: AnyRef](t1: PartialFunction[A, A1]): (IArray[A1], IArray[A]) = {
      val a1s     = Array.ofDim[AnyRef](as.length)
      var a1num   = 0
      val rest    = Array.ofDim[AnyRef](as.length)
      var restnum = 0

      var idx = 0
      while (idx < as.length) {
        as(idx) match {
          case t if t1.isDefinedAt(t) =>
            a1s(a1num) = t1(t)
            a1num += 1
          case t =>
            rest(restnum) = t
            restnum += 1
        }
        idx += 1
      }

      (
        fromArrayAndSize[A1](a1s, a1num),
        fromArrayAndSize[A](rest, restnum),
      )
    }

    def partitionCollect2[A1 <: AnyRef, A2 <: AnyRef](
        t1: PartialFunction[A, A1],
        t2: PartialFunction[A, A2],
    ): (IArray[A1], IArray[A2], IArray[A]) = {
      val a1s     = Array.ofDim[AnyRef](as.length)
      var a1num   = 0
      val a2s     = Array.ofDim[AnyRef](as.length)
      var a2num   = 0
      val rest    = Array.ofDim[AnyRef](as.length)
      var restnum = 0

      var idx = 0
      while (idx < as.length) {
        as(idx) match {
          case t if t1.isDefinedAt(t) =>
            a1s(a1num) = t1(t)
            a1num += 1
          case t if t2.isDefinedAt(t) =>
            a2s(a2num) = t2(t)
            a2num += 1
          case t =>
            rest(restnum) = t
            restnum += 1
        }
        idx += 1
      }

      (
        fromArrayAndSize[A1](a1s, a1num),
        fromArrayAndSize[A2](a2s, a2num),
        fromArrayAndSize[A](rest, restnum),
      )
    }

    def partitionCollect3[A1 <: AnyRef, A2 <: AnyRef, A3 <: AnyRef](
        t1: PartialFunction[A, A1],
        t2: PartialFunction[A, A2],
        t3: PartialFunction[A, A3],
    ): (IArray[A1], IArray[A2], IArray[A3], IArray[A]) = {
      val a1s     = Array.ofDim[AnyRef](as.length)
      var a1num   = 0
      val a2s     = Array.ofDim[AnyRef](as.length)
      var a2num   = 0
      val a3s     = Array.ofDim[AnyRef](as.length)
      var a3num   = 0
      val rest    = Array.ofDim[AnyRef](as.length)
      var restnum = 0

      var idx = 0
      while (idx < as.length) {
        as(idx) match {
          case t if t1.isDefinedAt(t) =>
            a1s(a1num) = t1(t)
            a1num += 1
          case t if t2.isDefinedAt(t) =>
            a2s(a2num) = t2(t)
            a2num += 1
          case t if t3.isDefinedAt(t) =>
            a3s(a3num) = t3(t)
            a3num += 1
          case t =>
            rest(restnum) = t
            restnum += 1
        }
        idx += 1
      }

      (
        fromArrayAndSize[A1](a1s, a1num),
        fromArrayAndSize[A2](a2s, a2num),
        fromArrayAndSize[A3](a3s, a3num),
        fromArrayAndSize[A](rest, restnum),
      )
    }

    def partitionCollect4[A1 <: AnyRef, A2 <: AnyRef, A3 <: AnyRef, A4 <: AnyRef](
        t1: PartialFunction[A, A1],
        t2: PartialFunction[A, A2],
        t3: PartialFunction[A, A3],
        t4: PartialFunction[A, A4],
    ): (IArray[A1], IArray[A2], IArray[A3], IArray[A4], IArray[A]) = {
      val a1s     = Array.ofDim[AnyRef](as.length)
      var a1num   = 0
      val a2s     = Array.ofDim[AnyRef](as.length)
      var a2num   = 0
      val a3s     = Array.ofDim[AnyRef](as.length)
      var a3num   = 0
      val a4s     = Array.ofDim[AnyRef](as.length)
      var a4num   = 0
      val rest    = Array.ofDim[AnyRef](as.length)
      var restnum = 0

      var idx = 0
      while (idx < as.length) {
        as(idx) match {
          case t if t1.isDefinedAt(t) =>
            a1s(a1num) = t1(t)
            a1num += 1
          case t if t2.isDefinedAt(t) =>
            a2s(a2num) = t2(t)
            a2num += 1
          case t if t3.isDefinedAt(t) =>
            a3s(a3num) = t3(t)
            a3num += 1
          case t if t4.isDefinedAt(t) =>
            a4s(a4num) = t4(t)
            a4num += 1
          case t =>
            rest(restnum) = t
            restnum += 1
        }
        idx += 1
      }

      (
        fromArrayAndSize[A1](a1s, a1num),
        fromArrayAndSize[A2](a2s, a2num),
        fromArrayAndSize[A3](a3s, a3num),
        fromArrayAndSize[A4](a4s, a4num),
        fromArrayAndSize[A](rest, restnum),
      )
    }

    def partitionCollect5[A1 <: AnyRef, A2 <: AnyRef, A3 <: AnyRef, A4 <: AnyRef, A5 <: AnyRef](
        t1: PartialFunction[A, A1],
        t2: PartialFunction[A, A2],
        t3: PartialFunction[A, A3],
        t4: PartialFunction[A, A4],
        t5: PartialFunction[A, A5],
    ): (IArray[A1], IArray[A2], IArray[A3], IArray[A4], IArray[A5], IArray[A]) = {
      val a1s     = Array.ofDim[AnyRef](as.length)
      var a1num   = 0
      val a2s     = Array.ofDim[AnyRef](as.length)
      var a2num   = 0
      val a3s     = Array.ofDim[AnyRef](as.length)
      var a3num   = 0
      val a4s     = Array.ofDim[AnyRef](as.length)
      var a4num   = 0
      val a5s     = Array.ofDim[AnyRef](as.length)
      var a5num   = 0
      val rest    = Array.ofDim[AnyRef](as.length)
      var restnum = 0

      var idx = 0
      while (idx < as.length) {
        as(idx) match {
          case t if t1.isDefinedAt(t) =>
            a1s(a1num) = t1(t)
            a1num += 1
          case t if t2.isDefinedAt(t) =>
            a2s(a2num) = t2(t)
            a2num += 1
          case t if t3.isDefinedAt(t) =>
            a3s(a3num) = t3(t)
            a3num += 1
          case t if t4.isDefinedAt(t) =>
            a4s(a4num) = t4(t)
            a4num += 1
          case t if t5.isDefinedAt(t) =>
            a5s(a5num) = t5(t)
            a5num += 1
          case t =>
            rest(restnum) = t
            restnum += 1
        }
        idx += 1
      }

      (
        fromArrayAndSize[A1](a1s, a1num),
        fromArrayAndSize[A2](a2s, a2num),
        fromArrayAndSize[A3](a3s, a3num),
        fromArrayAndSize[A4](a4s, a4num),
        fromArrayAndSize[A5](a5s, a5num),
        fromArrayAndSize[A](rest, restnum),
      )
    }

    def firstDefined[U](f: A => Option[U]): Option[U] = {
      var idx = 0
      while (idx < as.length) {
        val res = f(as(idx))
        if (res.isDefined) return res
        idx += 1
      }
      None
    }

    def nonEmptyOpt: Option[IArray[A]] =
      if (as.isEmpty) None else Some(as)

    @inline def distinctBy[B](f: A => B): IArray[A] = {
      if (as.isEmpty) {
        return as
      }

      val set = mutable.Set.empty[B]
      val ret = as.array.clone()
      var i   = 0
      var o   = 0
      while (i < as.length) {
        val a = as(i)
        val b = f(a)
        if (!set(b)) {
          set.add(b)
          ret(o) = a
          o += 1
        }
        i += 1
      }

      fromArrayAndSize[A](ret, o)
    }
  }
}

final class IArray[+A <: AnyRef](private val array: Array[AnyRef], val length: Int) extends Serializable { self =>
  @inline def isEmpty: Boolean =
    length == 0

  @inline def nonEmpty: Boolean =
    length > 0

  @inline def lengthCompare(len: Int): Int =
    length - len

  @inline def apply(n: Int): A =
    array(n).asInstanceOf[A]

  @inline def applyOrElse[AA >: A](x: Int, default: Int => AA): AA =
    if (isDefinedAt(x)) apply(x) else default(x)

  @inline def isDefinedAt(n: Int): Boolean =
    n < length

  @inline def map[B <: AnyRef](f: A => B): IArray[B] = {
    if (isEmpty) {
      return IArray.Empty
    }

    val newArray = Array.ofDim[AnyRef](length)
    var i        = 0
    while (i < length) {
      newArray(i) = f(apply(i))
      i += 1
    }

    fromArrayAndSize[B](newArray, length)
  }

  @inline def foreach(f: A => Unit): Unit = {
    var i = 0
    while (i < length) {
      f(apply(i))
      i += 1
    }
  }

  @inline def flatMap[B <: AnyRef](f: A => IArray[B]): IArray[B] = {
    if (isEmpty) {
      return IArray.Empty
    }

    val nested: IArray[IArray[B]] = map(f)

    val newLength: Int = {
      var value = 0
      var i     = 0
      while (i < nested.length) {
        value += nested(i).length
        i += 1
      }
      value
    }

    val ret = Array.ofDim[AnyRef](newLength)
    var i   = 0
    var o   = 0
    while (i < length) {
      val bs: IArray[B] = nested(i)
      var j = 0
      while (j < bs.length) {
        ret(o) = bs(j)
        j += 1
        o += 1
      }

      i += 1
    }
    fromArrayAndSize[B](ret, o)
  }

  @inline def foldLeft[Z](z: Z)(f: (Z, A) => Z): Z = {
    var current = z
    var idx     = 0
    while (idx < length) {
      current = f(current, apply(idx))
      idx += 1
    }
    current
  }

  @inline def reduce[A1 >: A](op: (A1, A1) => A1): A1 = {
    if (isEmpty) sys.error("reduce on empty list")
    var ret: A1 = apply(0)
    var idx = 1
    while (idx < length) {
      ret = op(ret, apply(idx))
      idx += 1
    }
    ret
  }

  @inline def reduceOption[A1 >: A](op: (A1, A1) => A1): Option[A1] =
    if (isEmpty) None else Some(reduce(op))

  def sum[B >: A](implicit num: Numeric[B]): B =
    foldLeft(num.zero)(num.plus)

  @inline def count(p: A => Boolean): Int = {
    var ret = 0
    var idx = 0
    while (idx < length) {
      if (p(apply(idx))) {
        ret += 1
      }
      idx += 1
    }

    ret
  }

  def headOption: Option[A] =
    if (isEmpty) None else Some(apply(0))

  def head: A =
    headOption.getOrElse(sys.error("head of empty list"))

  def tailOpt: Option[IArray[A]] =
    if (isEmpty) None else Some(drop(1))

  def tail: IArray[A] =
    tailOpt.getOrElse(sys.error("tail of empty list"))

  def initOption: Option[IArray[A]] =
    if (isEmpty) None else Some(dropRight(1))

  def init: IArray[A] =
    initOption.getOrElse(sys.error("init of empty list"))

  def lastOption: Option[A] =
    if (isEmpty) None else Some(apply(length - 1))

  def last: A =
    lastOption.getOrElse(sys.error("last of empty list"))

  @inline def forall(p: A => Boolean): Boolean = {
    var idx = 0
    while (idx < length) {
      if (!p(apply(idx))) {
        return false
      }
      idx += 1
    }
    true
  }

  @inline def exists(p: A => Boolean): Boolean = {
    var idx = 0
    while (idx < length) {
      if (p(apply(idx))) {
        return true
      }
      idx += 1
    }
    false
  }

  @inline def collectFirst[B](pf: PartialFunction[A, B]): Option[B] = {
    var idx = 0
    while (idx < length) {
      val a = apply(idx)
      if (pf.isDefinedAt(a))
        return Some(pf(a))
      idx += 1
    }
    None
  }

  def indexOf[B >: A](elem: B): Int = indexOf(elem, 0)
  def indexOf[B >: A](elem: B, from: Int): Int = {
    var i = math.max(from, 0)
    while (i < length) {
      if (elem == apply(i)) {
        return i
      }
      i += 1
    }
    -1
  }

  @inline def indexWhere(p: A => Boolean): Int = indexWhere(p, 0)
  @inline def indexWhere(p: A => Boolean, from: Int): Int = {
    var i = math.max(from, 0)
    while (i < length) {
      if (p(apply(i))) {
        return i
      }
      i += 1
    }
    -1
  }

  @inline def find(f: A => Boolean): Option[A] = {
    var idx = 0
    while (idx < length) {
      val a = apply(idx)
      if (f(a))
        return Some(a)
      idx += 1
    }
    None
  }

  @inline def collect[B <: AnyRef](f: PartialFunction[A, B]): IArray[B] = {
    if (isEmpty) {
      return IArray.Empty
    }

    val newArray = Array.ofDim[AnyRef](length)
    var i        = 0
    var o        = 0
    while (i < length) {
      val a = apply(i)
      if (f.isDefinedAt(a)) {
        val b = f(a)
        newArray(o) = b
        o += 1
      }

      i += 1
    }
    fromArrayAndSize[B](newArray, o)
  }

  @inline def filterNot(f: A => Boolean): IArray[A] =
    filter(a => !f(a))

  @inline def filter(f: A => Boolean): IArray[A] = {
    if (isEmpty) {
      return this
    }

    val ret = array.clone()
    var i   = 0
    var o   = 0
    while (i < length) {
      val a   = apply(i)
      val res = f(a)
      if (res) {
        ret(o) = a
        o += 1
      }
      i += 1
    }

    fromArrayAndSize[A](ret, o)
  }

  def flatten[B <: AnyRef](implicit asTraversable: A => IArray[B]): IArray[B] =
    flatMap(asTraversable)

  def ++[B >: A <: AnyRef](that: IArray[B]): IArray[B] =
    if (isEmpty) that
    else if (that.isEmpty) this
    else {
      val newLength = length + that.length
      val ret       = Array.ofDim[AnyRef](newLength)
      System.arraycopy(array, 0, ret, 0, length)
      System.arraycopy(that.array, 0, ret, length, that.length)
      fromArrayAndSize[A](ret, newLength)
    }

  //prepend
  def +:[B >: A <: AnyRef](elem: B): IArray[B] = {
    val newLength = length + 1
    val ret       = Array.ofDim[AnyRef](newLength)
    ret(0) = elem
    System.arraycopy(array, 0, ret, 1, length)
    fromArrayAndSize[B](ret, newLength)
  }

  //append
  def :+[B >: A <: AnyRef](elem: B): IArray[B] = {
    val newLength = length + 1
    val ret       = Array.ofDim[AnyRef](newLength)
    System.arraycopy(array, 0, ret, 0, length)
    ret(length) = elem
    fromArrayAndSize[B](ret, newLength)
  }

  def take(n: Int): IArray[A] = {
    require(n >= 0)
    val newLength = math.min(length, n)
    if (newLength == 0) return IArray.Empty
    val ret = Array.ofDim[AnyRef](newLength)
    System.arraycopy(array, 0, ret, 0, newLength)
    fromArrayAndSize[A](ret, newLength)
  }

  def takeRight(n: Int): IArray[A] = {
    require(n >= 0)
    val newLength = math.min(length, n)
    if (newLength == 0) return IArray.Empty
    val ret = Array.ofDim[AnyRef](newLength)
    System.arraycopy(array, length - newLength, ret, 0, newLength)
    fromArrayAndSize[A](ret, newLength)
  }

  @inline def takeWhile(p: A => Boolean): IArray[A] = {
    if (isEmpty) {
      return this
    }

    var i        = 0
    var continue = true
    while (i < length && continue) {
      val a   = apply(i)
      val res = p(a)
      if (res) {
        i += 1
      } else {
        continue = false
      }
    }

    fromArrayAndSize[A](array, i)
  }

  def drop(n: Int): IArray[A] = {
    val newLength = math.max(0, length - n)
    if (newLength == 0) return IArray.Empty
    val ret = Array.ofDim[AnyRef](newLength)
    System.arraycopy(array, n, ret, 0, newLength)
    fromArrayAndSize[A](ret, newLength)
  }

  def dropRight(n: Int): IArray[A] =
    fromArrayAndSize[A](array, math.max(0, length - n))

  @inline def dropWhile(p: A => Boolean): IArray[A] = {
    if (isEmpty) return IArray.Empty
    var idx = 0
    while (idx < length) {
      if (!p(apply(idx))) {
        return drop(idx)
      }
      idx += 1
    }
    IArray.Empty
  }

  def reverse: IArray[A] = {
    if (isEmpty) return IArray.Empty
    val ret = Array.ofDim[AnyRef](length)
    var idx = 0
    while (idx < length) {
      ret(idx) = apply(length - 1 - idx)
      idx += 1
    }
    fromArrayAndSize[A](ret, length)
  }

  def zip[B <: AnyRef](other: IArray[B]): IArray[(A, B)] = {
    val newLength = math.min(length, other.length)
    if (newLength == 0) return IArray.Empty

    val ret = Array.ofDim[AnyRef](newLength)
    var idx = 0
    while (idx < newLength) {
      ret(idx) = (apply(idx), other(idx))
      idx += 1
    }
    fromArrayAndSize[(A, B)](ret, newLength)
  }

  def zipWithIndex: IArray[(A, Int)] = {
    if (isEmpty) return IArray.Empty

    val ret = Array.ofDim[AnyRef](length)
    var idx = 0
    while (idx < length) {
      ret(idx) = (apply(idx), idx)
      idx += 1
    }
    fromArrayAndSize[(A, Int)](ret, length)
  }

  @inline def partition(f: A => Boolean): (IArray[A], IArray[A]) = {
    val lefts  = Array.ofDim[AnyRef](length)
    val rights = Array.ofDim[AnyRef](length)
    var i      = 0
    var l      = 0
    var r      = 0
    while (i < length) {
      val current = apply(i)
      if (f(current)) {
        lefts(l) = current
        l += 1
      } else {
        rights(r) = current
        r += 1
      }
      i += 1
    }

    (fromArrayAndSize(lefts, l), fromArrayAndSize(rights, r))
  }

  def iterator: Iterator[A] = new Iterator[A] {
    var idx = 0
    override def hasNext: Boolean = idx < self.length

    override def next(): A = {
      val ret = array(idx).asInstanceOf[A]
      idx += 1
      ret
    }
  }

  def indices: Range = 0 until length

  def sortBy[B](f: A => B)(implicit ord: Ordering[B]): IArray[A] =
    sorted(ord.on(f))

  def sorted[B >: A <: AnyRef](implicit ord: Ordering[B]): IArray[A] =
    if (length < 2) this
    else {
      val ret = Array.ofDim[AnyRef](length)
      System.arraycopy(array, 0, ret, 0, length)
      java.util.Arrays.sort(ret, ord.asInstanceOf[Ordering[AnyRef]])
      fromArrayAndSize(ret, length)
    }

  def min[B >: A](implicit cmp: Ordering[B]): A = {
    if (isEmpty) sys.error("min on empty IArray")

    reduce((x, y) => if (cmp.lteq(x, y)) x else y)
  }

  def max[B >: A](implicit cmp: Ordering[B]): A = {
    if (isEmpty) sys.error("max on empty IArray")

    reduce((x, y) => if (cmp.gteq(x, y)) x else y)
  }

  @inline def maxBy[B](f: A => B)(implicit cmp: Ordering[B]): A = {
    if (isEmpty) sys.error("maxBy on empty IArray")

    var maxF:    B = null.asInstanceOf[B]
    var maxElem: A = null.asInstanceOf[A]
    var first = true

    for (elem <- this) {
      val fx = f(elem)
      if (first || cmp.gt(fx, maxF)) {
        maxElem = elem
        maxF    = fx
        first   = false
      }
    }
    maxElem
  }

  def distinct: IArray[A] =
    if (length < 2) this
    else {
      val ret  = Array.ofDim[AnyRef](length)
      val seen = new mutable.HashSet[A]()
      seen.sizeHint(length)
      var idx       = 0
      var o         = 0
      var different = false
      while (idx < length) {
        val next = apply(idx)
        if (seen.add(next)) {
          ret(o) = next
          o += 1
        } else different = true
        idx += 1
      }
      if (different) fromArrayAndSize(ret, o) else this
    }

  def toSet[AA >: A]: Set[AA] =
    toArray[AA].toSet

  def toSortedSet[AA >: A: Ordering]: SortedSet[AA] =
    SortedSet.empty[AA] ++ toArray[AA]

  def toList: List[A] =
    toArray[A].toList

  def toVector: Vector[A] =
    toArray[A].toVector

  private def toArray[AA >: A]: Array[AA] = {
    val ret = if (array.length == length) array else array.take(length)
    ret.asInstanceOf[Array[AA]]
  }

  def toMap[T, U](implicit ev: A <:< (T, U)): immutable.Map[T, U] = {
    val ret = new mutable.MapBuilder[T, U, immutable.Map[T, U]](immutable.Map.empty)
    ret.sizeHint(length)
    var idx = 0
    while (idx < length) {
      ret += apply(idx)
      idx += 1
    }

    ret.result()
  }

  def groupBy[K](f: A => K): Map[K, IArray[A]] = {
    val builder = mutable.HashMap.empty[K, IArray[A]]
    var idx     = 0
    while (idx < length) {
      val a   = apply(idx)
      val key = f(a)
      val newEntry = builder.get(key) match {
        case Some(existing) => existing :+ a
        case None           => IArray[A](a)
      }
      builder.put(key, newEntry)
      idx += 1
    }
    builder.toMap
  }

  def transpose[B <: AnyRef](implicit asTraversable: A => IArray[B]): IArray[IArray[B]] = {
    if (isEmpty) return IArray.Empty

    def fail() = sys.error("transpose requires all collections have the same size")

    val headSize = asTraversable(head).length
    val bs       = Array.fill(headSize)(IArray.Builder.empty[B])
    for (xs <- this) {
      var i = 0
      for (x <- asTraversable(xs)) {
        if (i >= headSize) fail()
        bs(i) += x
        i += 1
      }
      if (i != headSize) fail()
    }
    IArray.fromArray(bs.map(_.result()))
  }

  def startsWith[B <: AnyRef](that: IArray[B]): Boolean = startsWith(that, 0)

  def startsWith[B <: AnyRef](that: IArray[B], offset: Int): Boolean = {
    var i = offset
    var j = 0
    while (i < length && j < that.length && apply(i) == that(j)) {
      i += 1
      j += 1
    }
    j == that.length
  }

  def mkString(init: String, sep: String, post: String): String = {
    val sb = new java.lang.StringBuilder()
    sb.append(init)
    var i = 0
    while (i < length) {
      if (i != 0) {
        sb.append(sep)
      }
      sb.append(apply(i))
      i += 1
    }
    sb.append(post)
    sb.toString
  }

  def updated[B >: A <: AnyRef](index: Int, elem: B): IArray[B] = {
    require(index >= 0)
    require(index < length)
    if (length == 0) return IArray.Empty
    val ret = Array.ofDim[AnyRef](length)
    System.arraycopy(array, 0, ret, 0, length)
    ret(index) = elem
    fromArrayAndSize[A](ret, length)
  }

  def intersect[B >: A <: AnyRef](that: IArray[B]): IArray[B] = {
    val occ = occCounts(that)
    val b   = IArray.Builder.empty[B]
    for (x <- this) {
      val ox = occ(x) // Avoid multiple map lookups
      if (ox > 0) {
        b += x
        occ(x) = ox - 1
      }
    }
    b.result()
  }

  private def occCounts[B <: AnyRef](sq: IArray[B]): mutable.Map[B, Int] = {
    val occ = new mutable.HashMap[B, Int] { override def default(k: B) = 0 }
    for (y <- sq) occ(y) += 1
    occ
  }

  def mkString: String =
    mkString("", "", "")

  def mkString(sep: String): String =
    mkString("", sep, "")

  override def toString: String =
    mkString("IArray(", ", ", ")")

  override lazy val hashCode: Int = {
    var idx    = 0
    val prime  = 31
    var result = 1
    while (idx < length) {
      result = prime * result + apply(idx).##
      idx += 1
    }
    result
  }

  override def equals(obj: Any): Boolean =
    obj match {
      case other: IArray[_] if other.length == length && hashCode == other.hashCode =>
        var idx = 0
        while (idx < length) {
          if (apply(idx) != other(idx)) {
            return false
          }
          idx += 1
        }
        true
      case _ => false
    }
}
