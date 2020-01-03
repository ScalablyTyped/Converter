package org.scalablytyped.converter.internal
package ts

trait RemoveComment[T] {
  def remove(t: T): T
}

object RemoveComment {
  implicit val r0: RemoveComment[TsMemberCtor]     = _.copy(comments = NoComments)
  implicit val r1: RemoveComment[TsMemberFunction] = _.copy(comments = NoComments)
  implicit val r2: RemoveComment[TsMemberCall]     = _.copy(comments = NoComments)
  implicit val r3: RemoveComment[TsDeclFunction]   = _.copy(comments = NoComments)

  def keepFirstOnly[T <: AnyRef: RemoveComment](fs: IArray[T]): IArray[T] =
    fs.zipWithIndex.map {
      case (f, 0) => f
      case (f, _) => implicitly[RemoveComment[T]].remove(f)
    }
}
