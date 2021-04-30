package org.scalablytyped.converter.internal

import scala.collection.GenTraversableLike
import scala.collection.generic.CanBuildFrom

trait Key[T] {
  type Id

  def apply(t: T): Id
}

trait IsKey[T] extends Key[T] {
  final type Id = T

  final def apply(t: T): T = t
}

object Key {

  trait AnyRefKey[T] extends Key[T] {
    override type Id <: AnyRef
  }

  def of[T, I](f: T => I)(implicit idKey: AnyRefKey[I]): AnyRefKey[T] = new AnyRefKey[T] {
    override type Id = idKey.Id

    override def apply(t: T): Id = idKey(f(t))
  }

  def identity[T]: Key[T] = new Key[T] {
    override type Id = T

    override def apply(t: T): Id = t
  }

  def identityRef[T <: AnyRef]: AnyRefKey[T] = new AnyRefKey[T] {
    override type Id = T

    override def apply(t: T): Id = t
  }

  implicit val BooleanKey: Key[Boolean]      = identity[Boolean]
  implicit val IntKey:     Key[Int]          = identity[Int]
  implicit val DoubleKey:  Key[Double]       = identity[Double]
  implicit val StringKey:  AnyRefKey[String] = identityRef[String]

  def apply[T: Key]: Key[T] = implicitly

  implicit def tuple2[T1: Key, T2: Key]: AnyRefKey[(T1, T2)] =
    new AnyRefKey[(T1, T2)] {
      val T1: Key[T1] = Key[T1]
      val T2: Key[T2] = Key[T2]

      override type Id = (T1.Id, T2.Id)

      override def apply(t: (T1, T2)): Id = (T1(t._1), T2(t._2))
    }

  implicit def tuple3[T1: Key, T2: Key, T3: Key]: AnyRefKey[(T1, T2, T3)] =
    new AnyRefKey[(T1, T2, T3)] {
      val T1: Key[T1] = Key[T1]
      val T2: Key[T2] = Key[T2]
      val T3: Key[T3] = Key[T3]

      override type Id = (T1.Id, T2.Id, T3.Id)

      override def apply(t: (T1, T2, T3)): Id = (T1(t._1), T2(t._2), T3(t._3))
    }

  implicit def option[T: Key]: AnyRefKey[Option[T]] =
    new AnyRefKey[Option[T]] {
      val T: Key[T] = Key[T]
      override type Id = Option[T.Id]

      override def apply(t: Option[T]): Id = t.map(T.apply)
    }

  implicit def seq[C[t] <: GenTraversableLike[t, C[t]] with AnyRef, T, I](implicit id: Key[T] { type Id = I }, cbf: CanBuildFrom[C[T], I, C[I]])
      : AnyRefKey[C[T]] =
    new AnyRefKey[C[T]] {
      override type Id = C[I]

      override def apply(t: C[T]): C[I] = t.map(id.apply)
    }

}
