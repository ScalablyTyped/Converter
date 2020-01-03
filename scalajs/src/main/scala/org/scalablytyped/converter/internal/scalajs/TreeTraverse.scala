package org.scalablytyped.converter.internal
package scalajs

import scala.collection.mutable

object TreeTraverse {
  def collect[T](tree: Tree)(extract: PartialFunction[Tree, T]): Seq[T] =
    collectSeq(Seq(tree))(extract)

  def collectSeq[T](tree: Traversable[Tree])(extract: PartialFunction[Tree, T]): Seq[T] = {
    val buf = mutable.Buffer.empty[T]

    tree foreach go(extract, buf)

    buf.to[Seq]
  }

  private def go[T](extract: PartialFunction[Tree, T], buf: mutable.Buffer[T])(tree: Tree): Unit = {
    if (extract.isDefinedAt(tree)) {
      buf += extract(tree)
    }

    def rec(a: Any): Unit =
      a match {
        case x:  Tree if x ne tree  => go(extract, buf)(x)
        case xs: TraversableOnce[_] => xs foreach rec
        case p:  Product            => p.productIterator foreach rec
        case _ => ()
      }

    rec(tree)
  }

  def foreach(tree: AnyRef)(run: Function[AnyRef, Unit]): Unit = {
    run(tree)

    def rec(a: Any): Unit =
      a match {
        case x:  AnyRef if x ne tree => foreach(x)(run)
        case xs: TraversableOnce[_]  => xs foreach rec
        case p:  Product             => p.productIterator foreach rec
        case _ => ()
      }

    rec(tree)
  }
}
