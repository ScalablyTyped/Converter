package com.olvind.tso
package ts

import scala.collection.mutable

object TsTreeTraverse {
  def collect[T](tree: TsTree)(extract: PartialFunction[TsTree, T]): Seq[T] =
    collectSeq(Seq(tree))(extract)

  def collectSeq[T](tree: Traversable[TsTree])(extract: PartialFunction[TsTree, T]): Seq[T] = {
    val buf = mutable.Buffer.empty[T]

    tree foreach go(extract, buf)

    buf.to[Seq]
  }

  private def go[T](extract: PartialFunction[TsTree, T], buf: mutable.Buffer[T])(tree: TsTree): Unit = {
    if (extract.isDefinedAt(tree)) {
      buf += extract(tree)
    }

    def rec(a: Any): Unit =
      a match {
        case x:  TsTree if x ne tree => go(extract, buf)(x)
        case xs: TraversableOnce[_]  => xs foreach rec
        case p:  Product             => p.productIterator foreach rec
        case _ => ()
      }

    rec(tree)
  }
}
