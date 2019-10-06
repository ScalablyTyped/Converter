package com.olvind.tso

import scala.collection.mutable
import seqs._

sealed trait Comment
final case class CommentRaw(raw:   String) extends Comment
final case class CommentData(data: Comment.Data) extends Comment

object Comment {
  trait Data

  def apply(raw: String): Comment = CommentRaw(raw)

  def warning(s: String)(implicit e: sourcecode.Enclosing): Comment =
    Comment(s"/* import warning: ${e.value.split("\\.").takeRight(2).mkString(".")} $s */")
}

sealed class Comments(val cs: List[Comment]) extends Serializable {
  def rawCs = cs collect { case CommentRaw(raw) => raw }

  def extract[T](pf: PartialFunction[Comment.Data, T]): Option[(T, Comments)] =
    cs.partitionCollect {
      case CommentData(data) if pf.isDefinedAt(data) => pf(data)
    } match {
      case (Nil, _)     => None
      case (some, rest) => Some((some.head, Comments(rest)))
    }

  def has[T](data: Comment.Data): Boolean =
    cs.exists {
      case CommentData(`data`) => true
      case _                   => false
    }

  override val hashCode: Int = 0

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Comments]

  override def toString: String =
    s"Comments(${cs.size})"

  def isEmpty: Boolean =
    cs.isEmpty

  def nonEmpty: Boolean =
    cs.nonEmpty

  def ++(that: Comments): Comments = {
    val ret = (this.cs, that.cs) match {
      case (Nil, Nil) => NoComments
      case (_, Nil)   => this
      case (Nil, _)   => that
      case (l, r)     => Comments(l ++ r)
    }
    ret
  }

  def +(c: Comment): Comments =
    new Comments(cs :+ c)

  def +?(oc: Option[Comment]): Comments =
    oc match {
      case None    => this
      case Some(c) => this + c
    }
}

case object NoComments extends Comments(Nil) {
  override def toString: String = "NoComments"
}

object Comments {
  def apply(h: String, tail: String*): Comments =
    new Comments(Comment(h) +: tail.map(Comment.apply).toList)

  def apply(cs: List[Comment]): Comments =
    cs match {
      case Nil   => NoComments
      case other => new Comments(other)
    }

  def apply(oc: Option[Comment]): Comments =
    oc match {
      case Some(c) => apply(c)
      case None    => NoComments
    }

  def apply(c: Comment): Comments =
    new Comments(List(c))

  def flatten[T](ts: Iterable[T])(f: T => Comments): Comments = {
    val buf = mutable.ArrayBuffer.empty[Comment]
    ts.foreach(t => buf ++= f(t).cs)
    apply(buf.distinct.toList)
  }

  def unapply(c: Comments): Some[List[Comment]] = Some(c.cs)

  def format(comments: Comments): String =
    comments.rawCs
      .map { raw =>
        stringUtils.formatComment(
          stringUtils.escapeUnicodeEscapes(
            stringUtils.escapeNestedComments(raw),
          ),
        )
      }
      .mkString("")
}
