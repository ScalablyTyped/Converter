package org.scalablytyped.converter

import io.circe.{Decoder, DecodingFailure, Encoder, Json}
import io.circe.syntax._

import scala.collection.immutable.{SortedSet, TreeSet}

sealed trait Selection[T] {
  def &&(other: Selection[T]): Selection[T] =
    Selection.And(this, other)

  def ||(other: Selection[T]): Selection[T] =
    Selection.Or(this, other)

  def map[U: Ordering](f: T => U): Selection[U] =
    this match {
      case Selection.NoneExcept(values) => Selection.NoneExcept(values.map(f))
      case Selection.AllExcept(values)  => Selection.AllExcept(values.map(f))
      case Selection.And(_1, _2)        => Selection.And(_1.map(f), _2.map(f))
      case Selection.Or(_1, _2)         => Selection.Or(_1.map(f), _2.map(f))
    }

  def apply(value: T): Boolean =
    this match {
      case Selection.NoneExcept(values) => values.contains(value)
      case Selection.AllExcept(values)  => !values.contains(value)
      case Selection.And(_1, _2)        => _1(value) && _2(value)
      case Selection.Or(_1, _2)         => _1(value) || _2(value)
    }
}

object Selection {
  def All[T: Ordering]: Selection[T] = AllExcept(TreeSet.empty[T])

  def None[T: Ordering]: Selection[T] = NoneExcept(TreeSet.empty[T])

  final case class AllExcept[T: Ordering](values: SortedSet[T]) extends Selection[T]

  object AllExcept {
    def apply[T: Ordering](values: T*): AllExcept[T] = AllExcept(TreeSet.empty[T] ++ values)
  }

  final case class NoneExcept[T](values: SortedSet[T]) extends Selection[T]

  object NoneExcept {
    def apply[T: Ordering](values: T*): NoneExcept[T] = NoneExcept(TreeSet.empty ++ values)
  }

  final case class And[T](_1: Selection[T], _2: Selection[T]) extends Selection[T]

  final case class Or[T](_1: Selection[T], _2: Selection[T]) extends Selection[T]

  implicit def encodes[T: Encoder: Ordering]: Encoder[Selection[T]] = Encoder.instance {
    case AllExcept(values)  => Json.obj("type" -> Json.fromString("AllExcept"), "values" -> values.asJson)
    case NoneExcept(values) => Json.obj("type" -> Json.fromString("NoneExcept"), "values" -> values.asJson)
    case And(s1, s2)        => Json.obj("type" -> Json.fromString("And"), "_1" -> s1.asJson, "_2" -> s2.asJson)
    case Or(s1, s2)         => Json.obj("type" -> Json.fromString("Or"), "_1" -> s1.asJson, "_2" -> s2.asJson)
  }

  implicit def decodes[T: Decoder: Ordering]: Decoder[Selection[T]] = Decoder.instance { c =>
    c.downField("type").as[String].flatMap {
      case "AllExcept"  => c.downField("values").as[SortedSet[T]].map(AllExcept(_))
      case "NoneExcept" => c.downField("values").as[SortedSet[T]].map(NoneExcept(_))
      case "And" =>
        for {
          s1 <- c.downField("_1").as[Selection[T]]
          s2 <- c.downField("_2").as[Selection[T]]
        } yield And(s1, s2)
      case "Or" =>
        for {
          s1 <- c.downField("_1").as[Selection[T]]
          s2 <- c.downField("_2").as[Selection[T]]
        } yield Or(s1, s2)
      case other => Left(DecodingFailure(s"Unknown Selection type: $other", c.history))
    }
  }
}
