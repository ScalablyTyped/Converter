package org.scalablytyped.converter.internal
package ts

import scala.IterableOnce
object TsTreeTraverse {
  def collect[T <: AnyRef](tree: TsTree)(extract: PartialFunction[TsTree, T]): IArray[T] =
    collectIArray(IArray(tree))(extract)

  def collectIArray[T <: AnyRef](tree: IArray[TsTree])(extract: PartialFunction[TsTree, T]): IArray[T] = {
    val buf = IArray.Builder.empty[T]

    tree.foreach(go(extract, buf))

    buf.result()
  }

  private def go[T <: AnyRef](extract: PartialFunction[TsTree, T], buf: IArray.Builder[T])(tree: TsTree): Unit = {
    if (extract.isDefinedAt(tree)) {
      buf += extract(tree)
    }

    def rec(a: Any): Unit =
      a match {
        case x: TsTree if x ne tree =>
          go(extract, buf)(x)
        case xs: IterableOnceIterableOnce[_] =>
          val it = xs.toIterator
          while (it.hasNext) {
            rec(it.next())
          }
        case xs: IArray[_] =>
          var i = 0
          while (i < xs.length) {
            rec(xs(i))
            i += 1
          }
        case p: Product =>
          var i = 0
          while (i < p.productArity) {
            rec(p.productElement(i))
            i += 1
          }
        case _ => ()
      }

    rec(tree)
  }
}
