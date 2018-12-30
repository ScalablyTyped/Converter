package com.olvind.tso
package ts

trait RemoveComment[T] {
  def remove(t: T): T
}

object RemoveComment {
  implicit val r0: RemoveComment[TsMemberCtor]     = _.copy(comments = NoComments)
  implicit val r1: RemoveComment[TsMemberFunction] = _.copy(comments = NoComments)
  implicit val r2: RemoveComment[TsMemberCall]     = _.copy(comments = NoComments)
  implicit val r3: RemoveComment[TsDeclFunction]   = _.copy(comments = NoComments)

  def keepFirstOnly[T: RemoveComment](fs: Seq[T]): Seq[T] =
    fs.zipWithIndex.map {
      case (f, 0) => f
      case (f, _) => implicitly[RemoveComment[T]].remove(f)
    }
}
