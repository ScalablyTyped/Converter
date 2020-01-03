package org.scalablytyped.converter.internal
package ts

object TsTreeTraverse {
  def collect[T <: AnyRef](tree: TsTree)(extract: PartialFunction[TsTree, T]): IArray[T] =
    collectIArray(IArray(tree))(extract)

  def collectIArray[T <: AnyRef](tree: IArray[TsTree])(extract: PartialFunction[TsTree, T]): IArray[T] = {
    val buf = IArray.Builder.empty[T]

    tree foreach go(extract, buf)

    buf.result()
  }

  private def go[T <: AnyRef](extract: PartialFunction[TsTree, T], buf: IArray.Builder[T])(tree: TsTree): Unit = {
    if (extract.isDefinedAt(tree)) {
      buf += extract(tree)
    }

    def rec(a: Any): Unit =
      a match {
        case x:  TsTree if x ne tree => go(extract, buf)(x)
        case xs: TraversableOnce[_]  => xs foreach rec
        case xs: IArray[_]           => xs foreach rec
        case p:  Product             => p.productIterator foreach rec
        case _ => ()
      }

    rec(tree)
  }
}
