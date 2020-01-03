package org.scalablytyped.converter.internal.scalajs

class LoopDetector private (val stack: List[(List[Name], TreeScope)]) {
  def this() = this(Nil)

  def including(wanted: List[Name], scope: TreeScope): Either[Unit, LoopDetector] = {
    val tuple = (wanted, scope)
    if (stack.contains(tuple)) Left(())
    else Right(new LoopDetector(tuple :: stack))
  }
}
